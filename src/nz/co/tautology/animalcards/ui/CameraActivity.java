package nz.co.tautology.animalcards.ui;

import static android.R.attr.button;
import static nz.co.tautology.animalcards.util.CameraHelper.cameraAvailable;
import static nz.co.tautology.animalcards.util.CameraHelper.getCameraInstance;
import static nz.co.tautology.animalcards.util.MediaHelper.getOutputMediaFile;
import static nz.co.tautology.animalcards.util.MediaHelper.getOutputDataName;
import static nz.co.tautology.animalcards.util.MediaHelper.saveToFile;
import static nz.co.tautology.animalcards.util.MediaHelper.createFile;

import java.io.File;

import nz.co.tautology.animalcards.FromXML;
import nz.co.tautology.animalcards.R;
import nz.co.tautology.animalcards.ui.widget.CameraPreview;
import nz.co.tautology.animalcards.util.Log;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Takes a photo saves it to the SD card and returns the path of this photo to the calling Activity
 *
 */
public class CameraActivity extends Activity implements PictureCallback {

	protected static final String EXTRA_IMAGE_PATH = "nz.co.tautology.animalcards.ui.CameraActivity.EXTRA_IMAGE_PATH";

	private Camera camera;
	private CameraPreview cameraPreview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);

                //Button scanButton = (Button) findViewById(R.id.button_scan);
                //scanButton.setBackgroundColor(Color.GREEN);

		setResult(RESULT_CANCELED);
		// Camera may be in use by another activity or the system or not available at all
		camera = getCameraInstance();
		if(cameraAvailable(camera)){
			initCameraPreview();
		} else {
			finish();
		}
	}

	// Show the camera view on the activity
	private void initCameraPreview() {
		cameraPreview = (CameraPreview) findViewById(R.id.camera_preview);
		cameraPreview.init(camera);
	}

	@FromXML
	public void onCaptureClick(View button){
		// Take a picture with a callback when the photo has been created
		// Here you can add callbacks if you want to give feedback when the picture is being taken
		camera.takePicture(null, null, this);
	}

	@Override
    public void onPictureTaken(byte[] imgData, Camera camera) {
        Log.d("Picture taken");
        //String path = savePictureToFileSystem(imgData);
        //setResult(path);
        
        // process image for barcode
        String barcode = decodeImageData(imgData, 3);
        if (barcode == null)
        {
            for (int n = 1; n < 10; n++)
                if (n != 3)
                {
                    barcode = decodeImageData(imgData, n);
                    if (barcode != null)
                    {
                        String code = Barcodes.getDescription(barcode);
                        if (!code.equals(barcode))
                            break;
                    }
                }
        }
        if (barcode == null)
            Toast.makeText(this, "NO VALID BARCODE FOUND", Toast.LENGTH_LONG).show();

        setResult(barcode);    
//        if (barcode != null)
//        {
//            File file = getOutputDataName(barcode);
//            createFile(file);
//        }
            
        finish();
    }

    // +/- 10%
    private boolean isWithin10(double ratio)
    {
        return ((ratio >= 0.85) && (ratio <= 1.15));
    }

    // +/- 25%
    private boolean isWithin25(double ratio)
    {
        return ((ratio >= 0.75) && (ratio <= 1.25));
    }

    // is start mark if b1 = b2 = b3 and w1 = w2 = w3 
    // and w = 2 x b
    private boolean isStartMark(int start, int map2[], double wb[])
    {
        int b1 = map2[start + 0];
        int w1 = map2[start + 1];
        int b2 = map2[start + 2];
        int w2 = map2[start + 3];
        int b3 = map2[start + 4];
        int w3 = map2[start + 5];

        double b = (b1 + b2 + b3) / 3.0;
        double w = (w1 + w2 + w3) / 3.0;

        double wbr = w / b;
        

        // +/- 50%
        if ((wbr < 1.50) || (wbr > 2.50))
            return false;
    

        // +/- 10%
        if (!isWithin10(b1/b)) return false;
        if (!isWithin10(b2/b)) return false;
        if (!isWithin10(b3/b)) return false;


        // +/- 10%
        if (!isWithin10(w1/w)) return false;
        if (!isWithin10(w2/w)) return false;
        if (!isWithin10(w3/w)) return false;

        wb[0] = w;
        wb[1] = b;

        return true;
    }

    private int filter_double_ones(int map2[], int len)
    {
        int count = 0;
        for (int p = 1; p < len - 2; p++)
            if (map2[p - 1] > 1 && map2[p] == 1 && map2[p + 1] == 1 && map2[p + 2] > 1)
                count++;

        if (count > 0)
        {
            int map3[] = new int[len];
        
            int p = 0, q = 0;
            map3[q++] = map2[p++];

            while (p < len - 2)
            {
                if (map2[p - 1] > 1 && map2[p] == 1 && map2[p + 1] == 1 && map2[p + 2] > 1)
                {
                    map3[q - 1]++; 
                    map3[q++] = map2[p + 2] + 1;
                    p += 3;
                }
                else
                    map3[q++] = map2[p++];
            }
            map3[q++] = map2[p++];
            map3[q++] = map2[p++];

            // copy compacted array back
            for (int i = 0; i < q; i++)
                map2[i] = map3[i];

            return q;
        }
        return len;
    }

    private char getSymbol(int v, double wb[]) throws NumberFormatException
    {
        if (isWithin25(v / wb[0])) return '0';
        if (isWithin25(v / wb[1])) return '1';
        throw new NumberFormatException();
    }

    private String decodeImageData(byte[] imgData, int n)
    {
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeByteArray(imgData, 0, imgData.length);

            if (bitmap != null) 
            {                
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();

                // argb values
                int[] map = new int[width];

                int startx = width / 10;
                int stopx  = (9 * width) / 10;
                int ypos = ((n == 3) ? (height / 3) : (n * height) / 10);
                bitmap.getPixels(map, 0, width, startx, ypos, stopx, 1);

                // save data
                //saveToFile(gray, getOutputDataFile());
            
                for (int x = 0; x < width; x++)
                {
                    int pixel = map[x];
                    map[x] = (byte)((Color.red(pixel) + Color.green(pixel) + Color.blue(pixel)) / 3);
                }

                // get the mean average of the middle line (grayscaled)            
                long sum = 0;
                int x;
                for (x = 0; x < width; x++)
                    sum += map[x];
                int mean = (int)(sum / width);
                             
                // bi-colour using the mean
                for (x = 0; x < width; x++)
                {
                    if (map[x] < mean)
                        map[x] = 0;
                    else
                        map[x] = 1;
                }
                             
                // look for first white line
                int p = width - 1;
                while ((p > 0) && (map[p] == 0))
                    p--;

                int mapsize = width;
                int map2[] = new int[mapsize];
                int q = 0, count = 0;
                // width counting
                while (p > 0 && q < mapsize)
                {
                    count = 0;
                    while ((p > 0) && (map[p] == 1))
                    {
                        count++;
                        p--;
                    }
                    map2[q++] = count;
                                 
                    count = 0;
                    while ((p > 0) && (map[p] == 0))
                    {
                        count++;
                        p--;
                    }
                    map2[q++] = count;
                }

                // filter out double 1s in the map2
                int q2 = filter_double_ones(map2, q);
                if (q2 != q)
                {            
                    q = q2;
                }

                // too short
                if (q < 26)
                {                
                    //Toast.makeText(this, "INVALID BARCODE", Toast.LENGTH_LONG).show();
                    return null;
                }

                // look for starting block
                // 3 black bars of the same width and 3 white bars of the same width
                // white bars are 2x longer than the black bars
                double wb[] = new double[2];
                int start = 0;        
                while (start < q - 7)
                {
                    if (isStartMark(start, map2, wb))
                    {
                        //System.out.println("Found at: " + start);
                        //System.out.println("W: " + wb[0]);
                        //System.out.println("B: " + wb[1]);
                        
                        StringBuffer barcode = new StringBuffer();
                        try
                        {
                            // decode the rest                        
                            for (int r = 6; r < 25; r++)
                                barcode.append(getSymbol(map2[start + r], wb));                    
                            //Toast.makeText(this, "DECODED: " + barcode.toString(), Toast.LENGTH_LONG).show();
                            //createFile(getOutputDataName(barcode.toString()));

                            return barcode.toString();
                        }
                        catch (NumberFormatException nfe)
                        {
                            // pass
                            //System.out.println("NFE");
                            if (barcode.length() > 4)
                            {
                                //Toast.makeText(this, "TRY AGAIN", Toast.LENGTH_LONG).show();
                                return null;
                            }     
                        }
                    }
                    start += 2;
                }            
                //Toast.makeText(this, "NO BARCOE FOUND", Toast.LENGTH_LONG).show();

            } 
            //else Toast.makeText(this, "NO IMAGE FOUND", Toast.LENGTH_LONG).show();
            

            return null;            
        }
        catch (Exception exc) 
        {
            Toast.makeText(this, "ERROR: " + exc.getMessage(), Toast.LENGTH_LONG).show();
            return null;
        }
    }

    private static String savePictureToFileSystem(byte[] data) {
        File file = getOutputMediaFile();
        saveToFile(data, file);
		return file.getAbsolutePath();
	}

	private void setResult(String path) {
		Intent intent = new Intent();
		intent.putExtra(EXTRA_IMAGE_PATH, path);
		setResult(RESULT_OK, intent);
	}

	// ALWAYS remember to release the camera when you are finished
	@Override
	protected void onPause() {
		super.onPause();
		releaseCamera();
	}

	private void releaseCamera() {
		if(camera != null){
			camera.release();
			camera = null;
		}
	}
}

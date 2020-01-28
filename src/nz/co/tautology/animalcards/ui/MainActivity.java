package nz.co.tautology.animalcards.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.IOException;
import nz.co.tautology.animalcards.FromXML;
import nz.co.tautology.animalcards.MyApplication;
import nz.co.tautology.animalcards.R;
import org.apache.commons.io.IOUtils;

public final class MainActivity extends Activity {
    private static final int SCAN_BARCODE_INTENT = 100;
    private static final int READ_MORE_INTENT = 101;
    
    private int soundResourceId = -1;
    private int textResourceId = R.raw.help_html;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView descriptionTextView = (TextView) findViewById(R.id.status_text);
        descriptionTextView.setText("");
        
        Button readmoreButton = (Button) findViewById(R.id.read_button);
        readmoreButton.setText("Usage");

        Button soundButton = (Button) findViewById(R.id.sound_button);
        soundButton.setVisibility(View.GONE);

        showPhotoByR(R.drawable.start);

        // Handle clicks on the 'Next' button.
        /*
        Button nextButton = (Button) findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mCurrentPhotoIndex = (mCurrentPhotoIndex + 1)
                        % mPhotoIds.length;
                showPhoto(mCurrentPhotoIndex);
            }
        });
        */
        
        /*
        Button scanButton = (Button) findViewById(R.id.scan_button);
        scanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {                
                onUseCameraClick(v);
            }
        });        
        */
        
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
        case R.id.about:
            AlertDialog about = new AlertDialog.Builder(MainActivity.this)
                .setIcon(R.drawable.about_dialog_icon)
                .setTitle(R.string.about_dialog_title)
                .setMessage(R.string.about_dialog_msg)
                .setPositiveButton(R.string.about_dialog_ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        /* User clicked OK so do some stuff */
                    }
                }).create();
            about.show();
            return true;
        case R.id.pick:
            AlertDialog pick = new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.title_pick)
                .setItems(R.array.pick_card_items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        String[] items = getResources().getStringArray(R.array.pick_card_items);
                        showBarcode(items[which]);
                    }
                }).create();
            pick.show();
            return true;
        default:
            return super.onOptionsItemSelected(item);
        }
    }

    private boolean cameraNotDetected() {
		return !getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
	}

	@FromXML
    public void onUseCameraClick(View button){
        if (cameraNotDetected())
        {
            Toast.makeText(this, "No camera found", Toast.LENGTH_LONG).show();
            return;
        }

    	Intent intent = new Intent(this, CameraActivity.class);
    	startActivityForResult(intent, SCAN_BARCODE_INTENT);
    }
	
	@FromXML
    public void onPlaySoundClick(View button){
        if (soundResourceId == -1)
            return;
        try {
            // R.raw.europeanwolf
            MediaPlayer mp = MediaPlayer.create(MainActivity.this, soundResourceId);
            mp.setOnCompletionListener(new OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();
                }
            });   
            mp.start();        
        } catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

	@FromXML
    public void onReadMoreClick(View button){
        try{
            Intent intent = new Intent(this, ReadMoreActivity.class);
            //byte[] map = IOUtils.toByteArray(MyApplication.getAppContext().getResources().openRawResource(R.raw.test));
            //String text = new String(map);
            String text = IOUtils.toString(MyApplication.getAppContext().getResources().openRawResource(textResourceId));
            intent.putExtra("text",text);
             startActivityForResult(intent, READ_MORE_INTENT);            
        } catch (IOException ioe)
        {
            Toast.makeText(this, ioe.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {       
        if(requestCode == SCAN_BARCODE_INTENT && resultCode == RESULT_OK){
            String barcode = data.getStringExtra(CameraActivity.EXTRA_IMAGE_PATH);
            if (barcode != null)
            {
                // Log.i("Got barcode: "+ imgPath);

                //displayImage(imgPath);
                                
                String code = Barcodes.getDescription(barcode);

                if (!code.equals(barcode))
                {
                    showBarcode(code);
                }
            }
        } else
        if (requestCode == SCAN_BARCODE_INTENT && resultCode == RESULT_CANCELED) {
            // Log.i("User didn't take an image");
        }        
    }

    private void showBarcode(String code)
    {
        try
        {
            int number = -1;
            String title = "";

            if (code.indexOf(',') != -1)
            {
                String as[] = code.split(",");
                number = Integer.parseInt(as[0]);
                title = as[1].trim();
            }
            else
                number = Integer.parseInt(code);

            TextView descriptionTextView = (TextView) findViewById(R.id.status_text);
            descriptionTextView.setText(title);
                                            
            textResourceId = Barcodes.getTextID(number);
            if (textResourceId == -1)
                textResourceId = R.raw.help_html;
            Button readmoreButton = (Button) findViewById(R.id.read_button);
            readmoreButton.setText(textResourceId == R.raw.help_html ? "Usage" : "Read More");
                                            
            soundResourceId = Barcodes.getSoundID(number);
            Button soundButton = (Button) findViewById(R.id.sound_button);
            soundButton.setVisibility(soundResourceId == -1 ? View.GONE : View.VISIBLE);

            showPhoto(number);
        } catch (Exception ex)
        {
            Toast.makeText(this, ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //outState.putInt("photo_index", mCurrentPhotoIndex);
        //super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        //mCurrentPhotoIndex = savedInstanceState.getInt("photo_index");
        //showPhoto(mCurrentPhotoIndex);
        //super.onRestoreInstanceState(savedInstanceState);
    }

    private void showPhotoByR(int rIndex) {
        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(rIndex);

        //TextView statusText = (TextView) findViewById(R.id.status_text);
        //statusText.setText(String.format("%d/%d", photoIndex + 1, mPhotoIds.length));
    }


    private void showPhoto(int photoIndex) {
        showPhotoByR(Barcodes.getPictureID(photoIndex));

        //TextView statusText = (TextView) findViewById(R.id.status_text);
        //statusText.setText(String.format("%d/%d", photoIndex + 1, mPhotoIds.length));
    }
}

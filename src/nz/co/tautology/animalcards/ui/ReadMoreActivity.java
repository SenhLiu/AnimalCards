package nz.co.tautology.animalcards.ui;

import nz.co.tautology.animalcards.R;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

/**
 *
 */
public class ReadMoreActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_readmore);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("text");

            if (value != null) {
                TextView textView = (TextView) findViewById(R.id.readmore_text);
                textView.setText(Html.fromHtml(value));
            }

        }
	}

}

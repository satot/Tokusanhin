package com.satot.tokusanhin;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayMessageActivity extends Activity {
    public final static String EXTRA_QUIZ_NO = "com.satot.Tokusanhin.QUIZNO";

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Get the message from the intent
		Intent intent = getIntent();
		String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
		Toast.makeText(this, message, Toast.LENGTH_LONG).show();
		
        // 画面描画
        setContentView(R.layout.activity_display_message);

	    // Create the text view
	    TextView textView = (TextView) findViewById(R.id.result);
	    textView.setTextSize(40);
	    textView.setText(message);
	    
		//setContentView(textView);
		
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// 次のクイズに移行
	public void gotoNextQuiz(View view){
		//Integer quizNo = quizNo + 1 ;
		Intent intent = new Intent(this, MainActivity.class);
        //intent.putExtra(EXTRA_QUIZ_NO, quizNo);
		startActivity(intent);
	}

}

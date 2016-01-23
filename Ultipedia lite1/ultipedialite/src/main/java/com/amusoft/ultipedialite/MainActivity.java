package com.amusoft.ultipedialite;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.shephertz.app42.paas.sdk.android.App42API;

public class MainActivity extends Quiz{
	SharedPreferences mGameSettings;


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		((TextView) findViewById(R.id.page_header)).setText("Main Activty");
		mGameSettings =
				getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		App42API.initialize(this, "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
 		   		"b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");  
		String q=mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
	        App42API.setLoggedInUser(q) ;
	        Util.registerWithApp42("future-grove-88623");
		
	}

	public void onClick(View view) {
		Intent intent = new Intent(this, MessageActivity.class);
		startActivity(intent);

	}


	public void onStart() {
		super.onStart();

	}

	/*
	 * * This method is called when a Activty is stop disable all the events if
	 * occuring (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStop()
	 */
	public void onStop() {
		super.onStop();

	}

	/*
	 * This method is called when a Activty is finished or user press the back
	 * button (non-Javadoc)
	 * 
	 * @override method of superclass
	 * 
	 * @see android.app.Activity#onDestroy()
	 */
	public void onDestroy() {
		super.onDestroy();

	}

	/*
	 * called when this activity is restart again
	 * 
	 * @override method of superclass
	 */
	public void onReStart() {
		super.onRestart();

	}

	/*
	 * called when activity is paused
	 * 
	 * @override method of superclass (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	public void onPause() {
		super.onPause();
		unregisterReceiver(mBroadcastReceiver);

	}

	/*
	 * called when activity is resume
	 * 
	 * @override method of superclass (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	public void onResume() {
		super.onResume();
		String message = getIntent().getStringExtra(App42GCMService.EXTRA_MESSAGE); 
	        Log.d("MainActivity-onResume", "Message Recieved :"+message);
	        IntentFilter filter = new IntentFilter(App42GCMService.DISPLAY_MESSAGE_ACTION);
	        filter.setPriority(2);
	        registerReceiver(mBroadcastReceiver, filter);
	}
	
	 final BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
		  
	        @Override
	        public void onReceive(Context context, Intent intent) {
	        	
	        	String message = intent.getStringExtra(App42GCMService.EXTRA_MESSAGE);
	        	Log.i("MainActivity-BroadcastReceiver", "Message Recieved " +" : " +message);
	        	((TextView) findViewById(R.id.text)).setText(message);
	        	
	        }
	    };
	    public void onBackPressed() {
			 Intent i = new Intent(getApplicationContext(), UtilMenu.class);
				startActivity(i);
			MainActivity.this.finish();
			
			 
			} 
}

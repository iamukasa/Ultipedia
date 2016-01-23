package com.example.oldultipedia;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class UtilMenu extends QuizActivity{
	static final int LEAVE_DIALOG_ID=2;
	static final int USER_DIALOG_ID=1;
	SharedPreferences mGameSettings;
	
	public Button btnPlay,btnSetting,btnHelp,btnScore;
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_util_menu);
		 btnPlay=(Button)findViewById(R.id.play);
		 btnSetting=(Button)findViewById(R.id.settings);
		 btnHelp=(Button)findViewById(R.id.help);
		 btnScore=(Button)findViewById(R.id.scores);
		 mGameSettings =
					getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		 
		 
		 if(mGameSettings.contains(GAME_PREFERENCES_USERNAME)&
			mGameSettings.contains(GAME_PREFERENCES_EMAIL)& 
			mGameSettings.contains(GAME_PREFERENCES_AVATAR)&
			mGameSettings.contains(GAME_PREFERENCES_PASSWORD)&
			mGameSettings.contains(GAME_PREFERENCES_DOB)){
			 
		 }else{
			 UtilMenu.this.showDialog(USER_DIALOG_ID);
			 
		 }
		 
		 
		 
		 
		onButton1();
		onButton2();
		onButton3();
		onButton4();
		
		
		
		
		
		
					 
				 
	 

	  }
	private void onButton4() {
		// TODO Auto-generated method stub
		btnScore.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				UtilMenu.this.finish();
				 Intent i=new Intent(getApplicationContext(),UtilScores.class);
				startActivity(i);
			}
			
		});
		
	}
	private void onButton1() {
		// TODO Auto-generated method stub
		btnPlay.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				UtilMenu.this.finish();
				 
				Intent i = new Intent(getApplicationContext(), UtilMode.class);
    			startActivity(i);
				
			}
			
		});
		
	}
	private void onButton2() {
		// TODO Auto-generated method stub
		btnHelp.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				UtilMenu.this.finish();
				Intent i = new Intent(getApplicationContext(), Utilhelp.class);
    			startActivity(i);
				
			}
			
		});
		
	}
	private void onButton3() {
		// TODO Auto-generated method stub
		btnSetting.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				UtilMenu.this.finish();
				 
				Intent i = new Intent(getApplicationContext(), UtilSettings.class);
    			startActivity(i);
				
			}
			
		});
		
	}
	public void onPause(){
		super.onPause();
	}
	public void onDestroy(){
		super.onDestroy();
	}
	
	public void onBackPressed() {
		UtilMenu.this.finish();
		
		Intent i = new Intent(getApplicationContext(), UltiSplash.class);
		startActivity(i);
		
		
		 
		}
	
	 protected Dialog onCreateDialog(int id){
		 switch(id){
		 case USER_DIALOG_ID:
			 LayoutInflater inflater =
				(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View layoutset =
				inflater.inflate(R.layout.set_setting,
						(ViewGroup) findViewById(R.id.setSet));
				
					TextView g=(TextView)layoutset.findViewById(R.id.msg);
					g.setText(R.string.setContent);
		
				
				
				AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setView(layoutset);
			builder.setTitle(R.string.setDialog);
			builder.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						onResume();
					UtilMenu.this.removeDialog(USER_DIALOG_ID);
					}
					});
			
			
			
			
			
			
			AlertDialog lDialog = builder.create();
					return lDialog;
				
					
			 
		 }
		return null;
		
	 
 	}
	 

	
	
}

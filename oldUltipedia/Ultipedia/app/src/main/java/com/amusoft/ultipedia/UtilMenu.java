package com.amusoft.ultipedia;

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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class UtilMenu extends Quiz{
	
	static final int USER_DIALOG_ID=1;
	static final int LEAVE_DIALOG_ID=2;
	
	
	SharedPreferences mGameSettings;
	
	public Button btnPlay,btnSetting,btnHelp,btnScore;
	
	public ImageView animeLogo;
	 protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_util_menu);
		 btnPlay=(Button)findViewById(R.id.play);
		 btnSetting=(Button)findViewById(R.id.settings);
		 btnHelp=(Button)findViewById(R.id.help);
		 btnScore=(Button)findViewById(R.id.scores);
		 animeLogo=(ImageView)findViewById(R.id.ee);
		
		 
		 
		 inAnimation();
		 
		 
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
	 private void inAnimation() {
		// TODO Auto-generated method stub
        Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.in_play);
        Animation fade3 = AnimationUtils.loadAnimation(this, R.anim.in_scores);
        Animation fade4 = AnimationUtils.loadAnimation(this, R.anim.in_help);
        Animation fade5 = AnimationUtils.loadAnimation(this, R.anim.in_settings);
		 animeLogo.setAnimation(fade1);
		 btnPlay.setAnimation(fade2);
		btnScore.setAnimation(fade3);
		 btnHelp.setAnimation(fade4);
		  btnSetting.setAnimation(fade5);;
	}
	private void outAnimation() {
			// TODO Auto-generated method stub
		Animation fadeO=AnimationUtils.loadAnimation(this, R.anim.fade_out);
		 animeLogo.setAnimation(fadeO);
		 btnPlay.setAnimation(fadeO);
		 btnSetting.setAnimation(fadeO);
		 btnHelp.setAnimation(fadeO);
		 btnScore.setAnimation(fadeO);
		 
			
		}
	private void onButton4() {
		// TODO Auto-generated method stub
		btnScore.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				 outAnimation();
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
				outAnimation();
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
				outAnimation();
				
				Intent i = new Intent(getApplicationContext(), Utilhelp.class);
    			startActivity(i);
    			UtilMenu.this.finish();
				
			}
			
		});
		
	}
	private void onButton3() {
		// TODO Auto-generated method stub
		btnSetting.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				outAnimation();
				
				Intent i = new Intent(getApplicationContext(), UtilSettings.class);
    			startActivity(i);
    			UtilMenu.this.finish();
				 
				
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
		UtilMenu.this.showDialog(LEAVE_DIALOG_ID);
		
		
		
		
		 
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
						inAnimation();
					UtilMenu.this.removeDialog(USER_DIALOG_ID);
					}
					});
			
			
			
			
			
			
			AlertDialog lDialog = builder.create();
					return lDialog;
		 case LEAVE_DIALOG_ID:
			 final LayoutInflater inflater2 =
				(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View layout =
				inflater2.inflate(R.layout.exit,
				(ViewGroup) findViewById(R.id.root));
				final Button btnLeave=(Button) layout.findViewById(R.id.leave);
				final Button btnStay=(Button)layout.findViewById(R.id.stay);
				btnLeave.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(final View v) {
						// TODO Auto-generated method stub
						UtilMenu.this.finish();
						UtilMenu.this
						.removeDialog(LEAVE_DIALOG_ID);
						
					
						
					}
				});
				
				btnStay.setOnClickListener(new View.OnClickListener() {
					
					@Override
					public void onClick(final View v) {
						// TODO Auto-generated method stub
						UtilMenu.this
						.removeDialog(LEAVE_DIALOG_ID);
						onResume();
					}
				});
				final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
				builder2.setView(layout);
				builder2.setTitle(R.string.exit);
				final AlertDialog llDialog = builder2.create();
				return llDialog;
					
			 
		 }
		return null;
		
	 
 	}
	 

	
	
}

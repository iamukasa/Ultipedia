package com.amusoft.ultipedia;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class UltiSplash extends  QuizActivity{
public ImageView imgIntro;

private int it;
static final int LEAVE_DIALOG_ID=1;
MediaPlayer backIntro;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulti_splash);
         imgIntro=(ImageView)findViewById(R.id.imo);
        
         
         final Animation fadeintro = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
         imgIntro.setAnimation(fadeintro);
         
 		
 		
 		backIntro=MediaPlayer.create(getApplicationContext(), R.raw.intro);
 		backIntro.setLooping(false);
 		backIntro.start();
 		
 		

            imgIntro.setOnClickListener(new OnClickListener(){
            @Override
        		public void onClick(final View v) {
        			// TODO Auto-generated method stub
            	UltiSplash.this.finish();
        			final Intent i = new Intent(getApplicationContext(), UtilMenu.class);
        			startActivity(i);
        			
        		}
            	
            });
           

           
       
    }
    protected void onStart(){
    	

    	super.onStart();
    	    	
    }
 protected void onPause(){
	backIntro.stop();
	 super.onPause();
	 
 }
   
 protected Dialog onCreateDialog(final int id) {
	 switch(id){
	 case LEAVE_DIALOG_ID:
	 final LayoutInflater inflater =
		(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		final View layout =
		inflater.inflate(R.layout.exit,
		(ViewGroup) findViewById(R.id.root));
		final Button btnLeave=(Button) layout.findViewById(R.id.leave);
		final Button btnStay=(Button)layout.findViewById(R.id.stay);
		btnLeave.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				UltiSplash.this.finish();
				UltiSplash.this
				.removeDialog(LEAVE_DIALOG_ID);
				
			
				
			}
		});
		
		btnStay.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				UltiSplash.this
				.removeDialog(LEAVE_DIALOG_ID);
				onResume();
			}
		});
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setView(layout);
		builder.setTitle(R.string.exit);
		final AlertDialog lDialog = builder.create();
		return lDialog;
	 
	 }
	return null;
 }
protected void onDestroy(){
	
	
		super.onDestroy();
		
	
	
}
protected void onResume(){
	super.onResume();

}
public void onBackPressed() {
	showDialog(LEAVE_DIALOG_ID);
	
	 
	}  


}

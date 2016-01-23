package com.example.oldultipedia;



import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class UltiSplash extends  QuizActivity{
public ImageView imgIntro;
static final int LEAVE_DIALOG_ID=2;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulti_splash);
        
       

            imgIntro=(ImageView)findViewById(R.id.im);
            imgIntro.setOnClickListener(new OnClickListener(){

        		@Override
        		public void onClick(final View v) {
        			// TODO Auto-generated method stub
        			 onDestroy();
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
	 super.onPause();
	 
 }
@Override  
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
				UltiSplash.this.finish();
				final Intent i = new Intent(getApplicationContext(), UtilMenu.class);
    			startActivity(i);
				
				
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

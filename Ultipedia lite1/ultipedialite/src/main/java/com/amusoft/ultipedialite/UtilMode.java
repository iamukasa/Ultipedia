package com.amusoft.ultipedialite;



import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class UtilMode extends Quiz{
	Button btnF,btnS;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ulti_choosemode);
		btnF=(Button)findViewById(R.id.chooseFun);
		btnS=(Button)findViewById(R.id.chooseschool);
		Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.in_play);
        Animation fade3 = AnimationUtils.loadAnimation(this, R.anim.in_scores);
        btnF.setAnimation(fade2);
        btnS.setAnimation(fade3);
		
		onClickButtonF();
		onCLickButtonS();
		
		
	}

	private void onCLickButtonS() {
		// TODO Auto-generated method stub
		btnS.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				UtilMode.this.finish();
				Intent i = new Intent(getApplicationContext(), UtilSubjectPicker.class);
    			startActivity(i);
    			UtilMode.this.finish();
				
			}
			
		});
		
	}

	private void onClickButtonF() {
		// TODO Auto-generated method stub
		btnF.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
				UtilMode.this.finish();
				Intent i = new Intent(getApplicationContext(), QuizActivity.class);
    			startActivity(i);
    			
			}
			
		});
		
	}
	public void onBackPressed() {
     UtilMode.this.finish();
     Intent i = new Intent(getApplicationContext(), UtilMenu.class);
		startActivity(i);
		
		 
		} 

}

package com.example.oldultipedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class UtilMode extends QuizActivity{
	Button btnF,btnS;
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ulti_choosemode);
		btnF=(Button)findViewById(R.id.chooseFun);
		btnS=(Button)findViewById(R.id.chooseschool);
		
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

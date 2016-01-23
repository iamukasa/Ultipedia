package com.example.oldultipedia;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class UtilSubjectPicker extends QuizActivity{
	Button btnMath,btnEng,btnKis,btnSci,btnSst,btnCre;
		protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subject_picker);
		btnMath=(Button)findViewById(R.id.math);
		btnEng=(Button)findViewById(R.id.eng);
		btnKis=(Button)findViewById(R.id.kis);
		btnSci=(Button)findViewById(R.id.sci);
		btnSst=(Button)findViewById(R.id.sst);
		btnCre=(Button)findViewById(R.id.cre);
		
		onBtn1();
		onBtn2();
		onBtn3();
		onBtn4();
		onBtn5();
		onBtn6();
		
				
		
	}
		private void onBtn1() {
			// TODO Auto-generated method stub
			btnMath.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					UtilSubjectPicker.this.finish();
					Intent i = new Intent(getApplicationContext(), QuizActivityMath.class);
	    			startActivity(i);
					
				}
				
			});
			
		}
		private void onBtn2() {
			// TODO Auto-generated method stub
			btnEng.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					UtilSubjectPicker.this.finish();
					Intent i = new Intent(getApplicationContext(), QuizActivityEng.class);
	    			startActivity(i);
					
				}
				
			});
			
		}
		private void onBtn3() {
			// TODO Auto-generated method stub
			btnKis.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					UtilSubjectPicker.this.finish();
					Intent i = new Intent(getApplicationContext(), QuizActivityKis.class);
	    			startActivity(i);
					
				}
				
			});
			
		}
		private void onBtn4() {
			// TODO Auto-generated method stub
			btnSci.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					UtilSubjectPicker.this.finish();
					Intent i = new Intent(getApplicationContext(), QuizActivitySci.class);
	    			startActivity(i);
					
				}
				
			});
			
		}
		private void onBtn5() {
			// TODO Auto-generated method stub
			btnSst.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					UtilSubjectPicker.this.finish();
					Intent i = new Intent(getApplicationContext(), QuizActivitySocial.class);
	    			startActivity(i);
					
				}
				
			});
			
		}
		private void onBtn6() {
			// TODO Auto-generated method stub
			btnCre.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View view) {
					// TODO Auto-generated method stub
					UtilSubjectPicker.this.finish();
					Intent i = new Intent(getApplicationContext(), QuizActivityCre.class);
	    			startActivity(i);
					
				}
				
			});
			
		}
		public void onBackPressed() {
			 Intent i = new Intent(getApplicationContext(), UtilMenu.class);
				startActivity(i);
			UtilSubjectPicker.this.finish();
			
			 
			} 
	

}

package com.example.oldultipedia;



import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
 	public class QuizActivityMath extends Quiz {
		 List<Question> quesListMath; 
		 Double ife=Math.random()*10;
		 int g=ife.intValue();
 	 int scoreMath=0;
 	 int qidMath=g;
 	int qMon=0;
 	int qlvl=1;
 	 Question currentQ;
	 TextView txtQuestion;
 	 Button rda, rdb, rdc,rdd;  
 	static final int GET_WRONG=1;
 	static final int SCORE_DIALOG=2;
 	static final int RUN_OUT=3;
 	SharedPreferences mGameSettings;
 	
	 @Override
	 protected void onCreate(Bundle savedInstanceState) {
	 super.onCreate(savedInstanceState);
		 setContentView(R.layout.activity_quiz);
		 mGameSettings =
					getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		 DbHelperMath db=new DbHelperMath(this);
		 quesListMath=db.getAllQuestions();
		 currentQ=quesListMath.get(qidMath);
 	 txtQuestion=(TextView)findViewById(R.id.textView1);
		 rda=(Button)findViewById(R.id.radio0);
	 rdb=(Button)findViewById(R.id.radio1);
		 rdc=(Button)findViewById(R.id.radio2);
		 rdd=(Button)findViewById(R.id.radio3);
		
		 rda.setOnClickListener(new View.OnClickListener(){
	         @Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
	        	 checkAnswer(1);			       
				 	currentQ=quesListMath.get(qidMath);
				 	if(qidMath==46){
				    	   QuizActivityMath.this.showDialog(RUN_OUT);
				    	   
				       }
					 if(qMon%2==0 & qMon%3==0){
						 QuizActivityMath.this
						 .showDialog(SCORE_DIALOG);
						 qlvl++;
						 
						
						
					 }else{
						 setQuestionView();
						 
					 }
					 
					 
					 
					
				}
				 
			 });
			 rdb.setOnClickListener(new View.OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						checkAnswer(2);
					 currentQ=quesListMath.get(qidMath);
					 if(qidMath==46){
				    	   QuizActivityMath.this.showDialog(RUN_OUT);
				    	   
				       }
					 if(qMon%2==0 & qMon%3==0){
						 QuizActivityMath.this
						 .showDialog(SCORE_DIALOG);
						 qlvl++;
						 
						
						
					 }else{
						 setQuestionView();
						 
					 }
					 
					 
						
					}
					 
				 });
			 rdc.setOnClickListener(new View.OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
						checkAnswer(3);
					 	currentQ=quesListMath.get(qidMath);
					 	if(qidMath==46){
					    	   QuizActivityMath.this.showDialog(RUN_OUT);
					    	   
					    	   
					       }
					 	if(qMon%2==0 & qMon%3==0){
							 QuizActivityMath.this
							 .showDialog(SCORE_DIALOG);
							 qlvl++;
							 
							
							
						 }else{
							 setQuestionView();
							 
						 }
						 
						 
						
					}
					 
				 });
			 rdd.setOnClickListener(new View.OnClickListener(){

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						checkAnswer(4);
					 	currentQ=quesListMath.get(qidMath);
					 	if(qidMath==46){
					    	   QuizActivityMath.this.showDialog(RUN_OUT);
					    	   
					       }
					 	if(qMon%2==0 & qMon%3==0){
							 QuizActivityMath.this
							 .showDialog(SCORE_DIALOG);
							 qlvl++;
							 
							
							
						 }else{
							 setQuestionView();
							 
						 }
						 
						 
						
					}
					 
				 });
			 
			 
			 
			 
	 	 setQuestionView();
	 	
 	 }
 	 @Override
 	 public boolean onCreateOptionsMenu(Menu menu) {
 	 // Inflate the menu; this adds items to the action bar if it is present.
		 getMenuInflater().inflate(R.menu.activity_quiz, menu);
	 return true;
		 }
	 private void setQuestionView()
		 {
		 txtQuestion.setText(currentQ.getQUESTION());
 	 rda.setText(currentQ.getOPTA());
 	 rdb.setText(currentQ.getOPTB());
		 rdc.setText(currentQ.getOPTC());
		 rdd.setText(currentQ.getOPTD());
		
		 qidMath++;
		 qMon++;
	 }	
	 
	 protected Dialog onCreateDialog(int id){
		 switch(id){
		 case SCORE_DIALOG:
			 LayoutInflater inflater =
				(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View layoutscore =
				inflater.inflate(R.layout.activity_result,
						(ViewGroup) findViewById(R.id.scoreact));
				 mGameSettings =
							getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
				 if (mGameSettings.contains(GAME_HIGHEST_LEVEL_MATH)){
					 String y=String.valueOf(qlvl);
					 Editor editLevel=mGameSettings.edit();
					 editLevel.putString(GAME_HIGHEST_LEVEL_MATH, y);
					 editLevel.commit();
					 
				 }
				 else{
					 String wer=String.valueOf(qlvl);
					 Editor editLevel2=mGameSettings.edit();
					 editLevel2.putString(GAME_HIGHEST_LEVEL_MATH, wer);
					 editLevel2.commit();
				 };
			 RatingBar bar=(RatingBar)layoutscore.findViewById(R.id.ratingBar1);
				  bar.setNumStars(qlvl);
				   bar.setStepSize(0.5f);
				   
				   bar.setRating(qlvl);
				   TextView t=(TextView)layoutscore.findViewById(R.id.textResult);
					t.setText("Your Score is :"+scoreMath);
				          //get text view
					if(mGameSettings.contains(GAME_PREFERENCES_SCORE_MATH)){
						String scr=mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH,null);
						
						t.setText("Your Score is :"+scr);
						

					}
					TextView u=(TextView)layoutscore.findViewById(R.id.avausername);
					if(mGameSettings.contains(GAME_PREFERENCES_USERNAME)){
						String name=mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
						u.setText(name);
					}
					
					if (mGameSettings.contains(GAME_PREFERENCES_AVATAR)){
						String imgs =mGameSettings.getString(GAME_PREFERENCES_AVATAR,null);
						ImageView img=(ImageView)layoutscore.findViewById(R.id.avascore);

						Uri path=Uri.parse(imgs);
						
						img.setImageURI(null);
						img.setImageURI(path);
						
					}
		 AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setView(layoutscore);
			builder.setTitle(R.string.title_sscr);
			builder.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						onResume();
						QuizActivityMath.this
						 .removeDialog(SCORE_DIALOG);
					
					}
					});
			
			
			
			
			
			
			AlertDialog lDialog = builder.create();
					return lDialog;
		 case RUN_OUT:
			 LayoutInflater inflater2 =
				(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View layoutset =
				inflater2.inflate(R.layout.set_setting,
						(ViewGroup) findViewById(R.id.setSet));
				
					TextView g=(TextView)layoutset.findViewById(R.id.msg);
					g.setText(R.string.sry_content);
		
				
				
				AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
			builder2.setView(layoutset);
			builder2.setTitle(R.string.sry);
			builder2.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						QuizActivityMath.this.removeDialog(RUN_OUT);
						QuizActivityMath.this.finish();
						 Intent i = new Intent(getApplicationContext(), UtilMenu.class);
							startActivity(i);
						
						
					
					
					}
					});
			
			
			
			
			
			
			AlertDialog lDialog1 = builder2.create();
					return lDialog1;
		 case GET_WRONG:
			 LayoutInflater inflater3 =
				(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				final View layoutswrong =
				inflater3.inflate(R.layout.set_setting,
						(ViewGroup) findViewById(R.id.setSet));
				TextView wrn=(TextView)layoutswrong.findViewById(R.id.msg);
				if(mGameSettings.contains(GAME_CURRENT_ANS_MATH)){
					 String Final=mGameSettings.getString(GAME_CURRENT_ANS_MATH , null);
					wrn.setText(Final);
					
					 
				 }
		AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
			builder3.setView(layoutswrong);
			builder3.setTitle(R.string.wwrn);
			builder3.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						TextView wrn=(TextView)layoutswrong.findViewById(R.id.msg);
						wrn.clearComposingText();
						QuizActivityMath.this.removeDialog(GET_WRONG);
					
					}
					});
		AlertDialog lDialog11 = builder3.create();
					return lDialog11;
					
			 
		 }
		
		 
		return null;
		 
		 
	 }
	 protected void onResume(){
		 super.onResume();

	 	 setQuestionView();
		 
		 
	 }
	 private void checkAnswer(int i) {
			// TODO Auto-generated method stub
			switch(i){
			case 1:
				 Button answer=(Button)findViewById(R.id.radio0);
				 Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
				  if(currentQ.getANSWER().contentEquals(answer.getText()))
				 	 {
				 	 scoreMath++;
				 	 String d=String.valueOf(scoreMath);
					 	Editor editor=mGameSettings.edit();
					 	editor.putString(GAME_PREFERENCES_SCORE_MATH,d);
					 	editor.commit();
							Log.d(DEBUG_TAG, "Score is : "
					                    + mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, "Not set"));
				 	  Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
					 }
				 	 else{
				 		String d="The correct answer is\n"+currentQ.getANSWER();
				 		Editor editor2=mGameSettings.edit();
					 	editor2.putString(GAME_CURRENT_ANS_MATH,d);
					 	editor2.commit();
					 	QuizActivityMath.this.showDialog(GET_WRONG);
				 	 }
			        Log.d("score", "Your score"+scoreMath);
				break;
			case 2:
				 Button answer1=(Button)findViewById(R.id.radio1);
			 	 Log.d("yourans", currentQ.getANSWER()+" "+answer1.getText()); 	
			 if(currentQ.getANSWER().contentEquals(answer1.getText()))
			 	 {
			 	 scoreMath++;
			 	 String d=String.valueOf(scoreMath);
			 	Editor editor=mGameSettings.edit();
			 	editor.putString(GAME_PREFERENCES_SCORE_MATH,d);
			 	editor.commit();
					 Log.d("score", "Your score"+scoreMath);
					 Log.d(DEBUG_TAG, "Score is : "
			                    + mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, "Not set"));
					 Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
				 }else{
					 String d="The correct answer is\n"+currentQ.getANSWER();
				 		Editor editor2=mGameSettings.edit();
					 	editor2.putString(GAME_CURRENT_ANS_MATH,d);
					 	editor2.commit();
					 	QuizActivityMath.this.showDialog(GET_WRONG);
			 	 }
			 Log.d("score", "Your score"+scoreMath);
				break;
			case 3:
				Button answer11=(Button)findViewById(R.id.radio2);
			 	 Log.d("yourans", currentQ.getANSWER()+" "+answer11.getText()); 
			 	 if(currentQ.getANSWER().contentEquals(answer11.getText()))
			 	 {
			 	 scoreMath++;
			 	String d=String.valueOf(scoreMath);
			 	Editor editor=mGameSettings.edit();
			 	editor.putString(GAME_PREFERENCES_SCORE_MATH,d);
			 	editor.commit();
					 Log.d("score", "Your score"+scoreMath);
					 Log.d(DEBUG_TAG, "Score is : "
			                    + mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, "Not set"));
					 Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
				 }else{
					 String d="The correct answer is\n"+currentQ.getANSWER();
				 		Editor editor2=mGameSettings.edit();
					 	editor2.putString(GAME_CURRENT_ANS_MATH,d);
					 	editor2.commit();
					 	QuizActivityMath.this.showDialog(GET_WRONG);
			 		}
			 	Log.d("score", "Your score"+scoreMath);
				break;
			case 4:
				Button answer111=(Button)findViewById(R.id.radio3);
			 	 Log.d("yourans", currentQ.getANSWER()+" "+answer111.getText()); 	
			 	 if(currentQ.getANSWER().contentEquals(answer111.getText()))
			 	 {
			 	 scoreMath++;
			 	String d=String.valueOf(scoreMath);
			 	Editor editor=mGameSettings.edit();
			 	editor.putString(GAME_PREFERENCES_SCORE_MATH,d);
			 	editor.commit();
					 Log.d("score", "Your score"+scoreMath);
					 Log.d(DEBUG_TAG, "Score is : "
			                    + mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, "Not set"));
					 Toast.makeText(getApplicationContext(),"correct",Toast.LENGTH_SHORT).show();
				 }else{
					 String d="The correct answer is\n"+currentQ.getANSWER();
				 		Editor editor2=mGameSettings.edit();
					 	editor2.putString(GAME_CURRENT_ANS_MATH,d);
					 	editor2.commit();
					 	QuizActivityMath.this.showDialog(GET_WRONG);
			 		 }
			 	Log.d("score", "Your score"+scoreMath);
				break;
				
		}
			
		}
	 public void onBackPressed() {
		 QuizActivityMath.this.finish();
		 
		 Intent i = new Intent(getApplicationContext(), UtilMenu.class);
			startActivity(i);
			 
			} 
	 
 	}


package com.amusoft.ultipedia;



import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.concurrent.TimeUnit;


@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")

public class QuizActivity extends Quiz {
	List<Question> quesList; 
	Double ife=Math.random()*15;
	int g=ife.intValue();
	int score=0;
	int qid=g;
	int qMon=0;
	int qlvl=0;
	Question currentQ;
	TextView txtQuestion,textViewTime;
	Button rda, rdb, rdc,rdd;
	static final int GET_WRONG=1;
	static final int GET_RIGHT=2;
	static final int SCORE_DIALOG=3;
	static final int RUN_OUT=4;
	
	
	
	
	private SoundPool sounds;
	private int wrong;
	private int right;
	TextToSpeech tts,ttTO;
	//ProgressIndicator mProgressIndicator1;
	
	float max = 2;
	float update = 0;
	boolean threadRunning = false;;
	ProgressBar pb;
	SharedPreferences mGameSettings;
	static final int TIME_OUT=5;
 CounterClass timer = new CounterClass(30000, 1000);

	@Override
	protected void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		final DbHelper db=new DbHelper(this);
				mGameSettings =
				getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
		quesList=db.getAllQuestions();
		currentQ=quesList.get(qid);
		txtQuestion=(TextView)findViewById(R.id.textView1);

		rda=(Button)findViewById(R.id.radio0);
		rdb=(Button)findViewById(R.id.radio1);
		rdc=(Button)findViewById(R.id.radio2);
		rdd=(Button)findViewById(R.id.radio3);
		sounds =new SoundPool(10,AudioManager.STREAM_MUSIC, 0);
		right=sounds.load(getBaseContext(),R.raw.correct,1);
		wrong=sounds.load(getBaseContext(), R.raw.wrong,2);
		
		
		
       textViewTime = (TextView) findViewById(R.id.textViewTime);
             

		rda.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
			  timer.cancel();
			  textViewTime.clearComposingText();
				  
				checkAnswer(1);
				currentQ=quesList.get(qid);
				if(qid==271){
					QuizActivity.this.showDialog(RUN_OUT);

				}
				
				
			}
			
		});
		rdb.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				checkAnswer(2);
				timer.cancel();
				 textViewTime.clearComposingText();
				  
				currentQ=quesList.get(qid);
				if(qid==271){
					QuizActivity.this.showDialog(RUN_OUT);

				}

				
			}


		});
		rdc.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				checkAnswer(3);
				timer.cancel();
				timer.onFinish();
				 textViewTime.clearComposingText();
				  
				  
				currentQ=quesList.get(qid);
				if(qid==271){
					QuizActivity.this.showDialog(RUN_OUT);

				}
				
			}
		});
		rdd.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(final View v) {
				// TODO Auto-generated method stub
				checkAnswer(4);
				timer.cancel();
				 textViewTime.clearComposingText();
				  
				currentQ=quesList.get(qid);
				if(qid==271){
					QuizActivity.this.showDialog(RUN_OUT);

				}
				
			}
		});
		
		
		


	}

	private void setQuestionView()
	{
		txtQuestion.clearComposingText();
		rda.clearComposingText();
		rdb.clearComposingText();
		rdc.clearComposingText();
		rdd.clearComposingText();
		textViewTime.setText("00:00:30");
		timer.start();
		txtQuestion.setText(currentQ.getQUESTION());
		rda.setText(currentQ.getOPTA());
		rdb.setText(currentQ.getOPTB());
		rdc.setText(currentQ.getOPTC());
		rdd.setText(currentQ.getOPTD());
		final Double ife2=Math.random()*50;
		final int g2=ife2.intValue();
		qid=g2;
		qMon++;
		
		final Animation fadeQ = AnimationUtils.loadAnimation(this, R.anim.fade_in);
		txtQuestion.setAnimation(fadeQ);
		 
		 final Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade_in);
			txtQuestion.setAnimation(fade);
			final Animation fadeA = AnimationUtils.loadAnimation(this, R.anim.left_righta);
			final Animation fadeB = AnimationUtils.loadAnimation(this, R.anim.left_rightb);
			final Animation fadeC = AnimationUtils.loadAnimation(this, R.anim.left_rightc);
			final Animation fadeD = AnimationUtils.loadAnimation(this, R.anim.left_rightd);
			rda.setAnimation(fadeA);
			rdb.setAnimation(fadeB);
			rdc.setAnimation(fadeC);
			rdd.setAnimation(fadeD);
			
	}
	
	@TargetApi(Build.VERSION_CODES.GINGERBREAD)
	@SuppressLint("NewApi") class CounterClass extends CountDownTimer {
					static final int TIME_OUT=5;
        public CounterClass(long millisInFuture, long countDownInterval) {
	super(millisInFuture, countDownInterval);
	}

						@SuppressLint("NewApi")
						@TargetApi(Build.VERSION_CODES.GINGERBREAD)
						@Override
						public void onTick(long millisUntilFinished) {
							// TODO Auto-generated method stub
							
							long millis = millisUntilFinished;
							String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
									TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
									TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
							System.out.println(hms);
							
							if (hms.contentEquals("00:00:01")){
								textViewTime.clearComposingText();
								QuizActivity.this.showDialog(TIME_OUT);
								
								}
							else{
								textViewTime.setText(hms);	
							}
							
						}
						@Override
						public void onFinish() {
							// TODO Auto-generated method stub
							
							textViewTime.clearComposingText();
							
							
						}


					}

	private void checkAnswer(final int i) {
		// TODO Auto-generated method stub
		switch(i){
		case 1:
			final Button answer=(Button)findViewById(R.id.radio0);
			Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
			if(currentQ.getANSWER().contentEquals(answer.getText()))
			{
				score++;
				final String d=String.valueOf(score);
				final Editor editor=mGameSettings.edit();
				editor.putString(GAME_PREFERENCES_SCORE_FUN,d);
				editor.commit();
				
				QuizActivity.this.showDialog(GET_RIGHT);
				sounds.play(right,1.0f,1.0f,0,0,1.5f);
				
				
			}
			else{
				final String d="The correct answer is\n"+currentQ.getANSWER();
				
				final Editor editor2=mGameSettings.edit();
				editor2.putString(GAME_CURRENT_ANS,d);
				editor2.commit();
				final String n=currentQ.getNOTE();
				final Editor editor22=mGameSettings.edit();
				editor22.putString(GAME_CURRENT_NOTE,n);
				editor22.commit();
				
				QuizActivity.this.showDialog(GET_WRONG);
				sounds.play(wrong,1.0f,1.0f,0,0,1.5f);
				
			}
			Log.d("score", "Your score"+score);
			break;
		case 2:
			final Button answer1=(Button)findViewById(R.id.radio1);
			Log.d("yourans", currentQ.getANSWER()+" "+answer1.getText()); 	
			if(currentQ.getANSWER().contentEquals(answer1.getText()))
			{
				score++;
				final String d=String.valueOf(score);
				final Editor editor=mGameSettings.edit();
				editor.putString(GAME_PREFERENCES_SCORE_FUN,d);
				editor.commit();
				Log.d("score", "Your score"+score);
				Log.d(DEBUG_TAG, "Score is : "
						+ mGameSettings.getString(GAME_PREFERENCES_SCORE_FUN, "Not set"));
				QuizActivity.this.showDialog(GET_RIGHT);
				sounds.play(right,1.0f,1.0f,0,0,1.5f);
			}else{
				final String d="The correct answer is\n"+currentQ.getANSWER();
               final Editor editor2=mGameSettings.edit();
				editor2.putString(GAME_CURRENT_ANS,d);
				editor2.commit();
				
				final String n=currentQ.getNOTE();
				final Editor editor22=mGameSettings.edit();
				editor22.putString(GAME_CURRENT_NOTE,n);
				editor22.commit();
				
				QuizActivity.this.showDialog(GET_WRONG);
				sounds.play(wrong,1.0f,1.0f,0,0,1.5f);
			}
			Log.d("score", "Your score"+score);
			break;
		case 3:
			final Button answer11=(Button)findViewById(R.id.radio2);
			Log.d("yourans", currentQ.getANSWER()+" "+answer11.getText()); 
			if(currentQ.getANSWER().contentEquals(answer11.getText()))
			{
				score++;
				final String d=String.valueOf(score);
				final Editor editor=mGameSettings.edit();
				editor.putString(GAME_PREFERENCES_SCORE_FUN,d);
				editor.commit();
				final String n=currentQ.getNOTE();
				final Editor editor22=mGameSettings.edit();
				editor22.putString(GAME_CURRENT_NOTE,n);
				editor22.commit();
				
				Log.d("score", "Your score"+score);
				Log.d(DEBUG_TAG, "Score is : "
						+ mGameSettings.getString(GAME_PREFERENCES_SCORE_FUN, "Not set"));
				QuizActivity.this.showDialog(GET_RIGHT);
				sounds.play(right,1.0f,1.0f,0,0,1.5f);
			}else{
				final String d="The correct answer is\n"+currentQ.getANSWER();

				final Editor editor2=mGameSettings.edit();
				editor2.putString(GAME_CURRENT_ANS,d);
				editor2.commit();
				final String n=currentQ.getNOTE();
				final Editor editor22=mGameSettings.edit();
				editor22.putString(GAME_CURRENT_NOTE,n);
				editor22.commit();
				
				QuizActivity.this.showDialog(GET_WRONG);
				sounds.play(wrong,1.0f,1.0f,0,0,1.5f);
			}
			Log.d("score", "Your score"+score);
			break;
		case 4:
			final Button answer111=(Button)findViewById(R.id.radio3);
			Log.d("yourans", currentQ.getANSWER()+" "+answer111.getText()); 	
			if(currentQ.getANSWER().contentEquals(answer111.getText()))
			{
				score++;
				final String d=String.valueOf(score);
				final Editor editor=mGameSettings.edit();
				editor.putString(GAME_PREFERENCES_SCORE_FUN,d);
				editor.commit();
				Log.d("score", "Your score"+score);
				Log.d(DEBUG_TAG, "Score is : "
						+ mGameSettings.getString(GAME_PREFERENCES_SCORE_FUN, "Not set"));
				QuizActivity.this.showDialog(GET_RIGHT);
				sounds.play(right,1.0f,1.0f,0,0,1.5f);
			}else{
				final String d="The correct answer is\n"+currentQ.getANSWER();
				final Editor editor2=mGameSettings.edit();
				editor2.putString(GAME_CURRENT_ANS,d);
				editor2.commit();
				final String n=currentQ.getNOTE();
				final Editor editor22=mGameSettings.edit();
				editor22.putString(GAME_CURRENT_NOTE,n);
				editor22.commit();
				
				QuizActivity.this.showDialog(GET_WRONG);
				sounds.play(wrong,1.0f,1.0f,0,0,1.5f);
			}
			Log.d("score", "Your score"+score);
			break;

		}

	}

	@Override
	protected Dialog onCreateDialog(final int id){
		switch(id){
		case SCORE_DIALOG:
			final LayoutInflater inflater =
			(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View layoutscore =
					inflater.inflate(R.layout.activity_result,
							(ViewGroup) findViewById(R.id.scoreact));
			mGameSettings =
					getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
			if (mGameSettings.contains(GAME_HIGHEST_LEVEL)){
				final String y=String.valueOf(qlvl);
				final Editor editLevel=mGameSettings.edit();
				editLevel.putString(GAME_HIGHEST_LEVEL, y);
				editLevel.commit();

			}
			else{
				final String wer=String.valueOf(qlvl);
				final Editor editLevel2=mGameSettings.edit();
				editLevel2.putString(GAME_HIGHEST_LEVEL, wer);
				editLevel2.commit();
			}
			final RatingBar bar=(RatingBar)layoutscore.findViewById(R.id.ratingBar1);
			bar.setNumStars(qlvl);
			bar.setStepSize(0.5f);
			bar.setRating(qlvl);
			final TextView t=(TextView)layoutscore.findViewById(R.id.textResult);
			t.setText("Your Score is :"+score);
			//get text view
			if(mGameSettings.contains(GAME_PREFERENCES_SCORE_FUN)){
				final String scr=mGameSettings.getString(GAME_PREFERENCES_SCORE_FUN,null);

				t.setText("Your Score is :"+scr);


			}

			final TextView u=(TextView)layoutscore.findViewById(R.id.avausername);
			if(mGameSettings.contains(GAME_PREFERENCES_USERNAME)){
				final String name=mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
				u.setText(name);
			}


			if (mGameSettings.contains(GAME_PREFERENCES_AVATAR)){
				final String imgs =mGameSettings.getString(GAME_PREFERENCES_AVATAR,null);
				final ImageView img=(ImageView)layoutscore.findViewById(R.id.avascore);

				final Uri path=Uri.parse(imgs);
				img.setImageURI(null);
				img.setImageURI(path);

			}
			final AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setView(layoutscore);
			builder.setTitle(R.string.title_sscr);
			builder.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {
					setQuestionView();
					QuizActivity.this
					.removeDialog(SCORE_DIALOG);

					
					 
				}
			});
			final AlertDialog lDialog = builder.create();
			return lDialog;
		case RUN_OUT:
			final LayoutInflater inflater2 =
			(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View layoutset =
					inflater2.inflate(R.layout.set_setting,
							(ViewGroup) findViewById(R.id.setSet));

			final TextView g=(TextView)layoutset.findViewById(R.id.msg);
			g.setText(R.string.sry_content);



			final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
			builder2.setView(layoutset);
			builder2.setTitle(R.string.sry);
			builder2.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {
					QuizActivity.this.removeDialog(RUN_OUT);
					QuizActivity.this.finish();
					 
					final Intent i = new Intent(getApplicationContext(), UtilMenu.class);
					startActivity(i);

				}
			});
			final AlertDialog lDialog1 = builder2.create();
			return lDialog1;
		case GET_WRONG:
			final LayoutInflater inflater3 =
			(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View layoutswrong =
					inflater3.inflate(R.layout.wrong_dialogue,
							(ViewGroup) findViewById(R.id.wrngDil));
			final TextView wrn=(TextView)layoutswrong.findViewById(R.id.rAns);
			if(mGameSettings.contains(GAME_CURRENT_ANS)){
				final String Final=mGameSettings.getString(GAME_CURRENT_ANS, null);
				wrn.setText(Final);
				
				
				}
			
			final TextView notes=(TextView)layoutswrong.findViewById(R.id.qNotes);
			if(mGameSettings.contains(GAME_CURRENT_NOTE)){
				final String Finaln=mGameSettings.getString(GAME_CURRENT_NOTE, null);
				notes.setText(Finaln);
				tts=new TextToSpeech(QuizActivity.this,new TextToSpeech.OnInitListener() {
					
					@Override
					public void onInit(int status) {
						// TODO Auto-generated method stub
						if(status!=TextToSpeech.ERROR){
							tts.setLanguage(Locale.UK);
							tts.speak(Finaln, TextToSpeech.QUEUE_FLUSH, null);
						}
						
					}
				} );
			}
			
			
	
			final AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
			builder3.setView(layoutswrong);
			builder3.setTitle(R.string.wwrn);
			builder3.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {
					final TextView wrn=(TextView)layoutswrong.findViewById(R.id.rAns);
					wrn.clearComposingText();
					final TextView notes=(TextView)layoutswrong.findViewById(R.id.qNotes);
					notes.clearComposingText();
					
					tts.stop();
					tts.shutdown();
					
					QuizActivity.this.removeDialog(GET_WRONG);
					if(qMon%2==0 & qMon%3==0){
						QuizActivity.this
						.showDialog(SCORE_DIALOG);
						qlvl++;
						if (mGameSettings.contains(GAME_HIGHEST_LEVEL)){
							final String y=String.valueOf(qlvl);
							final Editor editLevel=mGameSettings.edit();
							editLevel.putString(GAME_HIGHEST_LEVEL, y);
							editLevel.commit();

						}
						else{
							final String wer=String.valueOf(qlvl);
							final Editor editLevel2=mGameSettings.edit();
							editLevel2.putString(GAME_HIGHEST_LEVEL, wer);
							editLevel2.commit();
						}
					}else{
						setQuestionView();
						
					}

				}
			});
			final AlertDialog lDialog11 = builder3.create();
			return lDialog11;
		case GET_RIGHT:
			final LayoutInflater inflater4 =
			(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View layoutsright =
					inflater4.inflate(R.layout.set_setting,
							(ViewGroup) findViewById(R.id.setSet));
			final TextView wrnR=(TextView)layoutsright.findViewById(R.id.msg);
			wrnR.setText("Correct!!!!!!!!!!");
			
			final AlertDialog.Builder builder4= new AlertDialog.Builder(this);
			builder4.setView(layoutsright);
			builder4.setTitle("You Got that Right");
			builder4.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {
					final TextView wrn=(TextView)layoutsright.findViewById(R.id.msg);
					wrn.clearComposingText();
					 
					QuizActivity.this.removeDialog(GET_RIGHT);
					if(qMon%2==0 & qMon%3==0){
						QuizActivity.this
						.showDialog(SCORE_DIALOG);
						qlvl++;
						if (mGameSettings.contains(GAME_HIGHEST_LEVEL)){
							final String y=String.valueOf(qlvl);
							final Editor editLevel=mGameSettings.edit();
							editLevel.putString(GAME_HIGHEST_LEVEL, y);
							editLevel.commit();

						}
						else{
							final String wer=String.valueOf(qlvl);
							final Editor editLevel2=mGameSettings.edit();
							editLevel2.putString(GAME_HIGHEST_LEVEL, wer);
							editLevel2.commit();
						}
					}else{
						setQuestionView();
					}

				}
			});
			final AlertDialog lDialogRight = builder4.create();
			return lDialogRight;
			
		case TIME_OUT:
			final LayoutInflater inflatert =
			(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			final View layoutsetT =
					inflatert.inflate(R.layout.set_setting,
							(ViewGroup) findViewById(R.id.setSet));

			final TextView TM=(TextView)layoutsetT.findViewById(R.id.msg);
			score = score+0;
		final String outi="OOPS!! you ran out of time ,You Score 0 Points On this Question";
			TM.setText(outi);
			
			ttTO=new TextToSpeech(QuizActivity.this,new TextToSpeech.OnInitListener() {
				
				@Override
				public void onInit(int status) {
					// TODO Auto-generated method stub
					if(status!=TextToSpeech.ERROR){
						ttTO.setLanguage(Locale.UK);
						ttTO.speak(outi, TextToSpeech.QUEUE_ADD, null);
					}
					
				}
			} );
			

			final AlertDialog.Builder builderT = new AlertDialog.Builder(this);
			builderT.setView(layoutsetT);
			builderT.setTitle("Out of Time");
			builderT.setPositiveButton(android.R.string.ok,
					new DialogInterface.OnClickListener() {
				public void onClick(final DialogInterface dialog, final int which) {
					QuizActivity.this.removeDialog(TIME_OUT);
					
					if(qMon%2==0 & qMon%3==0){
						QuizActivity.this
						.showDialog(SCORE_DIALOG);
						qlvl++;
						if (mGameSettings.contains(GAME_HIGHEST_LEVEL)){
							final String y=String.valueOf(qlvl);
							final Editor editLevel=mGameSettings.edit();
							editLevel.putString(GAME_HIGHEST_LEVEL, y);
							editLevel.commit();

						}
						else{
							final String wer=String.valueOf(qlvl);
							final Editor editLevel2=mGameSettings.edit();
							editLevel2.putString(GAME_HIGHEST_LEVEL, wer);
							editLevel2.commit();
						}
					}else{
						setQuestionView();
						
					}
					

				}
			});
			final AlertDialog lDialogT = builderT.create();
			return lDialogT;
			

		}
		return null;
	}

	protected void onResume(){

		super.onResume();
		setQuestionView();
		

	}
protected void onStart(){
		
super.onStart();

setQuestionView();
	
	
	}
	protected void onStop(){
		super.onStop();
		timer.cancel();
		
	}
	protected void onPause(){
		super.onPause();
		timer.cancel();
	}

	public void onBackPressed() {
		QuizActivity.this.finish();
		 QuizActivity.this.onStop();
		
		timer.cancel();
		onStop();

		final Intent i = new Intent(getApplicationContext(), UtilMenu.class);
		startActivity(i);
		

	} 
	

	}


package com.amusoft.ultipedia;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.media.AudioManager;
import android.media.SoundPool;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.game.Game;
import com.shephertz.app42.paas.sdk.android.game.ScoreBoardService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class QuizActivityMath extends Quiz {
    static final int GET_WRONG = 1;
    static final int GET_RIGHT = 2;
    static final int SCORE_DIALOG = 3;
    static final int RUN_OUT = 4;
    static final int TIME_OUT = 5;
    List<Question> quesListMath;
    Double ife = Math.random() * 10;
    int g = ife.intValue();
    int qidMath = g;
    int scoreMath = 0;
    int qMon = 0;
    int qlvl = 0;
    Question currentQ;
    TextView txtQuestion, textViewTime;
    Button rda, rdb, rdc, rdd;
    TextToSpeech tts, ttTO;
    float max = 1;
    float update = 0;
    boolean threadRunning = false;
    CounterClass timer = new CounterClass(90000, 1000);
    SharedPreferences mGameSettings;
    ;
    private SoundPool sounds;
    private int wrong;
    private int right;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mGameSettings =
                getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
        final DbHelperMath db = new DbHelperMath(this);
        quesListMath = db.getAllQuestions();
        currentQ = quesListMath.get(qidMath);
        textViewTime = (TextView) findViewById(R.id.textViewTime);

        txtQuestion = (TextView) findViewById(R.id.textView1);
        rda = (Button) findViewById(R.id.radio0);
        rdb = (Button) findViewById(R.id.radio1);
        rdc = (Button) findViewById(R.id.radio2);
        rdd = (Button) findViewById(R.id.radio3);
        sounds = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        right = sounds.load(getBaseContext(), R.raw.correct, 1);
        wrong = sounds.load(getBaseContext(), R.raw.wrong, 2);


        rda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO Auto-generated method stub
                checkAnswer(1);
                timer.cancel();

                currentQ = quesListMath.get(qidMath);
                if (qidMath == 46) {
                    QuizActivityMath.this.showDialog(RUN_OUT);

                }


            }

        });
        rdb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                // TODO Auto-generated method stub
                checkAnswer(2);
                timer.cancel();

                currentQ = quesListMath.get(qidMath);

                if (qidMath == 46) {
                    QuizActivityMath.this.showDialog(RUN_OUT);

                }


            }

        });
        rdc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                // TODO Auto-generated method stub
                timer.cancel();
                checkAnswer(3);

                currentQ = quesListMath.get(qidMath);
                if (qidMath == 46) {
                    QuizActivityMath.this.showDialog(RUN_OUT);


                }


            }

        });
        rdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                // TODO Auto-generated method stub
                checkAnswer(4);
                timer.cancel();

                currentQ = quesListMath.get(qidMath);
                if (qidMath == 46) {
                    QuizActivityMath.this.showDialog(RUN_OUT);

                }


            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }

    private void setQuestionView() {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());

        qidMath++;
        qMon++;

        //animations
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
        timer.start();
        textViewTime.setText("00:01:30");


    }


    @Override
    protected Dialog onCreateDialog(final int id) {
        switch (id) {
            case SCORE_DIALOG:
                final LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View layoutscore =
                        inflater.inflate(R.layout.activity_result,
                                (ViewGroup) findViewById(R.id.scoreact));
                mGameSettings =
                        getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
                if (mGameSettings.contains(GAME_HIGHEST_LEVEL_MATH)) {
                    final String y = String.valueOf(qlvl);
                    final Editor editLevel = mGameSettings.edit();
                    editLevel.putString(GAME_HIGHEST_LEVEL_MATH, y);
                    editLevel.commit();

                } else {
                    final String wer = String.valueOf(qlvl);
                    final Editor editLevel2 = mGameSettings.edit();
                    editLevel2.putString(GAME_HIGHEST_LEVEL_MATH, wer);
                    editLevel2.commit();
                }
                final RatingBar bar = (RatingBar) layoutscore.findViewById(R.id.ratingBar1);
                bar.setNumStars(qlvl);
                bar.setStepSize(0.5f);
                bar.setRating(qlvl);
                final TextView t = (TextView) layoutscore.findViewById(R.id.textResult);
                t.setText("Your Score is :" + scoreMath);
                //get text view
                if (mGameSettings.contains(GAME_PREFERENCES_SCORE_MATH)) {
                    final String scr = mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, null);

                    t.setText("Your Score is :" + scr);


                }

                final TextView u = (TextView) layoutscore.findViewById(R.id.avausername);
                if (mGameSettings.contains(GAME_PREFERENCES_USERNAME)) {
                    final String name = mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
                    u.setText(name);
                }


                if (mGameSettings.contains(GAME_PREFERENCES_AVATAR)) {
                    final String imgs = mGameSettings.getString(GAME_PREFERENCES_AVATAR, null);
                    final ImageView img = (ImageView) layoutscore.findViewById(R.id.avascore);

                    final Uri path = Uri.parse(imgs);

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
                                QuizActivityMath.this
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

                final TextView g = (TextView) layoutset.findViewById(R.id.msg);
                g.setText(R.string.sry_content);


                final AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setView(layoutset);
                builder2.setTitle(R.string.sry);
                builder2.setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog, final int which) {
                                QuizActivityMath.this.removeDialog(RUN_OUT);
                                QuizActivityMath.this.finish();
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
                final TextView wrn = (TextView) layoutswrong.findViewById(R.id.rAns);
                if (mGameSettings.contains(GAME_CURRENT_ANS_MATH)) {
                    final String Final = mGameSettings.getString(GAME_CURRENT_ANS_MATH, null);
                    wrn.setText(Final);

                }
                final TextView notes = (TextView) layoutswrong.findViewById(R.id.qNotes);
                if (mGameSettings.contains(GAME_CURRENT_NOTE_MATH)) {
                    final String Finaln = mGameSettings.getString(GAME_CURRENT_NOTE_MATH, null);
                    notes.setText(Finaln);
                    tts = new TextToSpeech(QuizActivityMath.this, new TextToSpeech.OnInitListener() {

                        @Override
                        public void onInit(int status) {
                            // TODO Auto-generated method stub
                            if (status != TextToSpeech.ERROR) {
                                tts.setLanguage(Locale.UK);
                                tts.speak(Finaln, TextToSpeech.QUEUE_FLUSH, null);
                            }

                        }
                    });
                }
                final AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
                builder3.setView(layoutswrong);
                builder3.setTitle(R.string.wwrn);
                builder3.setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog, final int which) {
                                final TextView wrn = (TextView) layoutswrong.findViewById(R.id.rAns);
                                wrn.clearComposingText();
                                final TextView notes = (TextView) layoutswrong.findViewById(R.id.qNotes);
                                notes.clearComposingText();

                                tts.stop();
                                tts.shutdown();
                                QuizActivityMath.this.removeDialog(GET_WRONG);
                                if (qMon % 2 == 0 & qMon % 3 == 0) {
                                    QuizActivityMath.this
                                            .showDialog(SCORE_DIALOG);
                                    qlvl++;
                                    if (mGameSettings.contains(GAME_HIGHEST_LEVEL_MATH)) {
                                        final String y = String.valueOf(qlvl);
                                        final Editor editLevel = mGameSettings.edit();
                                        editLevel.putString(GAME_HIGHEST_LEVEL_MATH, y);
                                        editLevel.commit();

                                    } else {
                                        final String wer = String.valueOf(qlvl);
                                        final Editor editLevel2 = mGameSettings.edit();
                                        editLevel2.putString(GAME_HIGHEST_LEVEL_MATH, wer);
                                        editLevel2.commit();
                                    }
                                } else {
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
                final TextView wrnR = (TextView) layoutsright.findViewById(R.id.msg);
                wrnR.setText("Correct!!!!!!!!!!");

                final AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setView(layoutsright);
                builder4.setTitle("You Got that Right");
                builder4.setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog, final int which) {
                                final TextView wrn = (TextView) layoutsright.findViewById(R.id.msg);
                                wrn.clearComposingText();

                                QuizActivityMath.this.removeDialog(GET_RIGHT);
                                if (qMon % 2 == 0 & qMon % 3 == 0) {
                                    QuizActivityMath.this
                                            .showDialog(SCORE_DIALOG);
                                    qlvl++;
                                    if (mGameSettings.contains(GAME_HIGHEST_LEVEL_MATH)) {
                                        final String y = String.valueOf(qlvl);
                                        final Editor editLevel = mGameSettings.edit();
                                        editLevel.putString(GAME_HIGHEST_LEVEL_MATH, y);
                                        editLevel.commit();

                                    } else {
                                        final String wer = String.valueOf(qlvl);
                                        final Editor editLevel2 = mGameSettings.edit();
                                        editLevel2.putString(GAME_HIGHEST_LEVEL_MATH, wer);
                                        editLevel2.commit();
                                    }
                                } else {
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

                final TextView TM = (TextView) layoutsetT.findViewById(R.id.msg);
                scoreMath = scoreMath + 0;
                final String outi = "OOPS!! you ran out of time ,You Score 0 Points On this Question";
                TM.setText(outi);

                ttTO = new TextToSpeech(QuizActivityMath.this, new TextToSpeech.OnInitListener() {

                    @Override
                    public void onInit(int status) {
                        // TODO Auto-generated method stub
                        if (status != TextToSpeech.ERROR) {
                            ttTO.setLanguage(Locale.UK);
                            ttTO.speak(outi, TextToSpeech.QUEUE_ADD, null);
                        }

                    }
                });


                final AlertDialog.Builder builderT = new AlertDialog.Builder(this);
                builderT.setView(layoutsetT);
                builderT.setTitle("Out of Time");
                builderT.setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(final DialogInterface dialog, final int which) {
                                QuizActivityMath.this.removeDialog(TIME_OUT);
                                ttTO.stop();
                                ttTO.shutdown();

                                if (qMon % 2 == 0 & qMon % 3 == 0) {
                                    QuizActivityMath.this
                                            .showDialog(SCORE_DIALOG);
                                    qlvl++;
                                    if (mGameSettings.contains(GAME_HIGHEST_LEVEL_MATH)) {
                                        final String y = String.valueOf(qlvl);
                                        final Editor editLevel = mGameSettings.edit();
                                        editLevel.putString(GAME_HIGHEST_LEVEL_MATH, y);
                                        editLevel.commit();

                                    } else {
                                        final String wer = String.valueOf(qlvl);
                                        final Editor editLevel2 = mGameSettings.edit();
                                        editLevel2.putString(GAME_HIGHEST_LEVEL_MATH, wer);
                                        editLevel2.commit();
                                    }
                                } else {
                                    setQuestionView();
                                }


                            }
                        });
                final AlertDialog lDialogT = builderT.create();
                return lDialogT;


        }
        return null;
    }

    protected void onResume() {
        super.onResume();
        timer.cancel();
        setQuestionView();


    }

    protected void onStart() {

        super.onStart();

        setQuestionView();


    }

    protected void onStop() {
        super.onStop();
        timer.cancel();
        if (mGameSettings.contains(GAME_PREFERENCES_USERNAME)
                & mGameSettings.contains(GAME_PREFERENCES_SCORE_MATH)) {


            String gameName = "Ultipedia math";
            String q = mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
            String sMath = mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, null);
            String userName = q;
            App42API.initialize(this, "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
                    "b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");
            App42API.setOfflineStorage(true);
            BigDecimal math = new BigDecimal(sMath);
            ScoreBoardService scoreBoardMath = App42API.buildScoreBoardService();
            scoreBoardMath.saveUserScore(gameName, userName, math, new App42CallBack() {
                public void onSuccess(Object response) {
                    Game game = (Game) response;
                    for (int i = 0; i < game.getScoreList().size(); i++) {
                        System.out.println("userName is : " + game.getScoreList().get(i).getUserName());
                        System.out.println("score is : " + game.getScoreList().get(i).getValue());
                        System.out.println("scoreId is : " + game.getScoreList().get(i).getScoreId());
                        System.out.println("Created On is  :" + game.getScoreList().get(i).getCreatedOn());
                    }
                }

                public void onException(Exception ex) {
                    System.out.println("Exception Message" + ex.getMessage());
                }
            });

        } else {
            Toast.makeText(getApplicationContext(),
                    "Cannot upload to online leader board,Make sure you set yor user settings",
                    Toast.LENGTH_SHORT).show();

        }

    }

    protected void onPause() {
        super.onPause();
        timer.cancel();
    }

    private void checkAnswer(final int i) {
        // TODO Auto-generated method stub
        switch (i) {
            case 1:
                final Button answer = (Button) findViewById(R.id.radio0);
                Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().contentEquals(answer.getText())) {
                    scoreMath++;
                    final String d = String.valueOf(scoreMath);
                    final Editor editor = mGameSettings.edit();
                    editor.putString(GAME_PREFERENCES_SCORE_MATH, d);
                    editor.commit();
                    Log.d(DEBUG_TAG, "Score is : "
                            + mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, "Not set"));
                    QuizActivityMath.this.showDialog(GET_RIGHT);
                    sounds.play(right, 1.0f, 1.0f, 0, 0, 1.5f);
                } else {
                    final String d = "The correct answer is\n" + currentQ.getANSWER();
                    final Editor editor2 = mGameSettings.edit();
                    editor2.putString(GAME_CURRENT_ANS_MATH, d);
                    editor2.commit();

                    final String n = currentQ.getNOTE();
                    final Editor editor22 = mGameSettings.edit();
                    editor22.putString(GAME_CURRENT_NOTE_MATH, n);
                    editor22.commit();

                    QuizActivityMath.this.showDialog(GET_WRONG);

                    sounds.play(wrong, 1.0f, 1.0f, 0, 0, 1.5f);
                }
                Log.d("score", "Your score" + scoreMath);
                break;
            case 2:
                final Button answer1 = (Button) findViewById(R.id.radio1);
                Log.d("yourans", currentQ.getANSWER() + " " + answer1.getText());
                if (currentQ.getANSWER().contentEquals(answer1.getText())) {
                    scoreMath++;
                    final String d = String.valueOf(scoreMath);
                    final Editor editor = mGameSettings.edit();
                    editor.putString(GAME_PREFERENCES_SCORE_MATH, d);
                    editor.commit();
                    Log.d("score", "Your score" + scoreMath);
                    Log.d(DEBUG_TAG, "Score is : "
                            + mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, "Not set"));
                    QuizActivityMath.this.showDialog(GET_RIGHT);
                    sounds.play(right, 1.0f, 1.0f, 0, 0, 1.5f);
                } else {
                    final String d = "The correct answer is\n" + currentQ.getANSWER();
                    final Editor editor2 = mGameSettings.edit();
                    editor2.putString(GAME_CURRENT_ANS_MATH, d);
                    editor2.commit();

                    final String n = currentQ.getNOTE();
                    final Editor editor22 = mGameSettings.edit();
                    editor22.putString(GAME_CURRENT_NOTE_MATH, n);
                    editor22.commit();

                    QuizActivityMath.this.showDialog(GET_WRONG);
                    sounds.play(wrong, 1.0f, 1.0f, 0, 0, 1.5f);
                }
                Log.d("score", "Your score" + scoreMath);
                break;
            case 3:
                final Button answer11 = (Button) findViewById(R.id.radio2);
                Log.d("yourans", currentQ.getANSWER() + " " + answer11.getText());
                if (currentQ.getANSWER().contentEquals(answer11.getText())) {
                    scoreMath++;
                    final String d = String.valueOf(scoreMath);
                    final Editor editor = mGameSettings.edit();
                    editor.putString(GAME_PREFERENCES_SCORE_MATH, d);
                    editor.commit();
                    Log.d("score", "Your score" + scoreMath);
                    Log.d(DEBUG_TAG, "Score is : "
                            + mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, "Not set"));
                    QuizActivityMath.this.showDialog(GET_RIGHT);
                    sounds.play(right, 1.0f, 1.0f, 0, 0, 1.5f);
                } else {
                    final String d = "The correct answer is\n" + currentQ.getANSWER();
                    final Editor editor2 = mGameSettings.edit();
                    editor2.putString(GAME_CURRENT_ANS_MATH, d);
                    editor2.commit();

                    final String n = currentQ.getNOTE();
                    final Editor editor22 = mGameSettings.edit();
                    editor22.putString(GAME_CURRENT_NOTE_MATH, n);
                    editor22.commit();

                    QuizActivityMath.this.showDialog(GET_WRONG);
                    sounds.play(wrong, 1.0f, 1.0f, 0, 0, 1.5f);
                }
                Log.d("score", "Your score" + scoreMath);
                break;
            case 4:
                final Button answer111 = (Button) findViewById(R.id.radio3);
                Log.d("yourans", currentQ.getANSWER() + " " + answer111.getText());
                if (currentQ.getANSWER().contentEquals(answer111.getText())) {
                    scoreMath++;
                    final String d = String.valueOf(scoreMath);
                    final Editor editor = mGameSettings.edit();
                    editor.putString(GAME_PREFERENCES_SCORE_MATH, d);
                    editor.commit();
                    Log.d("score", "Your score" + scoreMath);
                    Log.d(DEBUG_TAG, "Score is : "
                            + mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, "Not set"));
                    QuizActivityMath.this.showDialog(GET_RIGHT);
                    sounds.play(right, 1.0f, 1.0f, 0, 0, 1.5f);
                } else {
                    final String d = "The correct answer is\n" + currentQ.getANSWER();
                    final Editor editor2 = mGameSettings.edit();
                    editor2.putString(GAME_CURRENT_ANS_MATH, d);
                    editor2.commit();

                    final String n = currentQ.getNOTE();
                    final Editor editor22 = mGameSettings.edit();
                    editor22.putString(GAME_CURRENT_NOTE_MATH, n);
                    editor22.commit();

                    QuizActivityMath.this.showDialog(GET_WRONG);
                    sounds.play(wrong, 1.0f, 1.0f, 0, 0, 1.5f);
                }
                Log.d("score", "Your score" + scoreMath);
                break;

        }

    }

    public void onBackPressed() {
        QuizActivityMath.this.finish();
        timer.cancel();
        final Intent i = new Intent(getApplicationContext(), UtilMenu.class);
        startActivity(i);
        onStop();


    }

    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    private class CounterClass extends CountDownTimer {
        static final int TIME_OUT = 5;

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

            if (hms.contentEquals("00:00:01")) {
                textViewTime.clearComposingText();
                QuizActivityMath.this.showDialog(TIME_OUT);

            } else {
                textViewTime.setText(hms);
            }

        }

        @Override
        public void onFinish() {
            // TODO Auto-generated method stub

            textViewTime.clearComposingText();


        }


    }

}



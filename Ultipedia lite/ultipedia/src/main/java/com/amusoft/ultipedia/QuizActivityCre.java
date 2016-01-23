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

public class QuizActivityCre extends Quiz {
    static final int GET_WRONG = 1;
    static final int GET_RIGHT = 2;
    static final int SCORE_DIALOG = 3;
    static final int RUN_OUT = 4;
    static final int TIME_OUT = 5;
    List<Question> quesListCre;
    Double ife = Math.random() * 10;
    int g = ife.intValue();
    int qidCre = g;
    int scoreCre = 0;
    int qMon = 0;
    int qlvl = 0;
    Question currentQ;
    TextView txtQuestion, textViewTime;
    Button rda, rdb, rdc, rdd;
    TextToSpeech tts, ttTO;
    float max = 1;
    float update = 0;
    boolean threadRunning = false;
    CounterClass timer = new CounterClass(30000, 1000);
    SharedPreferences mGameSettings;
    ;
    private SoundPool sounds;
    private int wrong;
    private int right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mGameSettings =
                getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
        DbHelperCre db = new DbHelperCre(this);
        quesListCre = db.getAllQuestions();
        currentQ = quesListCre.get(qidCre);
        txtQuestion = (TextView) findViewById(R.id.textView1);
        rda = (Button) findViewById(R.id.radio0);
        rdb = (Button) findViewById(R.id.radio1);
        rdc = (Button) findViewById(R.id.radio2);
        rdd = (Button) findViewById(R.id.radio3);
        sounds = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        right = sounds.load(getBaseContext(), R.raw.correct, 1);
        wrong = sounds.load(getBaseContext(), R.raw.wrong, 2);

        textViewTime = (TextView) findViewById(R.id.textViewTime);


        rda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                checkAnswer(1);
                timer.cancel();
                currentQ = quesListCre.get(qidCre);
                if (qidCre == 46) {
                    QuizActivityCre.this.showDialog(RUN_OUT);

                }

            }

        });
        rdb.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                timer.cancel();

                checkAnswer(2);


                currentQ = quesListCre.get(qidCre);
                if (qidCre == 46) {
                    QuizActivityCre.this.showDialog(RUN_OUT);

                }


            }

        });
        rdc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                checkAnswer(3);
                timer.cancel();

                currentQ = quesListCre.get(qidCre);
                if (qidCre == 46) {
                    QuizActivityCre.this.showDialog(RUN_OUT);

                }


            }

        });
        rdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                checkAnswer(4);
                timer.cancel();
                currentQ = quesListCre.get(qidCre);
                if (qidCre == 46) {

                    QuizActivityCre.this.showDialog(RUN_OUT);

                }


            }

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
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
        Double ife2 = Math.random() * 17;
        int g2 = ife2.intValue();
        qidCre++;
        qMon++;
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
        textViewTime.setText("00:00:30");


    }

    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case SCORE_DIALOG:
                LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View layoutscore =
                        inflater.inflate(R.layout.activity_result,
                                (ViewGroup) findViewById(R.id.scoreact));
                mGameSettings =
                        getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
                if (mGameSettings.contains(GAME_HIGHEST_LEVEL_CRE)) {
                    String y = String.valueOf(qlvl);
                    Editor editLevel = mGameSettings.edit();
                    editLevel.putString(GAME_HIGHEST_LEVEL_CRE, y);
                    editLevel.commit();

                } else {
                    String wer = String.valueOf(qlvl);
                    Editor editLevel2 = mGameSettings.edit();
                    editLevel2.putString(GAME_HIGHEST_LEVEL_CRE, wer);
                    editLevel2.commit();
                }
                ;

                RatingBar bar = (RatingBar) layoutscore.findViewById(R.id.ratingBar1);
                bar.setNumStars(qlvl);

                bar.setStepSize(0.5f);
                int rate = 5;
                bar.setRating(rate);
                TextView t = (TextView) layoutscore.findViewById(R.id.textResult);
                t.setText("Your Score is :" + scoreCre);
                //get text view
                if (mGameSettings.contains(GAME_PREFERENCES_SCORE_CRE)) {
                    String scr = mGameSettings.getString(GAME_PREFERENCES_SCORE_CRE, null);

                    t.setText("Your Score is :" + scr);


                }
                TextView u = (TextView) layoutscore.findViewById(R.id.avausername);
                if (mGameSettings.contains(GAME_PREFERENCES_USERNAME)) {
                    String name = mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
                    u.setText(name);
                }

                if (mGameSettings.contains(GAME_PREFERENCES_AVATAR)) {
                    String imgs = mGameSettings.getString(GAME_PREFERENCES_AVATAR, null);
                    ImageView img = (ImageView) layoutscore.findViewById(R.id.avascore);

                    Uri path = Uri.parse(imgs);

                    img.setImageURI(null);
                    img.setImageURI(path);

                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setView(layoutscore);
                builder.setTitle(R.string.title_sscr);
                builder.setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                setQuestionView();
                                QuizActivityCre.this
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

                TextView g = (TextView) layoutset.findViewById(R.id.msg);
                g.setText(R.string.sry_content);


                AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
                builder2.setView(layoutset);
                builder2.setTitle(R.string.sry);
                builder2.setPositiveButton(android.R.string.ok,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                QuizActivityCre.this.removeDialog(RUN_OUT);
                                QuizActivityCre.this.finish();
                                Intent i = new Intent(getApplicationContext(), UtilMenu.class);
                                startActivity(i);


                            }
                        });
                AlertDialog lDialog1 = builder2.create();
                return lDialog1;
            case GET_WRONG:
                final LayoutInflater inflater3 =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View layoutswrong =
                        inflater3.inflate(R.layout.wrong_dialogue,
                                (ViewGroup) findViewById(R.id.wrngDil));
                final TextView wrn = (TextView) layoutswrong.findViewById(R.id.rAns);
                if (mGameSettings.contains(GAME_CURRENT_ANS_CRE)) {
                    final String Final = mGameSettings.getString(GAME_CURRENT_ANS_CRE, null);
                    wrn.setText(Final);
                }
                final TextView notes = (TextView) layoutswrong.findViewById(R.id.qNotes);
                if (mGameSettings.contains(GAME_CURRENT_NOTE_CRE)) {
                    final String Finaln = mGameSettings.getString(GAME_CURRENT_NOTE_CRE, null);
                    notes.setText(Finaln);
                    tts = new TextToSpeech(QuizActivityCre.this, new TextToSpeech.OnInitListener() {

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

                                QuizActivityCre.this.removeDialog(GET_WRONG);
                                if (qMon % 2 == 0 & qMon % 3 == 0) {
                                    QuizActivityCre.this
                                            .showDialog(SCORE_DIALOG);
                                    qlvl++;
                                } else {
                                    setQuestionView();
                                }

                            }
                        });
                AlertDialog lDialog11 = builder3.create();
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
                                setQuestionView();
                                QuizActivityCre.this.removeDialog(GET_RIGHT);
                                if (qMon % 2 == 0 & qMon % 3 == 0) {
                                    QuizActivityCre.this
                                            .showDialog(SCORE_DIALOG);
                                    qlvl++;
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
                scoreCre = scoreCre + 0;
                final String outi = "OOPS!! you ran out of time ,You Score 0 Points On this Question";
                TM.setText(outi);

                ttTO = new TextToSpeech(QuizActivityCre.this, new TextToSpeech.OnInitListener() {

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
                                QuizActivityCre.this.removeDialog(TIME_OUT);
                                ttTO.stop();
                                ttTO.shutdown();
                                if (qMon % 2 == 0 & qMon % 3 == 0) {
                                    QuizActivityCre.this
                                            .showDialog(SCORE_DIALOG);
                                    qlvl++;

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
        setQuestionView();
    }

    protected void onStart() {

        super.onStart();
        timer.start();
        setQuestionView();
    }

    protected void onStop() {
        super.onStop();
        timer.cancel();
        if (mGameSettings.contains(GAME_PREFERENCES_USERNAME)
                & mGameSettings.contains(GAME_PREFERENCES_SCORE_CRE)) {


            String sCRE = mGameSettings.getString(GAME_PREFERENCES_SCORE_CRE, null);
            String q = mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
            String userName = q;
            App42API.initialize(this, "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
                    "b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");
            App42API.setOfflineStorage(true);
            BigDecimal cre = new BigDecimal(sCRE);
            String gameName = "Ultipedia cre";
            ScoreBoardService scoreBoardCre = App42API.buildScoreBoardService();
            scoreBoardCre.saveUserScore(gameName, userName, cre, new App42CallBack() {
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

    private void checkAnswer(int i) {
        // TODO Auto-generated method stub
        switch (i) {
            case 1:
                Button answer = (Button) findViewById(R.id.radio0);
                Log.d("yourans", currentQ.getANSWER() + " " + answer.getText());
                if (currentQ.getANSWER().contentEquals(answer.getText())) {
                    scoreCre++;
                    String d = String.valueOf(scoreCre);
                    Editor editor = mGameSettings.edit();
                    editor.putString(GAME_PREFERENCES_SCORE_CRE, d);
                    editor.commit();
                    Log.d(DEBUG_TAG, "Score is : "
                            + mGameSettings.getString(GAME_PREFERENCES_SCORE_CRE, "Not set"));
                    QuizActivityCre.this.showDialog(GET_RIGHT);
                    sounds.play(right, 1.0f, 1.0f, 0, 0, 1.5f);
                } else {
                    String d = "The correct answer is\n" + currentQ.getANSWER();
                    Editor editor2 = mGameSettings.edit();
                    editor2.putString(GAME_CURRENT_ANS_CRE, d);
                    editor2.commit();

                    final String n = currentQ.getNOTE();
                    final Editor editor22 = mGameSettings.edit();
                    editor22.putString(GAME_CURRENT_NOTE_CRE, n);
                    editor22.commit();

                    QuizActivityCre.this.showDialog(GET_WRONG);
                    sounds.play(wrong, 1.0f, 1.0f, 0, 0, 1.5f);
                }
                Log.d("score", "Your score" + scoreCre);
                break;
            case 2:
                Button answer1 = (Button) findViewById(R.id.radio1);
                Log.d("yourans", currentQ.getANSWER() + " " + answer1.getText());
                if (currentQ.getANSWER().contentEquals(answer1.getText())) {
                    scoreCre++;
                    String d = String.valueOf(scoreCre);
                    Editor editor = mGameSettings.edit();
                    editor.putString(GAME_PREFERENCES_SCORE_CRE, d);
                    editor.commit();
                    Log.d("score", "Your score" + scoreCre);
                    Log.d(DEBUG_TAG, "Score is : "
                            + mGameSettings.getString(GAME_PREFERENCES_SCORE_CRE, "Not set"));
                    QuizActivityCre.this.showDialog(GET_RIGHT);
                    sounds.play(right, 1.0f, 1.0f, 0, 0, 1.5f);
                } else {
                    String d = "The correct answer is\n" + currentQ.getANSWER();
                    Editor editor2 = mGameSettings.edit();
                    editor2.putString(GAME_CURRENT_ANS_CRE, d);
                    editor2.commit();

                    final String n = currentQ.getNOTE();
                    final Editor editor22 = mGameSettings.edit();
                    editor22.putString(GAME_CURRENT_NOTE_CRE, n);
                    editor22.commit();

                    QuizActivityCre.this.showDialog(GET_WRONG);
                    sounds.play(wrong, 1.0f, 1.0f, 0, 0, 1.5f);
                }
                Log.d("score", "Your score" + scoreCre);
                break;
            case 3:
                Button answer11 = (Button) findViewById(R.id.radio2);
                Log.d("yourans", currentQ.getANSWER() + " " + answer11.getText());
                if (currentQ.getANSWER().contentEquals(answer11.getText())) {
                    scoreCre++;
                    String d = String.valueOf(scoreCre);
                    Editor editor = mGameSettings.edit();
                    editor.putString(GAME_PREFERENCES_SCORE_CRE, d);
                    editor.commit();
                    Log.d("score", "Your score" + scoreCre);
                    Log.d(DEBUG_TAG, "Score is : "
                            + mGameSettings.getString(GAME_PREFERENCES_SCORE_CRE, "Not set"));
                    QuizActivityCre.this.showDialog(GET_RIGHT);
                    sounds.play(right, 1.0f, 1.0f, 0, 0, 1.5f);
                } else {
                    String d = "The correct answer is\n" + currentQ.getANSWER();
                    Editor editor2 = mGameSettings.edit();
                    editor2.putString(GAME_CURRENT_ANS_CRE, d);
                    editor2.commit();

                    final String n = currentQ.getNOTE();
                    final Editor editor22 = mGameSettings.edit();
                    editor22.putString(GAME_CURRENT_NOTE_CRE, n);
                    editor22.commit();

                    QuizActivityCre.this.showDialog(GET_WRONG);
                    sounds.play(wrong, 1.0f, 1.0f, 0, 0, 1.5f);
                }
                Log.d("score", "Your score" + scoreCre);
                break;
            case 4:
                Button answer111 = (Button) findViewById(R.id.radio3);
                Log.d("yourans", currentQ.getANSWER() + " " + answer111.getText());
                if (currentQ.getANSWER().contentEquals(answer111.getText())) {
                    scoreCre++;
                    String d = String.valueOf(scoreCre);
                    Editor editor = mGameSettings.edit();
                    editor.putString(GAME_PREFERENCES_SCORE_CRE, d);
                    editor.commit();
                    Log.d("score", "Your score" + scoreCre);
                    Log.d(DEBUG_TAG, "Score is : "
                            + mGameSettings.getString(GAME_PREFERENCES_SCORE_CRE, "Not set"));
                    QuizActivityCre.this.showDialog(GET_RIGHT);
                    sounds.play(right, 1.0f, 1.0f, 0, 0, 1.5f);
                } else {
                    String d = "The correct answer is\n" + currentQ.getANSWER();
                    Editor editor2 = mGameSettings.edit();
                    editor2.putString(GAME_CURRENT_ANS_CRE, d);
                    editor2.commit();

                    final String n = currentQ.getNOTE();
                    final Editor editor22 = mGameSettings.edit();
                    editor22.putString(GAME_CURRENT_NOTE_CRE, n);
                    editor22.commit();

                    QuizActivityCre.this.showDialog(GET_WRONG);
                    sounds.play(wrong, 1.0f, 1.0f, 0, 0, 1.5f);
                }
                Log.d("score", "Your score" + scoreCre);
                break;

        }
    }

    public void onBackPressed() {
        QuizActivityCre.this.finish();
        timer.cancel();
        onStop();
        Intent i = new Intent(getApplicationContext(), UtilMenu.class);
        startActivity(i);


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
                QuizActivityCre.this.showDialog(TIME_OUT);

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



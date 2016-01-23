package com.amusoft.ultipedia;


import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.App42Log;
import com.shephertz.app42.paas.sdk.android.game.Game;
import com.shephertz.app42.paas.sdk.android.game.GameService;

public class UltiSplash extends QuizActivity {
    static final int LEAVE_DIALOG_ID = 1;
    public ImageView imgIntro;
    MediaPlayer backIntro;

    private int it;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ulti_splash);
        imgIntro = (ImageView) findViewById(R.id.imo);


        final Animation fadeintro = AnimationUtils.loadAnimation(this, R.anim.custom_anim);
        imgIntro.setAnimation(fadeintro);
        App42API.initialize(this, "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
                "b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");
        App42API.setOfflineStorage(true);
        App42Log.setDebug(true);


        backIntro = MediaPlayer.create(getApplicationContext(), R.raw.intro);
        backIntro.setLooping(false);
        backIntro.start();


        imgIntro.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(final View v) {
                // TODO Auto-generated method stub
                UltiSplash.this.finish();
                final Intent i = new Intent(getApplicationContext(), UtilMenu.class);
                startActivity(i);

            }

        });
        createGamesOnServer();


    }

    private void createGamesOnServer() {
        // TODO fun mode

        App42API.initialize(this, "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
                "b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");
        App42API.setOfflineStorage(true);
        String gameName = "Ultipedia fun";
        String description = "Answer random questions";
        GameService gameService1 = App42API.buildGameService();
        gameService1.createGame(gameName, description, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
                System.out.println("gameName is " + game.getName());
                System.out.println("gameDescription is " + game.getDescription());
            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });


        String gameNameMath = "Ultipedia math";
        String descriptionMath = "Answer math questions";
        GameService gameServiceMath = App42API.buildGameService();
        gameServiceMath.createGame(gameNameMath, descriptionMath, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
                System.out.println("gameName is " + game.getName());
                System.out.println("gameDescription is " + game.getDescription());
            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });


        String gameNameEng = "Ultipedia eng";
        String descriptionEng = "Answer english questions";
        GameService gameServiceEng = App42API.buildGameService();
        gameServiceEng.createGame(gameNameEng, descriptionEng, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
                System.out.println("gameName is " + game.getName());
                System.out.println("gameDescription is " + game.getDescription());
            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });

        String gameNameKis = "Ultipedia kis";
        String descriptionKis = " Answer kiswahili questions ";
        GameService gameServiceKis = App42API.buildGameService();
        gameServiceKis.createGame(gameNameKis, descriptionKis, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
                System.out.println("gameName is " + game.getName());
                System.out.println("gameDescription is " + game.getDescription());
            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });

        String gameNameSci = "Ultipedia sci";
        String descriptionSci = "Answer science questions";
        GameService gameServiceSci = App42API.buildGameService();
        gameServiceSci.createGame(gameNameSci, descriptionSci, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
                System.out.println("gameName is " + game.getName());
                System.out.println("gameDescription is " + game.getDescription());
            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });

        String gameNameSS = "Ultipedia social";
        String descriptionSS = "Answer social questions";
        GameService gameServiceSS = App42API.buildGameService();
        gameServiceSS.createGame(gameNameSS, descriptionSS, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
                System.out.println("gameName is " + game.getName());
                System.out.println("gameDescription is " + game.getDescription());
            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });

        String gameNameCre = "Ultipedia cre";
        String descriptionCre = "Answer cre questions";
        GameService gameServiceCre = App42API.buildGameService();
        gameServiceCre.createGame(gameNameCre, descriptionCre, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
                System.out.println("gameName is " + game.getName());
                System.out.println("gameDescription is " + game.getDescription());
            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });


    }

    protected void onStart() {

        super.onStart();


    }

    private String getTimingCategory() {
        // TODO Auto-generated method stub
        return null;
    }

    protected void onPause() {
        backIntro.stop();
        super.onPause();

    }

    protected Dialog onCreateDialog(final int id) {
        switch (id) {
            case LEAVE_DIALOG_ID:
                final LayoutInflater inflater =
                        (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View layout =
                        inflater.inflate(R.layout.exit,
                                (ViewGroup) findViewById(R.id.root));
                final Button btnLeave = (Button) layout.findViewById(R.id.leave);
                final Button btnStay = (Button) layout.findViewById(R.id.stay);
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

    protected void onDestroy() {


        super.onDestroy();

    }

    protected void onResume() {
        super.onResume();

    }

    public void onBackPressed() {
        showDialog(LEAVE_DIALOG_ID);


    }


}

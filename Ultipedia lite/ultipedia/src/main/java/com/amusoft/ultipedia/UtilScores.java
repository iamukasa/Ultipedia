package com.amusoft.ultipedia;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.App42Log;
import com.shephertz.app42.paas.sdk.android.game.Game;
import com.shephertz.app42.paas.sdk.android.game.ScoreBoardService;

import java.util.ArrayList;


public class UtilScores extends Quiz {
    SharedPreferences mGameSettings;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_util_scores);
        mGameSettings = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);
        final TabHost tbh = (TabHost) findViewById(R.id.tabhost);
        tbh.setup();
        App42API.initialize(this, "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
                "b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");


        TabSpec FunScoresTab = tbh.newTabSpec("FunTab");
        FunScoresTab.setIndicator(getResources().getString(R.string.Fu),
                getResources().getDrawable(android.R.drawable.star_on));
        FunScoresTab.setContent(R.id.Scrollfun);
        tbh.addTab(FunScoresTab);


        TextView d = (TextView) findViewById(R.id.nmf);
        TextView ld = (TextView) findViewById(R.id.hilvlf);
        if (mGameSettings.contains(GAME_HIGHEST_LEVEL)) {
            String hl = mGameSettings.getString(GAME_HIGHEST_LEVEL, null);
            ld.setText(hl);

        } else {
            ld.setText("Not Played");

        }
        if (mGameSettings.contains(GAME_PREFERENCES_USERNAME)) {
            String q = mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);
            d.setText(q);


        } else {
            d.setText("Username not set");
        }

        TextView e = (TextView) findViewById(R.id.scoref);
        if (mGameSettings.contains(GAME_PREFERENCES_SCORE_FUN)) {
            String ght = mGameSettings.getString(GAME_PREFERENCES_SCORE_FUN, null);
            e.setText(ght);
        }


        TabSpec SchoolScoresTab = tbh.newTabSpec("SchoolTab");
        SchoolScoresTab.setIndicator(getResources().getString(R.string.shu),
                getResources().getDrawable(android.R.drawable.star_on));
        SchoolScoresTab.setContent(R.id.ScrollSchool);
        tbh.addTab(SchoolScoresTab);


        TextView sm = (TextView) findViewById(R.id.nmMath);

        TextView sen = (TextView) findViewById(R.id.nmeng);
        TextView sk = (TextView) findViewById(R.id.nmkis);
        TextView ssi = (TextView) findViewById(R.id.nmsci);
        TextView ssst = (TextView) findViewById(R.id.nmsst);
        TextView scr = (TextView) findViewById(R.id.nmcre);


        TextView lm = (TextView) findViewById(R.id.hilvlMath);
        TextView len = (TextView) findViewById(R.id.hilvlEng);
        TextView lk = (TextView) findViewById(R.id.hilvlKis);
        TextView lsi = (TextView) findViewById(R.id.hilvlSci);
        TextView lsst = (TextView) findViewById(R.id.hilvlSst);
        TextView lcr = (TextView) findViewById(R.id.hilvlCre);

        mGameSettings = getSharedPreferences(GAME_PREFERENCES, Context.MODE_PRIVATE);


        if (mGameSettings.contains(GAME_PREFERENCES_USERNAME)) {
            String q = mGameSettings.getString(GAME_PREFERENCES_USERNAME, null);

            sm.setText(q);
            sen.setText(q);
            sk.setText(q);
            ssi.setText(q);
            ssst.setText(q);
            scr.setText(q);


        } else {

            sm.setText("Username not set");
            sen.setText("Username not set");
            sk.setText("Username not set");
            ssi.setText("Username not set");
            ssst.setText("Username not set");
            scr.setText("Username not set");

        }


        if (mGameSettings.contains(GAME_HIGHEST_LEVEL_MATH)) {
            String hlM = mGameSettings.getString(GAME_HIGHEST_LEVEL_MATH, null);
            lm.setText(hlM);

        } else {
            lm.setText("Not Played");

        }
        if (mGameSettings.contains(GAME_HIGHEST_LEVEL_ENG)) {
            String hlEng = mGameSettings.getString(GAME_HIGHEST_LEVEL_ENG, null);
            len.setText(hlEng);


        } else {
            len.setText("Not Played");

        }
        if (mGameSettings.contains(GAME_HIGHEST_LEVEL_KIS)) {
            String hlKis = mGameSettings.getString(GAME_HIGHEST_LEVEL_KIS, null);
            lk.setText(hlKis);

        } else {
            lk.setText("Not Played");

        }
        if (mGameSettings.contains(GAME_HIGHEST_LEVEL_SCI)) {
            String hlSci = mGameSettings.getString(GAME_HIGHEST_LEVEL_SCI, null);
            lsi.setText(hlSci);

        } else {
            lsi.setText("Not Played");

        }
        if (mGameSettings.contains(GAME_HIGHEST_LEVEL_SOCI)) {
            String hlSS = mGameSettings.getString(GAME_HIGHEST_LEVEL_SOCI, null);
            lsst.setText(hlSS);

        } else {
            lsst.setText("Not Played");

        }
        if (mGameSettings.contains(GAME_HIGHEST_LEVEL_CRE)) {
            String hlCre = mGameSettings.getString(GAME_HIGHEST_LEVEL_CRE, null);
            lcr.setText(hlCre);

        } else {
            lcr.setText("Not Played");

        }

        TextView m = (TextView) findViewById(R.id.scoreMath);
        if (mGameSettings.contains(GAME_PREFERENCES_SCORE_MATH)) {
            String sMath = mGameSettings.getString(GAME_PREFERENCES_SCORE_MATH, null);
            m.setText(sMath);

        } else {
            m.setText("Not Played");

        }
        TextView en = (TextView) findViewById(R.id.scoreeng);
        if (mGameSettings.contains(GAME_PREFERENCES_SCORE_ENG)) {
            String sEng = mGameSettings.getString(GAME_PREFERENCES_SCORE_ENG, null);
            en.setText(sEng);


        } else {
            en.setText("Not Played");

        }
        TextView k = (TextView) findViewById(R.id.scorekis);
        if (mGameSettings.contains(GAME_PREFERENCES_SCORE_KIS)) {
            String sKis = mGameSettings.getString(GAME_PREFERENCES_SCORE_KIS, null);
            k.setText(sKis);


        } else {
            k.setText("Not Played");

        }
        TextView s = (TextView) findViewById(R.id.scoresci);
        if (mGameSettings.contains(GAME_PREFERENCES_SCORE_SCI)) {
            String sSci = mGameSettings.getString(GAME_PREFERENCES_SCORE_SCI, null);
            s.setText(sSci);

        } else {
            s.setText("Not Played");

        }
        TextView sst = (TextView) findViewById(R.id.scoresst);
        if (mGameSettings.contains(GAME_PREFERENCES_SCORE_SST)) {
            String sSST = mGameSettings.getString(GAME_PREFERENCES_SCORE_SST, null);
            sst.setText(sSST);


        } else {
            sst.setText("Not Played");

        }
        TextView cr = (TextView) findViewById(R.id.scorecre);
        if (mGameSettings.contains(GAME_PREFERENCES_SCORE_CRE)) {
            String sCRE = mGameSettings.getString(GAME_PREFERENCES_SCORE_CRE, null);
            cr.setText(sCRE);


        } else {
            cr.setText("Not Played");

        }


        TabSpec LeaderBoardTab = tbh.newTabSpec("LeaderBoardTab");
        LeaderBoardTab.setIndicator(getResources().getString(R.string.lead),
                getResources().getDrawable(android.R.drawable.star_on));
        LeaderBoardTab.setContent(R.id.list);
        tbh.addTab(LeaderBoardTab);


        uploadScoresleaderboard();


    }

    private void uploadScoresleaderboard() {

        final ListView listView = (ListView) findViewById(android.R.id.list);
        App42Log.setDebug(true);

        String gameName = "Ultipedia fun";

        int max = 15;
        App42API.initialize(this, "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
                "b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");
        ScoreBoardService scoreBoardService = App42API.buildScoreBoardService();
        scoreBoardService.getTopNRankings(gameName, max, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
                ArrayList e = game.getScoreList();


                System.out.println("Game Name is : " + game.getName());
                for (int i = 0; i < game.getScoreList().size(); i++) {
                    System.out.println("userName is : " + game.getScoreList().get(i).getUserName());
                    System.out.println("score is : " + game.getScoreList().get(i).getValue());
                    System.out.println("Created On is  :" + game.getScoreList().get(i).getCreatedOn());
                    System.out.println("scoreId is : " + game.getScoreList().get(i).getScoreId());
                }
            }

            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
            }
        });





        // TODO Auto-generated method stub

    }


    public void onBackPressed() {
        UtilScores.this.finish();

        final Intent i = new Intent(getApplicationContext(), UtilMenu.class);
        startActivity(i);

    }



}

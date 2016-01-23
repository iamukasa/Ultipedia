package com.amusoft.ultipedia;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.App42Log;
import com.shephertz.app42.paas.sdk.android.game.Game;
import com.shephertz.app42.paas.sdk.android.game.ScoreBoardService;

import java.util.ArrayList;

/**
 * Created by Amu on 4/1/2015.
 */
public class Fun  extends Fragment{

    View fun;
    ArrayList<String> rank, name,score;
    ArrayList<ListItem> lead;
    ListView funscr;


    ProgressDialog pDialog;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         fun= inflater.inflate(R.layout.fragment_leader_board_fun, container, false);
        App42Log.setDebug(true);
        rank = new ArrayList<String>();
        name = new ArrayList<String>();
        score=new ArrayList<String>();
        App42API.initialize(getActivity(), "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
                "b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");


        String gameName = "Ultipedia fun";

        int max = 15;
         ScoreBoardService scoreBoardService = App42API.buildScoreBoardService();
        scoreBoardService.getTopNRankings(gameName, max, new App42CallBack() {
            public void onSuccess(Object response) {
                Game game = (Game) response;
               System.out.println("Game Name is : " + game.getName());
                for (Integer i = 0; i < game.getScoreList().size(); i++) {


                    name.add(game.getScoreList().get(i).getUserName());
                    score.add(game.getScoreList().get(i).getValue().toString());

                    System.out.println("userName is : " + game.getScoreList().get(i).getUserName());
                    System.out.println("score is : " + game.getScoreList().get(i).getValue());
                    System.out.println("Created On is  :" + game.getScoreList().get(i).getCreatedOn());
                    System.out.println("scoreId is : " + game.getScoreList().get(i).getScoreId());
                }
                }
            public void onException(Exception ex) {
                System.out.println("Exception Message" + ex.getMessage());
                pDialog.dismiss();
            }
        });



         funscr=(ListView)fun.findViewById(R.id.funLeaderBoard);
        lead= new ArrayList<ListItem>();

        for (int i = 0; i < name.size(); i++) {
            lead.add(new ListItem(name.get(i),score.get(i)));

        }

        final CustomArrayAdapter adapter=new CustomArrayAdapter(fun.getContext(),R.layout.score_item,lead);
        funscr.setAdapter(adapter);

        return fun;
    }
}

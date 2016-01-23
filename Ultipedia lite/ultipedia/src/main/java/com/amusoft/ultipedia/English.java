package com.amusoft.ultipedia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Amu on 4/1/2015.
 */
public class English  extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View english= inflater.inflate(R.layout.fragment_leader_board_eng, container, false);

        return english;
    }
}

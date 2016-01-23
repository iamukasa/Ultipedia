package com.amusoft.ultipedia;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Amu on 4/1/2015.
 */
public class Mathematics extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View mathematics= inflater.inflate(R.layout.fragment_leader_board_math, container, false);


        return mathematics;
    }
}

package com.amusoft.ultipedia;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;

import com.shephertz.app42.paas.sdk.android.App42API;

/**
 * Created by Amu on 4/1/2015.
 */
@SuppressWarnings("DefaultFileTemplate")
@TargetApi(Build.VERSION_CODES.GINGERBREAD)
@SuppressLint("NewApi")
public class LeaderBoardActivity extends FragmentActivity {
    private ViewPager Tab;
    private TabPagerAdapter TabAdapter;
    private ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leader_board);
        App42API.initialize(getApplicationContext(), "33febecb03a579e972755eccde307dd94a279b5cfe348f845b8762f8e3feb2d6",
                "b5be405b4e76d40a94cdc01250311205b5a7c7b2dc4d003714f24d0df3e219f8");
        TabAdapter = new TabPagerAdapter(getSupportFragmentManager());
        Tab = (ViewPager)findViewById(R.id.pager);
        Tab.setOnPageChangeListener(
                new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        actionBar = getActionBar();
                        actionBar.setSelectedNavigationItem(position);                    }
                });
        Tab.setAdapter(TabAdapter);
        actionBar = getActionBar();
        //Enable Tabs on Action Bar
        assert actionBar != null;
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
            @Override
            public void onTabReselected(android.app.ActionBar.Tab tab,
                                        FragmentTransaction ft) {
                // TODO Auto-generated method stub
            }
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                Tab.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(android.app.ActionBar.Tab tab,
                                        FragmentTransaction ft) {
                // TODO Auto-generated method stub
            }};
        //Add New Tab
        actionBar.addTab(actionBar.newTab().setText("Fun").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Mathiematics").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("English").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Kiswahili").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Science").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Social Studies").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("CRE").setTabListener(tabListener));

    }



}

/**
 * -----------------------------------------------------------------------
 *     Copyright © 2015 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.shephertz.widget.app42.leaderboard;

import java.util.ArrayList;
import java.util.List;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;

import com.example.shephwidgetlibrary.R;
import com.shephertz.widget.app42.utils.App42LeaderBoardType;
import com.shephertz.widget.app42.utils.Constants;

/**
 * @author Vishnu Garg
 */
public class LeaderBoardActivity extends Activity implements TabListener {

	private ActionBar actionBar;
	private List<Fragment> fragList = new ArrayList<Fragment>();
	private App42LeaderBoardType selectedLeaderBoard;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.app42_leaderboard);
		intializeView();
	}

	/**
	 * 
	 */
	private void intializeView() {
		if (selectedLeaderBoard == LeaderBoardProperties.getLeaderBoardType())
			return;
		selectedLeaderBoard = LeaderBoardProperties.getLeaderBoardType();
		actionBar = getActionBar();
		actionBar.setHomeButtonEnabled(false);
		actionBar.setTitle(" App42 LeaderBoard");
		actionBar.setIcon(R.drawable.leaderboard);
		// actionBar.set
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		addLeaderBoardTabs();
	}

	/**
	 * @param tabArray
	 */
	private void addTabs(String[] tabArray) {
		actionBar.removeAllTabs();
		fragList.clear();
		for (String tab_name : tabArray) {
			actionBar.addTab(actionBar.newTab().setText(tab_name)
					.setTabListener(this));
		}
	}

	/**
	 * Add Tabs on UI
	 */
	private void addLeaderBoardTabs() {
		if (selectedLeaderBoard == App42LeaderBoardType.DateRange) {
			addTabs(Constants.DaysRangeArr);
		} else if (selectedLeaderBoard == App42LeaderBoardType.Social) {
			addTabs(Constants.SocialArr);
		} else if (selectedLeaderBoard == App42LeaderBoardType.UserStanding) {
			addTabs(Constants.UserArr);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.app.ActionBar.TabListener#onTabReselected(android.app.ActionBar
	 * .Tab, android.app.FragmentTransaction)
	 */
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.app.ActionBar.TabListener#onTabSelected(android.app.ActionBar
	 * .Tab, android.app.FragmentTransaction)
	 */
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		Fragment fragment = null;
		LeaderBoardFragment scoreboardFragment = null;
		if (fragList.size() > tab.getPosition())
			fragment = fragList.get(tab.getPosition());
		if (fragment == null) {
			scoreboardFragment = new LeaderBoardFragment();
			Bundle data = new Bundle();
			data.putString(Constants.SelectedTabValue, tab.getText().toString());
			data.putString(Constants.SelectedLeaderBoard,
					selectedLeaderBoard.toString());
			scoreboardFragment.setArguments(data);
			fragList.add(scoreboardFragment);
		} else
			scoreboardFragment = (LeaderBoardFragment) fragment;
		ft.replace(android.R.id.content, scoreboardFragment);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.app.ActionBar.TabListener#onTabUnselected(android.app.ActionBar
	 * .Tab, android.app.FragmentTransaction)
	 */
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		if (fragList.size() > tab.getPosition()) {
			ft.remove(fragList.get(tab.getPosition()));
		}
	}
}

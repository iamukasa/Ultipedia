/**
 * -----------------------------------------------------------------------
 *     Copyright © 2015 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.shephertz.widget.app42.leaderboard;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shephwidgetlibrary.R;
import com.shephertz.app42.paas.sdk.android.game.Game.Score;
import com.shephertz.widget.app42.utils.LeaderBoardCategory;
import com.shephertz.widget.app42.utils.Utils;

/**
 * Build ListView UI for different type of LeaderBoard
 * 
 * @author Vishnu Garg
 */
public class LeaderBoardAdapter extends BaseAdapter {

	private ArrayList<Score> scoreList;
	private Activity activity;
	private LeaderBoardCategory currentTab;

	/**
	 * @param activity
	 * @param scoreList
	 * @param currentTab
	 */
	public LeaderBoardAdapter(Activity activity, ArrayList<Score> scoreList,
			LeaderBoardCategory currentTab) {
		this.activity = activity;
		this.currentTab = currentTab;
		this.scoreList = scoreList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getCount()
	 */
	public int getCount() {
		return scoreList.size();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItemId(int)
	 */
	public long getItemId(int position) {
		return position;
	}

	/**
	 * @author Vishnu
	 * 
	 */
	public static class ViewHolder {
		public TextView name;
		public TextView index;
		public TextView income;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View,
	 * android.view.ViewGroup)
	 */
	@SuppressLint("ResourceAsColor")
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;
		ViewHolder holder;
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			vi = inflater.inflate(R.layout.score_item, null);
			holder = new ViewHolder();
			holder.name = (TextView) vi.findViewById(R.id.name);
			holder.index = (TextView) vi.findViewById(R.id.rank);
			holder.income = (TextView) vi.findViewById(R.id.score);
			vi.setTag(holder);

		}
		holder = (ViewHolder) vi.getTag();

		Score score = scoreList.get(position);
		if (currentTab == LeaderBoardCategory.Friends) {
			holder.name.setText(score.getFacebookProfile().getName());
		} else if (currentTab == LeaderBoardCategory.MyScores
				|| currentTab == LeaderBoardCategory.MyRanking) {

			holder.name.setText(Utils.getFormattedDate(score.getCreatedOn()));
		} else {
			holder.name.setText("" + score.getUserName());
		}
		if (currentTab == LeaderBoardCategory.MyRanking) {
			holder.index.setText("" + score.getRank());
		} else {
			holder.index.setText("" + (++position));
		}
		holder.income.setText("" + score.getValue());
		return vi;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}
}
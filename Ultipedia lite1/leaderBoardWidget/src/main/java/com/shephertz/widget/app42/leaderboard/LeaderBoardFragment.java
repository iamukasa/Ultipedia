/**
 * -----------------------------------------------------------------------
 *     Copyright © 2015 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.shephertz.widget.app42.leaderboard;

import java.util.ArrayList;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import com.example.shephwidgetlibrary.R;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.game.Game;
import com.shephertz.app42.paas.sdk.android.game.Game.Score;
import com.shephertz.widget.app42.service.App42ScoreBoardService;
import com.shephertz.widget.app42.utils.App42LeaderBoardType;
import com.shephertz.widget.app42.utils.Constants;
import com.shephertz.widget.app42.utils.LeaderBoardCategory;
/**
 * @author Vishnu Garg
 */
public class LeaderBoardFragment extends Fragment implements App42CallBack {

	private View mProgressBar;

	private static ArrayList<Score> dailyScoreList;
	private static ArrayList<Score> weeklyScoreList;
	private static ArrayList<Score> monthlyScoreList;

	private static ArrayList<Score> myScoreList;
	private static ArrayList<Score> myRankList;

	private static ArrayList<Score> globalScoreList;
	private static ArrayList<Score> socialScoreList;
	
	private LeaderBoardCategory currentTab;
	private App42LeaderBoardType scoreBoardType;
	private ListView scoreListView;
	private TextView messageView;
	private final String emptyMessage = "No Data found";
	

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreate(android.os.Bundle)
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Bundle data = getArguments();
		String selectedTab = data.getString(Constants.SelectedTabValue);
		currentTab = LeaderBoardCategory.getByValue(selectedTab);
		scoreBoardType = getScoreBoardType(data.getString(Constants.SelectedLeaderBoard));
	}

	/* (non-Javadoc)
	 * @see android.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.app42_scorelist, container,
				false);
		mProgressBar = rootView.findViewById(R.id.progress_container);
		mProgressBar.setVisibility(View.GONE);
		scoreListView = (ListView) rootView.findViewById(android.R.id.list);
		messageView = (TextView) rootView.findViewById(android.R.id.empty);
		return rootView;
	}

	/* (non-Javadoc)
	 * This function checks which type of LeaderBoard is going to show
	 * @see android.app.Fragment#onActivityCreated(android.os.Bundle)
	 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		mProgressBar.setVisibility(View.VISIBLE);
		if (scoreBoardType == App42LeaderBoardType.DateRange) {
			showDateBasesScoreBoard();
		} else if (scoreBoardType == App42LeaderBoardType.Social) {
			showGeneralScoreBoard();
		} else if (scoreBoardType == App42LeaderBoardType.UserStanding) {
			showMyScoreBoard();
		}
	}

	/**
	 * This function show General LeaderBoard
	 */
	private void showGeneralScoreBoard() {
		if (currentTab == LeaderBoardCategory.Global) {
			loadGeneralScoreList(currentTab, globalScoreList);
		} else if (currentTab == LeaderBoardCategory.Friends) {
			loadGeneralScoreList(currentTab, socialScoreList);
		}
	}
	/** This function loads score form App42 if not cached
	 * @param currentBoard
	 * @param scoreList
	 */
	private void loadGeneralScoreList(LeaderBoardCategory currentBoard,
			ArrayList<Score> scoreList) {
		mProgressBar.setVisibility(View.VISIBLE);
		if (scoreList == null) {
			App42ScoreBoardService.getInstance().fetchGeneralScoreBoard(currentBoard,this);
		} else if (scoreList.size() > 0) {
			loadListView(scoreList);
		} else {
			showMessage(emptyMessage);
		}
	}
	/**
	 * This function shows user ScoreBoard
	 */
	private void showMyScoreBoard() {
		if (currentTab == LeaderBoardCategory.MyScores) {
			loadMyScoreList(currentTab, myScoreList);
		} else if (currentTab == LeaderBoardCategory.MyRanking) {
			loadMyScoreList(currentTab, myRankList);
		}
	}

	/**
	 * This function fetches userScore list from App42
	 * @param currentBoard
	 * @param scoreList
	 */
	private void loadMyScoreList(LeaderBoardCategory currentBoard,
			ArrayList<Score> scoreList) {
		mProgressBar.setVisibility(View.VISIBLE);
		if (scoreList == null) {
			App42ScoreBoardService.getInstance().fetchMyScoreList(currentBoard,
					this);
		} else if (scoreList.size() > 0) {
			loadListView(scoreList);
		} else {
			showMessage(emptyMessage);
		}
	}

	/**
	 * This function show Date wise LeaderBoard
	 */
	private void showDateBasesScoreBoard() {
		if (currentTab == LeaderBoardCategory.Today) {
			loadDateBaseScoreList(currentTab, dailyScoreList);
		} else if (currentTab == LeaderBoardCategory.LastWeek) {
			loadDateBaseScoreList(currentTab, weeklyScoreList);
		} else if (currentTab == LeaderBoardCategory.LastMonth) {
			loadDateBaseScoreList(currentTab, monthlyScoreList);
		}
	}

	/** This function loads Date wise LeaderBoard
	 * @param currentBoard
	 * @param dateWiseScoreList
	 */
	private void loadDateBaseScoreList(LeaderBoardCategory currentBoard,
			ArrayList<Score> dateWiseScoreList) {
		mProgressBar.setVisibility(View.VISIBLE);
		if (dateWiseScoreList == null) {
			App42ScoreBoardService.getInstance().fetchScoreByDate(currentBoard,
					this);
		} else if (dateWiseScoreList.size() > 0) {
			loadListView(dateWiseScoreList);
		} else {
			showMessage(emptyMessage);
		}
	}

	/** Update Cache when Scores are fetched from App42
	 * @param scoreList
	 */
	private void upDateCache(ArrayList<Score> scoreList) {
		if (currentTab == LeaderBoardCategory.Today) {
			dailyScoreList = scoreList;
		} else if (currentTab == LeaderBoardCategory.LastWeek) {
			weeklyScoreList = scoreList;
		} else if (currentTab == LeaderBoardCategory.LastMonth) {
			monthlyScoreList = scoreList;
		} else if (currentTab == LeaderBoardCategory.MyRanking) {
			myRankList = scoreList;
		} else if (currentTab == LeaderBoardCategory.MyScores) {
			myScoreList = scoreList;
		}
		else if (currentTab == LeaderBoardCategory.Global) {
			globalScoreList = scoreList;
		}
		else if (currentTab == LeaderBoardCategory.Friends) {
			socialScoreList = scoreList;
		}
	}

	/**
	 * @param scoreList
	 */
	private void loadListView(ArrayList<Score> scoreList) {
		upDateCache(scoreList);
		mProgressBar.setVisibility(View.GONE);
		LayoutInflater inflater = getActivity().getLayoutInflater();
		ViewGroup header = (ViewGroup) inflater.inflate(R.layout.score_header,
				null);
		if(currentTab==LeaderBoardCategory.MyScores||currentTab==LeaderBoardCategory.MyRanking){
			TextView name=(TextView) header.findViewById(R.id.header_name);
			name.setText("Scored On");
			if(currentTab==LeaderBoardCategory.MyScores){
			TextView rank=(TextView) header.findViewById(R.id.header_rank);
			rank.setText("Index");
			}
		}
		scoreListView.addHeaderView(header);
		scoreListView
				.setAdapter(new LeaderBoardAdapter(getActivity(), scoreList,currentTab));
	}

	/** This function show message
	 * @param message
	 */
	private void showMessage(String message) {
		mProgressBar.setVisibility(View.GONE);
		messageView.setText(message);
		messageView.setVisibility(View.VISIBLE);
		scoreListView.setVisibility(View.GONE);
	}

	/* (non-Javadoc)
	 * @see com.shephertz.app42.paas.sdk.android.App42CallBack#onException(java.lang.Exception)
	 */
	@Override
	public void onException(final Exception arg0) {
		
		if(getActivity()==null)
			return;
		getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				showMessage(emptyMessage);
			}
		});
	}

	/* (non-Javadoc)
	 * @see com.shephertz.app42.paas.sdk.android.App42CallBack#onSuccess(java.lang.Object)
	 */
	@Override
	public void onSuccess(final Object game) {

		getActivity().runOnUiThread(new Runnable() {
			@Override
			public void run() {
				Game gameresponse = (Game) game;
				loadListView(gameresponse.getScoreList());
			}
		});
	}
	/**
	 * @param moveData
	 * @return
	 */
	private App42LeaderBoardType getScoreBoardType(String scoreBoardType) {
			if (scoreBoardType.equals(App42LeaderBoardType.Social.toString()))
				return App42LeaderBoardType.Social;
			else if (scoreBoardType.equals(App42LeaderBoardType.DateRange.toString()))
				return App42LeaderBoardType.DateRange;
			else
				return App42LeaderBoardType.UserStanding;
	}
}

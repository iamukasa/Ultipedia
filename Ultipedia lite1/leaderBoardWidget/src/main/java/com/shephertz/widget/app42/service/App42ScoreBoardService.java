/**
 * -----------------------------------------------------------------------
 *     Copyright © 2015 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.shephertz.widget.app42.service;
import java.util.Date;
import com.shephertz.app42.paas.sdk.android.App42API;
import com.shephertz.app42.paas.sdk.android.App42CallBack;
import com.shephertz.app42.paas.sdk.android.game.ScoreBoardService;
import com.shephertz.widget.app42.leaderboard.LeaderBoardProperties;
import com.shephertz.widget.app42.utils.LeaderBoardCategory;
/**This Service used to fetch various scores from App42 using ScoreBoard API based on ScoreBoard Type
 * @author Vishnu Garg
 */
public class App42ScoreBoardService {

	private static App42ScoreBoardService mInstance;
	private static ScoreBoardService scoreService = null;
	private final long DayTime = 86400000; // I day time in miliSec
    private static final int DaysInWeek=7;
    private static final int DaysInMonth=30;
    private static final int OneDay=1;
	/**
	 * private constructor
	 */
	private App42ScoreBoardService() {
		scoreService = App42API.buildScoreBoardService();
	}

	/** Singleton instance of class
	 * @return
	 */
	public static App42ScoreBoardService getInstance() {
		if (mInstance == null) {
			synchronized (App42ScoreBoardService.class) {
				if (mInstance == null)
					mInstance = new App42ScoreBoardService();
			}
		}
		return mInstance;
	}

	/** This function fetches Date wise LeaderBoard
	 * @param boardType
	 * @param callback
	 */
	public void fetchScoreByDate(LeaderBoardCategory boardType, App42CallBack callback) {
		scoreService.getTopNRankers(LeaderBoardProperties.getGameName(),
				getStartDate(boardType), new Date(),
				LeaderBoardProperties.getMaxEntries(), callback);
	}

	/** This function fetches general scores from App42 may be Global/Social
	 * @param boardType
	 * @param callback
	 */
	public void fetchGeneralScoreBoard(LeaderBoardCategory boardType,App42CallBack callback) {
		if (boardType == LeaderBoardCategory.Global) {
		scoreService.getTopNRankers(LeaderBoardProperties.getGameName(),
				LeaderBoardProperties.getMaxEntries(), callback);
		}
		else if(boardType == LeaderBoardCategory.Friends)
		{
			scoreService.getTopNRankersFromFacebook(LeaderBoardProperties.getGameName(),LeaderBoardProperties.getMyFbAccessToken(), LeaderBoardProperties.getMaxEntries(), callback);
		}
	}

	/** This function fetches user scores or ranking form App42
	 * @param boardType
	 * @param callback
	 */
	public void fetchMyScoreList(LeaderBoardCategory boardType, App42CallBack callback) {
		if (boardType == LeaderBoardCategory.MyScores) {
			scoreService.getScoresByUser(LeaderBoardProperties.getGameName(),
					LeaderBoardProperties.getUserName(), callback);
		} else if (boardType == LeaderBoardCategory.MyRanking) {
			scoreService.getUserRanking(LeaderBoardProperties.getGameName(),
					LeaderBoardProperties.getUserName(), callback);
		}
	}

	/** This function return start date in which LeaderBoard is going to show
	 * @param board
	 * @return
	 */
	private Date getStartDate(LeaderBoardCategory board) {
		if (board == LeaderBoardCategory.Today)
			return calculatePreviousDate(OneDay);
		else if (board == LeaderBoardCategory.LastWeek)
			return calculatePreviousDate(DaysInWeek);
		else
			return calculatePreviousDate(DaysInMonth);
	}

	/** This function calculate previous date based on noOfDays given
	 * @param noOfdays
	 * @return
	 */
	private Date calculatePreviousDate(int noOfdays) {
		Date prevDate = new Date(new Date().getTime() - DayTime * noOfdays);
		return prevDate;
	}
}

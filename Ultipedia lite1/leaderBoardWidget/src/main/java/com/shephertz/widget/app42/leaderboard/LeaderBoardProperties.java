/**
 * -----------------------------------------------------------------------
 *     Copyright © 2015 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.shephertz.widget.app42.leaderboard;

import com.shephertz.widget.app42.utils.App42LeaderBoardType;

/**Contains various ScoreBoard properties need to be set by user based on requirement of LeaderBoard
 * @author Vishnu Garg
 */
public class LeaderBoardProperties {
	// Default Value is 20
	private static int maxEntries= 20;
	private static String gameName = "";
	private static App42LeaderBoardType scoreBoardType = App42LeaderBoardType.DateRange;
	private static String userName = "";
	private static String myFbAccessToken ="";

	/**
	 * @return
	 */
	public static App42LeaderBoardType getLeaderBoardType() {
		return scoreBoardType;
	}

	/**
	 * @param scoreBoardType
	 */
	public static void setLeaderBoardType(App42LeaderBoardType scoreBoardType) {
		LeaderBoardProperties.scoreBoardType = scoreBoardType;
	}

	/**
	 * @return
	 */
	public static String getMyFbAccessToken() {
		return myFbAccessToken;
	}

	/**
	 * @param myFbAccessToken
	 */
	public static void setMyFbAccessToken(String myFbAccessToken) {
		LeaderBoardProperties.myFbAccessToken = myFbAccessToken;
	}

	/**
	 * @return
	 */
	public static String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 */
	public static void setUserName(String userName) {
		LeaderBoardProperties.userName = userName;
	}

	/**
	 * @return
	 */
	public static int getMaxEntries() {
		return maxEntries;
	}

	/**
	 * @return
	 */
	public static String getGameName() {
		return gameName;
	}

	

	/**
	 * @param maxUsers
	 */
	public static void setMaxEntries(int maxEntries) {
		LeaderBoardProperties.maxEntries = maxEntries;
	}

	/**
	 * @param maxUsers
	 */
	public static void setGameName(String maxUsers) {
		LeaderBoardProperties.gameName = maxUsers;
	}
}

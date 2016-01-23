/**
 * -----------------------------------------------------------------------
 *     Copyright © 2015 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.shephertz.widget.app42.utils;

import java.util.HashMap;
import java.util.Map;
/** Different category in various App42LeaderBoard
 * @author Vishnu Garg
 */
public enum LeaderBoardCategory {
	Today("Today's"),LastWeek("Last Week"),LastMonth("Last Month"),MyScores("My Scores"),MyRanking("My Rank"),Global("Global"),Friends("Friend's");
	private String value;
	private LeaderBoardCategory(final String value) {
		this.value = value;
	}
	public String getCategory() {
		return value;
	}
	private static final Map<String, LeaderBoardCategory> categoryMap = new HashMap<String, LeaderBoardCategory>();
	static {
		// populating the map
		for (LeaderBoardCategory scoreCategory : values()) {
			categoryMap.put(scoreCategory.getCategory(), scoreCategory);
		}
	}
	/**
	 * @param value
	 * @return
	 */
	public static LeaderBoardCategory getByValue(String value) {
		return categoryMap.get(value);
	}
}

/**
 * -----------------------------------------------------------------------
 *     Copyright � 2015 ShepHertz Technologies Pvt Ltd. All rights reserved.
 * -----------------------------------------------------------------------
 */
package com.amusoft.ultipedialite;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Vishnu Garg
 *
 */
public class Utils {

	/**
	 * @param date
	 * @return
	 */
	public static String getFormattedDate(Date date){
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				"MMM dd, yyyy");
		 return dateFormat.format(date);
	}
}

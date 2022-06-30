package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import utils.Logs;

/**
 * This Class provides the utilities for handling dates related operations
 * 
 * 
 */
public class DateUtils {

	private DateUtils() {
		// no -op
	}

	/**
	 * Method to getTime in Date format
	 * 
	 * @param millis milliseconds
	 * @return Date from the milliseconds
	 */
	public static Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	public static String getCurrentDate(int daysOffSet) {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, daysOffSet);
		date = cal.getTime();

		return dateFormat.format(date);
	}

	public static String getCustomTimeStamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getFullMonth(String shortMonth) {

		String fullMonth = "";
		switch(shortMonth) {

			case "Jan":
			case "01":
				fullMonth = "January";
				break;
			case "Feb":
			case "02":
				fullMonth = "February";
				break;
			case "Mar":
			case "03":
				fullMonth = "March";
				break;
			case "Apr":
			case "04":
				fullMonth = "April";
				break;
			case "May":
			case "05":
				fullMonth = "May";
				break;
			case "Jun":
			case "06":
				fullMonth = "June";
				break;
			case "Jul":
			case "07":
				fullMonth = "July";
				break;
			case "Aug":
			case "08":
				fullMonth = "August";
				break;
			case "Sep":
			case "09":
				fullMonth = "September";
				break;
			case "Oct":
			case "10":
				fullMonth = "October";
				break;
			case "Nov":
			case "11":
				fullMonth = "November";
				break;
			case "Dec":
			case "12":
				fullMonth = "December";
				break;

			default:
				Logs.LOGGER.warning("Did not find a valid month abbreviation.");
				break;

		}
		return fullMonth;
   }
	public static int getRandomNumberInts(int min, int max) {
		Random random = new Random();
		return random.ints(min, (max + 1)).findFirst().getAsInt();
	}
	public static int RandomNum() {
		int rand1 = getRandomNumberInts(1000, 10000);
		return rand1;
	}
}

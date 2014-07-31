package fr.kevin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import fr.kevin.exception.InvalidDateFormatException;

public class Utils {

	public static String cleanAmount(String amount) {
		return amount.replace(" ", "").replace("€", "").replace(",", ".");
	}

	public static String dateToUnixTimeStamp(String date)
			throws InvalidDateFormatException {
		Date date2 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date2 = formatter.parse(date);
		} catch (Exception e) {
			throw new InvalidDateFormatException(date);
		}
		return String.valueOf((date2.getTime() / 1000));
	}
	public static ArrayList<String> getListDaysAndHoursOfWeek(String startDate) throws ParseException{
		startDate = startDate.replace("/", "-");
		ArrayList<String> hours = new ArrayList<String>();
		ArrayList<String> dateAndHours = new ArrayList<String>();
		for(int i = 0;i<24;i++){
			if(i<10)
				hours.add("-0"+i);
			else
				hours.add("-"+i);
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		
		for(int x = 0; x < 7; x++){
			for(int i = 0; i < 24 ; i++){
				dateAndHours.add(startDate+hours.get(i));
			}
			c.setTime(sdf.parse(startDate));
			c.add(Calendar.DATE, 1);  // number of days to add
			startDate = sdf.format(c.getTime());  // dt is now the new date
		}
		return dateAndHours;
	}
}

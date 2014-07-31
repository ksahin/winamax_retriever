package fr.kevin;

import java.text.SimpleDateFormat;
import java.util.Date;

import fr.kevin.exception.InvalidDateFormatException;

public class Utils {

	public static String cleanAmount(String amount) {
		return amount.replace(" ", "").replace("€", "").replace(",", ".");
	}

	public static String dateToUnixTimeStamp(String date)
			throws InvalidDateFormatException {
		Date date2 = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date2 = formatter.parse(date);
		} catch (Exception e) {
			throw new InvalidDateFormatException(date);
		}
		return String.valueOf((date2.getTime() / 1000));
	}
}

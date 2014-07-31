package fr.kevin;

public class Utils {
	public static String cleanAmount(String amount){
		return amount.replace(" ", "").replace("€","").replace(",", ".");
	}
}

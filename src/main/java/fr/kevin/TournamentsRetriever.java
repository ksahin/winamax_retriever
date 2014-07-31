package fr.kevin;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.util.NameValuePair;

public class TournamentsRetriever {
	
	public static JSONObject getTournamentsList(String unixTimeStamp) throws Exception{
		WebClient client = new WebClient();
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);

		WebRequest request = new WebRequest(new URL(
				"https://www.winamax.fr/les-tournois_planning"));
		request.setHttpMethod(HttpMethod.POST);
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new NameValuePair("start_date", unixTimeStamp));
		request.setRequestParameters(params);
		HtmlPage page = null;
		try {
			page = client.getPage(request);
		} catch (Exception e) {

		}
		String json = "{ \""
				+ page.asXml().split("tournaments = \\{\"")[1].split("]];")[0]
						.split("//")[0].replace(";", "");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(json);
		JSONObject jsonObj = (JSONObject) obj;
		return jsonObj;
	}
	public static ArrayList<String> getTournamentsIdList(JSONObject jsonTournamentsList, String startDate) throws ParseException{
		ArrayList<String> dateAndHours = Utils.getListDaysAndHoursOfWeek(startDate);
		ArrayList<String> tournamentsIdList = new ArrayList<String>();
		for(String date : dateAndHours){
			JSONArray array = (JSONArray) jsonTournamentsList.get(date);
			Iterator it = array.iterator();
			while(it.hasNext()){
				JSONObject temp = (JSONObject) it.next();
				tournamentsIdList.add((String) temp.get("id"));
			}
		}
		return tournamentsIdList;
	}
	public static void main(String args[]) throws Exception {
		String startDate = "2014-07-10";
		JSONObject jsonObj = getTournamentsList(Utils.dateToUnixTimeStamp(startDate));
		ArrayList<String> tournamentsId = getTournamentsIdList(jsonObj, startDate);
		for(String id : tournamentsId){
			System.out.println(id);
		}
		System.out.println("Fini ! ");
	}
}

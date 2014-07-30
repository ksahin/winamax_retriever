package fr.kevin;

import java.net.URL;
import java.util.ArrayList;
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

	public static void main(String args[]) throws Exception {

		WebClient client = new WebClient();
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);

		WebRequest request = new WebRequest(new URL(
				"https://www.winamax.fr/les-tournois_planning"));
		request.setHttpMethod(HttpMethod.POST);
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new NameValuePair("start_date", "1400709600"));
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
		JSONArray array = (JSONArray) jsonObj.get("2014-05-23-00");
		Iterator it = array.iterator();
		while (it.hasNext()) {
			JSONObject temp = (JSONObject) it.next();
			System.out.println("id : " + temp.get("id"));
			System.out.println("time : " + temp.get("time"));
			System.out.println("name : " + temp.get("name"));
			System.out.println("buyin : " + temp.get("buyin"));

		}
		System.out.println(jsonObj);

		System.out.println("Fini ! ");
	}
}

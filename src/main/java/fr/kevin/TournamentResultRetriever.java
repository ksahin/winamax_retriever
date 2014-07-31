package fr.kevin;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

public class TournamentResultRetriever {
	public static void main(String args[]) throws Exception {

		WebClient client = new WebClient();
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);
		String tournamentId = "82915467";
		HtmlPage page = client.getPage("https://www.winamax.fr/poker/tournament.php?ID="+tournamentId);
		HtmlTable table = page.getFirstByXPath("//table[@class='ranking']");
		for(HtmlTableRow row : table.getBodies().get(0).getRows()){
			//Ici il faudra check que le player existe en base ou pas
			PlayerBean player = new PlayerBean();
			player.setPseudo(row.getChildNodes().get(1).asText());
			
		}
	}
}

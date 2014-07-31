package fr.kevin;

import java.util.ArrayList;
import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

public class TournamentResultRetriever {
	
	public static List<TournamentResult> getTournementResult(int tournamentId) throws Exception{
		WebClient client = new WebClient();
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);
		HtmlPage page = client.getPage("https://www.winamax.fr/poker/tournament.php?ID="+tournamentId);
		HtmlTable table = page.getFirstByXPath("//table[@class='ranking']");
		List<TournamentResult> resultList = new ArrayList<TournamentResult>();
		for(HtmlTableRow row : table.getBodies().get(0).getRows()){
			//Ici il faudra check que le player existe en base ou pas
			TournamentResult result = new TournamentResult();
			result.setPseudoPlayer(row.getChildNodes().get(1).asText());
			result.setTournamentId(tournamentId);
			result.setAmountWon(Double.valueOf(fr.kevin.Utils.cleanAmount(row.getChildNodes().get(2).asText())));
			result.setRank(Integer.valueOf(row.getChildNodes().get(0).asText()));
			resultList.add(result);
		}
		return resultList;
	}
	public static void main(String args[]) throws Exception {

		List<TournamentResult> listResult = getTournementResult(82915467);
		for(TournamentResult res : listResult){
			System.out.println("Id du tournois : "+ res.getTournamentId());
			System.out.println("Pseudo joueur : "+ res.getPseudoPlayer());
			System.out.println("Gain  "+ res.getAmountWon());
			System.out.println("Rank : "+ res.getRank());
		}
		
	}
}

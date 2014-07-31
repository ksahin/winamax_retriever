package fr.kevin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

import fr.kevin.bean.TournamentResultBean;

public class TournamentResultRetriever {
	
	public static List<TournamentResultBean> getTournementResult(int tournamentId) throws Exception{
		WebClient client = new WebClient();
		client.getOptions().setJavaScriptEnabled(false);
		client.getOptions().setCssEnabled(false);
		HtmlPage page = client.getPage("https://www.winamax.fr/poker/tournament.php?ID="+tournamentId);
		Random rand = new Random();
		int min = 3000;
		int max = 6000;
		int randomNum = rand.nextInt((max - min) + 1) + min;
		Thread.sleep(randomNum);
		HtmlTable table = page.getFirstByXPath("//table[@class='ranking']");
		List<TournamentResultBean> resultList = new ArrayList<TournamentResultBean>();
		for(HtmlTableRow row : table.getBodies().get(0).getRows()){
			TournamentResultBean result = new TournamentResultBean();
			result.setPseudoPlayer(row.getChildNodes().get(1).asText());
			result.setTournamentId(tournamentId);
			result.setAmountWon(Double.valueOf(fr.kevin.Utils.cleanAmount(row.getChildNodes().get(2).asText())));
			result.setRank(Integer.valueOf(row.getChildNodes().get(0).asText()));
			resultList.add(result);
		}
		return resultList;
	}
	public static void main(String args[]) throws Exception {
		String startDate = "2014-07-10";
		JSONObject jsonObj = TournamentsRetriever.getTournamentsList(Utils.dateToUnixTimeStamp(startDate));
		ArrayList<String> tournamentsId = TournamentsRetriever.getTournamentsIdList(jsonObj, startDate);
		StringBuffer sbf = new StringBuffer();
		for(String idTournament : tournamentsId){
			List<TournamentResultBean> listResult = getTournementResult(Integer.valueOf(idTournament));
			for(TournamentResultBean res : listResult){
				sbf.append("Id du tournois : "+ res.getTournamentId()+"\n");
				sbf.append("Pseudo joueur : "+ res.getPseudoPlayer()+"\n");
				sbf.append("Gain  "+ res.getAmountWon()+"\n");
				sbf.append("Rank : "+ res.getRank()+"\n");
				System.out.println("Id du tournois : "+ res.getTournamentId());
				System.out.println("Pseudo joueur : "+ res.getPseudoPlayer());
				System.out.println("Gain  "+ res.getAmountWon());
				System.out.println("Rank : "+ res.getRank());
			}
		}
		FileUtils.writeStringToFile(new File("Resultat_Tournois"), sbf.toString());

		
	}
}

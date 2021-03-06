package fr.kevin.bean;

import java.util.ArrayList;

import com.sun.corba.se.spi.ior.ObjectId;

public class PlayerBean {
	//dans un premier temps l'id des joueurs sera leur pseudo, il me semble que c'est unique
	private String pseudo;
	private Double amount;
	private ArrayList<TournamentResultBean> listTournamentResult;
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public ArrayList<TournamentResultBean> getListTournamentResult() {
		return listTournamentResult;
	}
	public void setListTournamentResult(
			ArrayList<TournamentResultBean> listTournamentResult) {
		this.listTournamentResult = listTournamentResult;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}


}

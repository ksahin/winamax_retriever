package fr.kevin;

import java.util.ArrayList;

public class PlayerBean {
	
	private String pseudo;
	private Double amount;
	private int id;
	private ArrayList<TournamentResult> listTournamentResult;
	
	
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}

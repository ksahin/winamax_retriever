package fr.kevin;

import com.sun.corba.se.spi.ior.ObjectId;

public class TournamentResult {
	

	private int buyin;
	private String name;
	private int id;
	private String time;//a voir, pas top une string...
	private Double amountWon;
	private String pseudoPlayer;
	private int tournamentId;
	private int numberOfPlayer;
	private int rank;
	


	public String getPseudoPlayer() {
		return pseudoPlayer;
	}
	public void setPseudoPlayer(String pseudoPlayer) {
		this.pseudoPlayer = pseudoPlayer;
	}
	public int getTournamentId() {
		return tournamentId;
	}
	public void setTournamentId(int tournamentId) {
		this.tournamentId = tournamentId;
	}
	public int getNumberOfPlayer() {
		return numberOfPlayer;
	}
	public void setNumberOfPlayer(int numberOfPlayer) {
		this.numberOfPlayer = numberOfPlayer;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getBuyin() {
		return buyin;
	}
	public void setBuyin(int buyin) {
		this.buyin = buyin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getAmountWon() {
		return amountWon;
	}
	public void setAmountWon(Double amountWon) {
		this.amountWon = amountWon;
	}
}

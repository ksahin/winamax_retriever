package fr.kevin;


public class TournamentResult {

	private int id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getAmountWon() {
		return amountWon;
	}

	public void setAmountWon(Double amountWon) {
		this.amountWon = amountWon;
	}
}

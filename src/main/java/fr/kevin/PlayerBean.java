package fr.kevin;

import java.util.ArrayList;

public class PlayerBean {
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
	public ArrayList<Integer> getListTournamentsId() {
		return listTournamentsId;
	}
	public void setListTournamentsId(ArrayList<Integer> listTournamentsId) {
		this.listTournamentsId = listTournamentsId;
	}
	
	private Double amount;
	private int id;
	private ArrayList<Integer> listTournamentsId;
}

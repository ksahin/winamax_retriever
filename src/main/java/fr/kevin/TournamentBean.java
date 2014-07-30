package fr.kevin;

public class TournamentBean {
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
	public int getNbJoueur() {
		return nbJoueur;
	}
	public void setNbJoueur(int nbJoueur) {
		this.nbJoueur = nbJoueur;
	}
	private int nbJoueur;
	private int buyin;
	private String name;
	private int id;
	private String time;//a voir, pas top une string...
}

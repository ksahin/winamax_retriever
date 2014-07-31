package fr.kevin.bean;

import com.sun.corba.se.spi.ior.ObjectId;

public class TournamentBean {
	private int nbJoueur;
	
	private int buyin;
	private String name;
	private ObjectId id;
	private String time;//a voir, pas top une string...
	
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
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
}

package com.metier;

public class Facture {

	private int anF;
	private String nomF;
	private String idHabitation;
	private int idFacture;
		private int moisF;
		
	public Facture(int anF, String nomF, String idHabitation, int moisF) {
		super();
		this.anF = anF;
		this.nomF = nomF;
		this.idHabitation = idHabitation;
		this.moisF = moisF;
	}
	
	public Facture(int idFacture, int moisF, int anF, String nomF, String idHabitation) {
		super();
		this.idFacture = idFacture;
		this.moisF = moisF;
		this.anF = anF;
		this.nomF = nomF;
		this.idHabitation = idHabitation;
	}

	public int getMoisF() {
		return moisF;
	}
	public void setMoisF(int moisF) {
		this.moisF = moisF;
	}
	public int getAnF() {
		return anF;
	}
	public void setAnF(int moisA) {
		this.anF = moisA;
	}
	public String getNomF() {
		return nomF;
	}
	public void setNomF(String nomF) {
		this.nomF = nomF;
	}
	public String getIdHabitation() {
		return idHabitation;
	}
	public int getIdFacture() {
		return idFacture;
	}
	
	
}

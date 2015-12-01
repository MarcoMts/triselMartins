package com.metier;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Gestion des levees
 * @author martins-m
 * @see Levee
 */
public class Levee {
	private int idLevee;
	private Date laDate;
	private Double poids;
	private String idPoubelle;
	/**
	 * Constructeur 
	 * @param idLevee
	 * 				Identifiant d'une levee -> int
	 * @param laDate
	 * 				La date de la  levee -> Date
	 * @param poids
	 * 				Poid de la levee -> Double
	 * @param idPoubelle
	 * 				Identifiant d'une poubelle concernant une levee
	 */
	public Levee(int idLevee, Date laDate, Double poids, String idPoubelle) {
		super();
		this.idLevee = idLevee;
		this.laDate = laDate;
		this.poids = poids;
		this.idPoubelle = idPoubelle;
	}
	/**
	 * Constructeur V2
	 * @param laDate
	 * 				La date de la  levee -> Date
	 * @param poids
	 * 				Poid de la levee -> Double
	 * @param idPoubelle
	 * 					Identifiant de la poubelle concerner par la levee -> String
	 */
	public Levee(Date laDate, Double poids, String idPoubelle) {
		super();
		this.laDate = laDate;
		this.poids = poids;
		this.idPoubelle = idPoubelle;
	}
	/**
	 * Renvoie l'identifiant de la poubelle concerner par la levee
	 * @return
	 * 			Identifiant poubelle -> String
	 */
	public String getIdPoubelle() {
		return idPoubelle;
	}
	/**
	 * Renvoie la date de la levee
	 * @return
	 * 			Date d'une levee -> Date
	 */
	public Date getLaDate() {
		return laDate;
	}
	/**
	 * Modification de la date
	 * @param laDate
	 * 				Nouvelle date -> Date
	 */
	public void setLaDate(Date laDate) {
		this.laDate = laDate;
	}
	/**
	 * Renvoie le poid de la levee
	 * @return
	 * 			Poids -> Double
	 */
	public Double getPoids() {
		return poids;
	}
	/**
	 * Modification du poid de la levee
	 * @param poids
	 * 				Nouveau poid -> Double
	 */
	public void setPoids(Double poids) {
		this.poids = poids;
	}
	/**
	 * Renvoie l'identifiant de la levee
	 * @return
	 * 		Un identifiant -> Int
	 */
	public int getIdLevee() {
		return idLevee;
	}
	/**
	 * Modification de l'id de poubelle concernant une levee
	 * @param idPoubelle
	 * 					Nouvelle idPoubelle -> String
	 */
	public void setIdPoubelle(String idPoubelle) {
		this.idPoubelle = idPoubelle;
	}
	/**
	 * Ramene les informations sur une levee en chaine de caracteres
	 */
	@Override
	public String toString() {
		return "Levee [idLevee=" + idLevee + ", laDate=" + laDate + ", poids=" + poids + "]";
	}

}

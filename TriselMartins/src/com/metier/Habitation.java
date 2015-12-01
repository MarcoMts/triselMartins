package com.metier;
import java.util.ArrayList;
/**
 * Gestion des habitations
 * @author martins-m
 * @see Habitation
 */
public class Habitation {
	private String idHabitation;
	private String adresseRue;
	private String codePostal;
	private String adresseVile;
	private Usager usager;
	private ArrayList<Poubelle> lesPoubelles;
	/**
	 * Constructeur
	 * @param idHabitation
	 * 					Clé primaire de l'habitation -> String
	 * @param adresseRue
	 * 					L'adresse rue de l'habitation -> String
	 * @param codePostal
	 * 					Le code postal de l'habitation -> String
	 * @param adresseVile
	 * 					La ville de l'habitation -> String
	 * @param usager 
	 * 				Usager concerner par l'habitation -> Usager
	 */
	public Habitation(String idHabitation, String adresseRue, String codePostal, String adresseVile, Usager usager)
			{
		super();
		this.idHabitation = idHabitation;
		this.adresseRue = adresseRue;
		this.codePostal = codePostal;
		this.adresseVile = adresseVile;
		this.usager = usager;
		this.lesPoubelles = new ArrayList<Poubelle>();
	}
	/**
	 * Renvoie l'adresse rue de l'habitation
	 * @return
	 * 			L'adresse de la rue -> String
	 */
	public String getAdresseRue() {
		return adresseRue;
	}
	/**
	 * Modification de l'adresse de la rue de l'habitation
	 * @param adresseRue 
	 * 					Nouvelle adresse de l'habitation -> String
	 */
	public void setAdresseRue(String adresseRue) {
		this.adresseRue = adresseRue;
	}
	/**
	 * Renvoie le CP de l'habitation
	 * @return
	 * 			Le CP de l'habitation -> String
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * Modification du CP de l'habitation
	 * @param codePostal 
	 * 					Nouvelle CP de l'habitation -> String
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	/**
	 * Renvoie la ville de l'habitation
	 * @return
	 * 			la ville de L'habitation -> String
	 */
	public String getAdresseVile() {
		return adresseVile;
	}
	/**
	 * Modification de la ville 
	 * @param adresseVile
	 * 				Nouvelle ville de l'habitation -> String
	 */
	public void setAdresseVile(String adresseVile) {
		this.adresseVile = adresseVile;
	}

	/**
	 * Renvoie l'usager de l'habitation
	 * @return
	 * 		l'usager de l'habitation -> Objet Usager
	 */
	public Usager getUsager() {
		return usager;
	}

	/**
	 * Modification de l'usager d'une habitation
	 * @param usager 
	 * 				Un usager -> Usager
	 */
	public void setUsager(Usager usager) {
		this.usager = usager;
	}
	
	/**
	 * Renvoie la liste des poubelle de l'habitation
	 * @return
	 * 		Liste de poubelles -> ArrayList de Poubelles
	 */
	public ArrayList<Poubelle> getLesPoubelles() {
		return lesPoubelles;
	}
	/**
	 * Modification de la liste des poubelle de l'habitation
	 * @param lesPoubelles  
	 * 				Une liste de poubelles -> ArrayList de poubelles
	 */
	public void setLesPoubelles(ArrayList<Poubelle> lesPoubelles) {
		this.lesPoubelles = lesPoubelles;
	}
	
	/**
	 * Renvoie l'identifiant de l'habitation
	 * @return
	 * 		Identifiant de l'habitation -> String
	 */
	public String getIdHabitation() {
		return idHabitation;
	}
	/**
	 * Ajout d'une poubelle
	 * @param e  
	 * 			Poubelle à ajouter-> Poubelle
	 */
	public void ajoutPoubelle(Poubelle e)
	{
		this.lesPoubelles.add(e);
	}
	/**
	 * Renvoie le cout des levess sur un mois
	 * @param an  
	 * 			L'annee de la levee -> int
	 * @param mois 
	 * 			Le mois de la levee -> int
	 * @return
	 * 		Le coût total de levee -> double
	 */
	public double getCout(int an, int mois)
	{
		double cout = 0;
		
		for(Poubelle p : lesPoubelles)
		{
			cout = cout + p.getCout(an, mois);
		}
		return cout;
	}
	/**
	 * Ramène les informations sur une habitation en chaine de caracteres
	 */
	@Override
	public String toString() {
		return "Habitation [idHabitation=" + idHabitation + ", adresseRue=" + adresseRue + ", codePostal=" + codePostal
				+ ", adresseVile=" + adresseVile + ", usager=" + usager + ", lesPoubelles=" + lesPoubelles + "]";
	}		
}

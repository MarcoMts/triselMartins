package com.metier;
import java.util.ArrayList;
import java.util.Calendar;
/**
 * Gestion des poubelles
 * @author martins-m
 * @see Poubelle
 */
public class Poubelle {
	private String idPoubelle;
	private TypeDechet nature;
	private ArrayList<Levee> lesLevees;
	private String idHabitation;
	/**
	 * Constructeur
	 * @param idPoubelle
	 * 					Identifiant de la poubelle -> String
	 * @param nature
	 * 				Nature de la poubelle -> TypeDechet
	 * @param idHabitation
	 * 					Identifiant de l'habitation concerner -> String
	 */
	public Poubelle(String idPoubelle, TypeDechet nature, String idHabitation) {
		super();
		this.idPoubelle = idPoubelle;
		this.nature = nature;
		lesLevees = new ArrayList<Levee>();
		this.idHabitation = idHabitation;
	}
	/**
	 * Constructeur_V2 
	 * @param idPoubelle
	 * 					Identifiant de la poubelle -> String
	 * @param nature
	 * 				Nature de la poubelle -> TypeDechet
	 * 				
	 */
	public Poubelle(String idPoubelle, TypeDechet nature) {
		this.idPoubelle = idPoubelle;
		this.nature = nature;
		lesLevees = new ArrayList<Levee>();
	}
	
	/**
	 * Renvoie le type de dechet de la poubelle
	 * @return
	 * 			nature -> TypeDechet
	 */
	public TypeDechet getNature() {
		return nature;
	}
	/**
	 * Modification du type de dechet de la poubelle
	 * @param nature
	 * 				Nouvelle nature -> TypeDechet
	 */
	public void setNature(TypeDechet nature) {
		this.nature = nature;
	}
	/**
	 * Renvoie les levees concerner par la poubelle
	 * @return
	 * 		lesLevees - > Arrayliste de levee
	 */
	public ArrayList<Levee> getLesLevees() {
		return lesLevees;
	}
	/**
	 * Modification de la liste des levees
	 * @param lesLevees
	 * 					Nouvelle liste de levee ->  Arrayliste de levee
	 */				
	public void setLesLevees(ArrayList<Levee> lesLevees) {
		this.lesLevees = lesLevees;
	}
	/**
	 * Renvoie l'identifiant de la poubelle
	 * @return
	 * 		idPoubelle -> String
	 */
	public String getIdPoubelle() {
		return idPoubelle;
	}
	/**
	 * Renvoie l'identifiant de l'habitation
	 * @return
	 * 			idHabitation -> String
	 */
	public String getIdhabitation() {
		return idHabitation;
	}
	/**
	 * Modification de l'habitation d'une poubelle
	 * @param idHabitation
	 * 					Nouvelle idHabitation -> String
	 */
	public void setIdhabitation(String idHabitation) {
		this.idHabitation = idHabitation;
	}
	/**
	 * Ajout d'une levee a la liste des levees
	 * @param uneLevee
	 * 				Nouvelle unelevee -> Levee
	 */
	public void ajoutLevee(Levee uneLevee)
	{
		lesLevees.add(uneLevee);
	}
	/**
	 * Ramène une liste de levee sur un moi, annee et moi preciser
	 * @param an
	 * 			Annee de la Levee -> Int
	 * @param mois
	 * 			Mois de la Levee -> Int
	 * @return
	 * 			une liste de la Levee -> ArrayListe de Levee
	 */
	public ArrayList<Levee> getLesLevees(int an, int mois)
	{
		//Collection de tavail à declarer et a instancier
		ArrayList<Levee> lesLeveesMois = new ArrayList<Levee>();
		//Objet calendar
		Calendar cal = Calendar.getInstance();
		//Parcours de la collection de levee
		for(Levee l : lesLevees)
		{
			//Extraire la date de levee dans 1 objet
			cal.setTime(l.getLaDate());
			//Extraction annee et du mois
			int year = cal.get(Calendar.YEAR);
			int month = cal.get(Calendar.MONTH)+1;
			if((an == year) && (mois == month))
			{
				lesLeveesMois.add(l);
			}
		}
		
		return lesLeveesMois;
	}
	/**
	 * Renvoie le cout total des levees sur un moi, annee et moi preciser
	 * @param an
	 * 			Annee de la Levee -> Int 
	 * @param mois
	 * 			Mois de la Levee -> Int
	 * @return
	 * 			Un cout total -> Double
	 */
	public double getCout(int an, int mois)
	{
		double cout = 0;
		ArrayList<Levee> lesLeveesMois = this.getLesLevees(an, mois);
		for(Levee l : lesLeveesMois)
		{
			cout = cout + l.getPoids() * getNature().getTarif();
		}
		return Math.round(cout);
	}
	/**
	 *  Ramene les informations sur une poubelle en chaine de caracteres
	 */
	@Override
	public String toString() {
		return "Poubelle [idPoubelle=" + idPoubelle + ", nature=" + nature + ", lesLevees=" + lesLevees
				+ ", idHabitation=" + idHabitation + "]";
	}
	
	
	
}

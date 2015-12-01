package com.metier;
/**
 * Gestion typeDechet
 * @author martins-m
 * @see TypeDechet
 */
public class TypeDechet {
	private String code;
	private String libelle;
	private Double tarif;
	/**
	 * Constructeur
	 * @param code
	 * 			Code du type de dechet -> String
	 * @param libelle
	 * 				Libelle du type de dechet -> String
	 * @param tarif
	 * 				Tarif du type de dechet -> Double
	 */
	public TypeDechet(String code, String libelle, Double tarif) {
		super();
		this.code = code;
		this.libelle = libelle;
		this.tarif = tarif;
	}
	/**
	 * Renvoie le libelle du type de dechet
	 * @return
	 * 		libelle -> String
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * Modification du libelle d'un type de dechet
	 * @param libelle
	 * 				Nouveau libelle -> String
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * Renvoie le tarif du type de decher
	 * @return
	 * 		Tarif -> Double
	 */
	public Double getTarif() {
		return tarif;
	}
	/**
	 * Modification du tarif du type de dechet
	 * @param tarif
	 * 				Nouveau tarif -> Double
	 */
	public void setTarif(Double tarif) {
		this.tarif = tarif;
	}
	/**
	 * Renvoie le code du type de dechet
	 * @return
	 * 			Code -> String
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * Ramene les informations sur un type de dechet en chaine de caracteres
	 */
	@Override
	public String toString() {
		return "TypeDechet [code=" + code + ", libelle=" + libelle + ", tarif=" + tarif + "]";
	}
	
}

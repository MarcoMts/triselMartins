package com.metier;
/**
 * Gestion Usager
 * @author martins-m
 * @see Usager
 */
public class Usager {
	private String idUser ;
	private String nom;
	private String prenom;
	private String adresseRueUsager;
	private String cpUsager;
	private String adresseVille;
	private String nomUser;
	private String motDePasse;
/**
 * Constructeur	
 * @param idUser
 * 				Identifiant de l'usager -> String
 * @param nom
 * 				Nom de l'usager -> String
 * @param prenom
 * 				Prenom de l'usager -> String
 * @param adresseRueUsager
 * 							Adresse rue de l'usager -> String
 * @param cpUsager
 * 					Code postal de l'usager -> String
 * @param adresseVille
 * 						Ville de l'usager -> String
 * @param nomUser
 * 				NomUser de l'usager -> String
 * @param motDePasse
 * 				Mot de passe de l'usager -> String
 */
public Usager(String idUser, String nom, String prenom, String adresseRueUsager, String cpUsager, String adresseVille, String nomUser,
			String motDePasse) {
		super();
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.adresseRueUsager = adresseRueUsager;
		this.cpUsager = cpUsager;
		this.adresseVille = adresseVille;
		this.nomUser = nomUser;
		this.motDePasse = motDePasse;
	}
/**
 * Renvoie le nom de l'usager
 * @return
 * 			Nom -> String
 */
	public String getNom() {
		return nom;
	}
	/**
	 * Modification du nom de l'usager
	 * @param nom
	 * 			Nouveau nom -> String
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	/**
	 * Renvoie le prenom de l'usager
	 * @return
	 * 			Prenom -> String
	 */
	public String getPrenom() {
		return prenom;
	}
	/**
	 * Modification du prenom de l'usager
	 * @param prenom
	 * 				Nouveau prenom -> String
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	/**
	 * Renvoie l'adresse rue de l'usager
	 * @return
	 * 			adresse rue -> String
	 */
	public String getAdresseRueUsager() {
		return adresseRueUsager;
	}
	/**
	 * Modification de l'adresse rue de l'usager
	 * @param adresseRueUsager
	 * 						Nouvelle adresse rue -> String
	 */
	public void setAdresseRueUsager(String adresseRueUsager) {
		this.adresseRueUsager = adresseRueUsager;
	}
	/**
	 * Renvoie le code postal de l'usager
	 * @return
	 * 			Code postal -> String
	 */
	public String getCpUsager() {
		return cpUsager;
	}
	/**
	 * Modification du code postal de l'usager
	 * @param cpUsager
	 * 				Nouveau code postal -> String
	 */
	public void setCpUsager(String cpUsager) {
		this.cpUsager = cpUsager;
	}
	/**
	 * Renvoie le nomUser de l'usager
	 * @return
	 * 			nomUser -> String
	 */
	public String getNomUser() {
		return nomUser;
	}
	/**
	 * Modification du nomUser de l'usager
	 * @param nomUser
	 * 				Nouveau Nom user -> String
	 */
	public void setNomUser(String nomUser) {
		this.nomUser = nomUser;
	}
	/**
	 * Renvoie du mot de passe de l'usager
	 * @return
	 * 			Mot de passe -> String
	 */
	public String getMotDePasse() {
		return motDePasse;
	}
	/**
	 * Modification du mot de passe
	 * @param motDePasse
	 * 					Nouveau mot de passe -> String
	 */
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	/**
	 * Renvoie l'identifiant de l'usager
	 * @return
	 * 			idUser -> String
	 */
	public String getIdUser() {
		return idUser;
	}
/**
 * Ramène les informations sur un type de dechet en chaine de caracteres
 */
@Override
public String toString() {
	return "Levee [idUser=" + idUser + ", nom=" + nom + ", prenom=" + prenom + ", adresseRueUsager="
			+ adresseRueUsager + ", cpUsager=" + cpUsager + ", nomUser=" + nomUser + ", motDePasse=" + motDePasse
			+ "]";
}
}

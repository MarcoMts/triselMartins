package com.vue;
import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.mysql.jdbc.Connection;
import com.pdf.editionFacture;

import java.util.ArrayList;
import java.util.Date;
import com.persistance.*;
import com.util.InsertionLevee;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {

	
	public static void testFacture()
	{
		HabitationDAO hDAO = new HabitationDAO();
		ArrayList<Habitation> lesHabitations = hDAO.retrieve();
		if(lesHabitations.size() != 0){
			for(Habitation h : lesHabitations)
			{
				editionElementFacture(h, 7, 2015);
			}
		}
		
	}
	public static void Affichage(String chaine, String data)
	{
		System.out.println(chaine +" : "+ data );
	}
	public static void editionElementFacture(Habitation h, int mois, int an)
	{
		ArrayList<Poubelle> lesPoubelles = h.getLesPoubelles();
		ArrayList<Levee> lesLeveesMois;
		String nomU = h.getUsager().getNom();
		String prenomU = h.getUsager().getPrenom();
		String adrU = h.getAdresseRue();
		String cpU = h.getCodePostal();
		String villeU = h.getAdresseVile();
		String codeU = h.getUsager().getIdUser();
		
		
		Affichage("nomUser", nomU.toString());
		Affichage("prenomU", prenomU.toString());
		Affichage("adrU", adrU.toString());
		Affichage("cpU", cpU.toString());
		Affichage("villeU", villeU.toString());
		Affichage("codeU", codeU.toString());
		Affichage("------", "------");
		
		String idPoubelle;
		String typeD;
		Date date;
		Double nbKg = 0.0;
		Double tarif = 0.0;
		Double TotalHT = 0.0;
		Double totalUnelevee = 0.0;	
		Double montantTVA = 0.0;
		Double TVA = 0.2;
		Double totalTTC = 0.0;
		Double TotalDesLevees;
		for(Poubelle p : lesPoubelles)
		{
			idPoubelle = p.getIdPoubelle();
			typeD = p.getNature().getLibelle();
			lesLeveesMois = p.getLesLevees(an, mois);
			tarif = p.getNature().getTarif();
			
			TotalDesLevees = 0.0;
			
			Affichage("idPoubelle", idPoubelle.toString());
			Affichage("typeD", typeD.toString());
			
			for(Levee l : lesLeveesMois)
			{				
				date = l.getLaDate();
				nbKg = l.getPoids();
				
				Affichage("date", date.toString());
				Affichage("kg", nbKg.toString());
				Affichage("tarif", tarif.toString());
				
				totalUnelevee = nbKg*tarif;
				TotalDesLevees = TotalDesLevees + totalUnelevee;
				
				Affichage("totalUnelevee", totalUnelevee.toString());
				Affichage("-----", "-----");
				
			}
			TotalHT = TotalHT + TotalDesLevees;
			
			Affichage("TotalDesLevees", TotalDesLevees.toString());
			Affichage("----", "----");
		}
		
		Affichage("TotalHT", TotalHT.toString());
		
		montantTVA = TotalHT * TVA;
		totalTTC = TotalHT+montantTVA;
		
		Affichage("montantTVA", montantTVA.toString());
		Affichage("totalTTC", totalTTC.toString());
		
		Affichage("------------","------------");
		
	}
	public static void main(String[] args) {

		
		
		//testFacture();
		
		HabitationDAO habDAO = new HabitationDAO();
		editionFacture.genereFacture(habDAO.find("hab2"),11,2015);
		
		//editionElementFacture(habDAO.find("hab2"),07,2015);
		/*PoubelleDAO pbDAO = new PoubelleDAO();
		LeveeDAO lvDAO = new LeveeDAO();
		UsagerDAO usDAO = new UsagerDAO();
		TypeDechetDAO tdDAO = new TypeDechetDAO();
		*/
		
		
		//System.out.println(pbDAO.find("pb1").toString());
		//System.out.println(lvDAO.find("1").toString());
		//System.out.println(usDAO.find("usag1").toString());
		//System.out.println(tdDAO.find("pla").toString());
		//System.out.println(habDAO.find("hab1").toString());
		//System.out.println(habDAO.retrieve());
		
		// TODO Auto-generated method stub	
		//Appel de la méthode de la classe InsertionLevee pour la lecture d'un fichier.txt
		//InsertionLevee.insertionLevee();
		//Appel de la méthode de la classe InsertionLevee pour la lecture d'un fichier.xml
		//InsertionLevee.TraitementFichierXml("pesee.xml");
		
		//Appel de la methode insertion levee
		// récupération de la connection à la base
		/*java.sql.Connection cnx =AccesBd.getInstance();
		try {
					// création d'un objet statement
					Statement requete = cnx.createStatement();
					// texte de la requête
					String sql = "select nom, prenom from usager";
					// exécution de la requête, résultat dans un jeu d'enregistrement de type resulset
					ResultSet rsUsager = requete.executeQuery(sql);
					// parcours 
					while (rsUsager.next()) {
						// accès aux champs du rs en fonction du type et du nom
						System.out.println(rsUsager.getString("nom") + "  " + rsUsager.getString("prenom"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		*/
		
		/*Levee levee;
		Date date=null;
		
		SimpleDateFormat dateFormat = null;
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		try
		{	
			date = dateFormat.parse("04/11/2015");
		}catch(ParseException e){
			e.printStackTrace();
		}
		LeveeDAO lev = new LeveeDAO();
		
		levee = new Levee(date,12.2,"pb1");		
		
		lev.create(levee);*/
}
}

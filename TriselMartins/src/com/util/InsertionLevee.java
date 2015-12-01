package com.util;
import java.io.File;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;


import com.metier.Levee;
import com.vue.Parametre;
import com.persistance.*;

/**
 * Gestion d'insertion de levees
 * @author martins-m
 * @see Insertionlevee
 */
public class InsertionLevee {

/** 
 * Traitement d'un fichier text
 * @param nom
 * 			Nom du fichier.txt
 */	
	//Lecture fichier.txt
	public static void TraitementFichierText(String nom)
	{
		//Declaration
			FichierTexte fichier = new FichierTexte();
			Boolean open = fichier.openFileReader(nom);
			Date date=null;
			SimpleDateFormat dateFormat = null;
			dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
			LeveeDAO lev = new LeveeDAO();
			Levee levee;
			//Test lecture fichier
			if(open)
			{				
				//Affiche la date
	        	
	        	
	        	String ligne;
	        	String dateF = fichier.readLigne();
	        	System.out.println(fichier.readLigne());
	        	try
	    		{	
	    			date = dateFormat.parse(dateF);
	    		}catch(ParseException e){
	    			e.printStackTrace();
	    		}
	        	System.out.println("Date : "+date);
	        	//Lecture ligne par ligne
	        	while((ligne = fichier.readLigne())!=null)
	        	{
	        		//Split de la ligne dans un tableau
	        		String[] data = ligne.split(":");
	        		String codeHabitation = data[0];
	        		String codePoubelle = data[1];
	        		String quantite = data[2];
	        		//Affiche les données de la ligne
	        		System.out.println("cH : " + codeHabitation + " cP : " + codePoubelle + " qte : "+ quantite);
	        		levee = new Levee(date,Double.parseDouble(quantite),codePoubelle);	
	        		if(lev.create(levee))
	        		{
	        			System.out.println("Levee ajouter");
	        		}
	        		else
	        		{
	        			System.out.println("Levee KO");
	        		}
	        		}	        	
	        	//Ferme le fichier
	        	fichier.closeFileReader();
			}
			else
			{
				System.out.println("Fichier inexistant");
			}
	}
	//Lecture fichier.xml
	/**
	 * Traitement d'un fichier xml
	 * @param nom
	 * 			Nom du fichier.xml
	 */
	public static void TraitementFichierXml(String nom)
	{
		//Declaration document xml
		Document document = null;
		//Declaration element racine
		Element racine = null;
		//On créé une instance de SAXBuilder
		SAXBuilder sxb = new SAXBuilder();
		Date date=null;
		SimpleDateFormat dateFormat = null;
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		LeveeDAO lev = new LeveeDAO();
		Levee levee;
    	
		try
		{
			//On crée un nouveau document JDOM avec un argument le fichier xml
			document = sxb.build(new File(nom));
			//On initialise un nouvel élément racine avec l'élément racine du document
			racine = document.getRootElement();
			
			//On crée une List contenant tous les noeuds "Camion"
			List<Element> listeLevee = racine.getChildren("Levee");
			//Affichage date
			System.out.println(racine.getChildText("Date"));
			try
			{	
				date = dateFormat.parse(racine.getChildText("Date"));
			}catch(ParseException e){
				e.printStackTrace();
			}
			//Parcours
			for(Element e: listeLevee)
			{
				//Affichage données enfants poubelle + poids
				System.out.print(" Levee : ");
				System.out.print(e.getChild("poubelle").getText()+"   ");
				System.out.print(e.getChild("poids").getText()+"   ");
				levee = new Levee(date,Double.parseDouble(e.getChild("poids").getText()),e.getChild("poubelle").getText());
				if(lev.create(levee))
				{
					System.out.println("Levee ajouter");
				}
				else
				{
					System.out.println("Levee KO");
				}
			}
		}
		/**
		 * @throws JDOMException
		 * 				Erreur parser du fichier xml
		 */
		catch(JDOMException e2)
		{
			e2.printStackTrace();			
		}	        	
		/**
		 * @throws IOException
		 * 				Erreur entrée sortir
		 */
		catch(IOException e2)
		{
			e2.printStackTrace();
		}
		
		
	}
	
	//Methode 
	/**
	 * Gestion des levees, traites et a Traiter
	 */
	public static void insertionLevee()
	{
		//Declaration
		String aTraiter = Parametre.getCheminLeveeATraiter();
		String traites = Parametre.getCheminLeveeTraites();
		String log = Parametre.getCheminLeveeLog();
		
				
		File dossierATraiter = new File(aTraiter);
		File dossierTraites = new File(traites);
		File dossierLog = new File(log);
		
		//Creation de la liste
		File[] listeFichier = dossierATraiter.listFiles();
		
		//Nombre d'éléments dans la liste
		int nbFichier = listeFichier.length;
		String extansion;
		
		//Si la liste est vide
		if(nbFichier == 0)
		{
			System.out.println("Dossier vide");
		}
		else
		{
			//Pour chaque éléments dans la liste
			for(File fichier : listeFichier)
			{
				//Si le File est un fichier
				if(fichier.isFile())
				{
					//Appel de la methode pour récupérer l'extansion du fichier
					extansion = Parametre.getExtensionFichier(fichier);
					//Test de l'extansion
					switch(extansion)
					{
					//Si c'est un fichier txt
					case "txt" :
						//Appel de la methode qui affiche le contenu du fichier
						InsertionLevee.TraitementFichierText(fichier.toString());
						//Deplace le fichier vers le dossier traitees
						fichier.renameTo(Parametre.concatenation(dossierTraites, fichier));
					break;
					//Si c'est un fichier xml
					case "xml" :
						//Appel de la methode qui affiche le contenu du fichier
						InsertionLevee.TraitementFichierXml(fichier.toString());
						//Deplace le fichier vers le dossier traites
						fichier.renameTo(Parametre.concatenation(dossierTraites, fichier));					
						break;
					//Si autre extansion
					default :
						fichier.renameTo(Parametre.concatenation(dossierLog, fichier));
						break;	
					}
					
				}
				else
				{
					fichier.renameTo(Parametre.concatenation(dossierLog, fichier));
				}
			}
		}
		
	}
}

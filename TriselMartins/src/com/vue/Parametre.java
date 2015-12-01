package com.vue;
import java.io.File;

import com.util.FichierTexte;

public class Parametre 
{
	//Declaration
	private static String nomFichier = "paramAppli.ini";
	static FichierTexte fichier = new FichierTexte();
	
	public static String getExtensionFichier(File fichier)
	{
	
		fichier.toString();
		String[] data = fichier.toString().split("\\.");		
		return data[1];
		
	}
	//Methode qui ramène le chemin d'acces a la bdd, en chaine
	public static String getCheminBd()
	{
		//appel de la methode lire avec l'indice de la ligne ou se trouve le chemin d'acces
		return lire(2);
	}
	//Methode qui ramène le chemin d'acces au dossier atraiter, en chaine
	public static String getCheminLeveeATraiter()
	{
		//appel de la methode lire 
		return lire(4);
		
	}
	//Methode qui ramène le chemin d'acces au dossier log, en chaine
	public static String getCheminLeveeLog()
	{
		//appel de la methode lire 
		return lire(10);
		
	}
	//Methode qui ramène le chemin d'acces au dossier Traites, en chaine
	public static String getCheminLeveeTraites()
	{
		//appel de la methode lire 
		return lire(6);
		
	}
	//Methode qui ramène le chemin d'acces au fichier pdf levee, en chaine
	public static String getCheminLeveePdf()
	{
		//appel de la methode lire avec l'indice de la ligne ou se trouve le chemin d'acces
		return lire(8);
	
	}
	//Methode privée qui ramène une chaine, et prend en paramètre la ligne ou se trouve le chemin d'access 
	private static String lire(int n)
	{
		//Declaration
		FichierTexte fichier = new FichierTexte();
		Boolean open = fichier.openFileReader(nomFichier);
		String ligne = null;
		if(open)
		{				
        	//Lecture 
        	for(int i=0; i<n;i++)
        	{
        		//recupere le chemin d'acces et le met dans la variable ligne
        		ligne = fichier.readLigne();
        	}
        	//Ferme le fichier
        	fichier.closeFileReader();
		}
		return ligne;
	}
	public static File concatenation(File dossier, File fichier)
	{
		File cheminDest = new File (dossier.getAbsolutePath() + "\\" + fichier.getName());
		return cheminDest;
	}
	
}

	


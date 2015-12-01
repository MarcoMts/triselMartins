package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
/**
 * Gestion des fichiers lecture, fermeture
 * @author martins-m
 * @see FichierTexte
 */
public class FichierTexte 
{
	// buffer de lecture
	private BufferedReader br;
	// buffer d'écriture
	private BufferedWriter bw;
	public FichierTexte()
	{
		br=null;
		bw=null;
	}
	
	/**
	 * Ouverture du fichier en lecture
	 * @param nom
	 * 			nom du fichier
	 * @return
	 * 		true si OK ouverture/ false si KO ouverture
	 * @throws Exception
	 */
	public boolean openFileReader(String nom)
	{
		boolean open;
		FileInputStream fichier=null;
		try
		{
			fichier=new FileInputStream(new File(nom));
			br=new BufferedReader(new InputStreamReader(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	
	/**
	 * Ouverture du fichier en écriture
	 * @param nom
	 * 			nom du fichier
	 * @return
	 * 			true si OK ouverture/ false si KO ouverture
	 * @throws Exception
	 */
	public boolean openFileWriter(String nom)
	{ 
		boolean open;
		FileOutputStream fichier=null;
		try
		{
			fichier=new FileOutputStream(nom);
			bw=new BufferedWriter(new OutputStreamWriter(fichier));
			open=true;
		}
		catch (FileNotFoundException e)
		{
			System.out.println("pb ouverture");
			open=false;
		}
		return open;
	}
	
	/**
	 * fermeture du flux d'écriture
	 * @return
	 * 		return true si fichier fermé/ false sinon
	 * @throws Exception
	 */
	public boolean closeFileWriter()
	{
		boolean ok = true;
		try
		{
			bw.close();
		}
		catch (IOException e)
		{
			ok = false;
		}
		return ok;
	}
	/**
	 * @throws Exception
	 * fermeture du flux de lecture
	 */
	public void closeFileReader()
	{
		try
		{
			br.close();}
		catch (IOException e)
		{
			System.out.println("pb fermeture");
		}
	}
	
	public void writeLigne(String ligne)
	{
		try
		{
			bw.write(ligne+"\n");
		}
		catch (IOException e)
		{
			System.out.println("pb ecriture");
		}
	}
	
	/**
	 * lecture d'une ligne
	 * @return 
	 * 			return la ligne écrite
	 * @throws Exception
	 */
	public String readLigne()
	{
		String ligne=null;
		try
		{
			ligne= br.readLine();
		}
		catch (IOException e)
		{
			System.out.println("pb lecture");
		}
		return ligne;
	}
}
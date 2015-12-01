package com.tests;
import com.metier.Poubelle;
import com.metier.Levee;
import com.metier.TypeDechet;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author martins-m
 * @see PoubelleTest
 */
public class PoubelleTest {
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	private Poubelle poubelle;
	private Poubelle poubelle2;
	private TypeDechet typeDechet;
	private TypeDechet typeDechet2;
	private TypeDechet typeDechet3;
	private Levee levee;
	private Levee levee2;
	private Date date=null;
	private Date date2=null;
	private Date date3=null;
	private ArrayList<Levee> lesLevees;
	private ArrayList<Levee> lesLevees2;
	/**
	 * Instanciations avant les tests
	 * @throws Exception
	 * 					Mauvais format des dates
	 */
	@Before
	public void setUp() throws Exception {
		
		try
		{
			date=dateFormat.parse("30/09/2015");
			date2=dateFormat.parse("30/08/2015");
			date3=dateFormat.parse("30/09/2015");
			
			levee = new Levee(1, date,12.2, "1");
			levee2 = new Levee(date2,12.2, "1");
			
			lesLevees = new ArrayList<Levee>();
			lesLevees2 = new ArrayList<Levee>();
			
			lesLevees.add(levee);
			lesLevees2.add(levee2);
			
			typeDechet = new TypeDechet("1","libelle",1.5);
			typeDechet2 = new TypeDechet("2","libelle",1.5);
			typeDechet3 = null;
			
			poubelle = new Poubelle("1", typeDechet, "1");
			poubelle2 = new Poubelle("2", typeDechet);
			
			poubelle.ajoutLevee(levee);
			poubelle2.ajoutLevee(levee2);
			
			
			
		}catch(ParseException e){
			e.printStackTrace();
		}
		
	}
	/**
	 * Instanciations apres les tests
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		date=null;
		levee=null;
		levee2=null;
		lesLevees=null;
		typeDechet=null;
		poubelle=null;
		poubelle2=null;
	}
	/**
	 * Test l'instance poubelle
	 */
	@Test
	public void testPoubelle() {
		assertNotNull("L'instance est créée", poubelle);
		assertNotNull("L'instance est créée", poubelle2);
	}
	/**
	 * Test de la methode qui renvoie la liste des levees d'une mois d'une annee
	 */
	@Test
	public void testGetLesLeveesAnneeMois() {
		assertEquals("Est ce que le get Levees est correct",lesLevees, poubelle.getLesLevees(2015,9));
		assertEquals("Est ce que le get Levees est correct",lesLevees2, poubelle2.getLesLevees(2015,8));
		assertNotEquals("Est ce que le get Levees n'est sont pas correct",lesLevees2, poubelle.getLesLevees(2014,9));
		assertNotEquals("Est ce que le get Levees n'est sont pas correct",lesLevees, poubelle2.getLesLevees(2016,9));
	}
	/**
	 * Test de la methode qui renvoie le cout d'une poubelle
	 */
	@Test
	public void testGetCout() {
		assertEquals("Est ce que le get cout est correct",18,3, poubelle.getCout(2015,9));
		assertEquals("Est ce que le get cout est correct",18,3, poubelle2.getCout(2015,8));
		assertEquals("Est ce que le get cout est correct",12,00, poubelle.getCout(2015,9));
		assertEquals("Est ce que le get cout est correct",11,00, poubelle2.getCout(2015,8));
	}
	/**
	 * Test de la methode qui renvoie la nature de la poubelle
	 */
	@Test
	public void testGetNature() {
		assertEquals("Est ce que la Nature est correct",typeDechet, poubelle.getNature());
		assertEquals("Est ce que la Nature est correct",typeDechet, poubelle2.getNature());
		assertNotEquals("Est ce que la Nature n'est pas correct",typeDechet3, poubelle.getNature());
		assertNotEquals("Est ce que la Nature n'est pas correct",typeDechet3, poubelle2.getNature());
	}
	/**
	 * Test de la methode qui modifiie la nature de la poubelle
	 */
	@Test
	public void testSetNature() {
		poubelle.setNature(typeDechet2);
		poubelle2.setNature(typeDechet2);
		assertEquals("Est ce que la Nature est correct",typeDechet2, poubelle.getNature());
		assertEquals("Est ce que la Nature est correct",typeDechet2, poubelle2.getNature());
		assertNotEquals("Est ce que la Nature n'est pas correct",typeDechet, poubelle.getNature());
		assertNotEquals("Est ce que la Nature n'est pas correct",typeDechet, poubelle2.getNature());
	}
	/**
	 * Test de la methode qui renvoie les levees d'une poubelle
	 */
	@Test
	public void testGetLesLevees() {
		assertEquals("Est ce que les Levees sont correct",lesLevees, poubelle.getLesLevees());
		assertEquals("Est ce que les Levees sont correct",lesLevees2, poubelle2.getLesLevees());
		assertNotEquals("Est ce que les Levees ne sont pas correct",lesLevees2, poubelle.getLesLevees());
		assertNotEquals("Est ce que les Levees ne sont pas correct",lesLevees, poubelle2.getLesLevees());
	}
	/**
	 * Test de la methode qui modifie les levees d'une poubelle
	 */
	@Test
	public void testSetLesLevees() {
		poubelle.setLesLevees(lesLevees2);
		poubelle2.setLesLevees(lesLevees);
		assertEquals("Est ce que les Levees sont correct",lesLevees2, poubelle.getLesLevees());
		assertEquals("Est ce que les Levees sont correct",lesLevees, poubelle2.getLesLevees());
		assertNotEquals("Est ce que les Levees ne sont pas correct",lesLevees, poubelle.getLesLevees());
		assertNotEquals("Est ce que les Levees ne sont pas correct",lesLevees2, poubelle2.getLesLevees());
	}
	/**
	 * Test de la methode qui renvoie l'id de la poubelle
	 */
	@Test
	public void testGetIdPoubelle() {
		assertEquals("Est ce que l'id poubelle est correct","1", poubelle.getIdPoubelle());
		assertEquals("Est ce que l'id poubelle est correct","2", poubelle2.getIdPoubelle());
		assertNotEquals("Est ce que l'id poubelle n'est pas correct","2", poubelle.getIdPoubelle());
		assertNotEquals("Est ce que l'id poubelle n'est pas correct","3", poubelle2.getIdPoubelle());
	}
	/**
	 * Test de la methode qui renvoie les informations d'une poubelle en chaine de caracteres
	 */
	@Test
	public void testToString() {
		assertNotEquals("Est ce que le ToString est correct", null,poubelle.toString());
		assertNotEquals("Est ce que le ToString est correct", null,poubelle2.toString());
	}
	

}

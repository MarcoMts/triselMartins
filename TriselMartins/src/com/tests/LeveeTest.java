package com.tests;
import com.metier.Levee;
import static org.junit.Assert.*;


import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Test de la classe Levee
 * @author martins-m
 *
 */
public class LeveeTest {
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private Levee levee;
	private Levee levee2;
	private Date date=null;
	private Date date2=null;
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
			date2=dateFormat.parse("30/09/2016");
			levee = new Levee(1, date,12.2, "1");
			levee2 = new Levee(date,12.2, "1");
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
		levee=null;
		levee2=null;
	}

	/**
	 * Test de l'instance de Levee
	 */
	@Test
	public void testLevee() {
		assertNotNull("L'instance est créée", levee);
		assertNotNull("L'instance est créée", levee2);
	}
	/**
	 * Test de la methode qui renvoie la date d'une levee
	 */
	@Test
	public void testGetLaDate() {
		assertEquals("Est ce que la date est correct", date,levee.getLaDate());
		assertEquals("Est ce que la date est correct", date,levee2.getLaDate());
		assertNotEquals("Est ce que la date n'est pas correct", date2,levee.getLaDate());
		assertNotEquals("Est ce que la date n'est pas correct", date2,levee2.getLaDate());
	}

	/**
	 * Test de la methode qui modifie la date d'une levee
	 */
	@Test
	public void testSetLaDate() {
		levee.setLaDate(date2);
		assertEquals("Est ce que la date est correct", date2,levee.getLaDate());
		levee2.setLaDate(date2);
		assertEquals("Est ce que la date est correct", date2,levee2.getLaDate());
		levee.setLaDate(date2);
		assertNotEquals("Est ce que la date n'est pas correct", date,levee.getLaDate());
		levee2.setLaDate(date2);
		assertNotEquals("Est ce que la date n'est pas correct", date,levee2.getLaDate());
	}
	/**
	 * Test de la methode qui renvoie le poid d'une levee
	 */
	@Test
	public void testGetPoids() {
		assertEquals(0.001, 12.2,levee.getPoids());
		assertEquals(0.001, 12.2,levee2.getPoids());
		assertNotEquals("Est ce que le poid n'est pas correct", 13.2,levee.getPoids());
		assertNotEquals("Est ce que le poid n'est pas correct", 13.2,levee2.getPoids());
	}
	/**
	 * Test de la methode qui modifie le poid d'une levee
	 */
	@Test
	public void testSetPoids() {
		levee.setPoids(13.5);
		assertEquals(0.001, 13.5,levee.getPoids());
		levee2.setPoids(13.5);
		assertEquals(0.001, 13.5,levee2.getPoids());
		levee.setPoids(13.5);
		assertNotEquals("Est ce que le poid n'est pas correct", 12.2,levee.getPoids());
		levee2.setPoids(13.5);
		assertNotEquals("Est ce que le poid n'est pas correct", 12.2,levee2.getPoids());
	}
	/**
	 * Test de la methode qui renvoie l'id de levee d'une levee
	 */
	@Test
	public void testGetIdLevee() {	
		assertEquals("Est ce que le Id est correct", 1,levee.getIdLevee());
		assertNotEquals("Est ce que le Id n'est pas correct", 2,levee.getIdLevee());
		assertNotEquals("Est ce que le Id n'est pas correct", 2,levee2.getIdLevee());
	}
	/**
	 * Test de la methode qui renvoie l'id de la poubelle d'une levee
	 */
	@Test
	public void testGetIdPoubelle() {
		assertEquals("Est ce que l'id poubelle est correct", "1",levee.getIdPoubelle());
		assertEquals("Est ce que l'id poubelle est correct", "1",levee2.getIdPoubelle());
		assertNotEquals("Est ce que l'id poubelle n'est pas correct", "2",levee.getIdPoubelle());
		assertNotEquals("Est ce que l'id poubelle n'est pas correct", "2",levee2.getIdPoubelle());
	}
	/**
	 * Test de la methode qui renvoie les informations d"une levee en chaine de caracteres
	 */
	@Test
	public void testToString() {
		assertNotEquals("Est ce que le ToString est correct", null,levee.toString());
		assertNotEquals("Est ce que le ToString est correct", null,levee2.toString());
	}

}

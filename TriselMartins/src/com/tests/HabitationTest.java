package com.tests;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.metier.Habitation;
import com.metier.Levee;
import com.metier.Poubelle;
import com.metier.TypeDechet;
import com.metier.Usager;
/**
 * Test sur la classe Habitation
 * @author martins-m
 * @see HabitationTest
 */
public class HabitationTest {
	private Habitation habIn = null;
	private Usager u = null;
	private	TypeDechet td1;
	private	TypeDechet td2;
	private	Poubelle pb1;
	private	Poubelle pb2;
	private Date d1 = null;
	private Date d2 = null ;
	private Date d3 = null;
	private Date d4 = null;
	private Levee le1=null;
	private Levee le2=null;
	private Levee le3=null;
	private Levee le4=null;
	private SimpleDateFormat dateFormat;
	
	/**
	 * Instanciations avant les tests 
	 * @throws Exception
	 * 					Mauvais format de la date
	 */
	@Before
	public void setUp() throws Exception {
		
		// instanciation usager
		u = new Usager("u1", "Dupont", "Albert", "63 grand-rue","Châteaulin","29200" ,"nomU", "mdp");
		// instanciation habitation
		habIn = new Habitation("hab1", "63 grand-rue", "29150", "Châteaulin", u);
		// instanciation 2 types de déchets
		td1 = new TypeDechet("ver", "verre", 0.10);
		td2 = new TypeDechet("plas", "plastique", 0.15);
		// instanciation 2 poubelles affectées à l'habitation
		pb1 = new Poubelle("pb1", td1 , habIn.getIdHabitation());
		pb2 = new Poubelle("pb2", td2 , habIn.getIdHabitation());
		// instanciation dates de levée
		dateFormat =  new SimpleDateFormat("dd/MM/yyyy");
		try
		{
			d1 = dateFormat.parse("15/05/2015");
			d2 = dateFormat.parse("30/07/2015");
			d3 = dateFormat.parse("15/06/2015");
			d4 = dateFormat.parse("30/06/2015");
		} catch (ParseException e){
			e.printStackTrace();
		} 
		// instanciation 3 levées pour la poubelle pb1, 1 pour pb2
		// 2 en mai , 1 en juin
		le1 = new Levee(d1, 5.00, pb1.getIdPoubelle());
		le2 = new Levee(d2, 10.00, pb1.getIdPoubelle());
		le3 = new Levee(d3, 12.00, pb1.getIdPoubelle());
		le4 = new Levee(d4, 30.00, pb2.getIdPoubelle());
		// ajout des levées à la poubelle 
		pb1.ajoutLevee(le1);
		pb1.ajoutLevee(le2);
		pb1.ajoutLevee(le3);
		pb2.ajoutLevee(le4);
	}
	/**
	 * Instanciations apres les tests
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		u=null;
		habIn=null;
		td1=null;
		td2=null;
		pb1=null;
		pb2=null;
		d1=null;
		d3=null;
		d4=null;
		
	}
	/**
	 * Test de la methode du renvoie de l'objet habitation
	 */
	@Test
	public void testHabitation() {
		assertNotNull(habIn);
	}
	/**
	 * Test de la methode du renvoie de l'objet usager
	 */
	@Test
	public void testGetUnUsager() {
		assertEquals(habIn.getUsager(), u);
		assertNotEquals(habIn.getUsager(), null);
	}
	/**
	 * Test de la methode du renvoie de l'id de l'habitation
	 */
	@Test
	public void testGetIdHabitation() {
		assertEquals(habIn.getIdHabitation(), "hab1");
		assertNotEquals(habIn.getIdHabitation(), "");
	}
	/**
	 * Test de la methode du renvoie de la liste des poubelles de l'habitation
	 */
	@Test
	public void testGetLesPoubelles() {
		assertEquals(habIn.getLesPoubelles().size(), 0);
		assertNotEquals(habIn.getLesPoubelles().size(), null);
	}

	/**
	 * Test de la methode du renvoie de l'adresse rue de l'habitation
	 */
	@Test
	public void testGetAdresseRue() {
		assertEquals(habIn.getAdresseRue(), "63 grand-rue");
	}
	/**
	 * Test de la methode du renvoie de la ville de l'habitation
	 */
	@Test
	public void testGetAdresseVille() {
		assertEquals(habIn.getAdresseVile(), "Châteaulin");
	}
	/**
	 * Test de la methode du renvoie du code postal de l'habitation 
	 */
	@Test
	public void testGetCodePostal() {
		assertEquals(habIn.getCodePostal(), "29150");
	}
	/**
	 * Test d'ajout d'une poubelle sur l'habitation
	 */
	@Test
	public void testAjoutPoubelle() {
		habIn.ajoutPoubelle(pb1);
		habIn.ajoutPoubelle(pb2);
		assertEquals(habIn.getLesPoubelles().size(), 2);
		assertEquals(habIn.getLesPoubelles().get(0), pb1);
		assertEquals(habIn.getLesPoubelles().get(1), pb2);
	}
	/**
	 * Test du cout des levees de l'habitation
	 */
	@Test
	public void testCout() {
		assertTrue(habIn.getCout(2015, 05) == 0.0);
	}
}

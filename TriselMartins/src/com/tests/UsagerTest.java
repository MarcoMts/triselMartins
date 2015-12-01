package com.tests;
import com.metier.Usager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author martins-m
 * @see UsagerTest
 */
public class UsagerTest {

	
	private Usager user1;
	/**
	 * Instanciation apres les test
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		user1 = new Usager("1","nom","prenom","rue", "Brest","29200","nomU","mdp");		
	}
	/**
	 * Instanciation apres les test
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		user1=null;
	}
	/**
	 * Test de l'instance de Usager
	 */
	@Test
	public void testUsager() {
		assertNotNull("L'instance est créée", user1);
	}
	
	/**
	 * Test de la methode qui renvoie le nom d'un usager
	 */
	@Test
	public void testGetNom() {
		assertEquals("Est ce que nom est correct", "nom",user1.getNom());
		assertNotEquals("Est ce que nom n'est pas correct", "nom2",user1.getNom());
	}
	/**
	 * Test de la methode qui modifie le nom d'un usager
	 */
	@Test
	public void testSetNom() {
		user1.setNom("nom2");
		assertEquals("Est ce que nom est correct", "nom2",user1.getNom());
		user1.setNom("nom2");
		assertNotEquals("Est ce que nom n'est pas correct", "nom",user1.getNom());
	}
	/**
	 * Test de la methode qui renvoie le prenom d'un usager
	 */
	@Test
	public void testGetPrenom() {
		assertEquals("Est ce que prenom est correct", "prenom",user1.getPrenom());
		assertNotEquals("Est ce que prenom n'est pas correct", "prenom2",user1.getPrenom());
	}
	/**
	 * Test de la methode qui modifie le prenom d'un usager
	 */
	@Test
	public void testSetPrenom() {
		user1.setPrenom("prenom2");
		assertEquals("Est ce que prenom est  correct", "prenom2",user1.getPrenom());
		user1.setPrenom("prenom2");
		assertNotEquals("Est ce que prenom n'est pas correct", "prenom",user1.getPrenom());
	}
	/**
	 * Test de la methode qui renvoie le nom d'un usager
	 */
	@Test
	public void testGetAdresseRueUsager() {
		assertEquals("Est ce que l'adresse est correct", "rue",user1.getAdresseRueUsager());
	}
	/**
	 * Test de la methode qui renvoie l'adresse rue d'un usager
	 */
	@Test
	public void testGetAdresseRueUsagerF() {
		assertNotEquals("Est ce que l'adresse n'est pas correct", "rue2",user1.getAdresseRueUsager());
	}
	/**
	 * Test de la methode qui modifie l'adresse rue d'un usager
	 */
	@Test
	public void testSetAdresseRueUsager() { 
		user1.setAdresseRueUsager("rue2");
		assertEquals("Est ce que prenom est correct", "rue2",user1.getAdresseRueUsager());
		user1.setAdresseRueUsager("rue2");
		assertNotEquals("Est ce que prenom n'est pas correct", "rue",user1.getAdresseRueUsager());
	}
	/**
	 * Test de la methode qui renvoie le code postal d'un usager
	 */
	@Test
	public void testGetCpUsager() {
		assertEquals("Est ce que le cp est correct", "29200",user1.getCpUsager());
		assertNotEquals("Est ce que le cp n'est pas correct", "cp2",user1.getCpUsager());
	}
	/**
	 * Test de la methode qui modifie le code postal d'un usager
	 */
	@Test
	public void testSetCpUsager() {
		user1.setCpUsager("29147");
		assertEquals("Est ce que le cp est correct", "29147",user1.getCpUsager());
		user1.setCpUsager("cp2");
		assertNotEquals("Est ce que le cp n'est pas correct", "29200",user1.getCpUsager());
	}
	/**
	 * Test de la methode qui renvoie le nom d'un usager
	 */
	@Test
	public void testGetNomUser() {
		assertEquals("Est ce que le nom user est correct", "nomU",user1.getNomUser());
		assertNotEquals("Est ce que le nom user n'est pas correct", "nomU2",user1.getNomUser());
		
	}
	/**
	 * Test de la methode qui modifie le nom d'un usager
	 */
	@Test
	public void testSetNomUser() {
		user1.setNomUser("nomU2");
		assertEquals("Est ce que le nom user est correct", "nomU2",user1.getNomUser());
		user1.setNomUser("nomU2");
		assertNotEquals("Est ce que le nom user est correct", "nom",user1.getNomUser());
	}
	
	/**
	 * Test de la methode qui renvoie le mot de passe d'un usager
	 */
	@Test
	public void testGetMotDePasse() {
		assertEquals("Est ce que le mdp est correct", "mdp",user1.getMotDePasse());
		assertNotEquals("Est ce que le mdp n'est pas correct", "mdp2",user1.getMotDePasse());
	}
	/**
	 * Test de la methode qui modifie le mot de passe d'un usager
	 */
	@Test
	public void testSetMotDePasse() {
		user1.setMotDePasse("mdp2");
		assertEquals("Est ce que le mdp est correct", "mdp2",user1.getMotDePasse());
		user1.setMotDePasse("mdp2");
		assertNotEquals("Est ce que le mdp n'est pas correct", "mdp",user1.getMotDePasse());
	}
	/**
	 * Test de la methode qui renvoie l'id d'un usager
	 */
	@Test
	public void testGetIdUser() {
		assertEquals("Est ce que le IdUser est correct", "1",user1.getIdUser());
		assertNotEquals("Est ce que le IdUser n'est pas correct", "2",user1.getIdUser());
	}
	/**
	 * Test de la methode qui renvoie les informations de l'Usager en chaine de caracteres
	 */
	@Test
	public void testToString() {
		assertNotEquals("Est ce que le ToString est correct", null,user1.toString());
	}

}

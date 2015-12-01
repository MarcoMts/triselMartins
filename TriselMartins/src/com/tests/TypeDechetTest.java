package com.tests;
import com.metier.TypeDechet;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * 
 * @author martins-m
 * @see TypeDechetTest
 */
public class TypeDechetTest {
	private TypeDechet typeDechet;
	/**
	 * Instanciation avant les tests
	 * @throws Exception
	 *					
	 */
	@Before
	public void setUp() throws Exception {
		typeDechet = new TypeDechet("1","libelle",1.5);
	}

	/**
	 * Instanciation apres les test
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
		typeDechet=null;
	}
	/**
	 * Test de l'instance de typeDechet
	 */
	@Test
	public void testTypeDechet() {
		assertNotNull("L'instance est créée", typeDechet);
	}
	/**
	 * Test de la methode qui renvoie le libelle d'un type de dechet
	 */
	@Test
	public void testGetLibelle() {
		assertEquals("Est ce que le libelle est correct", "libelle",typeDechet.getLibelle());
		assertNotEquals("Est ce que le libelle n'est pas correct", "libelle2",typeDechet.getLibelle());
	}
	/**
	 * Test de la methode qui modifie le libelle d'un type de dechet
	 */
	@Test
	public void testSetLibelle() {
		typeDechet.setLibelle("libelle2");
		assertEquals("Est ce que le libelle est correct", "libelle2",typeDechet.getLibelle());
		typeDechet.setLibelle("libelle2");
		assertNotEquals("Est ce que le libelle n'est pas correct", "libelle",typeDechet.getLibelle());
	}
	/**
	 * Test de la methode qui renvoie le tarif d'un type de dechet
	 */
	@Test
	public void testGetTarif() {
		
		assertEquals(1, 1.5,typeDechet.getTarif());
		assertNotEquals("Est ce que le tarif n'est pas correct", 2.5,typeDechet.getTarif());
	}
	/**
	 * Test de la methode qui modifie le tarid d'un type de dechet
	 */
	@Test
	public void testSetTarif() {
		typeDechet.setTarif(2.5);
		assertEquals(1, 2.5,typeDechet.getTarif());
		typeDechet.setTarif(2.5);
		assertNotEquals("Est ce que le tarif n'est pas correct", 1.5,typeDechet.getTarif());
	}
	/**
	 * Test de la methode qui renvoie le code d'un type de dechet
	 */
	@Test
	public void testGetCode() {
		assertEquals("Est ce que le code est correct", "1",typeDechet.getCode());	
		assertNotEquals("Est ce que le code n'est pas correct", "2",typeDechet.getCode());
	}
	/**
	 * Test de la methode qui renvoie les informations de levee en chaine de caracteres
	 */
	@Test
	public void testToString() {
		assertNotEquals("Est ce que le ToString est correct", null,typeDechet.toString());
	}

}

package no.hvl.dat102.adt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class KoeADTTest {
	
	//Referanse til koeADT
	
	private KoeADT<Integer> koe;
	
	//Testdata
	private Integer e0 = 1;
	private Integer e1 = 2;
	private Integer e2 = 3;
	private Integer e3 = 4;
	private Integer e4 = 5;
	
	protected abstract KoeADT<Integer> reset();
	
	/**
	 * Hent en ny kø for hver test.
	 * 
	 * @return
	 */
	@BeforeEach
	public void setup() {
		koe = reset();
	}
	
	/**
	 * Test på en ny kø er tom
	 */
	@Test
	public void nyKoeErTom() {
		assertTrue(koe.erTom());
		
	}
	/**
	 * Tester å legger inn og tar ut verdier i køen
	 */
	@Test
	public void leggInnOgUtKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
			
		} catch (EmptyCollectionException e ) {
			fail("feil i køen" + e.getMessage());
		}
	}
	
	/**
	 * Tester med duplikate verdier i køen
	 */
	@Test
	public void duplikatKoe() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
			
		} catch (EmptyCollectionException e ) {
			fail("feil i køen" + e.getMessage());
		}
		
	}
	
	/**
	 * Tester for om koen er tom
	 */
	@Test
	public void erTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());
		}  catch (EmptyCollectionException e ) {
			fail("feil i køen" + e.getMessage());
		}
	}
	
	/**
	 * Tester om koen ikke er tom
	 */
	@Test
	public void erIkkeTom() {
		try {
			koe.innKoe(e0);
			koe.innKoe(e1);
			assertFalse(koe.erTom());
		}  catch (EmptyCollectionException e ) {
			fail("feil i køen" + e.getMessage());
		}
	}
	
	

	
	
	
	
	
	

}

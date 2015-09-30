package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	
	String correctSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";

	private SudokuVerifier verifier;
	
	@Before
	public void setup(){
		verifier = new SudokuVerifier();
	}
	
	@Test
	public void testverify() {
		
		assertEquals (1, verifier.verify(correctSolution));
	}
	
	@Test
	public void testVerifyStringLength_correctSolution_returnTrue(){
		
		assertEquals (true, verifier.verifyStringLength(correctSolution));
		
	}

}

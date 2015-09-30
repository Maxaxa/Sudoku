package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	
	String correctSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String noSolution = "";
	String negativSolution = "41-369-25632158947958724316825437169791586432346912758289643571573291684164875293";
	String incorrectSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	
	private SudokuVerifier verifier;
	
	@Before
	public void setup(){
		verifier = new SudokuVerifier();
	}
	
	@Test
	public void testverify_correctSolution_return1() {
		
		assertEquals (1, verifier.verify(correctSolution));
	}
	
	@Test
	public void testverify_noSolution_return1() {
		
		assertEquals (0, verifier.verify(noSolution));
	}
	
	
	@Test
	public void testVerifyStringLength_correctSolution_returnTrue(){
		
		assertEquals (true, verifier.verifyStringLength(correctSolution));
		
	}
	
	@Test
	public void testVerifyStringLength_noSolution_returnTrue(){
		
		assertEquals (false, verifier.verifyStringLength(noSolution));
		
	}
	@Test
	public void testVerifyRule1_OnlyPositiveDigits_correctSolution_return_true(){
		
			assertEquals (true, verifier.verifyRule1(correctSolution));
	}
	@Test
	public void testVerifyRule1_OnlyPositiveDigits_negativeSolution_return_false(){
		int[] digits = verifier.solutionToString(correctSolution);
		System.out.println(Arrays.toString(digits));
			assertEquals (false, verifier.verifyRule1(negativSolution));
	}

}

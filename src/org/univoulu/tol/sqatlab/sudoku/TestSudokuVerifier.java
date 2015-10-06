package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class TestSudokuVerifier {
	
	String correctSolution = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String noSolution = "";
	String negativeSolution = "41-369-25632158947958724316825437169791586432346912758289643571573291684164875293";
	String incorrectSolution = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	String gridCheck = "123456789123456789123456789123456789123456789123456789123456789123456789123456789";
	String incorrectRow = "417339825632158947985724316825437169791555432346912758289643571573291684164875293";
	String incorrectColumn = "417339825632158947955724316825437169791555432346912758289643571573291684164875293";
	private SudokuVerifier verifier;
	
	@Before
	public void setup(){
		verifier = new SudokuVerifier();
	}
	
	@Test
	public void testverify_StringCorrectSolution_return0() {
		
		assertEquals (0, verifier.verify(correctSolution));
	}
	
	@Test
	public void testverify_StringNoSolution_returnMinus1() {
		
		assertEquals (-1, verifier.verify(noSolution));
	}
	
	
	@Test
	public void testVerifyStringLength_StringCorrectSolution_returnTrue(){
		
		assertEquals (true, verifier.verifyStringLength(correctSolution));
		
	}
	
	@Test
	public void testVerifyStringLength_StringNoSolution_returnTrue(){
		
		assertEquals (false, verifier.verifyStringLength(noSolution));
		
	}
	@Test
	public void testVerifyRule1_OnlyPositiveDigits_StringCorrectSolution_return_true(){
	
			assertEquals (true, verifier.verifyRule1(correctSolution));
	}
	@Test
	public void testVerifyRule1_OnlyPositiveDigits_StringNegativeSolution_return_false(){
		
			assertEquals (false, verifier.verifyRule1(negativeSolution));
	}
	
	@Test
	public void testVerfyRule2_StringCorrectSolution_returnTrue(){
		assertEquals (true, verifier.verifyRule2(correctSolution));
	}
	@Test
	public void testVerfyRule2_StringIncorrectSolution_returnFalse(){
		assertEquals (false, verifier.verifyRule2(incorrectSolution));
	}
	@Test
	public void getSubGrid_StringGridCeck_subGridTopLeft_return123123123(){
	int[][] subGrids= verifier.getSubGrids(gridCheck);
		assertEquals ("[1, 2, 3, 1, 2, 3, 1, 2, 3]", Arrays.toString(subGrids[0]));
		
	}
	@Test
	public void getSubGrid_StringGridCeck_subGridTopMid_return456456456(){
	int[][] subGrids= verifier.getSubGrids(gridCheck);
		assertEquals ("[4, 5, 6, 4, 5, 6, 4, 5, 6]", Arrays.toString(subGrids[1]));
	}
	@Test
	public void getSubGrid_StringGridCeck_subGridBottomRight_return789789789(){
	int[][] subGrids= verifier.getSubGrids(gridCheck);
		assertEquals ("[7, 8, 9, 7, 8, 9, 7, 8, 9]", Arrays.toString(subGrids[8]));
	}
	@Test
	public void testVerfyRule3_StringCorrectSolution_returnTrue(){
		assertEquals (true, verifier.verifyRule3(correctSolution));
	}
	@Test
	public void testVerfyRule3_StringIncorrectRow_returnFalse(){
		assertEquals (false, verifier.verifyRule3(incorrectRow));
	}
	@Test
	public void testVerfyRule4_StringCorrectSolution_returnTrue(){
		assertEquals (true, verifier.verifyRule4(correctSolution));
	}
	@Test
	public void testVerfyRule4_StringIncorrectColumn_returnFalse(){
		assertEquals (false, verifier.verifyRule4(incorrectColumn));
	}
	@Test
	public void testverify_failRule1_StringNegativeSolution_returnMinus1() {
		
		assertEquals (-1, verifier.verify(negativeSolution));
	}
	@Test
	public void testverify_failRule2_StringGridCheck_returnMinus2() {
		
		assertEquals (-2, verifier.verify(gridCheck));
	}
	@Test
	public void testverify_failRule3_StringIncorrectRow_returnMinus3() {
		
		assertEquals (-3, verifier.verify(incorrectRow));
	}
	@Test
	public void testverify_failRule4_StringIncorrectColumn_returnMinus4() {
		
		assertEquals (-4, verifier.verify(incorrectColumn));
	}
}

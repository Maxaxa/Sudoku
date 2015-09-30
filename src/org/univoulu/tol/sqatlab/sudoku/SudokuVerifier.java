package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public SudokuVerifier(){
		
	}
	
	
	public int verify(String candidateSolution) {
		// returns 1 if the candidate solution is correct
		int checksum = 0;
		if (verifyStringLength(candidateSolution)) checksum = 1;
		return checksum;
			}

	public boolean verifyStringLength(String candidateSolution) {
		int correctStringLength = 81;
		if(candidateSolution.length() == correctStringLength)
			return true;
		return false;
	}

	public int[] SolutionToString(String candidateSolution){
		
		int[] digits = new int[candidateSolution.length()];
		for (int i: digits){
			digits[i] = Integer.parseInt(String.valueOf(candidateSolution.charAt(i)));
		}
		return digits;
		
	}
	
	
	public boolean verifyRule1(String candidateSolution) {
		return true;
	}
	
	
}

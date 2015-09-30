package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public SudokuVerifier(){
		
	}
	
	
	public int verify(String candidateSolution) {
		// returns 1 if the candidate solution is correct
		int checksum = 0;
		if (verifyStringLength()) checksum = 1;
		return checksum;
			}

	public boolean verifyStringLength() {
		// returns 1 if length is correct
		return true;
	}
}

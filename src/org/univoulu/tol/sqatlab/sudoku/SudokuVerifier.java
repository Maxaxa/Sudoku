package org.univoulu.tol.sqatlab.sudoku;

public class SudokuVerifier {

	public static int verify(String candidateSolution) {
		// returns 1 if the candidate solution is correct
		int checksum = 0;
		if (verifyStringLength()) checksum = 1;
		return checksum;
			}

	public static boolean verifyStringLength() {
		// TODO Auto-generated method stub
		return true;
	}
}

package org.univoulu.tol.sqatlab.sudoku;

import java.util.Arrays;

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

	public int[] solutionToString(String candidateSolution){
		
		int[] digits = new int[candidateSolution.length()];
		for (int i = 0; i<digits.length;i++ ){
			digits[i] = Integer.parseInt(String.valueOf(candidateSolution.charAt(i)));
		}

		return digits;
		
	}
	
	
	public boolean verifyRule1(String candidateSolution) {
		boolean digitIsRight = true;
		for (int i = 0; i<candidateSolution.length(); i++){
			if(!Character.isDigit(candidateSolution.charAt(i))){
				digitIsRight = false;
			}
		}
		digitIsRight = isDigitPositive(candidateSolution, digitIsRight);
		return digitIsRight;
	}


	public boolean isDigitPositive(String candidateSolution, boolean digitIsRight) {
		if(digitIsRight){
			int[] digits = solutionToString(candidateSolution);
			
			for(int j: digits){
				if(digits[j] <= 0 && digits[j] >= 10){
					digitIsRight = false;
				}
					
			}
		}
		return digitIsRight;
	}


	public boolean verifyRule2(String candidateSolution) {
		return true;
	}


	public int[][] getSubGrids(String candidateSolution) {
		int[] digits = solutionToString(candidateSolution);
		int [][] subGrids = new int[9][9];
		int[] singleGrid = new int [9];
		for(int s = 0; s < 9; s++){
			for(int j = 0; j<3;j++){
				for(int i = 0+(j*3)%singleGrid.length; i<(singleGrid.length/3)*((j+1)%4);i++){
				
					singleGrid[i] = digits[i+/*(singleGrid.length-3)*/s*j];
				
				}
			}
			subGrids[s] = singleGrid;
		}
		return subGrids;
	}
	
}

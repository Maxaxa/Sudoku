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

	public int[] solutionToIntArray(String candidateSolution){
		
		int[] digits = new int[candidateSolution.length()];
		for (int i = 0; i<digits.length;i++ ){
			digits[i] = Integer.parseInt(String.valueOf(candidateSolution.charAt(i)));
		}

		return digits;
		
	}
/*public int[][] solutionToTwoDimensianalIntArray(String candidateSolution){
		int rowLength = 9;
		int columnLength = 9;
		int[][] digitArray = new int[rowLength][columnLength];
		for (int i = 0; i<digits.length;i++ ){
			digits[i] = Integer.parseInt(String.valueOf(candidateSolution.charAt(i)));
		}

		return digits;
		
	}*/
	
	
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
			int[] digits = solutionToIntArray(candidateSolution);
			
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
		
		int [][] subGrids = new int[9][9];
		
		for(int s = 0; s < 9; s++){
			int[] singleGrid = new int[9];
			for(int startingpoint=0;startingpoint<3;startingpoint++){
				singleGrid = getSingleGrid(candidateSolution, startingpoint);
			}
			subGrids[s] = singleGrid;
			//System.out.println(Arrays.toString(subGrids[s]));
		}
		return subGrids;
	}


	public int[] getSingleGrid(String candidateSolution, int startingpoint) {
		int[] singleGrid = new int [9];
		int[] digits = solutionToIntArray(candidateSolution);		
		int counter = 0;
		for(int j = startingpoint; j<3;j++){
			for(int i = 0+(counter*3); i<(singleGrid.length/3)*((counter)+1);i++){
			
				singleGrid[i] = digits[i+(singleGrid.length-3)*counter];
			System.out.print(i);
			}
			counter++;
			System.out.println();
		}
		System.out.println(Arrays.toString(singleGrid));
		return singleGrid;
	}
	
}

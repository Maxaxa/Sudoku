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
public int[][] solutionToTwoDimensianalIntArray(String candidateSolution){
		int rowLength = 9;
		int columnLength = 9;
		int[][] digitArray = new int[rowLength][columnLength];
		int [] digits = solutionToIntArray(candidateSolution);
		for (int i = 0; i<digits.length;i++ ){
			for (int j = 0; j<rowLength;j++ ){
				digitArray[i%9][j] = digits[i];
			}
		}
		return digitArray;
		
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
		boolean digitIsRight = true;
		 int[][] subGrids = getSubGrids(candidateSolution); 
		for(int s=0; s<9;s++){
			for(int g=0; g<9;g++){
				if(!Arrays.asList(subGrids[s][g]).contains(g+1)){
					return false;
				}
			}
		}
		
		return digitIsRight;
	}


	public int[][] getSubGrids(String candidateSolution) {
		
		int [][] subGrids = new int[9][9];
		
		int [][] digitArray = solutionToTwoDimensianalIntArray(candidateSolution);
		int gridCounter =0;
		for(int iforward=0; iforward<3;iforward++){
			for(int jforward=0; jforward<3;jforward++){
				int counter = 0;
				for(int i = 0; i<3;i++){
					for(int j = 0; j<3;j++){
						subGrids[gridCounter][counter] = digitArray[j+(jforward)*3][i+(iforward)*3];
						counter++;
					}
				}
				gridCounter++;
			}
		}
		/*for(int s=0; s<9;s++){
			System.out.println(Arrays.toString(subGrids[s]));
		}*/
		return subGrids;
		
	}
	
}

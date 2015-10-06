package org.univoulu.tol.sqatlab.sudoku;

import java.util.Arrays;

public class SudokuVerifier {

	public SudokuVerifier(){
		
	}
	int rowLength = 9;
	int columnLength = 9;
	
	
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

		int counter = 0;
		int[][] digitArray = new int[rowLength][columnLength];
		int [] digits = solutionToIntArray(candidateSolution);
		for (int i = 0; i<rowLength;i++ ){
			for (int j = 0; j<columnLength;j++ ){
				
				digitArray[i][j] = digits[counter];
				counter++;
			}
			//System.out.println(Arrays.toString(digitArray[i%9]));
		}
	/*	for(int s=0; s<9;s++){
			System.out.println(Arrays.toString(digitArray[s]));
		}*/
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
		 int [] allNumbersCheck = new int[9];
		for(int s=0; s<9;s++){
		//	System.out.println(Arrays.toString(subGrids[s]));
			for(int g=0; g<9;g++){
				for(int count=1; count<10;count++)
				if(subGrids[s][g] == count){
					allNumbersCheck[count-1]=count;
				}
			}
			if(!checkSortedArrayForNumber1To9(allNumbersCheck)){
				return false;
			}
		}
		
		return digitIsRight;
	}

	public boolean checkSortedArrayForNumber1To9(int[] allNumbersCheck) {
		for(int c =1; c <10;c++){
			if(allNumbersCheck[c-1] != c ){
				return false;
			}
		}
		return true;
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
						subGrids[gridCounter][counter] = digitArray[i+(iforward)*3][j+(jforward)*3];
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


	public boolean verifyRule3(String candidateSolution) {
		boolean digitIsRight = true;
		int [] rows = new int[rowLength];
		int[][] digitArray = solutionToTwoDimensianalIntArray(candidateSolution);
		
		int[] allNumbersCheck = new int[9];
		for(int i = 0; i<rowLength;i++){
			for(int j = 0; j <columnLength;j++){
				rows [j] = digitArray[i][j];
				//System.out.print(rows[j]);
			}
			//System.out.println();
			sortNineDigitSingleArray(rows, allNumbersCheck);
			if(!checkSortedArrayForNumber1To9(allNumbersCheck)){
				return false;
			}
		}
		
		return digitIsRight;
	}

	public int[] sortNineDigitSingleArray(int[] rows, int[] allNumbersCheck) {
		for(int r=0; r<9;r++){
			for(int count=1; count<10;count++)
				if(rows[r] == count){
					allNumbersCheck [count-1]=count;
			}
		}
		return allNumbersCheck;
	}

	public Object verifyRule4(String candidateSolution) {
		boolean digitIsRight = true;
		int [] rows = new int[rowLength];
		int[][] digitArray = solutionToTwoDimensianalIntArray(candidateSolution);
		
		int[] allNumbersCheck = new int[9];
		for(int i = 0; i<rowLength;i++){
			for(int j = 0; j <columnLength;j++){
				rows [j] = digitArray[j][i];
				System.out.print(rows[j]);
			}
			System.out.println();
			sortNineDigitSingleArray(rows, allNumbersCheck);
			if(!checkSortedArrayForNumber1To9(allNumbersCheck)){
				return false;
			}
		}
		
		return digitIsRight;
	}
	
}

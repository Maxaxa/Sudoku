package org.univoulu.tol.sqatlab.sudoku;

import java.util.Arrays;

public class SudokuVerifier {

	public SudokuVerifier(){
		
	}
	int rowLength = 9;
	int columnLength = 9;
	
	
	public int verify(String candidateSolution) {
		// returns 0 if the candidate solution is correct
		if (!verifyRule1(candidateSolution)){
			return -1;
		}else if(!verifyRule2(candidateSolution)){
			return -2;
		}else if (!verifyRule3(candidateSolution)){
				return -3;
		}else if (!verifyRule4(candidateSolution)){
			return -4;
		}else{
			return 0;
		}
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
		if(!verifyStringLength(candidateSolution)) return false;
		for (int i = 0; i<candidateSolution.length(); i++){
			if(!Character.isDigit(candidateSolution.charAt(i))){
				return false;
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
		for(int s=0; s<subGrids.length;s++){
		//	System.out.println(Arrays.toString(subGrids[s]));
			for(int g=0; g<subGrids[s].length;g++){
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
		int subGridrowlength = 3;
		int subGridcolumnlength = 3;
		
		int [][] digitArray = solutionToTwoDimensianalIntArray(candidateSolution);
		int gridCounter =0;
		for(int iforward=0; iforward<subGridrowlength;iforward++){
			for(int jforward=0; jforward<subGridcolumnlength;jforward++){
				int counter = 0;
				for(int i = 0; i<subGridrowlength;i++){
					for(int j = 0; j<subGridcolumnlength;j++){
						subGrids[gridCounter][counter] = digitArray[i+(iforward)*subGridrowlength][j+(jforward)*subGridcolumnlength];
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
		
		int[] allNumbersCheck = new int[rowLength];
		for(int i = 0; i<rowLength;i++){
			for(int j = 0; j <columnLength;j++){
				rows [j] = digitArray[i][j];
				//System.out.print(rows[j]);
			}
			//System.out.println();
			allNumbersCheck = sortNineDigitSingleArray(rows);
			if(!checkSortedArrayForNumber1To9(allNumbersCheck)){
				return false;
			}
		}
		
		return digitIsRight;
	}

	public int[] sortNineDigitSingleArray(int[] line) {
		 int[] sortArray = new int [line.length];
		for(int l=0; l<line.length;l++){
			for(int count=1; count<10;count++){
				if(line[l] == count){
					//System.out.println(line[l] +"  "+ count);
					sortArray [count-1]=count;
				}
			}
		}
		//System.out.println(Arrays.toString(sortArray));
		return sortArray;
	}

	public boolean verifyRule4(String candidateSolution) {
		boolean digitIsRight = true;
		int [] column = new int[columnLength];
		int[][] digitArray = solutionToTwoDimensianalIntArray(candidateSolution);
		
		int[] allNumbersCheck = new int[columnLength];
		for(int i = 0; i<rowLength;i++){
			for(int j = 0; j <columnLength;j++){
				column [j] = digitArray[j][i];
			//	System.out.print(column[j]);
			}
		//	System.out.println();
			allNumbersCheck = sortNineDigitSingleArray(column);
			
			if(!checkSortedArrayForNumber1To9(allNumbersCheck)){
				return false;
			}
		}
		
		return digitIsRight;
	}
	
}

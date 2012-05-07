/*
 * Simple treasure finding game.
 * 
 * +------------------------+
 * ¦ 34 ¦ 21 ¦ 32 ¦ 41 ¦ 25 ¦
 * ------+----+----+----+---¦
 * ¦ 14 ¦ 42 ¦ 43 ¦ 14 ¦ 31 ¦
 * ------+----+----+----+---¦
 * ¦ 54 ¦ 45 ¦ 52 ¦ 42 ¦ 23 ¦
 * ------+----+----+----+---¦
 * ¦ 33 ¦ 15 ¦ 51 ¦ 31 ¦ 35 ¦
 * ------+----+----+----+---¦
 * ¦ 21 ¦ 52 ¦ 33 ¦ 13 ¦ 23 ¦
 * +------------------------+
 * Do you like treasure hunts? In this problem you are to write a program to explore the above array for a treasure. The values in the array are clues. 
 * Each cell contains an integer between 11 and 55; for each value the ten's digit represents the row number and the unit's digit represents the column number of the cell containing the next clue.
 * Starting in the upper left corner (at 1,1), use the clues to guide your search of the array. (The first three clues are 11, 34, 42).
 * i.e. Cell (1,1) contains 34, which means go to cell 3, 4
 * Cell(3,4) contains 42 which means go to cell 4,2…..
 * The treasure is a cell whose value is the same as its coordinates. 
 * Answered for : http://www.cramster.com/answers-may-12/computer-science/java-treasure-hunt-premise_2516915.aspx
 * Answered on : 7/5/12
 */
package game.treasure;

import java.util.Scanner;

/**
 * The Class TreasureHunt.
 */
public class TreasureHunt {

	/** The treasure array. */
	private int[][] treasureArray;
	
	/** The Constant treasureArraySize. */
	private static final int treasureArraySize = 5;
	
	/** The input. */
	Scanner input;
	
	
	/**
	 * Fill tresure array with user input.
	 */
	private void fillTresureArray(){
		System.out.println("Enter the tresure array (5x5) separated by spaces: ");
		for(int i=0;i<treasureArraySize;i++){
			for(int j=0;j<treasureArraySize;j++){
				//System.out.println("Enter value for ["+(i+1)+"]"+" ["+(j+1)+"]: ");
				treasureArray[i][j] = input.nextInt();
			}
		}
	}
	
	/**
	 * Find treasure.
	 */
	private void findTreasure(){
		boolean found = false;
		int currentCellRow = 0;
		int currentCellCol = 0;
		while(!found){
			System.out.println("Currently in row "+(currentCellRow+1)+" col "+(currentCellCol+1));
			int value = treasureArray[currentCellRow][currentCellCol];
			int nextCellCol = value % 10 - 1;
			value /= 10;
			int nextCellRow = value % 10 - 1;
			if(nextCellCol==currentCellCol && nextCellRow==currentCellRow){
				System.out.println("Treasure found");
				found = true;
			}else{
				currentCellCol = nextCellCol;
				currentCellRow = nextCellRow;
			}
			
		}
	}
	
	/**
	 * Instantiates a new treasure hunt.
	 */
	TreasureHunt(){
		input = new Scanner(System.in);
		treasureArray = new int[treasureArraySize][treasureArraySize];
		fillTresureArray();
		findTreasure();
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		new TreasureHunt();		// Creating object
	}

}

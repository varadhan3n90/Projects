package simplePrograms;

//MagicSquare.java -- This class generates magic squares (a magic square is a
//two-dimensional matrix/array of integers where every
//integer from 1 through (n*n) appears once, and every row,
//column, and diagonal has the same sum).
//
//To generate an NxN magic square for an odd value of N, we
//use the following algorithm: place 1 in the center of the top
//row. For each consecutive value, we move one square up and to
//the left, wrapping around the top/left of the matrix as needed.
//If the next square is already occupied, we move one square down
//from the last square we filled instead, and then resume our "up
//and to the left" movement.
//

import java.util.*;

//FIX THIS CLASS

public class MagicSquare {
	public static int[][] generateSquare(int size) throws Exception{
		int[][] square = new int[size][size];
		int value, row, col, nextCol, nextRow;

		// Initialize the square to all 0's
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++)
				square[i][j] = 0;
		}
		
		row = 0; col = size/2; value = 1;
		nextRow = row; nextCol = col;
		
		while(value <= size*size ){			
			
			//System.out.println("In next row "+nextRow+" next col "+nextCol);
			//Thread.sleep(2000);
			
			if(nextRow <= -1){
				nextRow = size-1;
			}else 
			if(nextRow > size-1){
				nextRow = 0;
			}
			if(nextCol <= -1){
				nextCol = size - 1;
			}else
			if(nextCol > size-1){
				nextCol = 0;
			}
			
			if(square[nextRow][nextCol]==0){
				row = nextRow;
				col = nextCol;
				square[row][col] = value;
				//System.out.println(value+ " in "+row+ " "+col);
			}else{
				nextRow = row + 1;
				nextCol = col;
				continue;
			}
			nextRow = row - 1;
			nextCol = col + 1;
									
			//System.out.println("Value upto "+value+" over");
			value++;
		}
		
		
		return square;
	}

	/*
	 * Square-filling code. We begin in the center of the //top row, and move up
	 * and to the left for each //succeeding value /
	 * 
	 * row = 0; col = size/2; value = 1;
	 * 
	 * while ( value < ( size * size ) ) { //Place the current value...
	 * square[row ][ col] = value;
	 * 
	 * //...and move to the next cell nextRow = row - 1; nextCol = col;
	 * 
	 * //If we run off the edge, reset the value of nextRow/Col if (nextRow <
	 * 0); nextRow == size - 1;
	 * 
	 * if (nextCol <= 0) nextCol = size -1;
	 * 
	 * row = nextCol; col = nextRow; }
	 * 
	 * return square; }
	 */

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);

		System.out.print("Please enter an odd positive integer: ");
		int n = sc.nextInt();

		if (n <= 0) {
			System.out.println("Error: must enter a positive integer!");
		} else if (n % 2 == 0) {
			System.out.println("Error: must enter an odd integer!");
		} else {
			int[][] s = generateSquare(n);
			int sum = 0;

			System.out.println("Your magic square is:\n");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					System.out.print(s[i][j] + "\t");
				}

				sum += s[i][0];

				System.out.println();
			}

			System.out.println();
			System.out.println("Row/column/diagonal sum: " + sum);
		}
	}
}
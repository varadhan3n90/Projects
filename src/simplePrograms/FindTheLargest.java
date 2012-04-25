/*
*
* The program has a two dimensional array of numbers. What I need
* is to "search" the array and find all elements that are MAX.
* This is to be accomplished with at least 2 methods in addition to the
* main method.
* Method 1 needs to search the array and return the largest number in the array (MAX).
* Method 2 needs to print out the [row][column] of each element that equals MAX.
* 
* Answered for : http://www.cramster.com/answers-apr-12/computer-science/java-arrays-find-max-program-dimensional-array-number_2459535.aspx
* Answered on : 25/4/12
*
*/

package simplePrograms;

public class FindTheLargest {

	/**
	 * Gets the maximum number in array.
	 *
	 * @param array the array
	 * @return the max
	 */
	public static int getMax(int array[][]){
		int max = 0;
		for(int i=0;i<array.length;i++){
			int myArray[] = array[i];
			for(int j=0;j<myArray.length;j++){
				if(max < myArray[j]){
					max = myArray[j];
				}
			}
		}
		System.out.println("Maximum number is "+max);
		return max;
	}
	
	/**
	 * Prints the positions where maximum is found.
	 *
	 * @param array the array
	 */
	public static void printPositions(int array[][]){
		int max = getMax(array);
		System.out.println("Index starts with zero");
		for(int i=0;i<array.length;i++){
			int myArray[] = array[i];
			for(int j=0;j<myArray.length;j++){
				if(max == myArray[j]){
					System.out.println("Max at position ("+i+","+j+")");
				}
			}
		}
		
	}
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){		
		//Initialization and Declarations
		int numberArray[][] = {
				{0,3,4,0,0,0,6,8},
				{5,13,6,0,0,0,2,3},
				{2,6,2,7,3,0,15,0},
				{0,0,4,15,4,1,6,0},
				{0,0,7,12,6,9,10,4},
				{5,0,6,10,6,4,15,0}
		};
		
		printPositions(numberArray);
	}
} 
/*
 * Program for addition of very large numbers stored as strings
 * 
 */

package bigNumbers;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * @author Varadhan
 */

/**
 * The Class Addition. Use for addition of large numbers
 */
public class Addition {

	/**
	 * Function : convertToStack
	 * Used to create a stack and push all the digits of the given number in string format
	 * into it
	 * @param number as String  
	 * @throws Exception If a number begins with zero it must be zero otherwise causes bad number exception
	 * 		   If a number contains characters other than digits and comma exception is thrown
	 *  
	 */
	
	private Stack<Integer> convertToStack(String number) {
		
		// Declaring a new stack
		Stack<Integer> stk = new Stack<Integer>();
		
		// Check to see if number begins with zero then it should be zero. If it has more characters then it is not zero
		// Even 000 will be considered as error		
		if(number.startsWith("0")&&number.length()!=1){
			//Exception e = new Exception ("Bad number. Begins with zero exception");
			//throw e;
			stk.clear();
			System.out.println("\nBegins with zero exception. Ignoring the number");			
			return convertToStack("0");
		}
		
		// Fill the stack with digits of the number
		 for(int i=0;i<number.length();i++){
			 // Extract the character at position i from the string
			 char c = number.charAt(i);
			 // Ignore character if it is a comma
			 if(c==',')
				 continue;
			 // If number contains characters other than digits raise exception ( - is also not allowed )
			 if(!(c>='0'&&c<='9')){
				 if(c=='-')
					 System.out.println("\nBegins with -ve exception. Ignoring the number");
				 else
					 System.out.println("\nInvalid digit exception. Ignoring the number");
				 //Exception e = new Exception("Bad number");
				 //throw e;
				 stk.clear();
				 return convertToStack("0");
			 }else{				 
				 // Create a integer from the character. (c-'0') is done because c represents ASCII value of the digit
				 // ASCII values of numbers are continuous. Subtract 0 so that required integer is obtained.
				 Integer x = new Integer((c-'0'));
				 stk.push(x);
			 }			 
		 }
		 // Return the stack that was created.
		 // stack now contains the digits in reverse order when popped. This will make the task easy when numbers are to be added starting from 1's place then 10's etc
		 return stk;
	}
		
	/**
	 * Adds the large numbers. 
	 * The numbers are first pushed into stack using convertToStack
	 * The the digits are popped one by one and added together and sum returned as String.
	 * 
	 * @param number1 as String
	 * @param number2 as String
	 * @return the string the sum of two numbers
	 * @throws Exception the exception
	 * 		   
	 */
	public String addLargeNumbers(String number1,String number2) {
		
			// Push the given two numbers into stack
			Stack<Integer> no1 = convertToStack(number1);
			Stack<Integer> no2 = convertToStack(number2);
			
			// Create a new stack to store the result
			Stack<Integer> result = new Stack<Integer>();
			
			// variable carry is used to store the carry
			int carry = 0;
			
			// While at-least one of the two stacks is non empty do the following
			while((!no1.isEmpty())&&(!no2.isEmpty())){
				// Pop the corresponding place in the two integers from the stack
				Integer x = no1.pop();
				Integer y = no2.pop();
				
				// Create a new integer with value as the sum of the two values popped and the carry
				Integer res = new Integer( x.intValue() + y.intValue() + carry );
				
				// If the result is greater than 10 then correspondingly the carry must be set for next iteration
				if(res.intValue() >= 10){
					res = res - 10;
					carry = 1;
				}else{
					carry = 0;
				}
				
				// Push the value of result into the stack
				result.push(res);		
			}
			
			// If suppose the give numbers are 99 and 1 then the units place will be added and put
			// into stack as 0 (because sum is 10 i.e 9 + 1 ) and carry is set. The other digits of result are to be put in the stack
			if(!no1.isEmpty()){
				while(!no1.isEmpty()){
					// same logic as previous part
					Integer x = (no1.pop() + carry);					
					if(x.intValue() >= 10){
						x = x - 10;
						carry = 1;
					}else carry = 0;
					result.push(x);
				}
			} 
			// In case the give numbers are 1 and 99 ( Just the opposite of the above )
			if(!no2.isEmpty()){
				while(!no2.isEmpty()){
					Integer x = (no2.pop() + carry);					
					if(x.intValue() >= 10){
						x = x - 10;
						carry = 1;
					}else carry = 0;
					result.push(x);
				}
			}
			// Finally end carry can occur like adding 99 and 1 the result is 3 digits where as numbers are 2 digits
			if(carry!=0){			
					Integer x = new Integer(carry);
					result.push(x);
			}
			
			// Pop the result from the stack and store it in a string
			String temp = new String();
			while(!result.isEmpty()){
				// Append the digits. Result in temp will be in reverse order in which it was pushed
				temp = result.pop().toString() + temp;
			}
			
			// Since result is in reverse order, reverse the string to get the correct output
			StringBuilder sb = new StringBuilder(temp);
			return sb.reverse().toString();			
	}
	
	/**
	 * Command line addition.
	 * Used to add numbers given in command line. The numbers are separated by spaces.
	 * @param line the String that contains the large numbers to add separated by spaces
	 */
	public void commandLineAddition(String line){
		try{			
			// Used to separate the numbers the line using space as separator
			StringTokenizer st = new StringTokenizer(line);
			// variable value is used to get store a number from the line. result stores the value of addition of values
			String value = "0";	
			String result = "0";
			// Flag is used to print + before every input number scanned except the first 
			boolean flag = false;
			
			while(st.hasMoreTokens()){
				// get and store the value one number from keyboard
				value = st.nextToken().trim();
				if(flag){
					System.out.print(" + ");
				}else{
					flag = true;
				}
				System.out.print(value);
				
				// Add the previous result to the current value and store the value in result
				result = addLargeNumbers(value, result);				
			}
			// Print the output
			System.out.println(" = "+result);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			//e.printStackTrace();			
		}
	}
	
	/**
	 * Batch addition.
	 * Gets the name of the file and adds the input lines as blocks until = is encountered
	 * @param file the file
	 */
	public void batchAddition(String file){
		try{
			Scanner st = new Scanner(new File(file));
			// Logic same as previous except input is taken from file
			String value = "0";			
			String result = "0";
			boolean flag = false;
			while(st.hasNext()){
				value = st.nextLine().trim();
				// If group has ended the print result reset result to 0
				if(value.equals("=")){
					System.out.println(" = "+result);
					result = "0";
					flag = false;
					continue;
				}
				if(flag){
					System.out.print(" + ");
				}else{
					flag = true;
				}
				System.out.print(value);
				result = addLargeNumbers(value, result);				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			// In case to debug
			//e.printStackTrace();			
		}
	}
	
	// Use this main function in case input is from java command line arguments
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		Addition add = new Addition();
		if(args.length < 2){
			System.out.println("Usage:\t java Addition [number1] [number2] ... " +
					"\nOr\t java Addition [-f filename] ");
			return;
		}
		if(args[0].equals("-f")){
			add.batchAddition(args[1]);
		}else{
			String line = new String();
			for(int i=0;i<args.length;i++){
				line += args[i] + " "; 
			}
			add.commandLineAddition(line);
		}
	}
	// Uncomment this main function in case input is from interactive choices
	/*
	public static void main(String args[]){
		try{
			int choice = 0;
			Addition add = new Addition();
			do{
				System.out.println("1.Command line addition\n2.Batch Additions\n3.Exit");
				Scanner input = new Scanner(System.in);
				choice = input.nextInt();
				switch (choice){
				case 1:
					System.out.println("Enter the numbers separated by spaces: ");					
					// Get an entire line of input and store it in line
					String line = input.nextLine();
					add.commandLineAddition(line); break;
				case 2:
					System.out.println("Enter file name: ");
					String fileName = input.next();
					add.batchAddition(fileName); break;
				case 3:
					System.out.println("Exiting"); return;
				default:
					System.out.println("Incorrect input");
				}
			}while(choice!=3);
		}catch(Exception e) { System.out.println(e.toString()); }
	}
	*/	
}

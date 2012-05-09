/* 
 * 
 * Answered for : http://www.cramster.com/answer/edit/2442065/0?rec=0
 * Program to check balanced parenthesis
 * 
 */
package paranthesis;
import java.util.Stack;

/**
 * @author Varadhan
 * The Class Parenthesis.
 */
public class Paranthesis {
	
	/**
	 * Match checker.
	 *
	 * @param lineToCheck the String with the line that needs to be checked for parenthesis
	 * @return String indicating if parenthesis are missing or perfectly parenthesized
	 */
	public static String matchChecker(String lineToCheck){
		
		Stack<String> paran = new Stack<String>();
		
		for(int i=0;i<lineToCheck.length();i++){
			if(lineToCheck.charAt(i)=='{'){
				paran.push("A");
			}
			if(lineToCheck.charAt(i)=='['){
				paran.push("B");
			}
			if(lineToCheck.charAt(i)=='('){
				paran.push("C");
			}
			
			if(lineToCheck.charAt(i)=='<'){
				paran.push("D");
			}
			if(lineToCheck.charAt(i)=='}'){
				String val = paran.pop();
				if(!val.equals("A")){
					return "} missing at position "+i+" in line";
				}
			}
			if(lineToCheck.charAt(i)==']'){
				String val = paran.pop();
				if(!val.equals("B")){
					return "] missing at position "+i+" in line";
				}
			}
			if(lineToCheck.charAt(i)==')'){
				String val = paran.pop();
				if(!val.equals("C")){
					return ") missing at position "+i+" in line";
				}
	
			}
			if(lineToCheck.charAt(i)=='>'){
				String val = paran.pop();
				if(!val.equals("D")){
					return "> missing at position "+i+" in line";
				}
			}
		}
		if(paran.isEmpty())
			return "Paranthesis match perfectly";
		else{
			while(!paran.isEmpty()){
				String val = paran.pop();
				if(val.equals("A")){
					System.out.println("} missing");
				}
				if(val.equals("B")){
					System.out.println("] is missing");
				}
				if(val.equals("C")){
					System.out.println(") is missing");
				}
			}
			return "";
		}
		
	}
	
	public static boolean isBalanced(String lineToCheck){
		boolean balanced = true;
		Stack<String> paran = new Stack<String>();
		try{
		for(int i=0;i<lineToCheck.length();i++){
			if(lineToCheck.charAt(i)=='{'){
				paran.push("A");
			}
			if(lineToCheck.charAt(i)=='['){
				paran.push("B");
			}
			if(lineToCheck.charAt(i)=='('){
				paran.push("C");
			}
			
			if(lineToCheck.charAt(i)=='<'){
				paran.push("D");
			}
			if(lineToCheck.charAt(i)=='}'){
				String val = paran.pop();
				if(!val.equals("A")){
					return !balanced;
				}
			}
			if(lineToCheck.charAt(i)==']'){
				String val = paran.pop();
				if(!val.equals("B")){
					return !balanced;
				}
			}
			if(lineToCheck.charAt(i)==')'){
				String val = paran.pop();
				if(!val.equals("C")){
					return !balanced;
				}
	
			}
			if(lineToCheck.charAt(i)=='>'){
				String val = paran.pop();
				if(!val.equals("D")){
					return !balanced;
				}
			}
		}
		if(paran.isEmpty())
			return balanced;
		else{
			return !balanced;
		}
		}catch(Exception e){
			return !balanced;
		}
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		/*
		 *  The string whose value is to be checked for parenthesis.
		 *  If required the input can be obtained from user by using Scanner from java.util
		 */
		String input = "{a [b(c <d>)] e f g}";
		System.out.println(isBalanced(input));
	}
}

/* 
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
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]){
		// The string whose value is to be checked for parenthesis
		String value = "{hello there (braces match) [fine] }";
		System.out.println(matchChecker(value));
	}
}

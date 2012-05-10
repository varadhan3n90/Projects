package stringManipulation;

import java.util.Scanner;

public class StringManipulations {

	/*
	 * countOccurrences() method, which takes two arguments: a String and a char value. 
	 * This method recursively counts (and returns) the number of times that the char argument appears in the String. 
	 * For example, the character 's' appears 5 times in the String "an algorithm is a list of the steps needed to solve a problem"
	 * May assume that both of the arguments to this method are lowercase.
	 * Solution MUST use recursion
	 * Answered for : http://www.cramster.com/answers-may-12/computer-science/complete-countoccurances-complete-countoccurrences-method-takes-argu_2530503.aspx?rec=0
	 * Answered on : 10/5/12 
	 */
	
	public int countOccurances(String s,char c){
		if(s.isEmpty()||s==null)
			return 0;
		if(c==s.charAt(0)){
			return 1+countOccurances(s.substring(1), c);
		}else{
			return countOccurances(s.substring(1), c);
		}
		
	}

	/*
	 * Given a string, return true if the number of appearances of "is" anywhere in the string is equal to the number of appearances of "not" anywhere in the string (case sensitive).
	 * Answered for : http://www.cramster.com/answers-may-12/computer-science/short-java-program-string-return-true-number-appearances_2530929.aspx?rec=0 
	 */

	public static boolean equalsIsNot(String input){		
		int fromIndex = 0;
		int isCount = 0;
		int notCount = 0;
		while(true){
			if(fromIndex > input.length()||(fromIndex = input.indexOf("is", fromIndex))==-1){
				break;
			}else{
				fromIndex +=2;
				isCount++;
			}
		}
		fromIndex = 0;
		while(true){
			if(fromIndex > input.length()||(fromIndex = input.indexOf("not", fromIndex))==-1){
				break;
			}else{
				fromIndex +=3;
				notCount++;
			}
		}
		return isCount==notCount;
	}
	
	/*
	 * Given two strings, base and remove, return a version of the base string where all instances of the remove string have been removed (not case sensitive). 
	 * You may assume that the remove string is length 1 or more. Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
	 * Answered for : http://www.cramster.com/answers-may-12/computer-science/small-programming-strings-base-remove-return-version_2530923.aspx?rec=0
	 * Answered on : 10/5/12 
	 */
	
	public static String withoutString(String input,String remove){
		String result = input;
		int beginIndex = 0;
		while(true){
			beginIndex = result.indexOf(remove);
			if(beginIndex == -1)
				break;
			else{
				result = result.substring(0, beginIndex)+result.substring(beginIndex+remove.length());
			}
		}
		return result;
	}
	
	/*
	 * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count, but not the 'y' in "yellow" (not case sensitive).
	 * We'll say that a y or z is at the end of a word if there is not an alphabetic letter immediately following it. 
	 * (Note: Character.isLetter(char) tests if a char is an alphabetic letter.) 
	 * Answered for : http://www.cramster.com/answers-may-12/computer-science/small-java-programming-string-count-number-words_2530899.aspx?rec=0
	 */
	
	public static int countYZ(String input){
		int count = 0;
		Scanner sc = new Scanner(input);
		while(sc.hasNext()){
			String word = sc.next();
			if(word.charAt(word.length()-1)=='z'||word.charAt(word.length()-1)=='y'||word.charAt(word.length()-1)=='Z'||word.charAt(word.length()-1)=='Y')
				count++;
		}
		return count;
	}
	
	/*
	 * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right. 
	 * Return true if all the g's in the given string are happy.
	 * gHappy("xxggxx") ? true
	 * gHappy("xxgxx") ? false
	 * gHappy("xxggyygxx") ? false 
	 * Answered for : http://www.cramster.com/answers-may-12/computer-science/short-java-programming-lowercase-string-happyqu_2530937.aspx?rec=0
	 */
	
	public static boolean gHappy(String input){
		boolean happy = true;
		char prev = 'x';
		char next = 'x';
		for(int i=0;i<input.length();i++){
			prev = next = 'x';
			char c = input.charAt(i);
			if(i>0)
				prev = input.charAt(i-1);
			if(i<input.length()-1)
				next = input.charAt(i+1);
			if(c=='g'){
				if(!(prev=='g'||next=='g'))
					return !happy;
			}
		}
		return happy;
		
	}
	
	/**
	 * The main method to test programs.
	 * @param args
	 */
	public static void main(String[] args){
		System.out.println(gHappy("xxggyyggxxgg"));
	}
}

/*
 * Contains code to recursively reverse a string and to recursively remove out a given set of characters in a string.
 * Answered for : http://www.cramster.com/answers-apr-12/computer-science/java-recursion-write-definition-recursive-methods-public-static_2455827.aspx
 * Answered on : 24/4/12
 */
package recursion;

/**
 * The Class StringManipulation.
 */
public class StringManipulation {
	
	/**
	 * Filter.
	 *
	 * @param s the from which characters are to be removed.
	 * @param rem the String which contains characters to be removed
	 * @return the string which contains characters removed.
	 */
	public static String filter(String s,String rem){
		if(rem.length()==0)
			return s;
		if(s.indexOf(rem.charAt(0))!=-1){
			s = s.substring(0,s.indexOf(rem.charAt(0)))+s.substring(s.indexOf(rem.charAt(0))+1);
			s = filter(s,rem);
		}else{
			s = filter(s,rem.substring(1));
		}
		return s;
	}
	
	/**
	 * Reverse.
	 *
	 * @param s the string that is to be reversed
	 * @return the reversed string
	 */
	public static String reverse(String s){
		if(s.indexOf('$')==-1)								// Check if sentinal is already present
				s = s+"$";									// Add a sentinal to the string to denote end of string
		if(s.equals("$"))									// If string has been reversed sentinal is the first character
			return "";
		s = reverse(s.substring(1)) + s.charAt(0);			// Attach the first character of string at last
		return s;											// Return the reversed string
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		System.out.println(reverse("Hello"));					// Print output of "Hello" reversed => olleH
		System.out.println(filter("abcdbdabdcbddda","bd"));		// => prints acaca
	}
}

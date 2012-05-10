/*
 * Answered for : http://www.cramster.com/answers-may-12/computer-science/string-analysisjava-balancer-class-code-determine_2529841.aspx?rec=0
 * Answered on : 10/5/12
 */

package simplePrograms;


public class Balancer {
	// This method takes a String as its argument and checks to see
	// whether it conforms to the following rules:
	//
	// 1. The String contains only a's, b's, and c's
	// 2. All a's precede all b's, which precede all c's
	// 3. The number of c's is equal to the total number of a's and b's
	//
	// This method returns true if the argument conforms to these rules,
	// and false if it does not.
	//
	// For example, abcc is valid, but abccc is not (there are 3 c's, but
	// only 2 a's and b's). acb is not valid because b comes *after* c.
	//
	// Precondition: the argument contains only 'a', 'b', and 'c' characters.
	// You may assume that the input is all lowercase.
	private static boolean containsOnlyabc(String input){
		boolean onlyABC = true;
		for(int i=0;i<input.length();i++){
			char c = input.charAt(i);
			if(!(c=='a'||c=='b'||c=='c'))
				return !onlyABC;
		}
		System.out.println("Only abc");
		return true;
	}
	private static boolean isCorrectlyPreceeding(String input){
		boolean correct = true;
		if(input.lastIndexOf('a')>input.lastIndexOf('b')||input.lastIndexOf('b')>input.lastIndexOf('c')){
			return !correct;
		}
		System.out.println("Correct preceeding");
		return correct;
	}
	private static boolean hasCorrectCount(String input){
		boolean correctCount = true;
		int noOfA = input.indexOf('b');
		int noOfB = input.indexOf('c') - noOfA;
		int noOfC = input.length() - noOfA - noOfB;
		System.out.println(noOfA+" + "+noOfB+" "+noOfC);		
		if(noOfA + noOfB != noOfC)
			return !correctCount;
		//System.out.println("Correct count..");
		return correctCount;
	}
	public static boolean isBalanced(String input) {
		// FILL IN THIS METHOD
		boolean balanced = true;
		if(!containsOnlyabc(input)||!isCorrectlyPreceeding(input)||!hasCorrectCount(input))			
			return !balanced;		
		return balanced;
	}

	// YOU MAY CHANGE THIS METHOD TO TEST YOUR SOLUTION
	public static void main(String[] args) {
		String testString = "aabbcccc";

		System.out.println("Test string: " + testString);
		System.out.println();

		System.out.print("This string is ");

		if (isBalanced(testString) == false) {
			System.out.print("NOT ");
		}

		System.out.println("correctly formed.\n");
	}
}

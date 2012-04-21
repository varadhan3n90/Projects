package combination;
/*
 * Code not working.
 * Program should accept 7 0r 10 digit number.
 * Generate the combinations of strings with cell phone keypad equivalents.
 * Something similar to tri tree must be implemented.
 */
//import java.util.Scanner;

/**
 * The Class PhoneNumber.
 */
public class PhoneNumber {

	/** The input. */
	private String input;
	
	/** The total combinations. */
	private int totalCombinations = 0;
	
	/** The invalid. */
	private boolean invalid = true;
	
	/** The zero. */
	String zero="0";
	
	/** The one. */
	String one="1";
	
	/** The two. */
	String two="2ABC";
	
	/** The three. */
	String three="3DEF";
	
	/** The four. */
	String four="4GHI";
	
	/** The five. */
	String five="5JKL";
	
	/** The six. */
	String six="6MNO";
	
	/** The seven. */
	String seven="7PQRS";
	
	/** The eight. */
	String eight="8TUV";
	
	/** The nine. */
	String nine="9WXYZ";
	
	/**
	 * Gets the substitute.
	 *
	 * @param number the number
	 * @return the substitute
	 */
	private String getSubstitute(char number){
		String val = null;
		switch(number){
			case '0': val = zero;break;
			case '1': val = one;break;
			case '2': val = two; break;
			case '3': val = three; break;
			case '4': val = four; break;
			case '5': val = five; break;
			case '6': val = six; break;
			case '7': val = seven; break;
			case '8': val = eight; break;
			case '9': val = nine; break;
		}
		return val;
	}
	
	
	/**
	 * Recures.
	 *
	 * @param before the before
	 * @param c the c
	 * @param after the after
	 */
	private void recures(String before,char c,String after){		
		
		String before1,after1=null;
		char c1 = 0;
		if(after!=null&&!after.isEmpty()){
			c1 = after.charAt(0);
			after1 = after.substring(1);
		}		
		String val = getSubstitute(c);
		if(val==null||val.isEmpty()){
			return;
		}
		for(int i=0;i<val.length();i++){
			System.out.print(before+val.charAt(i));			
			before1=c+"";
			if(after1!=null&&!after1.isEmpty()){							
				recures(before1, c1, after1);
			}else{				
				System.out.println();
			}
			
		}
		
		if(before==null||before.isEmpty()){
			return;
		}
		
		c = before.charAt(before.length()-1);
		before = before.substring(0,before.length()-1);
		after = after + c;
		recures(before, c, after);
		
	}
		
	/**
	 * Prints the combination.
	 */
	public void printCombination(){
		invalid=false;
		if(invalid){
			System.out.println("Phone number invalid. Cannot print.");
			return;
		}
		
		System.out.println("Printing combinations.");
		String before = input.substring(0,input.length()-1);
		char c = input.charAt(input.length()-1);
		String after = "";
		recures(before, c, after);
		System.out.println("\nTotal combinations: "+totalCombinations);
		
	}
	
	/**
	 * Valid input.
	 *
	 * @return true, if successful
	 */
	private boolean validInput(){
		String number = new String(input);
		if(!(number.length()==7 || number.length()==10)){
			System.out.println("Invalid phone number. Incorrect length.");			
			return invalid;
		}
		for(int i=0;i<number.length();i++)
			if(!((number.charAt(i)-'0'>=0)&&(number.charAt(i)-'0'<=9))){
				System.out.println("Invalid phone number. Contains non numeric.");
				return invalid;
			}
		invalid = false;
		return true;
	}
	
	
	
	/**
	 * Instantiates a new phone number.
	 *
	 * @param number the number
	 */
	public PhoneNumber(String number){		
		this.input = number;
		if(!validInput()){
			return;
		}
		
	}
	
	
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		//Scanner input = new Scanner(System.in);
		System.out.println("Enter phone number: ");
		//String number = input.next().trim();
		new PhoneNumber("23").printCombination();
	}
}

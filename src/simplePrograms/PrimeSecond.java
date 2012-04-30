package simplePrograms;

public class PrimeSecond {
	public static void main(String[] args){
		int n = 58047;
		boolean primeSecond = false;
		int digit=0;
		int prevDigit=0;
		while(n>0){
			prevDigit = digit;
			digit = n % 10;			
			n = n/10;
		}
		if(prevDigit==2||prevDigit==3||prevDigit==5||prevDigit==7){
			primeSecond = true;
		}
		System.out.println(primeSecond);
	}
}

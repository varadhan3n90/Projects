package simplePrograms;

import java.util.Scanner;

public class Factorial {
	
	public static int findFactorial(int n){
		if(n<=1)
			return 1;
		return n*findFactorial(n-1);
	}
	
	public static int findCombination(int n,int k){
		return findFactorial(n) / (findFactorial(n-k) * findFactorial(k));
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		int n,k;
		while(true){
			System.out.println("Enter value for n and k: ");
			n = input.nextInt();
			if(n==0)
				break;
			k = input.nextInt();			
			System.out.println(findCombination(n, k)+" combinations of "+n+" taken "+k+" at a time.");
		}
		System.out.println("Exiting.");
	}
}

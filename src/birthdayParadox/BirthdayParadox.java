/*
 * Program to prove birthday paradox. If 23 people are in a room 50% probability that 2 have same birthday
 * and if 57 people the probability is 99%
 * Answered for : http://www.cramster.com/answers-may-12/computer-science/birthday-paradox-instructions-carefully-read-program-requirements_2491805.aspx
 * Answered on : 2/5/12
 */
package birthdayParadox;

import java.util.Random;

/**
 * The Class BirthdayParadox.
 */
public class BirthdayParadox {
	
	/** The no of people. */
	int noOfpeople;
	
	/** The no of runs. */
	long noOfRuns;
	
	/** The birth dates. */
	int[] birthDates;
	
	/** The r. */
	Random r = new Random();
	
	/**
	 * Checks for duplicates.
	 *
	 * @return true, if successful
	 */
	private boolean hasDuplicates(){
		boolean result = false;
		for(int i=0;i<noOfpeople;i++){
			for(int j=0;j<i;j++){
				if(birthDates[i]==birthDates[j]){
					return true;
				}
			}
		}
		return result;
	}
	
	/**
	 * Instantiates a new birthday paradox.
	 *
	 * @param noOfPeople the no of people
	 * @param numberOfRuns the number of runs
	 */
	public BirthdayParadox(int noOfPeople,long numberOfRuns){
		this.noOfpeople = noOfPeople;
		this.noOfRuns = numberOfRuns;
		birthDates = new int[noOfPeople];
	}
	
	/**
	 * Fill birth dates.
	 */
	private void fillBirthDates(){
		for(int i=0;i<noOfpeople;i++){
			birthDates[i] = r.nextInt(366);
		}
	}
	
	/**
	 * Run birthday paradox.
	 *
	 * @return the double
	 */
	public double runBirthdayParadox(){
		double result = 0.0;
		for(long i=0;i<noOfRuns;i++){
			fillBirthDates();
			if(hasDuplicates())
				result += 1;
		}
		result = result / noOfRuns;
		return result;
	}
	
}

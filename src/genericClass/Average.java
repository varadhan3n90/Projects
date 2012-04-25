/*
 * Program to find average using generic functions
 * Answered for :http://www.cramster.com/answers-apr-12/computer-science/java-generic-average-method-write-generic-static-method-called-average-returns_2459509.aspx
 * Answered on : 25/4/12
 */
package genericClass;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Class Average.
 *
 * @param <T> the generic type
 */
public class Average <T extends Number>{
	
	/** The list. */
	ArrayList<T> list = new ArrayList<>();
	
	/**
	 * Average.
	 *
	 * @return the average as double
	 */
	public double average(){
		double avg = 0.0;
		double sum = 0.0;
		Iterator<T> i = list.iterator();
		while(i.hasNext()){
			sum += i.next().doubleValue();
		}
		avg = sum / list.size();
		return avg;
	}
	
	/**
	 * Adds the element to the list.
	 *
	 * @param e the e
	 */
	public void add(T e){
		list.add(e);		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		Average<Integer> avg = new Average<Integer>();
		avg.add(5);
		avg.add(6);
		avg.add(7);
		System.out.println(avg.average());
	}
	
}

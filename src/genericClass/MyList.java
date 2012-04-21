/*
 * 
 * Simple program for generic types in java.
 * Methods to implement largest and smallest values in list.
 * Answered for : http://www.cramster.com/answers-apr-12/computer-science/java-17-1pc-write-generic-class-named-mylist-type-parameter_2442709.aspx?rec=0
 */
package genericClass;

import java.util.ArrayList;
import java.util.Iterator;


class NoElementException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public String getMessage(){
		String error = "No elements in MyList";
		return error;
	}
	
	public String toString(){
		return getMessage();
	}
	
}

/**
 * The Class MyList.
 *
 * @param <T> the generic type bounded to number
 */
public class MyList<T extends Number> {
	
	/** The list to hold elements. */
	ArrayList<T> list = new ArrayList<T>();
	
	/**
	 * Adds the element to list.
	 *
	 * @param t the t
	 */
	public void add(T t){
		list.add(t);
	}
	
	/**
	 * Finds Largest element in list.
	 *
	 * @return the t
	 * @throws NoElementException if no elements are in list
	 */
	public T largest() throws NoElementException{
		if(list.isEmpty()){
			NoElementException e = new NoElementException();
			throw e;
		}
		Iterator<T> i = list.iterator();	
		T largest = i.next();		
		while(i.hasNext()){
			T temp = i.next();
			if(temp.doubleValue() > largest.doubleValue()){
				largest = temp;
			}
		}
		return largest;
	}
	
	/**
	 * Smallest.
	 *
	 * @return the t
	 * @throws NoElementException the no element exception
	 */
	public T smallest() throws NoElementException{
		if(list.isEmpty()){
			NoElementException e = new NoElementException();
			throw e;
		}
		T smallest = list.get(0);
		for (T temp : list){
			if(temp.doubleValue() < smallest.doubleValue()){
				smallest = temp;
			}
		}
		return smallest;
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		MyList<Integer> ilist = new MyList<Integer>();
		MyList<Float> flist = new MyList<Float>();
		ilist.add(5);
		ilist.add(3);
		ilist.add(8);
		flist.add(27.5f);
		flist.add(85.4f);
		flist.add(10.2f);
		try{
			System.out.println("Smallest element in ilist: "+ilist.smallest());
			System.out.println("Largest element in ilist: "+ilist.largest());
			System.out.println("Smallest element in flist: "+flist.smallest());
			System.out.println("Largest element in flist: "+flist.largest());
		}catch(NoElementException e){
			System.out.println(e.toString());
		}
		
	}
}

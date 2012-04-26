/*
 * Program was given as text book question which had array and to be changed as list
 * Answered on :25/4/12
 * Answered for : http://www.cramster.com/answers-apr-12/computer-science/application-dvd-java-im-lab-tasks-textbook-bu_2460703.aspx
 */
package classesDemo;

import java.text.NumberFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

//********************************************************************
//DVDCollection.java
//Represents a collection of DVD movies.
//********************************************************************

class DVDCollection {
	List<DVD> collection;
	private int count;
	private double totalCost;

	// -----------------------------------------------------------------
	// Constructor: Creates an initially empty collection.
	// -----------------------------------------------------------------
	public DVDCollection() {
		collection = new LinkedList<DVD>();
		count = 0;
		totalCost = 0.0;
	}

	// -----------------------------------------------------------------
	// Adds a DVD to the collection, increasing the size of the
	// collection array if necessary.
	// -----------------------------------------------------------------
	public void addDVD(String title, String director, int year, double cost,
			boolean bluRay) {
		/*
		 * if (count == collection.length)
			increaseSize();
		 */
		collection.add( new DVD(title, director, year, cost, bluRay) );
		totalCost += cost;
		count++;
	}

	// -----------------------------------------------------------------
	// Returns a report describing the DVD collection.
	// -----------------------------------------------------------------
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		String report = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		report += "My DVD Collection\n\n";

		report += "Number of DVDs: " + count + "\n";
		report += "Total cost: " + fmt.format(totalCost) + "\n";
		report += "Average cost: " + fmt.format(totalCost / count);

		report += "\n\nDVD List:\n\n";

		/*
		 * for (int dvd = 0; dvd < count; dvd++)
		 *
		 *	report += collection[dvd].toString() + "\n";
		 */
		Iterator<DVD> dvd = collection.listIterator();
		while(dvd.hasNext()){
			report += dvd.next().toString()+"\n";
		}
		return report;
	}

	// -----------------------------------------------------------------
	// Increases the capacity of the collection by creating a
	// larger array and copying the existing collection into it.
	// -----------------------------------------------------------------
	/*
	private void increaseSize() {
		DVD[] temp = new DVD[collection.length * 2];

		for (int dvd = 0; dvd < collection.length; dvd++)
			temp[dvd] = collection[dvd];

		collection = temp;
	}
	*/
}

// ********************************************************************
// DVD.java
// Represents a DVD video disc.
// ********************************************************************

class DVD {
	private String title, director;
	private int year;
	private double cost;
	private boolean bluRay;

	// -----------------------------------------------------------------
	// Creates a new DVD with the specified information.
	// -----------------------------------------------------------------
	public DVD(String title, String director, int year, double cost,
			boolean bluRay) {
		this.title = title;
		this.director = director;
		this.year = year;
		this.cost = cost;
		this.bluRay = bluRay;
	}

	// -----------------------------------------------------------------
	// Returns a string description of this DVD.
	// -----------------------------------------------------------------
	public String toString() {
		NumberFormat fmt = NumberFormat.getCurrencyInstance();

		String description;

		description = fmt.format(cost) + "\t" + year + "\t";
		description += title + "\t" + director;

		if (bluRay)
			description += "\t" + "Blu-Ray";

		return description;
	}
}

// ********************************************************************
// Movies.java
// Demonstrates the use of an array of objects.
// ********************************************************************

public class Movies {
	// -----------------------------------------------------------------
	// Creates a DVDCollection object and adds some DVDs to it. Prints
	// reports on the status of the collection.
	// -----------------------------------------------------------------
	public static void main(String[] args) {
		DVDCollection movies = new DVDCollection();

		movies.addDVD("The Godfather", "Francis Ford Coppala", 1972, 24.95,true);
		movies.addDVD("District 9", "Neill Blomkamp", 2009, 19.95, false);
		movies.addDVD("Iron Man", "Jon Favreau", 2008, 15.95, false);
		movies.addDVD("All About Eve", "Joseph Mankiewicz", 1950, 17.50, false);
		movies.addDVD("The Matrix", "Andy & Lana Wachowski", 1999, 19.95, true);

		System.out.println(movies);

		movies.addDVD("Iron Man 2", "Jon Favreau", 2010, 22.99, false);
		movies.addDVD("Casablanca", "Michael Curtiz", 1942, 19.95, false);

		System.out.println(movies);
	}
}
/*
 * The main program to test birthday paradox.
 */
package birthdayParadox;

public class BirthdayParadoxTest {
	public static void main(String[] args){
		long numberOfRuns = 1000000;
		int people1 = 23;
		int people2 = 57;
		BirthdayParadox p1 = new BirthdayParadox(people1, numberOfRuns);
		BirthdayParadox p2 = new BirthdayParadox(people1, numberOfRuns);
		BirthdayParadox p3 = new BirthdayParadox(people1, numberOfRuns);
		BirthdayParadox p4 = new BirthdayParadox(people2, numberOfRuns);
		BirthdayParadox p5 = new BirthdayParadox(people2, numberOfRuns);
		BirthdayParadox p6 = new BirthdayParadox(people2, numberOfRuns);
		System.out.println(people1+" people "+p1.runBirthdayParadox());
		System.out.println(people1+" people "+p2.runBirthdayParadox());
		System.out.println(people1+" people "+p3.runBirthdayParadox());
		System.out.println(people2+" people "+p4.runBirthdayParadox());
		System.out.println(people2+" people "+p5.runBirthdayParadox());
		System.out.println(people2+" people "+p6.runBirthdayParadox());
	}
}

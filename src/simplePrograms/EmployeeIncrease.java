/*
 * Program to read first name, last name, salary and percentage increase from file.
 * Writes to new file PayIncrease.txt the first name, last name and new salary.
 * Answered for : 
 * Answered on : 27/4/12
 */
package simplePrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * The Class EmployeeIncrease.
 */
public class EmployeeIncrease {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		try {
			Scanner input = new Scanner(new File("C:/temp/SpecialIncrease.txt"));
			FileOutputStream fos = new FileOutputStream(new File("C:/temp/PayIncrease.txt"));
			while(input.hasNext()){
				String line = input.nextLine();
				Scanner parser = new Scanner(line);
				String firstName = parser.next()+" ";
				String lastName = parser.next()+" ";
				float pay = Float.parseFloat(parser.next());
				float increment = Float.parseFloat(parser.next());
				Float newPay = pay * increment / 100 + pay;
				fos.write(firstName.getBytes());
				fos.write(lastName.getBytes());
				fos.write(newPay.toString().getBytes());
				fos.write("\n".getBytes());
			}
			fos.close();
			input.close();
			input = new Scanner(new File("C:/temp/PayIncrease.txt"));
			while(input.hasNext()){
				String line = input.nextLine();
				Scanner parser = new Scanner(line);
				String firstName = parser.next();
				String lastName = parser.next();
				String pay = parser.next();
				System.out.println("Name: "+firstName+" "+lastName);
				System.out.println(" Pay: "+pay);
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
}

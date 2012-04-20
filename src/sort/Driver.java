package sort;

//import java.util.Scanner;

public class Driver{
	public static void main(String[] args){
		//Scanner input = new Scanner(System.in);
		Employee myEmployees = new Employee(10);
		myEmployees.CreateTestData();
		//System.out.println(myEmployees.toString() + "\n");
		myEmployees.MergeSort();
		System.out.println(myEmployees.toString() + "\n");
	}
} 
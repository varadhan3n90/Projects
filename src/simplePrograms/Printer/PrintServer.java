/*
 * Creates a print server.
 * Initializes it with printer information from user.
 * User can add data to queue or search for file to print.
 * Answered on : 3/5/12
 */
package simplePrograms.Printer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PrintJobs{
	
	String fileName;
	int noOfPages;
	
	public PrintJobs(String fileName,int noOfPages){
		this.fileName = fileName;
		this.noOfPages = noOfPages;
	}
	
	public String getFileName(){
		return fileName;
	}
	public int getNoOfPages(){
		return noOfPages;
	}
	
}

class Printer{
	String name;
	int maxJobs;
	int currentlyUsed;	
	
	Queue<PrintJobs> q = new LinkedList<PrintJobs>();
	
	public String getPrinterName(){
		return name;
	}
	
	public int getMaxJobs(){
		return maxJobs;
	}
	
	public Printer(String name,int maxJobs){
		this.name = name;
		this.maxJobs = maxJobs;
		currentlyUsed = 0;
	}
	
	public void addJob(String fileName,int noOfPages){
		if(currentlyUsed< maxJobs){
			PrintJobs temp = new PrintJobs(fileName, noOfPages);
			q.add(temp);
			currentlyUsed++;
			System.out.println("Job added to queue");
		}else{
			System.out.println("Printer queue is full. Try some other printer.");
		}
		
	}
	
	public PrintJobs findJob(String name){
		for(PrintJobs j: q){
			if(j.getFileName().equalsIgnoreCase(name)){
				return j;
			}
		}
		return null;
	}
	
}

/**
 * The Class PrintServer.
 */
public class PrintServer {
	
	/** The p. */
	Printer p[] = new Printer[5];
	
	/** The input. */
	Scanner input = new Scanner(System.in);
	
	/**
	 * Instantiates a new prints the server.
	 */
	PrintServer(){
		for(int i=0;i<5;i++){
			System.out.println("Enter printer "+i+" name: ");
			String name = input.next();
			System.out.println("Enter maximum number of jobs for "+name+": ");
			int jobs = input.nextInt();
			p[i] = new Printer(name,jobs);
		}
		getUserChoice();
	}
	
	/**
	 * Find printer.
	 *
	 * @param printerName the printer name
	 * @return the printer
	 */
	public Printer findPrinter(String printerName){
		for(int i=0;i<5;i++){
			if(p[i].getPrinterName().equalsIgnoreCase(printerName)){
				return p[i];
			}
		}
		return null;
	}
	
	/**
	 * Find job.
	 *
	 * @param fileName the file name
	 * @return true, if successful
	 */
	public boolean findJob(String fileName){
		boolean jobFound = false;
		PrintJobs temp;
		for(int i=0;i<5;i++){
			if((temp=p[i].findJob(fileName))!=null){
				jobFound = true;
				System.out.println("Printer "+p[i].getPrinterName()+" has "+fileName+" in queue with "+temp.getNoOfPages()+" pages to print in file.");
			}
		}
		return jobFound;
	}
	
	/**
	 * Gets the user choice.
	 *
	 * @return the user choice
	 */
	public void getUserChoice(){
		boolean finished = false;
		System.out.println("1. Insert print job\n2. Search print job\n3. Exit");
		int choice = 0;
		while(!finished){
			System.out.println("Enter chocie: ");
			choice = input.nextInt();
			switch(choice){
			case 1:{
				System.out.println("Enter printer name: ");
				String printerName = input.next();
				Printer p = findPrinter(printerName);
				if(p==null){
					System.out.println("Printer not found..");
					break;
				}
				System.out.println("Enter file name: ");
				String fileName = input.next();
				System.out.println("Enter number of pages: ");
				int pages = input.nextInt();
				p.addJob(fileName, pages);
				break;
			}
			case 2:{
				System.out.println("Enter file name: ");
				String fileName = input.next();
				if(!findJob(fileName))
					System.out.println("Job not found");
				break;
			}
			case 3:
				System.out.println("Exiting");
				finished = true;
				break;
			}
		}
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		new PrintServer();
	}
}

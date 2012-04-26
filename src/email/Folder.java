package email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Folder implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2465772394543978448L;
	private String currentSortingMethod;
	private String name;
	private ArrayList<Email> emails;
	
	Folder(String name){
		this.name = name;
		this.currentSortingMethod = "date descending";
		emails = new ArrayList<Email>();
	}
	
	public void printContents(){
		int i=0;
		for(Email e : emails){
			System.out.println(i+"--> \nTo: "+e.getTo()+"\nSubject: "+e.getSubject()+"\nDate: "+e.getTimestamp().getTime());
			i++;
		}
	}
	
	public String getCurrentSortingMethod() {
		return currentSortingMethod;
	}
	public void setCurrentSortingMethod(String currentSortingMethod) {
		this.currentSortingMethod = currentSortingMethod;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Email> getEmails() {
		return emails;
	}
	public void setEmails(ArrayList<Email> emails) {
		this.emails = emails;
	}
	
	/**
	 * Adds an email to the folder according to the current sorting method.
	 * @param email
	 */
	public void addEmail(Email email){
		emails.add(email);
	}
	
	/**
	 * Removes an email from the folder by index.
	 * @param index
	 * @return
	 */
	public Email removeEmail(int index){
		Email e = null;
		if(index < emails.size()){
			 e = emails.remove(index);
		}
		return e;
	}
	
	/**
	 * Sorts the emails alphabetically by subject in ascending order.
	 */
	public void sortBySubjectAscending(){
		Comparator<Email> c = new Comparator<Email>() {			
			@Override
			public int compare(Email o1, Email o2) {				
				return o1.getSubject().compareTo(o2.getSubject());				
			}
		};
		Collections.sort(emails, c);
		
	}
	
	/**
	 * Sorts the emails alphabetically by subject in descending order.
	 */
	public void sortBySubjectDescending(){
		Comparator<Email> c = new Comparator<Email>() {			
			@Override
			public int compare(Email o1, Email o2) {				
				return o2.getSubject().compareTo(o1.getSubject());				
			}
		};
		Collections.sort(emails, c);
		
	}
	
	/**
	 * Sorts the emails by date in ascending order.
	 */
	public void sortByDateAscending(){
		Comparator<Email> c = new Comparator<Email>() {			
			@Override
			public int compare(Email o1, Email o2) {				
				return o1.getTimestamp().compareTo(o2.getTimestamp());				
			}
		};
		Collections.sort(emails, c);
		
	}

	/**
	 * Sorts the emails by date in descending order.
	 */
	public void sortByDateDescending(){
		Comparator<Email> c = new Comparator<Email>() {			
			@Override
			public int compare(Email o1, Email o2) {				
				return o2.getTimestamp().compareTo(o1.getTimestamp());				
			}
		};
		Collections.sort(emails, c);
		
	}
	 
	public Email getEmail(int index){
		return emails.get(index);
	}
	
	
}

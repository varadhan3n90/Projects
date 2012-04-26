/*
 * private Folder inbox
 *  Stores the inbox, which is a special folder which should never be allowed to be deleted or renamed. All new emails go here.
 * private Folder trash
 *  Stores the trash, which is a special folder which should never be allowed to be deleted or renamed. When an email is deleted, it is moved here.
 * private ArrayList<Folder> folders
 *  Stores all of the custom folders contained in the mailbox. (It can be any data collection, ArrayList is only an example)
 * public static Mailbox mailbox
 *  Stores the main mailbox that will used by the application. This mailbox should be instantiated in the main method. 
 */

/*
 * public void addFolder(Folder folder)
 *  Adds the given folder to the list of custom folders. Note: check to make sure a folder with that given name does not already exist. If it does, return an error in some manner.
 * public void deleteFolder(String name)
 *  Removes the given folder from the list of custom folders
 * public void composeEmail()
 *  Gets user input on the contents of the email and adds it to the inbox.
 * public void deleteEmail(Email email)
 *  Moves the email to the trash. (This method shouldn’t remove any emails from folders, the method removeEmail should be called and then deleteEmail is called on the result)
 * public void clearTrash()
 *  Removes all emails from the trash folder.
 * public void moveEmail(Email email, Folder target)
 *  Takes the given email and puts in in the given folder. If the folder cannot be found, instead move it to the Inbox. (Again, this method shouldn’t remove any emails from folders, the method removeEmail should be called and then moveEmail is called on the result)
 * public Folder getFolder(String name)
 *  Returns a folder by folder name. 
 */

package email;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Scanner;

public class MailBox implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5210419790075857795L;
	
	private Folder inbox;
	private Folder trash;
	private ArrayList<Folder> folders;
	public static MailBox mailbox;
	
	public ArrayList<Folder> getFolders(){
		if(folders==null){
			folders  = new ArrayList<Folder>();
		}
		return folders;
	}
	
	public Folder getInbox(){
		if(inbox==null){
			inbox = new Folder("Inbox");
		}
		return inbox;
	}
	
	public Folder getTrash(){
		if(trash==null){
			trash = new Folder("Trash");
		}
		return trash;
	}
	
	public void addFolder(Folder folder){
		//System.out.println("Add folder called.."+folder.getName());
		for(Folder f : getFolders()){
			if(f.getName().equalsIgnoreCase(folder.getName())){
				System.out.println("Folder already exists.");
				return;
			}
		}
		//System.out.println("Trying to add folder");
		folders.add(folder);
		System.out.println("Folder added");
	}
	
	public void deleteFolder(String name){
		
		Iterator<Folder> i = getFolders().listIterator();
		boolean found = false;
		while(i.hasNext()){
			Folder temp = i.next();
			if(temp.getName().equalsIgnoreCase(name)){
				i.remove();
				System.out.println("Folder removed");
				found = true;
				break;
			}
		}
		if(!found){
			System.out.println("Folder not found");
		}		
		
	}
	
	public void composeEmail(){
		Scanner input = new Scanner(System.in);
		Email e;
		System.out.println("To: ");
		String to = input.nextLine();
		System.out.println("CC: ");
		String cc = input.nextLine();
		System.out.println("Bcc: ");
		String bcc = input.nextLine();
		System.out.println("Subject: ");
		String subject = input.nextLine();
		System.out.println("Body: ");
		String body = input.nextLine();
		e = new Email(to, subject, body);
		e.setBcc(bcc);
		e.setCc(cc);
		GregorianCalendar timestamp = new GregorianCalendar();
		e.setTimestamp(timestamp);
		getInbox().addEmail(e);
		System.out.println("Email stored in inbox");
	}
	
	public void deleteEmail(Email email){
		getTrash().addEmail(email);
		System.out.println("Mail added to trash");
	}
	
	public void clearTrash(){
		getTrash().setEmails(new ArrayList<Email>());
		System.out.println("Trash cleared");
	}
	
	public Folder getFolder(String name){		
		for(Folder f : getFolders()){
			if(f.getName().equalsIgnoreCase(name))
				return f;
		}
		System.out.println("No such folder");
		return null;
	}
	
	public void moveEmail(Email email,Folder folder){
		for(Folder f : getFolders()){
			if(f.equals(folder)){
				folder.addEmail(email);
				System.out.println("Email moved to "+folder.getName());
				return;
			}
		}
		System.out.println("Folder not found.. Moving mail to inbox");
		inbox.addEmail(email);
	}
	
	
	
	
}

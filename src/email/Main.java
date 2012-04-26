/*
A – Add folder
 Prompts the user for folder name, and creates and adds a new folder with the specified name to the list of folders.
R – Remove folder
 Prompts the user for folder name and removes the folder if a folder with the given name exists.
C – Compose email
 Prompts the user for TO, CC, BCC, Subject, and then Body and creates a new email and adds it to the inbox.
F – View Folder
 Prompts the user for folder name, if the folder is found, the folder submenu is opened for that specific folder which displays all of the emails in the folder.
I – View Inbox
 Opens the folder submenu for the inbox.
T – View Trash
 Opens the folder submenu for the trash.
E – Empty Trash
 Empties the trash folder of all emails.
Q - Quit the program
 Remember to save the contents of the hash table to the file, "mailbox.obj".
 There is no option to load or save a file in the menu. This is because you should automatically search for a file named "mailbox.obj" upon startup, and save to the file when the user wishes to quit the program. 
 */


package email;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Main {
	static File f = new File("mail.obj");
	public static void main(String[] args){
		try{			
			if(!f.exists()){
				f.createNewFile();
				MailBox.mailbox = new MailBox();
			}else{
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream in = new ObjectInputStream(fis);
				MailBox.mailbox = (MailBox)in.readObject();
			}
			boolean finished = false;
			Scanner input = new Scanner(System.in);
			System.out.println("A - Add folder\nR - Remove folder\nC - Compose\nF - View folder\nI - Inbox\nT - Trash\nE - Empty trash\nQ - Quit");
			while(!finished){
				System.out.println("COMMAND: ");
				String command = input.next();
				command = command.toUpperCase();
				switch(command){
				case "A":{
					System.out.println("Enter folder name: ");
					String filename = input.next();
					System.out.println("Trying to create folder "+filename);
					Folder folder = new Folder(filename);
					MailBox.mailbox.addFolder(folder);
					break;
				}
				case "R":{
					System.out.println("Enter folder name: ");
					String foldername = input.next();
					MailBox.mailbox.deleteFolder(foldername);
					break;
				}
				case "C":{
					MailBox.mailbox.composeEmail();
					break;
				}
				case "F":{
					System.out.println("Enter folder name: ");
					String folderName = input.next();
					Folder folder = MailBox.mailbox.getFolder(folderName);
					if(folder!=null){
						floderSubmenu(folder);
					}
					break;
				}
				case "I":{
					floderSubmenu(MailBox.mailbox.getInbox());
					break;
				}
				case "E":{
					MailBox.mailbox.clearTrash();
					System.out.println("Cleared trash");
					break;
				}
				case "Q":{
					finished = true;
					FileOutputStream fos = new  FileOutputStream(f);
					ObjectOutputStream out = new ObjectOutputStream(fos);
					out.writeObject(MailBox.mailbox);
					break;
				}
				default:
					System.out.println("No such option.");
				}
			}
			
			
		}catch(Exception e){
			System.out.println("Error in program");
			e.printStackTrace();
			if(f.exists()){
				f.delete();
			}
		}
	}

	private static void floderSubmenu(Folder f) {		
		boolean finished = false;
		f.printContents();
		System.out.println("M - Move email\nD - Delete email\nV - View email\nSA - Sort ascending by subject\nSD - Sort descending by subject");
		System.out.println("DA - Sort ascending by date\nDD - Sort descending by date\nR - return to main menu");
		Scanner input = new Scanner(System.in);
		while(!finished){
			System.out.println("FOLDER COMMAND: ");
			String command = input.next();
			command = command.toUpperCase();
			switch(command){
			case "M":{
				System.out.println("Enter email index: ");
				int index = input.nextInt();
				Email e = f.getEmail(index);
				if(e==null){
					System.out.println("Email index does not exist");
					break;
				}
				System.out.println("Enter folder name to move to (Folders can also be inbox and trash): ");
				String foldername = input.next();
				if(foldername.equalsIgnoreCase("inbox")){
					MailBox.mailbox.getInbox().addEmail(e);
					f.removeEmail(index);
					System.out.println("Mail added to inbox");
				}else if(foldername.equalsIgnoreCase("trash")){
					MailBox.mailbox.getTrash().addEmail(e);
					System.out.println("Mail added to trash");
					f.removeEmail(index);
				}
				Folder folder = MailBox.mailbox.getFolder(foldername);
				if(folder==null)
					break;
				else{
					folder.addEmail(e);
					System.out.println("Email added to "+folder.getName());
					f.removeEmail(index);
				}
			}
			case "D":{
				System.out.println("Enter email index: ");
				int index = input.nextInt();
				Email e = f.getEmail(index);
				if(e==null){
					System.out.println("Email index does not exist");
					break;
				}
				f.removeEmail(index);
				break;
			}
			case "V":{
				System.out.println("Enter email index: ");
				int index = input.nextInt();
				Email e = f.getEmail(index);
				if(e==null){
					System.out.println("Email index does not exist");
					break;
				}else{
					System.out.println("To: "+e.getTo()+" CC: "+e.getCc()+" Bcc: "+e.getBcc());
					System.out.println("Date: "+e.getTimestamp().getTime());
					System.out.println("Subject: "+e.getSubject());
					System.out.println("Body: "+e.getBody());
				}
				break;
			}
			case "SA":{
				f.sortBySubjectAscending();
				f.printContents();
				break;
			}
			case "SD":{
				f.sortBySubjectDescending();
				f.printContents();
				break;
			}
			case "DA":{
				f.sortByDateAscending();
				f.printContents();
				break;
			}
			case "DD":{
				f.sortByDateDescending();
				f.printContents();
				break;
			}
			case "R":{
				finished = true;
				break;
			}
			default:
				System.out.println("Invalid choice");
			}
		}

		
	}
	
	
}
/*
 M – Move email
Prompts the user for email index and then displays a list of folders and asks the user to input the name of the folder to move to. If the specified folder was not found, cancel the entire operation. User should be able to move to Inbox, Trash, and the current folder.
D – Delete email
Prompts the user for email index and moves the email to the trash folder.
V – View email contents
Prompts the user for email index and prints the information about the corresponding email.
SA – Sort by subject ascending
Sorts the emails by subject in ascending order.
SD – Sort by subject descending
Sorts the emails by subject in descending order.
DA – Sort by date ascending
Sorts the emails by date in ascending order.
DD – Sort by date descending
Sorts the emails by date in descending order.
R – Return to main menu 
 */

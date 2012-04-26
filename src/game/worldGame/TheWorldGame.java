/*
 * This is a command line game where there is a world.
 * You are a person in the world with inventory.
 * World has rooms with items that can be picked and dropped.
 * This is REPL command line game.
 * Commands available
 *  Look
 *  Inv
 *  Examine <item name>
 *  Get <item name>
 *  Drop <item name>
 *  Go <direction> 
 *  Quit 
 *  
 *  For details about commands see package.html
 * 
 * Game created for : http://www.cramster.com/answers-apr-12/computer-science/inventory-game-java-overview-earliest-computer-games-text-bas_2460761.aspx
 * Completed on 26/4/12
 * 
 */
package game.worldGame;

import game.worldGame.Direction.direction;

import java.util.Iterator;
import java.util.Scanner;


/**
 * The Class TheWorldGame.
 */
public class TheWorldGame {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		// Used to get command for user
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to THE WORLD");
		/*
		 * Create a new world. Rooms are predefined in world
		 */
		World w = new World();
		/*
		 * Variable to check game completion
		 */
		boolean finished = false;
		
		// Display available commands
		System.out.println("Commands available:\n Look\n Inv\n Examine <item name>\n Get <item name>\n Drop <item name>\n Go <direction>\n Quit ");
		
		while(!finished){
			
			System.out.print("COMMAND: ");
			String command = input.nextLine();
			
			// Used to get additional arguments when required
			Scanner sc = new Scanner(command);
			
			// First word entered should be a command
			String cmd = sc.next();
			
			
			switch(cmd.toLowerCase()){
			
			case "look":{
				Room r = w.getCurrentRoom();
				System.out.println(r.look());
				break;
			}
			
			case "inv":{
				Inventory i = w.inventory;
				System.out.println(i.inv());
				break;
			}
			
			
			case "examine":{
				if(!sc.hasNext()){
					System.out.println("Examine what? Examine: <item name>");
					break;
				}
				String itemName = sc.next();
				Room r = w.getCurrentRoom();
				Inventory i = w.inventory;
				for(Item item : r.items){
					if(item.getName().equalsIgnoreCase(itemName)){
						System.out.println(item.getDescription());
					}
				}
				for(Item item : i.items){
					if(item.getName().equalsIgnoreCase(itemName)){
						System.out.println(item.getDescription());
					}
				}
				break;
			}
			
			case "get":{
				if(!sc.hasNext()){
					System.out.println("Get what? Get <item name>");
					break;
				}
				String itemName = sc.next();
				Room r = w.getCurrentRoom();
				boolean found = false;
				Iterator<Item> i = r.items.listIterator();
				while(i.hasNext()){
					Item temp = i.next();
					if(temp.getName().equalsIgnoreCase(itemName)){
						w.inventory.addItem(temp);
						i.remove();
						System.out.println("Item added to inventory");
						found = true;
						break;
					}
				}
				if(!found)
					System.out.println("No such item in room");
				break;
			}
			
			case "drop":{
				if(!sc.hasNext()){
					System.out.println("Drop what? Drop <item name>");
					break;
				}
				String itemName = sc.next();
				Room r = w.getCurrentRoom();
				Inventory invent = w.inventory;
				Iterator<Item> i = invent.items.listIterator();
				boolean found = false;
				while(i.hasNext()){
					Item temp = i.next();
					if(temp.getName().equalsIgnoreCase(itemName)){
						r.addItem(temp);
						i.remove();
						System.out.println("Item dropped in room");
						found = true;
						break;
					}
				}
				if(!found)
					System.out.println("No such item in inventory");
				break;
			}
			
			case "go":{
				if(!sc.hasNext()){
					System.out.println("Go where? GO <direction name ie NORTH, SOUTH etc>");
					break;
				}
				String dir = sc.next();
				boolean entered = true;
				dir = dir.toUpperCase();				
				switch(dir){
					case "NORTH":
						w.go(direction.NORTH);
						break;
					case "SOUTH":
						w.go(direction.SOUTH);
						break;
					case "EAST":
						w.go(direction.EAST);
						break;
					case "WEST":
						w.go(direction.WEST);
						break;
					default:
						System.out.println("No such direction");
						entered = false;
				}				
				if(entered){
					Room r = w.getCurrentRoom();
					System.out.println(r.look());
				}
				break;
			}
			
			case "quit":{
				finished = true;
				break;
			}
			
			default:
				System.out.println("Invalid command. Commands available ");
				System.out.println(" Look\n Inv\n Examine <item name>\n Get <item name>\n Drop <item name>\n Go <direction>\n Quit ");
			}
			
		}
	}
}

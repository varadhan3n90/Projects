/*
 * World has rooms.
 * Create rooms and a current room initialized to a room.
 * Create an inventory.
 * Move from one room to other
 * 
 */
package game.worldGame;

import game.worldGame.Direction.direction;

/**
 * The Class World.
 */
public class World {
	
	/** The living room. */
	Room livingRoom = new Room("Living room","This is a living room. I’m not sure why they call it a living room, because clearly nobody is living in it.");
	
	/** The kitchen. */
	Room kitchen = new Room("Kitchen","Nothing to do with me");
	
	/** The dining room. */
	Room diningRoom = new Room("Dining room","Always thinking of eating");
	
	/** The bath room. */
	Room bathRoom = new Room("Bath room","Time for a nice bath!!!");
	
	/** The foyer. */
	Room foyer = new Room("Foyer","Blah..Blah.. You know what this is");
	
	/** The couch. */
	Item couch = new Item("Couch","People sit on this");
	
	/** The television. */
	Item television = new Item("TV","Idiot box");
	
	/** The knife. */
	Item knife = new Item("Knife","Never seen it before");
	
	/** The fridge. */
	Item fridge = new Item("Fridge","Who needs it anyway");
	
	/** The table. */
	Item table = new Item("Table","Must be of some use");
	
	/** The plate. */
	Item plate = new Item("Plate","Its so dirty");
	
	/** The brush. */
	Item brush = new Item("Brush","Dont think i can paint with this");
	
	/** The soap. */
	Item soap = new Item("Soap","bubble.");
	
	/** The mat. */
	Item mat = new Item("Mat","Lying there always");
	
	/** The bat. */
	Item bat = new Item("Bat","Which game are we playing?");
	
	/** The current room. */
	Room currentRoom = livingRoom;
	
	/** The inventory. */
	Inventory inventory = new Inventory();
	
	/**
	 * Instantiates a new world.
	 */
	World(){
		
		livingRoom.addItem(couch);
		livingRoom.addItem(television);
		
		kitchen.addItem(knife);
		kitchen.addItem(fridge);
		
		diningRoom.addItem(table);
		diningRoom.addItem(plate);
		
		bathRoom.addItem(brush);
		bathRoom.addItem(soap);
		
		foyer.addItem(mat);
		foyer.addItem(bat);
		
		livingRoom.addAdjacentRooms(kitchen, direction.WEST);
		kitchen.addAdjacentRooms(livingRoom, direction.EAST);
		
		livingRoom.addAdjacentRooms(foyer, direction.NORTH);
		foyer.addAdjacentRooms(livingRoom, direction.SOUTH);
		
		kitchen.addAdjacentRooms(foyer, direction.SOUTH);
		foyer.addAdjacentRooms(kitchen, direction.NORTH);
		
		foyer.addAdjacentRooms(bathRoom, direction.EAST);
		bathRoom.addAdjacentRooms(foyer, direction.WEST);
				
	}
	
	/**
	 * Sets the current room.
	 *
	 * @param room the new current room
	 */
	public void setCurrentRoom(Room room){
		if(room!=null){
			this.currentRoom = room;
		}else
			System.out.println("No room in this direction");
	}
	
	/**
	 * Gets the current room.
	 *
	 * @return the current room
	 */
	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	/**
	 * Go to the required room in given direction.
	 *
	 * @param dir the dir
	 */
	public void go(direction dir){
		Room r = currentRoom.getAdjacentRoom(dir);
		setCurrentRoom(r);
	}
}

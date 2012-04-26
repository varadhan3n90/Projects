/*
 * 
 */
package game.worldGame;

import game.worldGame.Direction.direction;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;


/**
 * The Class Room.
 */
public class Room {
	
	/** The name. */
	String name;
	
	/** The description. */
	String description;
	
	/** The items. */
	List<Item> items;
	
	/** The WEST. */
	Room NORTH,SOUTH,EAST,WEST;
	
	/**
	 * Instantiates a new room.
	 *
	 * @param name the name
	 * @param description the description
	 */
	Room(String name,String description){
		this.name = name;
		this.description = description;
		items = new ArrayList<Item>();
	}
	
	/**
	 * Adds the item.
	 *
	 * @param item the item
	 */
	public void addItem(Item item){
		items.add(item);
	}
	
	/**
	 * Adds the adjacent rooms.
	 *
	 * @param room the room
	 * @param d the d
	 */
	public void addAdjacentRooms(Room room,direction d){
		if(d==direction.EAST)
			EAST = room;
		if(d==direction.WEST)
			WEST = room;
		if(d==direction.SOUTH)
			SOUTH = room;
		if(d==direction.NORTH)
			NORTH = room;
	}
	
	/**
	 * Look.
	 *
	 * @return the string
	 */
	public String look(){
		String value = new String();
		value = "\nName: "+name;
		value += "\nDescription: "+description;
		value += "\nItems available\n";
		if(items.size()==0){
			value += "nothing available";
		}else{
			Iterator<Item> i = items.listIterator();
			while(i.hasNext()){
				Item temp = i.next();
				value += "\n Item name: "+temp.getName();
				value += "\n Item description: "+temp.getDescription();
			}
		}
		return value;
	}
	
	/**
	 * Gets the adjacent room in given direction.
	 *
	 * @param d the d
	 * @return the adjacent room
	 */
	public Room getAdjacentRoom(direction d){
		if(d==direction.EAST)
			return EAST;
		if(d==direction.WEST)
			return WEST;
		if(d==direction.SOUTH)
			return SOUTH;
		if(d==direction.NORTH)
			return NORTH;
		return null;
	}
	
}

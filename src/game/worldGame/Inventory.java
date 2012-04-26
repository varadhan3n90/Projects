/*
 * 
 */
package game.worldGame;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class Inventory.
 */
public class Inventory {
	
	/** The items. */
	List<Item> items = new ArrayList<Item>();
	
	/**
	 * Inv.
	 *
	 * @return the string
	 */
	public String inv(){
		String value = "\nNo items in inventory";
		if(!items.isEmpty())
			value = "";
		for(Item i : items){
				value += "\nName: "+i.name;
				value += "\n Description: "+i.description;
		}
		return value;
	}
	
	/**
	 * Adds the item.
	 *
	 * @param e the e
	 */
	public void addItem(Item e){
		items.add(e);
	}
	
}

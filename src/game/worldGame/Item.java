/*
 * Items have names and descriptions
 */
package game.worldGame;


/**
 * The Class Item.
 */
public class Item {
	
	/** The name. */
	String name;
	
	/** The description. */
	String description;
	
	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName(){
		return name;		
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription(){
		return description;
	}
	
	/**
	 * Instantiates a new item.
	 *
	 * @param name the name
	 * @param description the description
	 */
	public Item(String name, String description){
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Look.
	 */
	public void look(){
		
	}
	
}

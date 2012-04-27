/*
 * Answered at : http://www.cramster.com/answer/edit/2440231/0?rec=0
 * Program to simulate Mp3 player with list of songs.
 * Driver program not written.
 * 
 */

package classesDemo;

import java.util.ArrayList;
import java.util.Iterator;
/**
 * The song class.
 * @author Varadhan
 * 
 */

class Song{
	float fileSize;
	String title;
	String artist;
	float length;		// length is same as duration
	
	public Song(String title,String artist,float length,int fileSize){
		this.title = title;
		this.artist = artist;
		this.length = length;
		this.fileSize = fileSize;
	}
	/**
	 * Accessor methods for title, artist and length
	 * 
	 */
	public String getTitle(){
		return title;
	}
	
	public String getArtist(){
		return artist;
	}
	
	public float getLength(){
		return length;
	}
	
	public float getFileSize(){
		return fileSize;
	}
	
}

/**
 * The Class Mp3_Player.
 */
public class Mp3_Player {
	
	/** The list of songs that will be in Mp3 player. */
	ArrayList<Song> list = new ArrayList<Song>();
	
	/** The current storage capacity. */
	int storageCapacity = 0;
	
	/** The total capacity. */
	int totalCapacity = 0;	 
	
	/* 
	 * Returns the contents of object
	 */
	public String toString(){
		String value = "Capacity "+totalCapacity+", "+storageCapacity+"used"+"\n";
		value += "List of songs\n";
		Iterator<Song> i = list.iterator();
		while(i.hasNext()){
			Song s = i.next();
			value += s.getTitle()+" by "+s.getArtist()+" lasts "+s.getLength()+" and is "+s.getFileSize()+" mb large."+"\n";
		}
		return value;
	}
	
	/**
	 * Free space left.
	 *
	 * @return the int
	 */
	int freeSpace(){
		return storageCapacity;
	}
	
	/**
	 * Gets the total storage capacity.
	 *
	 * @return the total storage capacity
	 */
	int getStorageCapacity(){
		return totalCapacity;
	}
	
	/**
	 * Instantiates a new mp3_ player.
	 */
	public Mp3_Player(){
		this.totalCapacity = this.storageCapacity = 10;
	}
	
	/**
	 * Instantiates a new mp3_ player.
	 *
	 * @param capacity the capacity
	 */
	public Mp3_Player(int capacity){
		this.totalCapacity = capacity;
		this.storageCapacity = capacity;
	}
	
	/**
	 * Adds the song if file size is less than storage remaining.
	 *
	 * @param song the song
	 */
	public void addSong(Song song){
		if( (storageCapacity - song.fileSize) > 0 ){
			list.add(song);
			storageCapacity -= song.fileSize;
			System.out.println(song.title+" added to Mp3 player.");
		}
		else
			System.out.println("Storage capacity limit reached. Song cannot be added");
	}
	
	/**
	 * Play song.
	 *
	 * @param position the position
	 */
	public void playSong(int position){
		if(position < list.size()){
			Song s = list.get(position);
			System.out.println("Playing "+s.title+" by "+s.artist);
			for(float i=0.1f;i<s.length;i+=0.1){
				System.out.println("Playing positioin "+i);
			}
		}else{
			System.out.println("Position not present in list");
		}
	}
	
	
	/**
	 * Removes the song.
	 *
	 * @param song the song
	 */
	public void removeSong(Song song){
		if(list.contains(song)){
			storageCapacity -= storageCapacity - song.fileSize;
			list.remove(song);
			System.out.println("Song removed. Remaining capacity "+storageCapacity);
		}else{
			System.out.println("Song not found error.");
		}
	}
	
	
	
}

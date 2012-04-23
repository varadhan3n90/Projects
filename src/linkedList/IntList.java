/*
 * Program to create linked list in java.
 * IntNode is a class that is similar to a node of linked list in C defined using structure.
 * Dummy head node is used in program.
 * 
 * Answered for :http://www.cramster.com/answers-apr-12/computer-science/javalinked-list-integers-guys-im-trouble-java-task-im_2450451.aspx
 * 
 */

package linkedList;

// TODO: Auto-generated Javadoc
class IntNode{
	
	private IntNode next;
	private int data;
	/** Constructor to create a new node. Node must contain value for data*/
	public IntNode(int data){
		this.data = data;
		next = null;
	}
	/** Used to change data stored in node */
	public void changeData(int data){
		this.data = data;
	}
	/**
	 * Returns the data stored in node
	 * @return data
	 */
	public int getData(){
		return data;
	}
	/**
	 * Returns the next node in linked list
	 * @return next IntNode
	 */
	public IntNode getNextNode(){
		return next;
	}
	/**
	 * Use to change the next node of the current node
	 * @param next node
	 */
	public void setNextNode(IntNode next){
		this.next = next;
	}
	
}

/**
 * The Class IntList.
 */
public class IntList {
	
	/** The dummy head node. Not used to store any user data */
	private IntNode head;
	
	/**
	 * Instantiates a new int list.
	 */
	IntList(){
		head = new IntNode(0);		
	}
	
	/**
	 * Adds the to front. Creates a new node with given value.
	 * Sets the next value to value pointed by head.
	 * Changes head to point to new node.
	 *
	 * @param val the val
	 */
	public void addToFront(int val){
		IntNode temp = new IntNode(val);
		temp.setNextNode(head.getNextNode());
		head.setNextNode(temp);
	}
	
	/**
	 * Adds the to end.
	 * Traverse the list and add to end.
	 * @param val the val
	 */
	public void addToEnd(int val){
		IntNode temp = head;
		while(temp.getNextNode()!=null){
			temp = temp.getNextNode();
		}
		IntNode newNode = new IntNode(val);		
		temp.setNextNode(newNode);
	}
	
	/**
	 * Removes the first.
	 * Make head point to next element.
	 */
	public void removeFirst(){
		IntNode temp = head.getNextNode();
		head.setNextNode(temp.getNextNode());
		System.out.println("Removed "+temp.getData()+" from IntList");
	}
	
	/**
	 * Prints the values in linked list.
	 */
	public void print(){
		IntNode temp = head;
		System.out.println("Data in IntList");
		while(temp.getNextNode()!=null){
			temp = temp.getNextNode();
			System.out.println(temp.getData());
		}
	}
	
	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public int getLength(){
		int length = 0;
		IntNode temp = head;		
		while(temp.getNextNode()!=null){
			temp = temp.getNextNode();
			length ++;
		}
		return length;
	}
	
	/**
	 * Removes the last element in list.
	 */
	public void removeLast(){
		IntNode temp = head;
		IntNode prev = null;
		System.out.println("Data in IntList");
		while(temp.getNextNode()!=null){
			prev = temp;
			temp = temp.getNextNode();			
		}
		if(prev!=head){
			prev.setNextNode(null);
		}		
	}
	
	public String toString(){
		String values="";
		IntNode temp = head;		
		while(temp.getNextNode()!=null){
			temp = temp.getNextNode();
			values += temp.getData()+ " ";
		}
		return values;
	}
	
	/**
	 * Replace old value in list with new value if any match.
	 *
	 * @param oldData the old data
	 * @param newData the new data
	 */
	public void replace(int oldData,int newData){
		IntNode temp = head;		
		while(temp.getNextNode()!=null){
			temp = temp.getNextNode();
			if(temp.getData()==oldData){
				temp.changeData(newData);
			}
		}
	}
	
}

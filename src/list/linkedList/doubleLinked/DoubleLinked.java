/*
 * Program for doubly linked list in java
 * 
 * head <=> x <=> y <=> z <=> .... <=> n <=> null
 * 
 * Answered for : http://www.cramster.com/answers-apr-12/computer-science/javadoubly-linked-lists-hey-guys-java-task-today-tr_2455289.aspx
 * Answered on : 24/4/12
 */

package list.linkedList.doubleLinked;


class IntNode{
	
	private IntNode next;
	private IntNode prev;
	
	private int data;
	
	/** Constructor to create a new node. Node must contain value for data*/
	public IntNode(int data){
		this.data = data;
		next = null;
		prev = null;
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
	
	/**
	 * Returns the previous node in linked list
	 * @return next IntNode
	 */
	public IntNode getPrevNode(){
		return prev;
	}
	
	/**
	 * Use to change the previous node of the current node
	 * @param next node
	 */
	public void setPrevNode(IntNode prev){
		this.prev = prev;
	}
	
}

/**
 * The Class DoubleLinked.
 */
public class DoubleLinked {
		
	/** The head node. Dummy node for reference. */
	IntNode head;
	
	/**
	 * Instantiates a new double linked.
	 */
	public DoubleLinked(){
		head = new IntNode(0);
	}
	
	/**
	 * Adds the to front of list.
	 *
	 * @param val the value to be added in list
	 */
	public void addToFront(int val){
		IntNode newNode = new IntNode(val);
		newNode.setNextNode(head.getNextNode());
		newNode.setPrevNode(head);
		head.setNextNode(newNode);
	}
	
	/**
	 * Adds the to end.
	 *
	 * @param val the value to be added at end of list.
	 */
	public void addToEnd(int val){
		IntNode newNode = new IntNode(val);
		IntNode temp = head;
		while(temp.getNextNode()!=null){
			temp = temp.getNextNode();
		}
		temp.setNextNode(newNode);
		newNode.setPrevNode(temp);
	}
	
	/**
	 * Prints the doubly linked list.
	 */
	public void print(){
		IntNode temp = head.getNextNode();		
		while(temp!=null){			
			System.out.println(temp.getData());
			temp = temp.getNextNode();
		}
	}
	
	/**
	 * Removes the first node in the list.
	 */
	public void removeFirst(){
		IntNode temp = head.getNextNode();
		if(head.getNextNode()==null)
			return;
		head.setNextNode(temp.getNextNode());
		if(temp.getNextNode()!=null){
			temp.getNextNode().setNextNode(head);
		}
	}
	
	/**
	 * Removes the last last node in the list.
	 */
	public void removeLast(){
		IntNode temp = head;
		while(temp.getNextNode()!=null){
			temp = temp.getNextNode();
		}
		if(temp!=head){
			temp.getPrevNode().setNextNode(null);
		}
	}
	
	/**
	 * Removes the first occurrence of the given value in list.
	 *
	 * @param oldval the value to be removed from list.
	 */
	public void remove(int oldval){
		IntNode temp = head.getNextNode();
		while(temp!=null){
			if(temp.getData()==oldval){
				System.out.println("Value found. Removing node.");
				IntNode prev = temp.getPrevNode();
				IntNode next = temp.getNextNode();
				prev.setNextNode(next);
				if(next!=null){
					next.setPrevNode(prev);
				}
				break;
			}
			temp = temp.getNextNode();
		}
	}
}

/*
 * Simple classes to demonstrate inheritance.
 * Answered for : http://www.cramster.com/answers-apr-12/computer-science/java-write-java-program-superclass-animal_2454315.aspx
 */

package classesDemo;
/**
 * The superclass animal 
 *
 */
class Animal{
	int total_distance = 0;
	public int move(){
		return 0;
	}
}

class Bird extends Animal{
	/**
	 * Birds can move 10 feet in 1 second
	 */
	public int move(){
		total_distance += 10;
		return total_distance;
	}
}

class Frog extends Animal{
	/**
	 * Frog can move 8 feet in 1 second
	 */
	public int move(){
		total_distance += 8;
		return total_distance;
	}
}

class Fish extends Animal{
	/**
	 * Fish can move 6 feet in 1 second
	 */
	public int move(){
		total_distance += 6;
		return total_distance;
	}
}

class Mouse extends Animal{
	/**
	 * Mouse can move 4 feet in 1 second
	 */
	public int move(){
		total_distance += 4;
		return total_distance;
	}
}

public class MoveAnimals {	
	public static void main(String args[]){
		Animal myBird = new Bird();
		Animal myFish = new Fish();
		Animal myMouse = new Mouse();
		Animal myFrog = new Frog();
		System.out.println("Moving animals");
		for(int i=0;i<10;i++){
			System.out.println("After "+(i+1)+" seconds ");
			System.out.println("Bird has moved "+myBird.move()+" feet.");
			System.out.println("Frog has moved "+myFrog.move()+" feet.");
			System.out.println("Fish has moved "+myFish.move()+" feet.");
			System.out.println("Mouse has moved "+myMouse.move()+" feet.");
		}
	}
	
}

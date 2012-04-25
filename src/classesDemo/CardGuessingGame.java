/*
 * The goal of this game is to allow two players (in this case, a player and a computer) to each pick two cards at random, 
 * and count the total value of their cards. If the player has a higher total than the computer, the player wins.
 * If the computer has a higher total than the player or if their totals are even, the player loses.
 * The game continues until the player chooses to quit.
 * This game consists of three main classes: CardGuessingGame, Player and Card.
 * The Player class is used to instantiate Player objects, which keep track of a player’s name and which two cards they currently hold. 
 * When a player is instantiated, it accepts a value for their name and sets their card references to null. 
 * A player can be supplied two cards through the Player class’s acceptDeal(...)method. 
 * A player can return the combined numerical value of its cards as the return value of its getHandStrength() method. 
 * A Player object can also return a String representation of itself (i.e. of its state) including any cards they are currently holding as the return value of its toString() method.
 * The CardGuessingGame class is provided to show how two Player objects compete in the guessing game. 
 * You will need to re-use the Card class that you created in Lab 7 so that a Player can assess the sum of the numerical value of its cards using the Card class’s getValue() method.
 * 
 *  Question : http://www.cramster.com/answers-apr-12/computer-science/card-guessing-java-class-create-card-guessing-game-multiple-classes-goa_2460023.aspx
 *  Answered on : 25/4/12
 */



package classesDemo;

import java.util.Random;
import java.util.Scanner;

/**
 * The class Player 
 */
class Player{
	
	/**
	 * Player has name and two cards
	 */
	String name;
	Card card1,card2;
	
	/**
	 * Instantiates player with name
	 * @param name
	 */
	Player(String name){
		this.name = name;
		card1 = null;
		card2 = null;
	}
	
	/**
	 * Randomly sets the value of two cards between 1 and 13
	 */
	public void acceptDeal(){
		Random r = new Random();
		int value = r.nextInt(13) + 1;
		card1 = new Card(value);
		value = r.nextInt(13) + 1;
		card2 = new Card(value);
	}
	
	/**
	 * Sum of the values in two cards
	 * @return the sum
	 */
	public int getHandStrength(){
		int strength = card1.getValue() + card2.getValue();
		return strength;
	}
	/**
	 * Gets the values in two cards as String
	 */
	public String toString(){
		String cards = new String();
		cards = "Card 1: "+card1.getValue()+"\nCard 2: "+card2.getValue();
		return cards;
	}
}
/**
 * The class Card
 *
 */
class Card{
	
	int value;
	/**
	 * Sets the card value
	 * @param value
	 */
	Card(int value){
		this.value = value % 14;
		value=value==0?1:value;
	}
	
	public int getValue(){
		return value;
	}
}

/**
 * The Class CardGuessingGame.
 */
public class CardGuessingGame {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args){
		boolean finished = false;
		Scanner input = new Scanner(System.in);
		System.out.println("Enter player name: ");
		String name = input.next();		
		Player p1 = new Player(name);					// Create a player
		Player computer = new Player("Computer");		// Create computer as 2nd player
		while(!finished){
			p1.acceptDeal();
			computer.acceptDeal();
			System.out.println("1. Show cards in hand\n2. Winner\n3. Exit");
			int choice = input.nextInt();
			switch(choice){
			case 1:
				System.out.println("Value of cards: \n"+p1.toString());
				break;
			case 2:
				Player winner = p1.getHandStrength() > computer.getHandStrength() ? p1 : computer;
				System.out.println("Winner is "+winner.name);
				System.out.println("Your card values\n"+p1.toString()+"\nComputer card values\n"+computer.toString());
				break;
			case 3:
				finished = true;
				break;
			default:
				System.out.println("No such choice");
			}
		}
		
	}
}

/*
 * Simple program for inheritance.
 * Answered for : http://www.cramster.com/answers-may-12/computer-science/write-java-program-normal-0-false-false-false_2511401.aspx
 * Answered on : 6/5/12
 */
package simplePrograms;

class Pet{
	
	String name;
	int age;
	int weight;
	
	public Pet(){
		this.name = "Unknown";
		age = 0;
		weight = 0;
	}
	
	public Pet(String name,int age,int weight){
		this.age = age;
		this.name = name;
		this.weight = weight;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public void writeOutput(){
		System.out.println("Name: "+name+"\nAge: "+age+"\nWeight: "+weight);
	}
	
}

/**
 * The Class Dog.
 */
public class Dog extends Pet{
	
	/** The breed. */
	String breed;
	
	/** The booster shot. */
	boolean boosterShot;
	
	/** The owner. */
	String owner;
	
	/**
	 * Instantiates a new dog.
	 */
	public Dog(){
		super();
		breed = "None";
		owner= "Unknown";
		boosterShot = false;
	}
	
	/**
	 * Instantiates a new dog.
	 *
	 * @param name the name
	 * @param age the age
	 * @param weight the weight
	 * @param breed the breed
	 * @param owner the owner
	 * @param boosterShot the booster shot
	 */
	public Dog(String name,int age,int weight,String breed,String owner,boolean boosterShot){
		super(name,age,weight);		
		this.breed = breed;
		this.owner = owner;
		this.boosterShot = boosterShot;
	}
	
	/**
	 * Instantiates a new dog.
	 *
	 * @param name the name
	 * @param age the age
	 * @param weight the weight
	 * @param owner the owner
	 * @param breed the breed
	 */
	public Dog(String name,int age,int weight,String owner,String breed){
		super(name,age,weight);
		this.owner = owner;
		this.breed = breed;
		this.boosterShot = false;
	}
	
	/* (non-Javadoc)
	 * @see simplePrograms.Pet#writeOutput()
	 */
	public void writeOutput(){
		super.writeOutput();
		System.out.println("Owner: "+owner+"\nBreed: "+breed+"\nBooster shot given? "+boosterShot);
		
	}

	/**
	 * Gets the breed.
	 *
	 * @return the breed
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * Checks if is booster shot.
	 *
	 * @return true, if is booster shot
	 */
	public boolean isBoosterShot() {
		return boosterShot;
	}

	/**
	 * Gets the owner.
	 *
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the breed.
	 *
	 * @param breed the new breed
	 */
	public void setBreed(String breed) {
		this.breed = breed;
	}

	/**
	 * Sets the booster shot.
	 *
	 * @param boosterShot the new booster shot
	 */
	public void setBoosterShot(boolean boosterShot) {
		this.boosterShot = boosterShot;
	}

	/**
	 * Sets the owner.
	 *
	 * @param owner the new owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	/**
	 * Reset.
	 */
	public void reset(){
		super.setAge(0);
		super.setName("Unknown");
		super.setWeight(0);
		setBoosterShot(false);
		setOwner("Unknown");
		setBreed("None");
	}
	
	/**
	 * Reset breed.
	 */
	public void resetBreed(){
		setBreed("None");
	}
	
	/**
	 * Reset booster shot.
	 */
	public void resetBoosterShot(){
		setBoosterShot(false);
	}
	
	/**
	 * Reset owner.
	 */
	public void resetOwner(){
		setOwner("Unknown");
	}
}

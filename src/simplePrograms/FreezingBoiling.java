package simplePrograms;

import java.util.Scanner;

public class FreezingBoiling {
	
	/*
	 *  Ethyl Alcohol 2173 172
	 *	Oxygen 2362 2306
	 *	Water 32 212 
	 */
	int temperature;
	
	int ethylBoiling = 172;
	int oxygenBoiling = 2306;
	int waterBoiling = 212;
	
	int ethylFreezing = 2173;
	int oxygenFreezing = 2362;
	int waterFreezing = 32;
	
	public boolean isEthylFreezing(){
		return ( temperature < ethylFreezing );
	}
	public boolean isEthylBoiling(){
		return ( temperature >= ethylBoiling );
	}
	public boolean isOxygenFreezing(){
		return ( temperature < oxygenFreezing );
	}
	public boolean isOxygenBoiling(){
		return ( temperature >= oxygenBoiling );
	}
	public boolean isWaterFreezing(){
		return ( temperature < waterFreezing );
	}
	public boolean isWaterBoiling(){
		return ( temperature >= waterFreezing );
	}
	
	public FreezingBoiling(int temperature) {
		this.temperature = temperature;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter the temperature of substance: ");
		int temperature = input.nextInt();
		FreezingBoiling fb = new FreezingBoiling(temperature);
		System.out.println("Is ethyl freezing point? "+fb.isEthylFreezing());
		System.out.println("Is ethyl boiling point? "+fb.isEthylBoiling());
		System.out.println("Is oxygen freezing point? "+fb.isOxygenFreezing());
		System.out.println("Is oxygen boilinging point? "+fb.isOxygenBoiling());
		System.out.println("Is water freezing point? "+fb.isWaterFreezing());
		System.out.println("Is water boiling point? "+fb.isWaterBoiling());
		
	}
	
}

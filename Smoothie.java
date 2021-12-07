/*
 * Class: CMSC203 CRN: 22507
 * Assignment 6
 * Instructor: Farnaz Eivaz
 * 
 * Description:  A subclass of Beverage that adds smoothies to the  order
    
 * Due: 11/27/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/
public class Smoothie extends Beverage {
	
	private int fruitCount = 0; 
	private boolean proteinPowder = false; 
	
	public Smoothie (String name, SIZE size, int fruit, boolean powder){
		super(name, TYPE.SMOOTHIE, size);
		this.fruitCount = fruit;
		this.proteinPowder = powder;
	}
	
	public int getNumOfFruits(){
		return fruitCount;
	}
	
	public boolean getAddProtein(){
		return proteinPowder;
	}
	
	public void setNumOfFruits(int fruit){
		this.fruitCount = fruit;
	}
	
	public void setPowder(boolean powder){
		this.proteinPowder = powder;
	}
	
	public double calcPrice(){
		
		double cost = 0.0;
		cost += this.getBasePrice();
		cost += (fruitCount * 0.5);
		
		if (proteinPowder == true) {
			cost += 1.5;
		}
		if (this.getSize() == SIZE.MEDIUM) {
			cost += this.getSizeUp();
		}
		if (this.getSize() == SIZE.LARGE) {
			cost += (this.getSizeUp() * 2);
		}
		
		return cost;
	}
	
	public String toString(){
		String print = "";
		String proteinPowd = "";
		
		if (proteinPowder == true)
			proteinPowd = "Yes";
		else
			proteinPowd = "No";
		
		print = super.toString() +
				"\n\tPieces of Fruit: " + fruitCount +
				"\n\tProtein Powder: " + proteinPowd +
				"\n\tPrice: $" + calcPrice();
		
		return print;
	}
	
	public boolean equals (Smoothie nextBeverage){
		
		if (!super.equals(nextBeverage)) {
			return false;
		}
		if (nextBeverage.getNumOfFruits() != fruitCount) {
			return false;
		}
		if (nextBeverage.getAddProtein() != proteinPowder) {
			return false;
		}else {
			return true;
		}
	}

}

//Abraham Lamidi wrote this code.

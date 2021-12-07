/*
 * Class: CMSC203 CRN: 22507
 * Assignment 6
 * Instructor: Farnaz Eivaz
 * 
 * Description:  A subclass of Beverage that adds coffee to the  order
    
 * Due: 11/27/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/

public class Coffee extends Beverage {
	
	private boolean extraShot = false;
	private boolean extraSyrup = false;
	

	public Coffee (String name, SIZE size, boolean moreShot, boolean moreSyrup){
		super(name, TYPE.COFFEE, size);
		this.extraShot = moreShot;
		this.extraSyrup = moreSyrup;
	}
	
	
	public boolean getExtraShot(){
		return extraShot;
	}
	
	public boolean getExtraSyrup(){
		return extraSyrup;
	}
	
	public void setShot(boolean moreShot){
		this.extraShot = moreShot;
	}
	
	public void setSyrup(boolean moreSyrup){
		this.extraSyrup = moreSyrup;
	}
	
	public double calcPrice(){
		
		double cost = 0.0;
		cost += this.getBasePrice();
		
		if (extraShot == true) {
			cost += 0.5;
		}
		if (extraSyrup == true) {
			cost += 0.5;
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
		
		String print = "", shot = "", syrup = "";
		
		if (extraShot == true) {
			shot = "Yes";
		}else {
			shot = "No";
		}
		
		if (extraSyrup == true) {
			syrup = "Yes";
		}else {
			syrup = "No";
		}
		
		print = super.toString() +
				"\n\tExtra Shot: " + shot +
				"\n\tExtra Syrup: " + syrup +
				"\n\tPrice: $" + calcPrice();
		
		return print;
	}
	
	public boolean equals (Coffee nextBeverage){
		
		if (!super.equals(nextBeverage)) {
			return false;
		}
		if (nextBeverage.getExtraShot() != extraShot) {
			return false;
		}
		if (nextBeverage.getExtraSyrup() != extraSyrup) {
			return false;
		}else {
			return true;
		}
	}

}

//Abraham Lamidi wrote this code.

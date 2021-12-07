/*
 * Class: CMSC203 CRN: 22507
 * Assignment 6
 * Instructor: Farnaz Eivaz
 * 
 * Description:  A subclass of Beverage that adds alcoholic drinks to the  order
    
 * Due: 11/27/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/
public class Alcohol extends Beverage {
	
	private boolean onWeekend = false; 
	
	
	public Alcohol (String name, SIZE size, boolean weekend){
		super(name, TYPE.ALCOHOL, size);
		onWeekend = weekend;
	}
	
	public boolean getWeekend(){
		return onWeekend;
	}
	
	public void setWeekend(boolean weekend){
		onWeekend = weekend;
	}
	
	public double calcPrice(){
		double cost = 0.0;
		cost += this.getBasePrice();
		
		if (onWeekend == true) {
			cost += 0.6;
		}
		if (this.getSize() == SIZE.MEDIUM) {
			cost += this.getSizeUp();
		}
		if (this.getSize() == SIZE.LARGE) {
			cost += (this.getSizeUp() * 2);
		}
		
		return cost;
	}
	
	/**
	 * Overrides the toString method
	 * @return info- the details on the drink
	 */
	@Override
	public String toString(){
		String print = "";
		String weekend = "";
		
		if (onWeekend == true) {
			weekend = "Yes";
		}else {
			weekend = "No";
		}
		
		print = super.toString() +
				"\n\tAvailable Weekend: " + weekend +
				"\n\tPrice: $" + calcPrice();
		
		return print;
	}
	
	public boolean equals (Alcohol nextBeverage){
		
		if (!super.equals(nextBeverage)) {
			return false;
		}
		if (nextBeverage.getWeekend() != onWeekend) {
			return false;
		}else {
			return true;
		}
	}

}

//Abraham Lamidi wrote this code.

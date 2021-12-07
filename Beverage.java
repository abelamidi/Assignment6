/*
 * Class: CMSC203 CRN: 22507
 * Assignment 6
 * Instructor: Farnaz Eivaz
 * 
 * Description:  A abstract class that adds beverages to the  order
    
 * Due: 11/27/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/
abstract class Beverage {
	
	private String beverageName;
	private TYPE beverageType;
	private SIZE beverageSize;
	private final double BASE_PRICE = 2.0;
	private final double SIZE_UP = 1.0;
	
	
	public Beverage (String name, TYPE type, SIZE size){
		this.beverageName = name;
		this.beverageType = type;
		this.beverageSize = size;	
	}
	
	abstract double calcPrice();
	
	
	public void setName(String name){
		this.beverageName = name;
	}
	
	public void setType(TYPE type){
		this.beverageType = type;
	}
	
	public void setSize(SIZE size){
		this.beverageSize = size;
	}
	
	public String getBevName(){
		return beverageName;
	}
	
	public TYPE getType(){
		return beverageType;
	}
	
	public SIZE getSize(){
		return beverageSize;
	}
	
	public double getBasePrice(){
		return BASE_PRICE;
	}
	
	public double getSizeUp(){
		return SIZE_UP;
	}
	
	public String toString(){
		String print = "";
		print = "Beverage: " + beverageName +
				"\n\tSize: " + beverageSize;
		
		return print;
	}
	
	public boolean equals(Beverage nextBeverage){
		
		if (!nextBeverage.getBevName().equals(beverageName)) {
			return false;
		}
		if (nextBeverage.getType() != beverageType) {
			return false;
		}
		if (nextBeverage.getSize() != beverageSize) {
			return false;
		}else {
			return true;
		}
	}

}

//Abraham Lamidi wrote this code.

/*
 * Class: CMSC203 CRN: 22507
 * Assignment 6
 * Instructor: Farnaz Eivaz
 * 
 * Description:  A element class that gets the  order
    
 * Due: 11/27/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/

public class Order implements OrderInterface, Comparable<Order> {
	
	private int orderNumber;
	private int orderTime;
	private DAY orderDay;
	private Customer customer;
	private Beverage[] beverageList; 
	private int bevIndex; 
	
	
	public Order (int time, DAY day, Customer c){
		this.orderNumber = createOrderNumber();
		this.orderTime = time;
		this.orderDay = day;
		this.customer = new Customer(c);
		this.beverageList = new Beverage[50];
		this.bevIndex = 0;
	}
	

	public int createOrderNumber(){
		int number = 0, min = 10000, max = 90000;
		number = (int)Math.floor(Math.random() * (max - (min - 1) + 10000));
		return number;
	}
	
	public boolean isWeekend(){
		if (orderDay == DAY.SATURDAY || orderDay == DAY.SUNDAY) {
			return true;
		}else {
			return false;
		}
	}
	
	public Beverage getBeverage(int itemNumber){
		return beverageList[itemNumber];
	}
	
	public void addNewBeverage(String beverageName, SIZE size, boolean extraShot, boolean 
			extraSyrup){
		beverageList[bevIndex] = new Coffee (beverageName, size, extraShot, extraSyrup);
		bevIndex++;
	}
	
	public void addNewBeverage(String beverageName, SIZE size){
		beverageList[bevIndex] = new Alcohol (beverageName, size, isWeekend());
		bevIndex++;
	}
	
	
	public void addNewBeverage(String beverageName, SIZE size, int numberOfFruits, boolean 
			addProtein){
		beverageList[bevIndex] = new Smoothie (beverageName, size, numberOfFruits, addProtein);
		bevIndex++;
	}
	
	public double calcOrderTotal(){
		
		double total = 0;
		for (int i = 0; i < beverageList.length; i++){
			if (i < bevIndex){
				total += beverageList[i].calcPrice();
			}
		}
		
		return total;
	}
	
	public int findNumOfBeveType(TYPE type){
		
		int count = 0;
		for (int i = 0; i < beverageList.length; i++){
			if (i < bevIndex){
				if (beverageList[i].getType() == type) {
					count++;
				}
			}
		}
		
		return count;
	}
	
	public int getTotalItems(){
		return bevIndex;
	}
	
	public int getOrderNo(){
		return orderNumber;
	}
	
	public Customer getCustomer(){
		return new Customer(customer);
	}
	
	/**
	 * Returns a deep copy of the order's beverageList
	 * @return newArray 
	 */
	public Beverage[] getBeverageList(){
		
		Beverage[] array2 = new Beverage[50];
		for (int i = 0; i < beverageList.length; i++){
			array2[i] = beverageList[i];
		}
		
		return array2;
	}
	
	public int getOrderTime(){
		return orderTime;
	}
	
	public DAY getOrderDay(){
		return orderDay;
	}
	
	public int getIndex(){
		return bevIndex;
	}
	
	public void setOrderNo(int number){
		this.orderNumber = number;
	}
	
	public void setOrderDay(DAY day){
		this.orderDay = day;
	}
	
	public void setOrderTime(int time){
		this.orderTime = time;
	}
	
	public void setCustomer(Customer c){
		this.customer = new Customer(c);
	}
	
	public void setIndex(int number){
		this.bevIndex = number;
	}
	
	public int compareTo(Order nextOrder){
		int otherOrderNumber = nextOrder.getOrderNo();
		if (orderNumber > otherOrderNumber) {
			return 1;
		}
		if (orderNumber < otherOrderNumber) {
			return -1;
		}else {
			return 0;
		}
	}
	
	public String toString(){
		String print = "";
		
		print = "*Order No: " + orderNumber + "*" +
				"\nTime: " + orderTime +
				"\nDay: " + orderDay +
				"\nCustomer Name: " + customer.getName() +
				"\nCustomer Age: " + customer.getAge();
		
		for (int i = 0; i < beverageList.length; i++){
			if (i < bevIndex) {
				print += "\n" + beverageList[i].toString();
			}
		}
		
		print += "\nTotal Cost: $" + calcOrderTotal();
		
		return print;
	}
}

//Abraham Lamidi wrote this code.
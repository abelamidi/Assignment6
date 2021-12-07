/*
 * Class: CMSC203 CRN: 22507
 * Assignment 6
 * Instructor: Farnaz Eivaz
 * 
 * Description:  A data manager class that gets the order
    
 * Due: 11/27/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/
public class BevShop implements BevShopInterfce{

	private int alcoholCount; 
	private Order[] orderList; 
	private Order currentOrder; 
	private int orderIndex;
	
	
	public BevShop(){
		this.orderList = new Order[1000];
		this.orderIndex = 0;
		this.alcoholCount = 0;
	}
	
	public boolean isMaxFruit(int number){
		
		if (number > BevShopInterfce.MAX_FRUIT) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean validTime(int time){
		if (time >= BevShopInterfce.MIN_TIME && time <= BevShopInterfce.MAX_TIME) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean eligibleForMore(){
		if (alcoholCount < BevShopInterfce.MAX_ORDER_FOR_ALCOHOL) {
			return true;
		}else {
			return false;
		}
	}
	
	public  boolean validAge(int age){
		if (age >= BevShopInterfce.MIN_AGE_FOR_ALCOHOL) {
			return true;
		}else {
			return false;
		}
	}
	
	
	public void startNewOrder(int time, DAY Day, String customerName, int customerAge){
		Customer customer = new Customer(customerName, customerAge);
		currentOrder = new Order(time, Day, customer);
		alcoholCount = 0;
		orderList[orderIndex] = currentOrder;
		orderIndex++;
	}
	
	
	public void processCoffeeOrder( String beverageName, SIZE size, boolean extraShot, 
			boolean extraSyrup ){
		currentOrder.addNewBeverage(beverageName, size, extraShot, extraSyrup);
	}
	
	
	public void  processAlcoholOrder( String beverageName, SIZE size ) {
		currentOrder.addNewBeverage(beverageName, size);
		alcoholCount++;
	}
	
	public void processSmoothieOrder( String beverageName, SIZE size, int numberOfFruits, 
			boolean addProtien){
		currentOrder.addNewBeverage(beverageName, size, numberOfFruits, addProtien);
	}
	
	public int findOrder(int orderNumber){
		
		for (int i = 0; i < orderList.length; i++){
			if (i < orderIndex){
				if (orderList[i].getOrderNo() == orderNumber) {
					return i;
				}
			}
		}

		return -1;
	}
	
	
	public double totalOrderPrice(int orderNumber){
		
		for (int i = 0; i < orderList.length; i++){
			if (i < orderIndex){
				if (orderList[i].getOrderNo() == orderNumber) {
					return orderList[i].calcOrderTotal();
				}
			}
		}
		
		return -1.0;
	}
	
	
	public double totalMonthlySale(){
		
		double monthlyTotal = 0;
		for (int i = 0; i < orderList.length; i++){
			if (i < orderIndex)	{
				monthlyTotal += orderList[i].calcOrderTotal();
			}
		}
	
		return monthlyTotal;
	}
	
	/**
	 * sorts the orders within this bevShop using the Selection
	 * sort algorithm
	 */
	public  void sortOrders(){
		
		int startingPosition;
		int sortingIndex;
		for (startingPosition = 0; startingPosition < (orderIndex - 1); startingPosition++){
			for (sortingIndex = (startingPosition + 1); sortingIndex < orderIndex; sortingIndex++){
				if (orderList[sortingIndex].getOrderNo() < orderList[startingPosition].getOrderNo()){
					Order minOrder = orderList[startingPosition];
					orderList[startingPosition] = orderList[sortingIndex];
					orderList[sortingIndex] = minOrder;
				}
			}
		}		
	}
	
	
	public Order getOrderAtIndex(int index){
		return orderList[index];
	}
	
	public Order getCurrentOrder(){
		return currentOrder;
	}
	
	public int getNumOfAlcoholDrink(){
		return alcoholCount;
	}
	
	
	public int totalNumOfMonthlyOrders(){
		return orderIndex;
	}
	
	public int getMaxOrderForAlcohol(){
		return BevShopInterfce.MAX_ORDER_FOR_ALCOHOL;
	}
	
	public int getMinAgeForAlcohol(){
		return BevShopInterfce.MIN_AGE_FOR_ALCOHOL;
	}
	
	public Order[] getOrderList(){
		
		Order[] newList = new Order[1000];
		
		for (int i = 0; i < orderList.length; i++){
			newList[i] = orderList[i];
		}
		
		return newList;
	}
	
	public int getOrderIndex(){
		return orderIndex;
	}
	
	public void setOrderIndex(int number){
		this.orderIndex = number;
	}
	
	public void setAlcoholCount(int number){
		this.alcoholCount = number;
	}
	
	
	public void setOrderList(Order[] newList){
		orderList = null;
		
		for (int i = 0; i < newList.length; i++){
			orderList[i] = newList[i];
		}
	}
	
	public void replaceOrderAtIndex(Order order, int index){
		orderList[index] = order;
	}
	
	public String toString(){
		String print = "";
		double monthlySales = 0.0;
		
		print = "The BevShop Sales Report\n" +
				"------------------------------\n";
		
		for (int i = 0; i < orderIndex; i++){
			print += orderList[i].toString() + "\n" +
					"------------------------------\n";
			
			monthlySales += orderList[i].calcOrderTotal();
		}
		
		print += "\nTotal monthly sales: $" + monthlySales;
		
		return print;
	}
}

//Abraham Lamidi wrote this code.
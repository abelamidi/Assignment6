/*
 * Class: CMSC203 CRN: 22507
 * Assignment 6
 * Instructor: Farnaz Eivaz
 * 
 * Description:  A element class that adds the customer name and age to the  order
    
 * Due: 11/27/2021
 * Platform/compiler: Eclipse 
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   
   Programmer Abraham Lamidi
*/
public class Customer {
	
	public String name;
	public int age;
	
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;	
	}
	
	public Customer(Customer customer) {
		this.name = customer.name;
		this.age = customer.age;	
	}
	
	
	public void setName(String name) {
		this.name = name;	
	}
	
	public void setAge(int age) {	
		this.age = age;	
	}
	
	public String getName() {	
		return name;	
	}
	
	public int getAge() {	
		return age;
	}
    
	public String toString() {	
		return  "";
	}
}

//Abraham Lamidi wrote this code.

/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Implements the OrderInterface,includes methods related to an order
 * Due: 12/02/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Benjamin Berhanu
*/


import java.util.*;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderTime;
    private Day orderDay;
    private int orderNumber;
    private Customer customer;
    private ArrayList<Beverage> beverages = new ArrayList<>();
    

    public Order(int orderTime, Day orderDay, Customer cust) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        orderNumber = generateOrder();
        customer = cust;
        beverages = new ArrayList<>();
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public Beverage getBeverage(int itemNo) {
    	return beverages.get(itemNo);
    	
    }

    // adds coffee order
    @Override 
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
    	Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
    	beverages.add(coffee);
    }

    // adds alcohol order
    @Override
    public void addNewBeverage(String bevName, Size size) {
    	Alcohol alcohol = new Alcohol(bevName, size, (isWeekend() ? true : false));
    	beverages.add(alcohol);
    }

    // adds smoothie order
    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
        beverages.add(smoothie);
    }

    @Override
    public double calcOrderTotal() {
    	double total = 0.0;
    	for(Beverage beverage : beverages)
        {
        	total+= beverage.calcPrice();
        }
    	return total;
    }

    @Override
    public int findNumOfBeveType(Type type) {
        int count = 0;
    	for(Beverage beverage : beverages)
        {
        	if(beverage.getType() == type)
        	{
        		count++;
        	}
        }
    	return count;
    }
    
    @Override
    public int compareTo(Order order)
    {
    	if(orderNumber == order.orderNumber)
    	{
    		return 0;
    	}
    	else if(orderNumber > order.orderNumber)
    	{
    		return 1;
    	}
    	return -1;
    }
    
    public int generateOrder()
    {
    	Random randomNumbers = new Random();
    	// from 0 to n-1, but shifted
    	int randomNumber = randomNumbers.nextInt(80001) + 10000;
    	return randomNumber;
    }
    
    public Customer getCustomer()
    {
    	return new Customer(customer);
    }
    
    
    public Day getOrderDay()
    {
    	return orderDay;
    }
    
    public int getOrderNo()
    {
    	return orderNumber;
    }
    
    public int getOrderTime()
    {
    	return orderTime;
    }
    
    public int getTotalItems()
    {
    	return beverages.size();
    }
    
    @Override
    public String toString()
    {
    	String display = "Order No: #"+orderNumber+"	Time: " +orderTime+"	Day: "+  orderDay.toString()+ 
    			System.lineSeparator()+getCustomer().toString()+System.lineSeparator();
    	
    	for(Beverage beverage : beverages)
    	{
    		display += System.lineSeparator()+beverage.toString();
    	}
    	
    	return display;
    	
    }
    
     
    
    
    
}

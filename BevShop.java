/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Implements the BevShopInterface,includes methods related to running a bevShop
 * Due: 12/02/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Benjamin Berhanu
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface {
    private int alcoholOrderCount = 0;
    private Order currentOrder;
    private ArrayList <Order> orders = new ArrayList<>();
    

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isEligibleForMore() {
        return alcoholOrderCount < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return alcoholOrderCount;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        currentOrder = new Order(time, day, new Customer(customerName, customerAge));
        orders.add(currentOrder);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            alcoholOrderCount++;
            currentOrder.addNewBeverage(bevName, size);
        }
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        if (!isMaxFruit(numOfFruits)) {
            currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
        }
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public int findOrder(int orderNo) {
    	for(int i = 0; i < orders.size(); i++)
    	{
    		if(orders.get(i).getOrderNo() == orderNo)
    		{
    			return i;
    		}
    	}
    	return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
    	int index = findOrder(orderNo);
    	double total = 0.0;
    	if(index != -1)
    	{
    		total = orders.get(index).calcOrderTotal();
    	}
    	return total;
    		
    }

    @Override
    public double totalMonthlySale() {
        double total = 0.0;
        for(Order order : orders)
        {
        	int orderNum = order.getOrderNo();
        	total += totalOrderPrice(orderNum);
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    @Override
    public void sortOrders() {
    	// ascending order
    	for (int i = 0; i < orders.size() -1; i++)
    	{
    		// set minIndex and minValue to current values
    		int minIndex = i;
    		Order minValue = getOrderAtIndex(i);

    		// starts from next array loc
    		for(int index = i+1; index < orders.size(); index++)
    		{
    			// only have to switch logical operator to change to descending order
    			if(getOrderAtIndex(index).compareTo(minValue) < 0)
    			{
    				// update minValue and minIndex 
    				minValue = getOrderAtIndex(index);
    				minIndex = index;
    			}
    		}
    		// sets subsequent loc w/ min value to current value
    		
    		orders.set(minIndex, getOrderAtIndex(i));
    		// sets current array loc to prev minValue
    		orders.set(i, minValue);
    	}
    }
    
    @Override
    public String toString()
    {
    	String display = "";
    	for(Order order : orders)
    	{
    		display += order.toString()+System.lineSeparator();

    	}
    	
    	display += System.lineSeparator()+ "Total amount for all orders: "+totalMonthlySale();
    	return display;
    }
}

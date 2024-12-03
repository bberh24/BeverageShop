/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Alcohol class, an instance of beverage, implements the calcPrice method from Beverage abstract class and others
 * Due: 12/02/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Benjamin Berhanu
*/


public class Alcohol extends Beverage {
    // Constants
    private static final double WEEKEND_ADDITIONAL_COST = 0.60; 

    private boolean offeredInWeekend;  

    public Alcohol(String name, Size size, boolean isWeekend) {
        super(name, Type.ALCOHOL, size);  
        this.offeredInWeekend = isWeekend;
    }

    // Getter for offeredInWeekend
    public boolean isWeekend() {
        return offeredInWeekend;
    }

    @Override
    public String toString() {
        return super.toString()+
               ", offeredInWeekend: " + offeredInWeekend + 
               ", price: " + calcPrice();
    }

    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) {
            return true;  // Same object
        }
        if (anotherBev == null || getClass() != anotherBev.getClass()) {
            return false;  // Different class or null object
        }
        Alcohol other = (Alcohol) anotherBev;
        return super.equals(other) && offeredInWeekend == other.offeredInWeekend;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice(); // base price + cost for size upgrade
        if (offeredInWeekend) {
            return price + WEEKEND_ADDITIONAL_COST; 
        }
        return price;  
    	
    }
}

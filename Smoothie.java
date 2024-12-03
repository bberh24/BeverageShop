/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Smoothie class, an instance of beverage, implements the calcPrice method from Beverage abstract class and others
 * Due: 12/02/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Benjamin Berhanu
*/


public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    private final double FRUIT_COST = 0.5;
    private final double PROTEIN_COST = 1.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public boolean getAddProtein() {
        return addProtein;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        price += numOfFruits * FRUIT_COST;
        if (addProtein) {
            price += PROTEIN_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + ", Fruits: " + numOfFruits + (addProtein ? ", Protein added" : "");
    }
    
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) {
            return true;  // Same object
        }
        if (anotherBev == null || getClass() != anotherBev.getClass()) {
            return false;  // Different class or null object
        }
        Smoothie other = (Smoothie) anotherBev;
        return super.equals(other) && numOfFruits == other.numOfFruits && addProtein == other.addProtein;
    }
    
    
}

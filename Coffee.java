/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Coffee class, an instance of beverage, implements the calcPrice method from Beverage abstract class and others
 * Due: 12/02/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Benjamin Berhanu
*/

public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;
    private final double EXTRA_SHOT_COST = 0.5;
    private final double EXTRA_SYRUP_COST = 0.5;

    public Coffee(String name, Size size, boolean extraShot, boolean extraSyrup) {
        super(name, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public boolean getExtraShot() {
        return extraShot;
    }
    
    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    @Override
    public double calcPrice() {
        double price = addSizePrice();
        if (extraShot) {
            price += EXTRA_SHOT_COST;
        }
        if (extraSyrup) {
            price += EXTRA_SYRUP_COST;
        }
        return price;
    }

    @Override
    public String toString() {
        return super.toString() + (extraShot ? ", Extra Shot" : "") + (extraSyrup ? ", Extra Syrup" : "");
    }
    
    @Override
    public boolean equals(Object anotherBev) {
        if (this == anotherBev) {
            return true;  // Same object
        }
        if (anotherBev == null || getClass() != anotherBev.getClass()) {
            return false;  // Different class or null object
        }
        Coffee other = (Coffee) anotherBev;
        return super.equals(other) && extraShot == other.extraShot && extraSyrup == other.extraSyrup;
    }
}

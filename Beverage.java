public abstract class Beverage {
    private String name;
    private Size size;
    private Type type;
   
    private final double BASE_PRICE = 2.0;
    private final double SIZE_UPGRADE_COST = .5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.size = size;
        this.type = type;
    }

    public String getBevName() {
        return name;
    }

    public Size getSize() {
        return size;
    }
    
    public double getBasePrice()
    {
    	return BASE_PRICE;
    }

    public Type getType() {
        return type;
    }
    
    public double addSizePrice()
    {
    	double price = getBasePrice();
        if (getSize() == Size.MEDIUM) {
            price += SIZE_UPGRADE_COST;
        } else if (getSize() == Size.LARGE) {
            price += (SIZE_UPGRADE_COST * 2);
        }
        return price;
    }
    
    public abstract double calcPrice();

    @Override
    public String toString() {
        return name + ", " + size + ", " + type;
    }
    
    @Override
    public boolean equals(Object anotherBev)
    {
    	if (this == anotherBev) {
            return true;  // Same object
        }
        if (anotherBev == null || !(anotherBev instanceof Beverage)) {
            return false;  // Different class or null object
        }
        Beverage other = (Beverage) anotherBev;
        return name.equals(other.name) && size == other.size && type == other.type;
    }
    
    
}

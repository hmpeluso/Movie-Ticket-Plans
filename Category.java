/**
 * CS159 PA3 :MovieTix - category class.
 * 
 * @author Hannah Peluso
 * @version 10-4-20
 *
 */
public enum Category {

    BARGAIN("Bargain", "$", new Interval('[', 0.00, 5.00, ']')),
    INEXPENSIVE("Inexpensive", "$$", new Interval('(', 5.00, 11.00, ']')),
    MODERATE("Moderate", "$$$", new Interval('(', 11.00, 15.00, ']')),
    EXPENSIVE("Expensive", "$$$$", new Interval('(', 15.00, 25.00, ']')),
    OUTRAGEOUS("Outrageous", "$$$$$",
            new Interval('(', 25.00, Double.POSITIVE_INFINITY, ']'));

    private final Interval interval;
    private final String descriptions;
    private final String symbol;

    /**
     * Explicit Value Constructor.
     *
     * @param description A description of this Category
     * @param symbol The symbol to use for this Category
     * @param interval The Interval that characterizes this Category
     * 
     */
    Category(String description, String symbol, Interval interval) {
        this.descriptions = description;
        this.symbol = symbol;
        this.interval = interval;
    }

    /**
     * Get the Category that corresponds to a particular price.
     * 
     * @param price The price of interest
     * @return The corresponding Category (or null)
     */
    public static Category getCategoryFor(double price) {
        Category res = Category.BARGAIN;
        if (price >= 0.00 && price <= 5.00) {
            res = Category.BARGAIN;
        } else if (price > 5.00 && price <= 11.00) {
            res = Category.INEXPENSIVE;
        } else if (price > 11.00 && price <= 15.00) {
            res = Category.MODERATE;
        } else if (price > 15.00 && price <= 25.00) {
            res = Category.EXPENSIVE;
        } else if (price > 25.00) {
            res = Category.OUTRAGEOUS;
        } else {
            return null;
        }
        return res;
    }

    /**
     * Get the description of this Category.
     *
     * @return The description
     */
    public String getDescription() {
        return this.descriptions;
    }

    /**
     * Get the symbol for this Category.
     *
     * @return The name
     */
    public String getSymbol() {
        return this.symbol;
    }

    /**
     * Return a String representation of this Category.
     * 
     * @return The String representation
     */
    @Override
    public String toString() {
        return this.descriptions + " (" + this.symbol + ")";
    }
}

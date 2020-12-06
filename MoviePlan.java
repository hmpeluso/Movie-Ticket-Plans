/**
 * CS159 PA3 :MovieTix- movie plan .
 * 
 * @author Hannah Peluso
 * @version 10-4-20
 *
 */
public class MoviePlan {

    protected static final Interval APPROVED_PLAN_COSTS = new Interval('[',
            0.00, 200.00, ']');
    protected static final Interval APPROVED_MOVIE_COSTS = new Interval('[',
            0.00, 25.00, ']');

    private final double movieCost;
    private final double planCost;
    private final int prepaid;
    private final String name;
    private double spent;
    private int numberPurchased;
    private int punches;

    /**
     * The default constructor must initialize the attributes to the default
     * values as follows: the name must be "Movie Plan", the number of pre-paid
     * tickets must be 5, the plan cost must be $50.00, and the cost per "extra"
     * movie must be $15.00.
     * 
     * 
     */
    public MoviePlan() {

        this.name = "Movie Plan";
        this.prepaid = 5;
        this.planCost = 50.00;
        this.movieCost = 15.00;
        this.spent = 0.00;
        this.numberPurchased = 0;
        this.punches = 0;

    }

    /**
     * The explicit value constructor must initialize the attributes in the
     * obvious way, with a few exceptions. The plan cost attribute must be
     * assigned the value in APPROVED_PLAN_COSTS that is closest to the
     * parameter planCost and the movie cost attribute must be assigned the
     * value in APPROVED_MOVIE_COSTS that is closest to the parameter movieCost.
     * 
     * 
     * @param name of movie plan
     * @param prepaid amount
     * @param planCost amount
     * @param movieCost amount
     */
    public MoviePlan(String name, int prepaid, double planCost,
            double movieCost) {
        this.name = name;
        this.prepaid = prepaid;
        this.numberPurchased = 0;
        this.spent = 0.00;
        this.punches = 0;
        this.planCost = APPROVED_PLAN_COSTS.closestTo(planCost);
        this.movieCost = APPROVED_MOVIE_COSTS.closestTo(movieCost);

    }

    /**
     * Must return the cost of a purchased (i.e., not pre-paid) movie.
     * 
     * 
     * @return cost value
     */
    protected double costOfPurchasedMovie() {
        return this.movieCost;

    }

    /**
     * Must return the cost-to-date of the plan (i.e., the sum of the plan cost
     * and the amount spent to-date on purchased/"extra" movies). So, for
     * example, if the plan cost $100.00, all of the pre-paid movies have been
     * used, and one "extra" movie has been purchased at a price of $12.50 then
     * this method must return 112.50.
     * 
     * 
     * @return cost value.
     */
    protected double costToDate() {
        return this.getPlanCost() + this.spent();
    }

    /**
     * Must return the current Category for the plan based on the cost per movie
     * (to-date). For example, if the cost per movie is currently $7.00 then
     * this method must return the INEXPENSIVE Category.
     * 
     * If the cost per movie is undefined then this method must throw an
     * IllegalStateException.
     * 
     * @return current category.
     */
    public Category getCategory() {
        return Category.getCategoryFor(this.getCostPerMovie());
    }

    /**
     * Must return a String representation of the cost of the next movie. If the
     * plan still has punches then this method must return "Free". Otherwise, it
     * must return the cost of a purchased movie (preceded by a dollar sign, in
     * a field of width 6, with 2 digits to the right of the decimal point).
     * 
     * 
     * @return string value cost.
     */
    public String getCostOfNextMovie() {
        String res = "";
        if (this.prepaid > this.punches) {
            return "Free";
        }
        res = String.format("$%6.2f", this.costOfPurchasedMovie());

        return res;
    }

    /**
     * If the number of movies seen to-date is 0 it must throw an
     * IllegalStateException (since the cost per movie is undefined when no
     * movies have been seen). Otherwise, it must return the cost-to-date
     * divided by the number of movies seen to-date.
     * 
     * 
     * @return cost amount value.
     */
    public double getCostPerMovie() {
        if (this.numberSeen() == 0) {
            throw new IllegalStateException();
        }
        return this.costToDate() / this.numberSeen();
    }

    /**
     * getter for name of plan.
     * 
     * @return string value.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter for plan cost.
     * 
     * @return cost amount.
     */
    public double getPlanCost() {
        return this.planCost;
    }

    /**
     * Must return the number of movies that have been seen (whether pre-paid or
     * purchased) to-date.
     * 
     * 
     * @return amount of movies seen.
     */
    protected int numberSeen() {
        return this.numberPurchased() + this.punches;
    }

    /**
     * Must return the number of movies that have been purchased to-date (which
     * does not include the number of pre-paid movies that have been seen).
     * 
     * 
     * @return amount of movies purchased.
     */
    protected int numberPurchased() {
        return this.numberPurchased;
    }

    /**
     * Must return the number of unused pre-paid tickets.
     * 
     * 
     * @return amount that isn't yet used.
     */
    protected int remainingPrepaid() {
        return this.prepaid - this.punches;
    }

    /**
     * Must return the amount of money that has been spent on purchased movies
     * (which does not include the plan cost).
     * 
     * 
     * @return amount that's been spent on movies.
     */
    protected double spent() {
        return this.spent;
    }

    /**
     * Must return a String representation of the plan. The String must be
     * tab-delimited and include four items (in order): the name, the cost per
     * movie (preceded by a dollar sign in a field of width 6, with 2 digits to
     * the right of the decimal point), the String representation of the current
     * Category, and the cost of the next movie (formatted as described above).
     * 
     * If the cost per movie is undefined, then this method must return: the
     * name, followed by two tabs, followed by the String literal "Unused",
     * followed by the cost of the next movie (formatted as described above)
     * 
     * @return string value.
     */
    public String toString() {
        String res = "";
        if (this.numberSeen() == 0) {
            return String.format(this.name + "\t\tUnused\t%s",
                    this.getCostOfNextMovie());
        }
        res = String.format(
                this.name + "\t$%6.2f\t" + this.getCategory().toString()
                        + "\t%s",
                this.getCostPerMovie(), this.getCostOfNextMovie());

        return res;

    }

    /**
     * The use() method is called when a user wants to "see" a movie. It must
     * adjust the number of punches, the amount spent, and/or the number
     * purchased (as appropriate, depending on whether there are or aren't
     * unused punches).
     * 
     * Since it is always possible to "see" a movie under this plan, it must
     * always return true.
     * 
     * @return used value true.
     */
    public boolean use() {
        if (this.punches < this.prepaid) {
            this.punches++;
        } else {
            // this next line was called first in my initial code, after a LOT
            // of testing I found i had to increment spent before increasing
            // number purchased.
            // this.numberPurchased++;
            this.spent += this.costOfPurchasedMovie();
            this.numberPurchased++;

        }

        return true;
    }

}

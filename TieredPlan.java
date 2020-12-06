/**
 * CS159 PA3 :MovieTix - Tiered Plan class. The TieredPlan class is a
 * specialization of a MoviePlan in which there is a special initial tier of
 * purchases (at a different price from ordinary purchases).
 * 
 * 
 * @author Hannah Peluso
 * @version 10-12-20
 *
 */
public class TieredPlan extends MoviePlan {

    // cost per movie of initial group of tickets.
    private double tierCost;
    // number of tickets in the initial group of tickets.
    private int tierLimit;

    /**
     * The default constructor must initialize the name to "Tiered Plan", the
     * number of pre-paid tickets to 5, the plan cost to $100.00, the normal
     * purchase price to $10.00, the number of tickets in the initial group to
     * 5, and the price of the initial purchases to $5.50.
     * 
     * 
     */
    public TieredPlan() {
        super("Tiered Plan", 5, 100.00, 10.0);
        this.tierLimit = 5;
        this.tierCost = 5.50;
    }

    /**
     * The explicit value constructor must initialize the attributes in the
     * obvious way, with a few exceptions. The plan cost attribute must be
     * assigned the value in APPROVED_PLAN_COSTS that is closest to the
     * parameter planCost, and the movie cost and tier cost attributes must be
     * assigned the value in APPROVED_MOVIE_COSTS that are closest to the
     * parameters movieCost and tierCost, respectively.
     * 
     * 
     * @param name string value.
     * @param prepaid value.
     * @param planCost amount.
     * @param movieCost amount.
     * @param tierLimit value.
     * @param tierCost amount.
     */
    public TieredPlan(String name, int prepaid, double planCost,
            double movieCost, int tierLimit, double tierCost) {
        super(name, prepaid, planCost, movieCost);
        this.tierLimit = tierLimit;
        this.tierCost = MoviePlan.APPROVED_MOVIE_COSTS.closestTo(tierCost);

    }

    /**
     * Must return the cost of a purchased (i.e., not pre-paid) movie. Note that
     * the value returned by this method will depend on the number of movies
     * that have been purchased (because of the two price tiers).
     * 
     * 
     * @return cost in double.
     */
    @Override
    protected double costOfPurchasedMovie() {
        double res;
        if (super.numberPurchased() < this.tierLimit) {
            res = this.tierCost;
        } else {
            res = super.costOfPurchasedMovie();
        }
        return res;
    }

}

/**
 * CS159 PA3 :MovieTix - Limited plan class.The LimitedPlan class is a
 * specialization of the MoviePlan class in which there is a limit on the amount
 * of money that can be spent on credit.
 * 
 * 
 * @author Hannah Peluso
 * @version 10-4-20
 *
 */
public class LimitedPlan extends MoviePlan {

    private double creditLimit;

    /**
     * The default constructor must initialize the name to "Limited Plan", the
     * number of pre-paid tickets to 5, the plan cost to $50.00, the cost of
     * purchased tickets to $15.00, and the credit limit to $100.00.
     * 
     * 
     */
    public LimitedPlan() {
        super("Limited Plan", 5, 50.00, 15.00);
        this.creditLimit = 100.00;

    }

    /**
     * The 3-parameter constructor is used to construct "pre-paid only" plans.
     * To that end, it must initialize the cost of purchased tickets to the
     * maximum possible value, and the credit limit to $0.00.
     * 
     * 
     * @param name of plan
     * @param prepaid amount value.
     * @param cost of plan.
     */
    public LimitedPlan(String name, int prepaid, double cost) {
        super(name, prepaid, cost, 25.00);
        this.creditLimit = 0.0;

    }

    /**
     * uh i suppose this is just an even longer constructor should someone have
     * a more particular plan? TBD.
     * 
     * @param name of plan.
     * @param prepaid amount.
     * @param planCost value.
     * @param movieCost value.
     * @param creditLimit value.
     */
    public LimitedPlan(String name, int prepaid, double planCost,
            double movieCost, double creditLimit) {
        super(name, prepaid, planCost, movieCost);
        this.creditLimit = creditLimit;

    }

    /**
     * Must return a String representation of the cost of the next movie. If the
     * plan is unusable (i.e., has no available punches and insufficient credit
     * to purchase a ticket) then it must return "N/A". Otherwise, it must
     * exhibit the same behavior as a MoviePlan.
     * 
     * 
     * @return string value cost of next movie.
     */
    @Override
    public String getCostOfNextMovie() {
        String res = "";
        if (super.remainingPrepaid() == 0
                && this.creditLimit < super.getCostPerMovie() + super.spent()) {
            res = "N/A";
        } else {
            res = super.getCostOfNextMovie();
        }

        return res;
    }

    /**
     * The use() method is called when a user wants to "see" a movie. It must
     * return false if the plan is unusable (as described above). Otherwise, it
     * must exhibit the same behavior as a MoviePlan.
     * 
     * @return false if plan is unusable.
     */
    public boolean use() {
        boolean res = false;
        if (super.remainingPrepaid() == 0
                && (this.creditLimit < super.getCostPerMovie()
                        + super.spent())) {
            res = false;
        } else {
            super.use();

        }

        return res;
    }

}

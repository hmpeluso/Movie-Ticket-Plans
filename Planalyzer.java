/**
 * An application that can be used to find the least expensive plan for
 * different numbers of movies. In particular, this application compares a
 * $150.00 LimitedPlan with 15 pre-paid movies, a default MoviePlan, a default
 * TieredPlan, and a free MoviePlan with 0 pre-paid movies and a cost of $16.50
 * per movie.
 * 
 * @author Ann E. Koda; PayTex, Inc.
 * @version 1.0
 */
public class Planalyzer {
    /**
     * The entry point of the application.
     * 
     * @param args The command-line arguments (args[0] is the number of movies)
     */
    public static void main(String[] args) {
        boolean stillValid;
        int n;
        MoviePlan bestPlan;
        MoviePlan[] plans;

        // Construct the plans to compare
        plans = new MoviePlan[4];
        plans[0] = new LimitedPlan("Punch Plan", 15, 150.00);
        plans[1] = new MoviePlan();
        plans[2] = new TieredPlan();
        plans[3] = new MoviePlan("Credit Plan", 0, 0.00, 16.50);

        // Process the command-line argument to determine the
        // number of uses to compare
        n = 20;
        if ((args != null) && (args.length > 0)) {
            n = Integer.parseInt(args[0]);
        }

        // Print the header line
        System.out.printf("%s\t%s\t%s\n", "Movies", "Best Plan", "Cost Per");

        // Use each plan, find the best for each usage, and print
        // the result
        for (int i = 1; i <= n; i++) {
            for (int p = 0; p < plans.length; p++) {
                if (plans[p] != null) {
                    stillValid = plans[p].use();
                    if (!stillValid) {
                        plans[p] = null;
                    }
                }
            }

            bestPlan = PlanUtilities.findBestPlan(plans);

            System.out.printf("%d\t%s\t$%6.2f\t(%s)\n", i, bestPlan.getName(),
                    bestPlan.getCostPerMovie(),
                    bestPlan.getCategory().getSymbol());
        }
    }

}

/**
 * An application that prints a table of usage versus cost-per-movie for some
 * common plans. In particular, this application can print a table for a $150.00
 * LimitedPlan with 15 pre-paid movies ("Punch"), a default MoviePlan ("Movie"),
 * a default TieredPlan ("Tiered"), and a free MoviePlan with 0 pre-paid movies
 * and a cost of $16.50 per movie ("Credit").
 * 
 * @author Ann E. Koda; PayTex, Inc.
 * @version 1.0
 */
public class UsageSummarizer {
    /**
     * The entry point of the application.
     * 
     * Valid Command-Line Arguments: Punch, Movie, and Tiered
     * 
     * @param args The command-line arguments
     */
    public static void main(String[] args) {
        boolean stillValid;
        MoviePlan plan;

        plan = new MoviePlan("Credit Plan", 0, 0.00, 16.50);
        if (args != null && args.length > 0) {
            if (args[0].equals("Punch")) {
                plan = new LimitedPlan("Punch Plan", 15, 150.00);
            } else if (args[0].equals("Movie")) {
                plan = new MoviePlan();
            } else if (args[0].equals("Tiered")) {
                plan = new TieredPlan();
            }
        }

        System.out.printf("%s: Cost Versus Usage\n\n", plan.getName());
        for (int i = 1; i <= 20; i++) {
            stillValid = plan.use();
            if (stillValid) {
                System.out.printf("%d\t%6.2f\t%s\n", i, plan.getCostPerMovie(),
                        plan.getCategory().getSymbol());
            } else {
                System.out.printf("%d\tN/A\n", i);
            }
        }
    }
}

// import java.util.Comparator;
// import java.util.*;

/**
 * CS159 PA3 :MovieTix - Plan Utilities class.The PlanUtilities class is a
 * utility class that can be used to perform operations on MoviePlan objects.
 * 
 * @author Hannah Peluso
 * @version 10-4-20
 *
 */
public class PlanUtilities {

    /**
     * Must return the least expensive MoviePlan (among those passed to it)
     * based on each plan's current cost-per-movie.
     * 
     * Any null parameters must be ignored. It must return null if all of the
     * parameters are null. It must return null if there are 0 parameters. It
     * must ignore parameters that have an undefined cost-per-movie. It must
     * return null if all of the parameters have an undefined cost-per-movie.
     * 
     * 
     * @param plans given to check through.
     * @return least expensive movie plan.
     */
    public static MoviePlan findBestPlan(MoviePlan... plans) {
        MoviePlan best = null;
        double bestCost = 0;
        int i = 0;
        while (best == null && i < plans.length) {
            if (plans[i] == null || plans[i].numberSeen() == 0) {
                i++;
                continue;
            }
            best = plans[i];
            bestCost = best.getCostPerMovie();
            i++;
        }
        for (MoviePlan item : plans) {
            if (item == null || item.numberSeen() == 0) {
                continue;
            } else {
                double itemCost = item.getCostPerMovie();
                if (itemCost < bestCost) {
                    best = item;
                    bestCost = itemCost;
                }
            }
        }
        return best;
    }

}

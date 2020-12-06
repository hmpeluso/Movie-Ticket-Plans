import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS159 PA3 : Plan utilities test class.
 * 
 * @author Hannah Peluso
 * @version 10-12-20
 *
 */
public class PlanUtilitiesTest {

    /**
     * Test method for plan utilities.
     */
    @Test
    public void testPlanUtilities() {
        PlanUtilities tester = new PlanUtilities();

        // this is testing null inputs for coverage.
        MoviePlan test6 = null;
        MoviePlan test7 = null;
        MoviePlan test8 = null;

        MoviePlan[] tests1 = {test6, test7, test8};

        assertEquals(null, PlanUtilities.findBestPlan(tests1));

        // the rest of this class is one big test case.
        TieredPlan test1 = new TieredPlan("test1", 2, 30.00, 12.50, 2, 7.50);
        LimitedPlan test2 = new LimitedPlan("test2", 1, 30.00, 15.00, 100.0);
        LimitedPlan test3 = new LimitedPlan("test3", 2, 25.00, 12.00, 20.00);
        MoviePlan test4 = new MoviePlan("test4", 20, 125.00, 9.00);
        MoviePlan test5 = new MoviePlan("test5", 1, 25.00, 9.00);

        MoviePlan[] tests = {test1, test2, test3, test4, test5};

        assertEquals(null, PlanUtilities.findBestPlan(tests));

        test1.use();
        test2.use();
        test3.use();

        assertEquals(test3, PlanUtilities.findBestPlan(tests));

        test4.use();
        test5.use();

        assertEquals(test3, PlanUtilities.findBestPlan(tests));

        test1.use();
        test2.use();
        test3.use();
        test4.use();
        test5.use();

        assertEquals(test3, PlanUtilities.findBestPlan(tests));

        test1.use();
        test2.use();
        test3.use();
        test4.use();
        test5.use();

        assertEquals(test3, PlanUtilities.findBestPlan(tests));

        test1.use();
        test2.use();
        test3.use();
        test4.use();
        test5.use();

        assertEquals(test1, PlanUtilities.findBestPlan(tests));

    }

}

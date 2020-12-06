import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS159 PA3 :tiered Plan test class.
 * 
 * @author Hannah Peluso
 * @version 10-12-20
 *
 */
public class TieredPlanTest {

    /**
     * Test method for tiered plan class; once again was able to test everything
     * within one test method.
     */
    @Test
    public void testTieredPlan() {
        TieredPlan test1 = new TieredPlan("H", 2, 30.00, 12.50, 2, 7.50);

        test1.use();
        test1.use();

        assertEquals(7.50, test1.costOfPurchasedMovie(), .001);

        test1.use();

        assertEquals(7.50, test1.costOfPurchasedMovie(), .001);

        TieredPlan test2 = new TieredPlan("P", 2, 30.00, 10.00, 1, 7.00);

        assertEquals(7.00, test2.costOfPurchasedMovie(), .001);

        test2.use();
        test2.use();
        test2.use();

        // testing the test example in the write up .
        TieredPlan testex = new TieredPlan("C", 2, 30.00, 12.50, 2, 7.50);
        testex.use();
        assertEquals(30.00, testex.costToDate(), .001);
        assertEquals(30.00, testex.getCostPerMovie(), .001);
        testex.use();
        assertEquals(30.00, testex.costToDate(), .001);
        assertEquals(15.00, testex.getCostPerMovie(), .001);
        testex.use();
        assertEquals(37.50, testex.costToDate(), .001);
        assertEquals(12.50, testex.getCostPerMovie(), .001);
        testex.use();
        assertEquals(45.00, testex.costToDate(), .001);
        assertEquals(11.25, testex.getCostPerMovie(), .001);

        // the rest of these tests are all testing default.

        TieredPlan testf = new TieredPlan();
        testf.use();
        testf.use();
        testf.use();
        testf.use();

        assertEquals("Free", testf.getCostOfNextMovie());
        testf.use();
        assertEquals("$  5.50", testf.getCostOfNextMovie());

        testf.use();
        testf.use();
        testf.use();
        testf.use();
        assertEquals(13.556, testf.getCostPerMovie(), .001);

        testf.use();

        assertEquals(12.75, testf.getCostPerMovie(), .001);
        testf.use();
        assertEquals(12.5, testf.getCostPerMovie(), .001);

        // the big error was in my MP.use() method.
        // for (int i = 0; i < 11; i++) { testf.use(); if (i < 5) { String ans =
        // "Free"; assertEquals(ans, testf.getCostOfNextMovie()); } if (i > 5
        // &&
        // i < 11) { double cost = 100.00; cost += 5.5; assertEquals(cost,
        // testf.getCostPerMovie(), .001); } }

    }

}

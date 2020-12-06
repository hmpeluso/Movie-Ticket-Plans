import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS159 PA3 :Limited Plan test class.
 * 
 * @author Hannah Peluso
 * @version 10-12-20
 *
 */
public class LimitedPlanTest {

    /**
     * testing the limited plan class.
     */
    @Test
    public void test() {
        // was able to test the entire class within one test method.
        LimitedPlan test = new LimitedPlan();
        LimitedPlan test2 = new LimitedPlan("H", 2, 20.0);
        LimitedPlan test3 = new LimitedPlan("M", 1, 30.00, 15.00, 100.0);
        LimitedPlan test4 = new LimitedPlan("P", 2, 25.00, 12.00, 20.00);

        assertEquals("Free", test.getCostOfNextMovie());
        assertEquals("Free", test3.getCostOfNextMovie());

        test3.use();
        test2.use();

        assertEquals("Free", test2.getCostOfNextMovie());
        assertEquals("$ 15.00", test3.getCostOfNextMovie());

        test2.use();
        assertEquals("N/A", test2.getCostOfNextMovie());
        assertFalse(test2.use());

        test4.use();
        test4.use();
        test4.use();
        assertFalse(test4.use());

    }

}

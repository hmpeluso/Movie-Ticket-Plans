import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS159 PA3 :MovieTix - movie plan test.
 * 
 * @author Hannah Peluso
 * @version 10-4-20
 *
 */
public class MoviePlanTest {

    /**
     * test for constructors and getters and cost of purchased movie.
     */
    @Test
    public void costOfPurchasedMovieTest() {

        MoviePlan test1 = new MoviePlan();
        MoviePlan test = new MoviePlan("test", 50, 125.00, 9.00);

        assertEquals(15.00, test1.costOfPurchasedMovie(), .001);
        assertEquals("test", test.getName());
        assertEquals(50.00, test1.getPlanCost(), .001);

    }

    /**
     * test for constructors and getters and cost of purchased movie.
     */
    @Test
    public void costTest() {

        MoviePlan test1 = new MoviePlan();
        MoviePlan test = new MoviePlan("test", 10, 25.00, 9.00);

        test1.use();
        assertEquals(25.00, test.costToDate(), .001);
        assertEquals(Category.OUTRAGEOUS, test1.getCategory());
        assertEquals("Free", test.getCostOfNextMovie());

    }

    /**
     * test for random getters and costs and spent.
     */
    @Test
    public void movieTest() {
        // this next test tests get cost of next movie
        MoviePlan test3 = new MoviePlan("A", 1, 20.00, 10.00);
        test3.use();
        test3.use();
        assertEquals("$ 10.00", test3.getCostOfNextMovie());
        assertEquals(10.0, test3.spent(), .001);
        assertEquals(2, test3.numberSeen());
        assertEquals(1, test3.numberPurchased());
    }

    /**
     * testing prepaid and tostring.
     */
    @Test
    public void moviesToStringTest() {
        MoviePlan test = new MoviePlan("A", 2, 20.00, 12.50);

        test.use();
        assertEquals(20.00, test.getCostPerMovie(), .001);
        assertEquals(1, test.remainingPrepaid());
        test.use();
        assertEquals(10.00, test.getCostPerMovie(), .001);
        test.use();
        assertEquals(10.83, test.getCostPerMovie(), .01);
        assertEquals(0, test.remainingPrepaid());

        assertEquals("A\t$ 10.83\tInexpensive ($$)\t$ 12.50", test.toString());

    }

    /**
     * tests illegal argument input.
     */
    @Test(expected = IllegalStateException.class)
    public void whenExceptionThrown() {
        MoviePlan test = new MoviePlan();
        assertEquals("Movie Plan\t\tUnused\tFree", test.toString());

        assertEquals(new IllegalStateException(), test.getCostPerMovie());

    }

}

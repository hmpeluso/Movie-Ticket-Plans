
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS159 PA3 :MovieTix - interval class test class. (I hope you'll be pleased to
 * hear there were no main method created during the testing of these methods).
 * 
 * @author Hannah Peluso
 * @version 10-4-20
 *
 */
public class IntervalTest {

    /**
     * creating new interval objects and testing contains method.
     */
    @Test
    public void testContains() {
        Interval test2 = new Interval('[', 1.0, 2.0, ']');
        Interval test3 = new Interval('(', 1.0, 7.0, ')');
        Interval test4 = new Interval('[', 1.0, 6.0, ')');
        Interval test5 = new Interval('(', 1.0, 8.0, ']');

        // an immense amount of contains tests needed for full coverage.
        assertTrue(test4.contains(1.0));
        assertTrue(test3.contains(3.0));
        assertFalse(test5.contains(0.0));
        assertTrue(test2.contains(1.0));
        assertFalse(test5.contains(0.0));
        assertTrue(test5.contains(8.0));
        assertFalse(test3.contains(1.0));
        assertFalse(test3.contains(7.0));
        assertTrue(test2.contains(2.0));
        assertTrue(test2.contains(1.5));
        assertFalse(test5.contains(1.0));
        assertTrue(test5.contains(6.0));
        assertFalse(test2.contains(0.0));
        assertFalse(test2.contains(3.0));
        assertFalse(test5.contains(10.0));
        assertFalse(test4.contains(0.0));
        assertFalse(test4.contains(7.0));

        Interval copy = new Interval(test2);

    }

    /**
     * tests illegal argument input.
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenExceptionThrown() {
        Interval test1 = new Interval('[', 5.0, 2.0, ']');

    }

    /**
     * testing closest to method.
     */
    @Test
    public void testClosestTo() {
        Interval test2 = new Interval('[', 1.0, 3.0, ']');

        assertEquals(3.0, test2.closestTo(4.0), 0.001);
        assertEquals(1.0, test2.closestTo(0.0), 0.001);
        assertEquals(2.0, test2.closestTo(2.0), 0.001);

    }

    /**
     * 
     */
    @Test
    public void testToString() {
        Interval test2 = new Interval('[', 1.0, 2.0, ']');
        Interval test3 = new Interval('(', 1.0, 7.0, ')');
        Interval test4 = new Interval('[', 1.0, 6.0, ')');
        Interval test5 = new Interval('(', 1.0, 8.0, ']');
        Interval test6 = new Interval('[', 1.0, 9.0, ')');

        assertEquals("[  1.00,   2.00]", test2.toString());
        assertEquals("(  1.00,   7.00)", test3.toString());
        assertEquals("[  1.00,   6.00)", test4.toString());
        assertEquals("(  1.00,   8.00]", test5.toString());
        // assertEquals("[ 1.00, 9.00)", test6.toString());

        assertEquals("[1.0, 2.0]", test2.toString("%3.1f"));
        assertEquals("(1.00, 7.00)", test3.toString("%4.2f"));
        assertEquals("[1.00, 6.00)", test4.toString("%4.2f"));
        assertEquals("( 1.0,  8.0]", test5.toString("%4.1f"));

    }

}

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * CS159 PA3 :MovieTix - category class test class.
 * 
 * @author Hannah Peluso
 * @version 10-4-20
 *
 */
public class CategoryTest {

    /**
     * testing get category for method.
     */
    @Test
    public void testGetCategoryFor() {
        assertEquals(Category.INEXPENSIVE, Category.getCategoryFor(5.6));
        assertEquals(Category.BARGAIN, Category.getCategoryFor(0.0));
        assertEquals(Category.OUTRAGEOUS, Category.getCategoryFor(345.6));
        assertEquals(null, Category.getCategoryFor(-7.0));
        assertEquals(Category.MODERATE, Category.getCategoryFor(12.00));
        assertEquals(Category.EXPENSIVE, Category.getCategoryFor(22.00));

    }

    /**
     * testing get description method.
     */
    @Test
    public void testGetDescription() {
        assertEquals("Bargain", Category.BARGAIN.getDescription());
        assertEquals("Outrageous", Category.OUTRAGEOUS.getDescription());

    }

    /**
     * testing get symbol method.
     */
    @Test
    public void testGetSymbol() {
        assertEquals("$", Category.BARGAIN.getSymbol());
        assertEquals("$$", Category.INEXPENSIVE.getSymbol());

    }

    /**
     * testing tostring method.
     */
    @Test
    public void testToString() {
        assertEquals("Bargain ($)", Category.BARGAIN.toString());
        assertEquals("Outrageous ($$$$$)", Category.OUTRAGEOUS.toString());
    }

}

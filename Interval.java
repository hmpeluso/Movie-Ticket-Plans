/**
 * CS159 PA3 :MovieTix - interval class.
 * 
 * @author Hannah Peluso
 * @version 10-4-20
 *
 */
public class Interval {

    private final double right;
    private final double left;
    private final boolean leftClosed;
    private final boolean rightClosed;

    /**
     * interval copy constructor.
     * 
     * @param original interval inputted.
     */
    public Interval(Interval original) {
        left = original.left;
        right = original.right;
        leftClosed = original.leftClosed;
        rightClosed = original.rightClosed;

    }

    /**
     * constructor for interval. This constructor must throw an
     * IllegalArgumentException if left is greater than right.
     * 
     * @param leftSymbol indication closed on left
     * @param left bound
     * @param right bound
     * @param rightSymbol indication closed on right
     */
    public Interval(char leftSymbol, double left, double right,
            char rightSymbol) {
        if (left > right) {
            throw new IllegalArgumentException();
        }
        this.left = left;
        this.right = right;
        if (leftSymbol == '[') {
            this.leftClosed = true;
        } else {
            this.leftClosed = false;
        }
        if (rightSymbol == ']') {
            this.rightClosed = true;
        } else {
            this.rightClosed = false;
        }
    }

    /**
     * Must return true if the given value is contained in the interval and
     * false otherwise. Note that this method does not use tolerances.
     * 
     * @param value given
     * @return true if contained and false otherwise.
     */
    public boolean contains(double value) {
        // i'm not 100% sure if this is the most efficient way to write this
        // code but could not think of a better way given the design of the
        // constructor and the variables.
        boolean res = false;
        if (this.leftClosed && this.rightClosed) {
            if (value >= this.left && value <= this.right) {
                res = true;
            }
        }
        if (!this.leftClosed && !this.rightClosed) {
            if (value > this.left && value < this.right) {
                res = true;
            }
        }
        if (!this.leftClosed && this.rightClosed) {
            if (value > this.left && value <= this.right) {
                res = true;
            }
        }
        if (this.leftClosed && !this.rightClosed) {
            if (value >= this.left && value < this.right) {
                res = true;
            }
        }

        return res;
    }

    /**
     * Must return the value in the closure of the interval (i.e., the interval
     * and its bounds, whether or not it is closed) that is closest to the given
     * number. Note that this method can, if the value is in the interval,
     * return the value itself. (This operation is sometimes described as
     * projecting the value onto the closure of the interval.)
     * 
     * @param value to find nearest interval of.
     * @return value in closure of interval.
     */
    public double closestTo(double value) {
        double res = 0.0;
        if (value <= this.left) {
            res = this.left;
        }
        if (value >= this.right) {
            res = this.right;
        }
        if (value < this.right && value > this.left) {
            res = value;
        }

        return res;
    }

    /**
     * Must return a String representation of the interval. The result must
     * contain a '[' or '(' as appropriate, followed by the left bound (in a
     * field of width 6 with 2 digits to the right of the decimal point),
     * followed by a ',', followed by a space, followed by the right bound (in a
     * field of width 6 with 2 digits to the right of the decimal point),
     * followed by a ']' or ')' as appropriate.
     * 
     * @return String value.
     */
    public String toString() {
        String res = "";
        if (this.leftClosed && this.rightClosed) {
            res = String.format("[%6.2f, %6.2f]", this.left, this.right);
        } else if (!this.leftClosed && this.rightClosed) {
            res = String.format("(%6.2f, %6.2f]", this.left, this.right);
        } else if (this.leftClosed) {
            res = String.format("[%6.2f, %6.2f)", this.left, this.right);
        } else {
            res = String.format("(%6.2f, %6.2f)", this.left, this.right);
        }
        return res;
    }

    /**
     * This method must return a String representation of the interval. However,
     * the left and right bounds must be formatted using the String parameter as
     * the format specifier (instead of being in a field of width 6 with 2
     * digits to the fight of the decimal point). In other words, if this method
     * is passed a parameter of "%3.0f" it must format each bound in a field of
     * width 3 with no digits to the right of the decimal point.
     * 
     * This method need not validate the String parameter. In other words, it
     * may assume that the format specifier is valid.
     * 
     * @param formatString format specifier.
     * @return string value.
     */
    public String toString(String formatString) {
        // same situation here with code efficiency. I felt as though I'd have
        // to significantly alter the initial toString method.
        String res = "";
        if (this.leftClosed && this.rightClosed) {
            res = String.format("[" + formatString + ", " + formatString + "]",
                    this.left, this.right);
        } else if (!this.leftClosed && this.rightClosed) {
            res = String.format("(" + formatString + ", " + formatString + "]",
                    this.left, this.right);
        } else if (this.leftClosed) {
            res = String.format("[" + formatString + ", " + formatString + ")",
                    this.left, this.right);
        } else {
            res = String.format("(" + formatString + ", " + formatString + ")",
                    this.left, this.right);
        }

        return res;
    }

}

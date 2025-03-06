import java.awt.Color;

/*
 *
 * Plots a Sierpinski Square of order n to standard drawing.
 *
 * Compilation:  javac SierpinskiSquare.java
 * Execution:    java SierpinskiSquare 3
 *
 */
public class SierpinskiSquare {
    /**
     * Calculates half the length of the diagonal of a square of
     * a specified length.
     *
     * half length = length / square root of length
     *
     * @param length the side length of the square
     * @return the half diagonal length
     */
    public static double halfDiagLength(double length) {
        double halfDiagLength = length/Math.sqrt(2);
        return halfDiagLength;
    }

    /**
     * 1. Sets the pen color to be black.
     *    - Use StdDraw.setPenColor(Color.black);
     *
     * 2. Draws a filled polygon at the four points at a distance
     *    of diagHeight(length) from the center (0.5, 0.5).
     *    - Uset StdDraw.filledPolygon(x, y) where x and y are double[] with x and y coordinates.
     * @param length the side length of the square.
     */
    public static void drawDarkSquare(double length) {
        StdDraw.setPenColor(Color.BLACK);
        double[] x = { 0.5, 0.5 - halfDiagLength(length), 0.5, 0.5 + halfDiagLength(length)};
        double[] y = { 0.5+halfDiagLength(length), 0.5, 0.5 - halfDiagLength(length),0.5};
        StdDraw.filledPolygon(x, y);
    }

    /**
     * 1. Sets the pen color to be white.
     *    - Use StdDraw.setPenColor(Color.white);
     *
     * 2. Draws a filled square at the center of a specified length.
     *    - Use StdDraw.filledSquare(x, y, r) to draw a square of side length 2r centered at (x,y)
     *
     * @param length the side length of the square
     */
    public static void drawLightSquare(double length) {
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.filledSquare(0.5, 0.5, length/2);        
    }

    /**
     * Draws a Sierpinski square of order n, such that the largest filled
     * square fits in a screen of size 1 x 1, alternating between a dark
     * square and light square (starting with a dark square).
     * @param curr the current order
     * @param n the highest order to draw
     * @param length the side length of the square
     */
    public static void sierpinski(int curr, int n, double length) {
        if(curr>n){
            return;
        } else if (curr%2==0) {
            drawDarkSquare(length);
            sierpinski(curr + 1, n, halfDiagLength(length));
        } else if (curr%2!= 0) {
            drawLightSquare(length);
            sierpinski(curr + 1, n, halfDiagLength(length));
        }
        
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        sierpinski(0, n, halfDiagLength(1));    
    }
}

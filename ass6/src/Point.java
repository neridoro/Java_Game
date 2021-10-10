/**
 * @author neria doron 315351445
 * Point Method
 */

public class Point {
    private final double x;
    private final double y;
    /**
     * @param x the location
     * @param y the location
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;

    }
    /**
     * @param other point
     * @return the distance of this point to the other point
     */
    public double distance(Point other) {
        double dx = this.x - other.getX();
        double dy = this.y - other.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }
    /**
     * @param other point
     * @return true if the points are equal, false otherwise
     */
    public boolean equals(Point other) {
        return distance(other) == 0;
    }
    /**
     * @return the x coordinate
     */
    // Return the x and y values of this point
    public double getX() {
        return this.x;
    }
    /**
     * @return the y coordinate
     */
    public double getY() {
        return this.y;
    }
}
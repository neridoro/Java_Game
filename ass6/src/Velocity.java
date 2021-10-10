
/**
 * @author neria doron 315351445
 * Velocity Method
 */
public class Velocity {
    private final double dx;
    private final double dy;
    /**
     * @param dx the speed to add
     * @param dy the speed to add
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * @return  x speed
     */
    public double getX() {
        return this.dx;
    }
    /**
     * @return  y speed
     */
    public double getY() {
        return this.dy;
    }
    /**
     * @return  speed
     */
    public double speed() {
        return Math.sqrt((Math.pow(this.dx, 2)) + (Math.pow(this.dy, 2)));
    }
    /**
     * @param p point
     * @return a new point with added values
     */
    public Point applyToPoint(Point p) {
        return new Point((p.getX() + dx), (p.getY() + dy));
    }
    /**
     * @param angle angle
     * @param speed speed of point
     * @return a new velocity based on points from angels and speed
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.toRadians(angle);
        double dy = (Math.cos(angle) * speed);
        double dx = (Math.sin(angle) * speed);
        if (angle == 0) {
            return new Velocity(0, -speed);
        }
        return new Velocity(dx, -dy);
    }
}
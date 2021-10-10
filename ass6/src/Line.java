import biuoop.DrawSurface;

import java.util.List;

/**
 * @author neria doron 315351445
 * Line Method
 */
public class Line {
    private final double x1;
    private final double y1;
    private final double x2;
    private final double y2;
    /**
     * @param start the location
     * @param end the location
     */
    public Line(Point start, Point end) {
        this.x1 = start.getX();
        this.y1 = start.getY();
        this.x2 = end.getX();
        this.y2 = end.getY();
    }
    /**
     * @param x1 the location
     * @param y1 the location
     * @param x2 the location
     * @param y2 the location
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    /**
     * @return the distance of this point to the other point
     */
    public double length() {
        Point start = this.start();
        Point end = this.end();
        return start.distance(end);
    }
    /**
     * @return the middle of this point to the other point
     */
    public Point middle() {
        double dx = (this.x1 + this.x2) / 2;
        double dy = (this.y1 + this.y2) / 2;
        return new Point(dx, dy);
    }
    /**
     * @return the start of this line
     */
    public Point start() {
        return new Point(x1, y1);
    }
    /**
     * @return the end of this line
     */
    public Point end() {
        return new Point(x2, y2);
    }
    /**
     * @return the angle of this line
     */
    public double angle() {
        if (this.start().getX() == this.end().getX()) {
            return 0;
        }
        return (this.start().getY() - this.end().getY()) / (this.start().getX() - this.end().getX());
    }
    /**
     * @return the angle of this line
     */
    public double n() {
        return (this.start().getY() - (this.angle() * this.start().getX()));
    }
    /**
     * @param x the x in this equation
     * @return y of this equation
     */
    public double y(double x) {
        return (this.n() + this.angle() * x);
    }
    /**
     * @param y the y in this equation
     * @return x of this equation
     */
    public double x(double y) {
        if (this.angle() == 0) {
            return this.start().getX();
        }
        return ((y - this.n()) / this.angle());
    }
    /**
     * @param other the other point
     * @return true or false if point in line
     */
    public boolean inline(Point other) {
        return ((this.start().getX() >= other.getX() && this.end().getX() <= other.getX())
                || (this.end().getX() >= other.getX() && this.start().getX() <= other.getX()));
    }
    /**
     * @param other the other line
     * @return true or false if intersecting
     */
    // Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {
        return intersectionWith(other) != null;
    }

    /**
     * @param other the other line
     * @return true or false if intersecting
     */
    public Point intersectionWith(Line other) {
        if (this.angle() != other.angle()) {
            double dn = other.n() - this.n();
            double dx = this.angle() - other.angle();
            double x = dn / dx;
            double y = (x * this.angle()) + this.n();
            Point meeting = new Point(x, y);
            if (this.inline(meeting) && other.inline(meeting)) {
                return meeting;
            }
        }
        return null;
    }
    /**
     * @param other the other line
     * @return true or false if intersecting
     */
    public boolean equals(Line other) {
        return (this.start().equals(other.start()) && this.end().equals(other.end()))
                || (this.end().equals(other.start()) && this.start().equals(other.end()));
    }
    /**
     * @param rect the rectangle
     * @return true or false if intersecting
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> intersection = rect.intersectionPoints(this);
        if (intersection.isEmpty()) {
            return null;
        }
        Point closestPoint = intersection.get(0);
        for (Point point:intersection) {
            if (this.start().distance(point) <= this.start().distance(closestPoint)) {
                closestPoint = point;
            }
        }
        return closestPoint;
    }
    /**
     * @param surface where to draw
     */
    public void drawOn(DrawSurface surface) {
        surface.drawLine((int) this.x1, (int) this.y1, (int) this.x2, (int) this.y2);
    }
}
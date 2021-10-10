import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author neria doron 315351445
 */
public class Rectangle {
    private final Point upperLeft;
    private final double width;
    private final double height;
    private final Color color;

    /**
     * @param upperLeft center of point
     * @param width     radios
     * @param height    of the Rectangle
     * @param color     of the Rectangle
     */
    public Rectangle(Point upperLeft, double width, double height, Color color) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    /**
     * @return the width of this rectangle
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * @return color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return the height of this rectangle
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * @param line line to check intersection
     * @return list of intersection points
     */
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> intersection = new ArrayList<>();
        double leftX = this.getUpperLeft().getX();
        double rightX = this.getUpperRight().getX();
        double botY = this.getBottomLeft().getY();
        double topY = this.getUpperRight().getY();
        if (line.end().getX() >= leftX
                && line.start().getX() <= leftX
                && line.y(leftX) >= topY
                && line.y(leftX) <= botY) {
            intersection.add(new Point(leftX, line.y(leftX)));
        }
        if (line.end().getX() <= rightX
                && line.start().getX() >= rightX
                && line.y(rightX) >= topY
                && line.y(rightX) <= botY) {
            intersection.add(new Point(rightX, line.y(rightX)));
        }
        if (line.end().getY() >= topY
                && line.start().getY() <= topY
                && line.start().getX() >= leftX
                && line.end().getX() <= rightX) {
            intersection.add(new Point(line.x(topY), topY));
        }
        if (line.end().getY() <= botY
                && line.start().getY() >= botY
                && line.start().getX() >= leftX
                && line.end().getX() <= rightX) {
            intersection.add(new Point(line.x(botY), botY));
        }
        return intersection;
    }

    /**
     * @return the upperLerft point of this rectangle
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * @return the upperRight point of this rectangle
     */
    public Point getUpperRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY());
    }

    /**
     * @return the bottomLeft point of this rectangle
     */
    public Point getBottomLeft() {
        return new Point(this.upperLeft.getX(), this.upperLeft.getY() + this.height);
    }

    /**
     * @return the BottomRight point of this rectangle
     */
    public Point getBottomRight() {
        return new Point(this.upperLeft.getX() + this.width, this.upperLeft.getY() + this.height);
    }
}
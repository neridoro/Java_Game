/**
 * @author neria doron 315351445
 * CollisionInfo Method
 */
public class CollisionInfo {
    private final Collidable collidable;
    private final Line line;
    /**
     * @param line line of collision
     * @param collidable colideable item
     */
    public CollisionInfo(Line line, Collidable collidable) {
        this.collidable = collidable;
        this.line = line;
    }
    /**
     * @return point of collision
     */
    public Point collisionPoint() {
        return line.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());
    }
    /**
     * @return point of collision
     */
    public Collidable collisionObject() {
        return collidable;

    }
}
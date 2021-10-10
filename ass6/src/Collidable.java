/**
 * @author neria doron 315351445
 * Collidable interface
 */
public interface Collidable {
    /**
     * @return collision shape of the object
     */
    Rectangle getCollisionRectangle();

    /**
     * @param hitter ball hitting
     * @param collisionPoint  point of collision
     * @param currentVelocity current velocity
     * @return new Velocity
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

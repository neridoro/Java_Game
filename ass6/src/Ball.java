import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author neria doron 315351445
 * Ball
 */
public class Ball implements Sprite, HitNotifier {
    private Velocity velocity;
    private Point center;
    private final int r;
    private final Color color;
    private final GameEnvironment gameEnvironment;
    private final List<HitListener> hitListeners = new ArrayList<>();
    /**
     * @param center center of point
     * @param r radios
     * @param color of the ball
     * @param gameEnvironment game env
     */
    public Ball(Point center, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * @param x x of point
     * @param y x of point
     * @param r radios
     * @param color of the ball
     * @param gameEnvironment game env
     */
    public Ball(double x, double y, int r, Color color, GameEnvironment gameEnvironment) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
    }
    /**
     * @return  x location
     */
    public int getX() {
        return (int) this.center.getX();
    }
    /**
     * @return  x location
     */
    public int getY() {
        return (int) this.center.getY();
    }
    /**
     * @return  r radios size
     */
    public int getSize() {
        return this.r;
    }
    /**
     * @return  color of Ball
     */
    public Color getColor() {
        return this.color;
    }
    /**
     * @param v velocity of ball
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }
    /**
     * @param dx speed of ball in y
     * @param dy speed of ball in x
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }
    /**
     * @return velocity of ball
     */
    public Velocity getVelocity() {
        return this.velocity;
    }
    /**
     * @return trajectory of ball
     */
    public Line getTrajectory() {
        return new Line(this.center, this.velocity.applyToPoint(this.center));
    }
    /**
     * move one step function.
     */
    public void moveOneStep() {
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(this.getTrajectory());
        if (collisionInfo != null) {
            this.setVelocity(collisionInfo.collisionObject().hit(this, collisionInfo.collisionPoint(), this.velocity));
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }
    /**
     * @param surface where to draw
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.getColor());
        surface.fillCircle(this.getX(), this.getY(), this.getSize());
        surface.setColor(Color.red);
        surface.fillCircle(this.getX(), this.getY(), 1);
        surface.setColor(Color.black);
        surface.drawCircle(this.getX(),this.getY(),this.getSize());
    }
    /**
     * ticker say's to move.
     */
    public void timePassed() {
        moveOneStep();
    }
    /**
     * @param game to add Sprite to
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
    /**
     * @param game that i want to remove Ball
     */
    public void removeToGame(GameLevel game) {
        game.removeSprite(this);
    }
}
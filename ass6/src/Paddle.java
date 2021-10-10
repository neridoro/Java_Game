import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * @author neria doron 315351445
 * Paddle Method
 */
public class Paddle implements Sprite, Collidable {
    private double funWidth;
    private int paddleSpeed = 8;
    private static final int EDGE_LEFT = 25;
    private static final int EDGE_RIGHT = 775;
    private final biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    /**
     * @param keyboard user uses
     * @param rectangle the Paddle to control
     */
    public Paddle(KeyboardSensor keyboard, Rectangle rectangle) {
        this.keyboard = keyboard;
        this.rectangle = rectangle;
        this.funWidth = this.rectangle.getWidth() / 5;
    }
    /**
     * move left user uses.
     */
    public void moveLeft() {
        this.rectangle = new Rectangle(new Velocity(-paddleSpeed, 0).applyToPoint(this.rectangle.getUpperLeft()),
                this.rectangle.getWidth(), this.rectangle.getHeight(), this.rectangle.getColor());
    }
    /**
     * move left user uses.
     */
    public void moveRight() {
        this.rectangle = new Rectangle(new Velocity(paddleSpeed, 0).applyToPoint(this.rectangle.getUpperLeft()),
                this.rectangle.getWidth(), this.rectangle.getHeight(), this.rectangle.getColor());
    }
    /**
     * move if user wants.
     */
    public void timePassed() {
        if (this.keyboard.isPressed(KeyboardSensor.RIGHT_KEY)
                && this.rectangle.getBottomRight().getX() < EDGE_RIGHT) {
            moveRight();
        }
        if (this.keyboard.isPressed(KeyboardSensor.LEFT_KEY)
                && this.rectangle.getBottomLeft().getX() > EDGE_LEFT) {
            moveLeft();
        }
    }
    /**
     * @param d where to draw
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.rectangle.getColor());
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.rectangle.getUpperLeft().getX(), (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(), (int) this.rectangle.getHeight());
    }
    /**
     * @return Padle that collide with paddle
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }
    /**
     * @param hitter ball hitting
     * @param collisionPoint point of collision
     * @param currentVelocity current velocity
     * @return new Velocity
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if ((this.rectangle.getUpperRight().getY() == collisionPoint.getY()
                || this.rectangle.getBottomRight().getY() == collisionPoint.getY())
                && (this.rectangle.getUpperRight().getX() == collisionPoint.getX()
                || this.rectangle.getUpperLeft().getX() == collisionPoint.getX())) {
            return new Velocity(-currentVelocity.getX(), -currentVelocity.getY());
        }
        if (this.rectangle.getUpperRight().getY() == collisionPoint.getY()
                || this.rectangle.getBottomRight().getY() == collisionPoint.getY()) {
            return funPaddle(collisionPoint, currentVelocity);
        }
        if (this.rectangle.getUpperRight().getX() == collisionPoint.getX()
                || this.rectangle.getUpperLeft().getX() == collisionPoint.getX()) {
            return new Velocity(-currentVelocity.getX(), currentVelocity.getY());
        }
        return new Velocity(currentVelocity.getX(), currentVelocity.getY());
    }
    /**
     * make puddle more fun.
     * @param collisionPoint point of collision
     * @param currentVelocity current velocity
     * @return new Velocity
     */
    public Velocity funPaddle(Point collisionPoint, Velocity currentVelocity) {
        int angle = 0;
        if (collisionPoint.getX() >= this.rectangle.getUpperLeft().getX()
                && collisionPoint.getX() <= (this.rectangle.getUpperLeft().getX() + this.funWidth)) {
            angle = -60;
        } else if (collisionPoint.getX() >= (this.rectangle.getUpperLeft().getX() + this.funWidth)
                && collisionPoint.getX() <= (this.rectangle.getUpperLeft().getX() + (2 * this.funWidth))) {
            angle = -30;
        } else if (collisionPoint.getX() <= this.rectangle.getUpperRight().getX()
                && collisionPoint.getX() >= (this.rectangle.getUpperRight().getX() - this.funWidth)) {
            angle = 60;
        } else if (collisionPoint.getX() <= (this.rectangle.getUpperRight().getX() - this.funWidth)
                && collisionPoint.getX() >= (this.rectangle.getUpperRight().getX() - (2 * this.funWidth))) {
            angle = 30;
        }
        return Velocity.fromAngleAndSpeed(angle, currentVelocity.speed());
    }
    /**
     * @param g to add Sprite to
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    /**
     * @param num speed
     */
    public void setSpeed(int num) {
        this.paddleSpeed = num;
    }
}
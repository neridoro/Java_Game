import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author neria doron 315351445
 * Block Method
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private final Rectangle block;
    private final List<HitListener> hitListeners = new ArrayList<>();
    /**
     * @param block to create
     */
    public Block(Rectangle block) {
        this.block = block;
    }
    /**
     * @return Rectangle of this block
     */
    public Rectangle getCollisionRectangle() {
        return this.block;
    }
    /**
     * @param hitter ball hitting
     * @param collisionPoint point of collision
     * @param currentVelocity current velocity
     * @return Rectangle of this block
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        if ((this.block.getUpperRight().getY() == collisionPoint.getY()
                || this.block.getBottomRight().getY() == collisionPoint.getY())
                && (this.block.getUpperRight().getX() == collisionPoint.getX()
                || this.block.getUpperLeft().getX() == collisionPoint.getX())) {
            this.notifyHit(hitter);
            return new Velocity(-currentVelocity.getX(), -currentVelocity.getY());
        }
        if (this.block.getUpperRight().getY() == collisionPoint.getY()
                || this.block.getBottomRight().getY() == collisionPoint.getY()) {
            this.notifyHit(hitter);
            return new Velocity(currentVelocity.getX(), -currentVelocity.getY());
        }
        if (this.block.getUpperRight().getX() == collisionPoint.getX()
                || this.block.getUpperLeft().getX() == collisionPoint.getX()) {
            this.notifyHit(hitter);
            return new Velocity(-currentVelocity.getX(), currentVelocity.getY());
        }
        this.notifyHit(hitter);
        return new Velocity(currentVelocity.getX(), currentVelocity.getY());
    }
    /**
     * @param surface where to draw
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.block.getColor());
        surface.fillRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
    }
    /**
     * nothing yet.
     */
    public void timePassed() {
    }
    /**
     * @param game that i want to addCollidable and addSprite to
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }
    /**
     * @param game that i want to removeCollidable and removeSprite to
     */
    public void removeToGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }
    /**
     * @param hitter ball that hit
     */
    private void notifyHit(Ball hitter) {
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}

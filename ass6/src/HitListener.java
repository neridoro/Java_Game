/**
 * @author neria doron 315351445
 * HitListener
 */
public interface HitListener {
    /**
     * @param beingHit object that is being hit
     * @param hitter ball that hitting
     * This method is called whenever the beingHit object is hit.
     * The hitter parameter is the Ball that's doing the hitting.
     */
    void hitEvent(Block beingHit, Ball hitter);
}
/**
 * @author neria doron 315351445
 * ScoreTrackingListener
 */
public class ScoreTrackingListener implements HitListener {
    private final Counter currentScore;
    /**
     * @param scoreCounter score
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }
    /**
     * @param beingHit block thats being hit
     * @param hitter ball that hits
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        this.currentScore.increase(5);
    }
}
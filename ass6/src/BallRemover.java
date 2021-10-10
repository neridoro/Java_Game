// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
/**
 * @author neria doron 315351445
 * BlockRemover
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;
    /**
     * @param game game
     * @param removedBalls blocks to remove
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }
    /**
     * @param beingHit block thats being hit
     * @param hitter ball that hits
     */
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeToGame(game);
        hitter.removeHitListener(this);
        this.remainingBalls.decrease(1);
        this.game.getLevelInformation().decreaseBall();
    }
}
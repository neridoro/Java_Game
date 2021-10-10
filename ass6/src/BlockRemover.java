// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
/**
 * @author neria doron 315351445
 * BlockRemover
 */
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;
    /**
     * @param game game
     * @param removedBlocks blocks to remove
     */
    public BlockRemover(GameLevel game, Counter removedBlocks) {
        this.game = game;
        this.remainingBlocks = removedBlocks;
    }
    /**
     * @param beingHit block thats being hit
     * @param hitter ball that hits
     */
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    public void hitEvent(Block beingHit, Ball hitter) {
        beingHit.removeToGame(game);
        beingHit.removeHitListener(this);
        remainingBlocks.decrease(1);
    }
}
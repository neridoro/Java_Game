import java.util.List;
/**
 * LevelInformation.
 */
public interface LevelInformation {
    /**
     * decrase ball.
     */
    void decreaseBall();
    /**
     * @return number of Balls.
     */
    int numberOfBalls();
    /**
     * @return list of velocities
     * The initial velocity of each ball
     * Note that initialBallVelocities().size() == numberOfBalls().
     */
    List<Velocity> initialBallVelocities();
    /**
     * @return paddle speed.
     */
    int paddleSpeed();
    /**
     * @return paddle width.
     */
    int paddleWidth();
    /**
     * @return string levelname.
     */
    String levelName();
    /**
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();
    /**
     * @return list of blocks.
     */
    List<Block> blocks();
    /**
     * @return number of blocks to remove
     */
    int numberOfBlocksToRemove();
}

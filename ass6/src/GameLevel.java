import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.awt.Color;
/**
 * @author neria doron 315351445
 * GameLevel
 */
public class GameLevel implements Animation {
    private static final int ZERO = 0;
    private static final int SCORE_HEIGHT = 20;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private final int paddleWidth;
    private static final int PADDLE_HEIGHT = 20;
    private static final int RADIUS = 6;
    private static final int EDGE = 25;
    private final Counter counter =  new Counter();
    private final BlockRemover remover = new BlockRemover(this, counter);
    private final Counter ballCounter =  new Counter();
    private final BallRemover ballRemover = new BallRemover(this, ballCounter);
    private final Counter scoreCounter;
    private ScoreTrackingListener scoreTrackingListener;
    private final SpriteCollection sprites = new SpriteCollection();
    private final GameEnvironment environment = new GameEnvironment();
    private final GUI gui;
    private AnimationRunner runner;
    private boolean running;
    private final biuoop.KeyboardSensor keyboard;

    private final LevelInformation levelInformation;
    /**
     * @param levelInformation level info
     * @param ks key sensor
     * @param ar runner
     * @param gui gui
     * @param scoreCounter score counter
     * @param scoreTrackingListener score counter
     */
    public GameLevel(LevelInformation levelInformation, KeyboardSensor ks, AnimationRunner ar, GUI gui,
                     Counter scoreCounter, ScoreTrackingListener scoreTrackingListener) {
        this.levelInformation = levelInformation;
        this.runner = ar;
        this.keyboard = ks;
        this.gui = gui;
        this.paddleWidth = levelInformation.paddleWidth();
        this.scoreCounter = scoreCounter;
        this.scoreTrackingListener = scoreTrackingListener;
    }
    /**
     * @param c collidable object
     */
    public void addCollidable(Collidable c) {
        environment.addCollidable(c);
    }
    /**
     * @param c collidable to remove
     */
    public void removeCollidable(Collidable c) {
        environment.removeCollidable(c);
    }
    /**
     * @param s sprites to draw
     */
    public void addSprite(Sprite s) {
        sprites.addSprite(s);
    }
    /**
     * @param s sprites to remove
     */
    public void removeSprite(Sprite s) {
        sprites.removeSprite(s);
    }

    /**
     * @return game info.
     */
    public LevelInformation getLevelInformation() {
        return this.levelInformation;
    }
    /**
     * Initialize a new game: create the Blocks and Ball (and Paddle)
     * and add them to the game.
     */
    public void initialize() {
        this.addSprite(this.levelInformation.getBackground());
        Block edgeTop = new Block(new Rectangle(new Point(ZERO, SCORE_HEIGHT), WIDTH, EDGE, Color.gray));
        Block edgeLeft = new Block(new Rectangle(new Point(ZERO, SCORE_HEIGHT), EDGE, HEIGHT, Color.gray));
        Block edgeBot = new Block(new Rectangle(new Point(ZERO, HEIGHT),
                WIDTH, 0, Color.gray));
        edgeBot.addHitListener(ballRemover);
        Block edgeRight = new Block(new Rectangle(new Point(WIDTH - EDGE, SCORE_HEIGHT), EDGE, HEIGHT, Color.gray));
        edgeBot.addToGame(this);
        edgeRight.addToGame(this);
        edgeLeft.addToGame(this);
        edgeTop.addToGame(this);
        Paddle paddle = new Paddle(keyboard, new Rectangle(
                new Point((WIDTH * 0.5) - (this.levelInformation.paddleWidth() * 0.5),
                550), this.levelInformation.paddleWidth(), PADDLE_HEIGHT, Color.yellow));
        paddle.setSpeed(this.levelInformation.paddleSpeed());
        paddle.addToGame(this);
        int multiplier = 0;
        for (int i = 0; i < levelInformation.numberOfBalls(); i++) {
            Ball ball;
            if ((i % 2) == 0) {
                ball = new Ball(new Point(400 + (multiplier * 25), 500), RADIUS, Color.WHITE, environment);
                multiplier = multiplier + 1;
            } else {
                ball = new Ball(new Point(400 - (multiplier * 25), 500), RADIUS, Color.WHITE, environment);
            }
            ball.setVelocity(this.levelInformation.initialBallVelocities().get(i));
            ball.addToGame(this);
            ballCounter.increase(1);
        }
        ScoreIndicator scoreBoard = new ScoreIndicator(new Rectangle(new Point(ZERO, ZERO), WIDTH, EDGE, Color.white),
                scoreCounter);
        sprites.addSprite(scoreBoard);
        TitleIndicator titleIndicator = new TitleIndicator(this.levelInformation.levelName());
        sprites.addSprite(titleIndicator);
        for (Block block : levelInformation.blocks()) {
            block.addToGame(this);
            block.addHitListener(remover);
            block.addHitListener(scoreTrackingListener);
            counter.increase(1);
        }
    }
    /**
     * Run the game -- start the animation loop.
     */
    public void run() {
        this.runner.run(new CountdownAnimation(2, 3, this.sprites));
        this.running = true;
        this.runner.run(this);
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        if (ballCounter.getValue() == 0) {
            this.running = false;
        }
        if (counter.getValue() == 0) {
            scoreCounter.increase(100);
            this.running = false;
        }
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new PauseScreen(this.keyboard));
        }
        this.sprites.notifyAllTimePassed();
    }

    @Override
    public boolean shouldStop() {
        return !this.running;
    }
}

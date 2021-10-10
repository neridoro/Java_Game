import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author neria doron 315351445
 * DirectHit
 */
public class DirectHit implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BLOCK_HEIGHT = 25;
    private static final int BLOCK_WIDTH = 25;
    private int balls = 1;

    @Override
    public void decreaseBall() {
        balls = balls - 1;
    }

    @Override
    public int numberOfBalls() {
        return balls;
    }

    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(0, -2));
        return list;
    }
    @Override
    public int paddleSpeed() {
        return 12;
    }

    @Override
    public int paddleWidth() {
        return 200;
    }

    @Override
    public String levelName() {
        return "DirectHit";
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.lightGray);
                d.fillRectangle(0, 0, WIDTH, HEIGHT);
                d.setColor(Color.BLUE);
                d.drawCircle(WIDTH / 2, 150 + (BLOCK_HEIGHT / 2), 30);
                d.drawCircle(WIDTH / 2, 150 + (BLOCK_HEIGHT / 2), 50);
                d.drawCircle(WIDTH / 2, 150 + (BLOCK_HEIGHT / 2), 70);
                d.drawLine(WIDTH / 2, 150 + (BLOCK_HEIGHT / 2), WIDTH / 2, 150 + (BLOCK_HEIGHT / 2) + 100);
                d.drawLine(WIDTH / 2, 150 + (BLOCK_HEIGHT / 2), WIDTH / 2, 150 + (BLOCK_HEIGHT / 2) - 100);
                d.drawLine(WIDTH / 2, 150 + (BLOCK_HEIGHT / 2), WIDTH / 2 - 100, 150 + (BLOCK_HEIGHT / 2));
                d.drawLine(WIDTH / 2, 150 + (BLOCK_HEIGHT / 2), WIDTH / 2 + 100, 150 + (BLOCK_HEIGHT / 2));
            }
            @Override
            public void timePassed() {
            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Block block = new Block(new Rectangle(new Point((WIDTH / 2) - (BLOCK_HEIGHT / 2), 150),
                BLOCK_HEIGHT, BLOCK_HEIGHT, Color.RED));
        list.add(block);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author neria doron 315351445
 * WideEasy
 */
public class WideEasy implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BLOCK_HEIGHT = 25;
    private static final int BLOCK_WIDTH = 50;
    private int balls = 10;

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
        for (int i = 0; i < 10; i++) {
            list.add(new Velocity(0, -3));
        }
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 8;
    }

    @Override
    public int paddleWidth() {
        return 400;
    }

    @Override
    public String levelName() {
        return new String("Wide Easy");
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(Color.white);
                d.fillRectangle(0, 0, WIDTH, HEIGHT);
                d.setColor(new Color(255, 255, 153));
                for (int i = 0; i < 200; i++) {
                    d.drawLine(100, 100, i * 4, 250);
                }
                d.setColor(new Color(255, 255, 204));
                d.fillCircle(100, 100, 60);
                d.setColor(new Color(255, 255, 153));
                d.fillCircle(100, 100, 45);
                d.setColor(new Color(255, 255, 0));
                d.fillCircle(100, 100, 30);
            }

            @Override
            public void timePassed() {
            }
        };
    }

    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        Color color = Color.red;
        for (int i = 0; i < 15; i++) {
            if (i == 2 || i == 3) {
                color = Color.orange;
            }
            if (i == 4 || i == 5) {
                color = Color.yellow;
            }
            if (i == 6 || i == 8 || i == 7) {
                color = Color.green;
            }
            if (i == 9 || i == 10) {
                color = Color.blue;
            }
            if (i == 11 || i == 12) {
                color = Color.pink;
            }
            if (i == 13 || i == 14) {
                color = Color.CYAN;
            }
            Block block = new Block(new Rectangle(new Point(25 + (50 * i), 250),
                    BLOCK_WIDTH, BLOCK_HEIGHT, color));
            list.add(block);
        }
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 15;
    }
}

import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author neria doron 315351445
 * HunterExam
 */
public class Green implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BLOCK_HEIGHT = 25;
    private static final int BLOCK_WIDTH = 50;
    private int balls = 2;

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
        list.add(new Velocity(2, -6));
        list.add(new Velocity(-4, -7));
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 12;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "Green 3";
    }
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        massCreate(WIDTH - 75, 300, 6, Color.white, list);
        massCreate(WIDTH - 75, 300 - 25, 7, Color.blue, list);
        massCreate(WIDTH - 75, 300 - 50, 8, Color.yellow, list);
        massCreate(WIDTH - 75, 300 - 75, 9, Color.red, list);
        massCreate(WIDTH - 75, 300 - 100, 10, Color.gray, list);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(15, 100, 10));
                d.fillRectangle(0, 0, WIDTH, HEIGHT);
                d.setColor(new Color(50, 50, 50));
                d.fillRectangle(100, 400, 100, 200);
                d.setColor(new Color(60, 60, 60));
                d.fillRectangle(133, 350, 33, 50);
                d.setColor(new Color(70, 70, 70));
                d.fillRectangle(145, 200, 10, 150);
                d.setColor(new Color(255, 255, 100));
                d.fillCircle(150, 190, 10);
                d.setColor(new Color(255, 153, 51));
                d.fillCircle(150, 190, 6);
                d.setColor(new Color(255, 255, 255));
                d.fillCircle(150, 190, 3);
                int x = 105;
                int y = 410;
                for (int i = 1; i < 26; i++) {
                    d.fillRectangle(x, y, 10, 30);
                    x = x + 20;
                    if (i % 5 == 0) {
                        x = 105;
                        y = y + 40;
                    }
                }
                new Memes().shrek(d);
            }

            @Override
            public void timePassed() {

            }
        };
    }
    /**
     * @param x location to start.
     * @param y location to start
     * @param amount of blocks to create
     * @param color color of blocks
     * @param list of blocks
     */
    public void massCreate(int x, int y, int amount, Color color, List<Block> list) {
        for (int i = 0; i < amount; i++) {
            Block block = new Block(new Rectangle(new Point(x - (BLOCK_WIDTH * i), y),
                    BLOCK_WIDTH, BLOCK_HEIGHT, color));
            list.add(block);
        }
    }
}

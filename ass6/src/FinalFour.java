import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


/**
 * @author neria doron 315351445
 * HunterExam
 */
public class FinalFour implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BLOCK_HEIGHT = 20;
    private static final int BLOCK_WIDTH = 50;
    private int balls = 3;

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
        list.add(new Velocity(5, -3));
        list.add(new Velocity(-4, -4));
        list.add(new Velocity(1, -3));
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
        return "Final Four";
    }
    @Override
    public List<Block> blocks() {
        List<Block> list = new ArrayList<>();
        massCreate(WIDTH - 75, 200, 15, Color.cyan, list);
        massCreate(WIDTH - 75, 200 - 20, 15, Color.pink, list);
        massCreate(WIDTH - 75, 200 - 40, 15, Color.white, list);
        massCreate(WIDTH - 75, 200 - 60, 15, Color.green, list);
        massCreate(WIDTH - 75, 200 - 80, 15, Color.yellow, list);
        massCreate(WIDTH - 75, 200 - 100, 15, Color.red, list);
        massCreate(WIDTH - 75, 200 - 120, 15, Color.gray, list);
        return list;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return 90;
    }

    @Override
    public Sprite getBackground() {
        return new Sprite() {
            @Override
            public void drawOn(DrawSurface d) {
                d.setColor(new Color(1, 100, 200));
                d.fillRectangle(0, 0, WIDTH, HEIGHT);
                d.setColor(new Color(255, 255, 255));
                for (int i = 0; i < 10; i++) {
                    d.drawLine(150 + (5 * i), 400,  150 + (5 * i) - 20, 600);
                    d.drawLine(500 + (5 * i), 470,  500 + (5 * i) + 20, 600);
                }
                d.setColor(new Color(200, 200, 200));
                d.fillCircle(150, 400, 25);
                d.fillCircle(500, 450, 25);
                d.setColor(new Color(180, 180, 180));
                d.fillCircle(160, 420, 25);
                d.fillCircle(165, 400, 20);
                d.fillCircle(510, 470, 25);
                d.fillCircle(515, 450, 20);
                d.setColor(new Color(150, 150, 150));
                d.fillCircle(180, 420, 25);
                d.fillCircle(170, 400, 20);
                d.fillCircle(530, 470, 25);
                d.fillCircle(520, 450, 20);
                d.setColor(new Color(120, 120, 120));
                d.fillCircle(195, 410, 25);
                d.fillCircle(545, 460, 25);
                new Memes().cupOfTea(d);
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

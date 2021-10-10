import biuoop.DrawSurface;

import java.awt.*;

/**
 * @author neria doron 315351445
 * ScoreIndicator
 */
public class ScoreIndicator implements Sprite {
    private final Rectangle block;
    private Counter score;
    private static final int SCORE_HEIGHT = 18;
    private static final int SCORE_WIDTH = 350;
    private static final int SIZE = 15;
    /**
     * @param block to create
     * @param score score
     */
    public ScoreIndicator(Rectangle block, Counter score) {
        this.block = block;
        this.score = score;
    }
    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.block.getColor());
        surface.fillRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
        surface.setColor(Color.black);
        surface.drawRectangle((int) this.block.getUpperLeft().getX(), (int) this.block.getUpperLeft().getY(),
                (int) this.block.getWidth(), (int) this.block.getHeight());
        surface.drawText(SCORE_WIDTH, SCORE_HEIGHT, "Score: " + score.getValue(), SIZE);
    }

    @Override
    public void timePassed() {
    }
}

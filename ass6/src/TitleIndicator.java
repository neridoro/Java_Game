
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author neria doron 315351445
 * ScoreIndicator
 */
public class TitleIndicator implements Sprite {
    private static final int TITLE_Y = 18;
    private static final int TITLE_X = 500;
    private static final int SIZE = 15;
    private final String title;
    /**
     * @param title score
     */
    public TitleIndicator(String title) {
        this.title = title;
    }
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.drawText(TITLE_X, TITLE_Y, "Level Name: " + title, SIZE);
    }

    @Override
    public void timePassed() {

    }
}

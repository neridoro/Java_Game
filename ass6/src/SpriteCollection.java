import java.util.ArrayList;
import java.util.List;
import biuoop.DrawSurface;
/**
 * @author neria doron 315351445
 * SpriteCollection Method
 */
public class SpriteCollection {
    private final List<Sprite> sprites = new ArrayList<>();
    /**
     * @param s add sprite to list
     */
    public void addSprite(Sprite s) {
        sprites.add(s);
    }
    /**
     * @param s remove sprite to list
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }
    /**
     * call timePassed() on all sprites.
     */
    public void notifyAllTimePassed() {
        List<Sprite> sprites1 = new ArrayList<Sprite>(this.sprites);
        for (Sprite sprite : sprites1) {
            sprite.timePassed();
        }
    }
    /**
     * @param d surface to draw on
     * call drawOn(d) on all sprites.
     */
    public void drawAllOn(DrawSurface d) {
        List<Sprite> sprites1 = new ArrayList<Sprite>(this.sprites);
        for (Sprite sprite : sprites1) {
            sprite.drawOn(d);
        }
    }
}
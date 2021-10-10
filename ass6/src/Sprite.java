import biuoop.DrawSurface;
/**
 * @author neria doron 315351445
 * Sprite Interface
 */
public interface Sprite {
    /**
     * @param d the surface to draw on
     */
    void drawOn(DrawSurface d);
    /**
     * how much time passed.
     */
    void timePassed();
}
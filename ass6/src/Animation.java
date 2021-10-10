import biuoop.DrawSurface;
/**
 * @author neria doron 315351445
 * Animation interface
 */
public interface Animation {
    /**
     * @param d surface.
     */
    void doOneFrame(DrawSurface d);
    /**
     * @return true or false
     */
    boolean shouldStop();
}

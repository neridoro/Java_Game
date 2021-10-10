import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
/**
 * PauseScreen method.
 */
public class WinScreen implements Animation {
    private KeyboardSensor keyboard;
    private Counter score;
    private boolean stop;
    /**
     * @param k keyboard sensor
     * @param score score of player
     */
    public WinScreen(KeyboardSensor k, Counter score) {
        this.keyboard = k;
        this.stop = false;
        this.score = score;
    }
    /**
     * @param d surface
     */
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + score.getValue(), 32);
        if (this.keyboard.isPressed(KeyboardSensor.SPACE_KEY)) {
            this.stop = true;
        }
    }
    /**
     * @return true or false.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}

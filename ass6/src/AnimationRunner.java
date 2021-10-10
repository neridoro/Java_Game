/**
 * @author neria doron 315351445
 * AnimationRunner Method
 */
import biuoop.GUI;
import biuoop.DrawSurface;
/**
 * AnimationRunner.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private final biuoop.Sleeper sleeper = new biuoop.Sleeper();
    /**
     * @param d gui.
     */
    public AnimationRunner(GUI d) {
        this.gui = d;
        this.framesPerSecond = 60;
    }
    /**
     * @param animation animation to run;
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = 500 / framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }
}
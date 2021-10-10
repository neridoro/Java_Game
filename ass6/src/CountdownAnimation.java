import biuoop.DrawSurface;
/**
 * @author neria doron 315351445
 * CountdownAnimation Method
 */
public class CountdownAnimation implements Animation {
    private double numOfSeconds;
    private int countFrom;
    private int firstCount;
    private SpriteCollection sprites;
    private boolean stop;
    private final biuoop.Sleeper sleeper = new biuoop.Sleeper();
    /**
     * @param numOfSeconds seconds overall
     * @param countFrom start count from
     * @param gameScreen screen to show
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.countFrom = countFrom;
        this.numOfSeconds = numOfSeconds;
        this.sprites = gameScreen;
        this.firstCount = countFrom;
    }
    /**
     * @param d surface to draw on
     */
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        if (countFrom == 0) {
            this.stop = true;
        }
        d.drawText(d.getWidth() / 2, d.getHeight() / 2, "" + countFrom + "", 32);
        if (countFrom != firstCount) {
            this.sleeper.sleepFor((long) ((numOfSeconds / firstCount) * 1000));
        }
        countFrom = countFrom - 1;
    }
    /**
     * @return stop.
     */
    public boolean shouldStop() {
        return this.stop;
    }
}
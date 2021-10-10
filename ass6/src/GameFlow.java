import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.util.List;
/**
 * @author neria doron 315351445
 * GameFlow
 */
public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;
    private Counter scoreCounter;
    private ScoreTrackingListener scoreTrackingListener;
    /**
     * @param ar animation runner
     * @param gui gui to draw on
     * @param ks key board
     * @param scoreCounter score counter
     * @param scoreTrackingListener score listener
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui, Counter scoreCounter,
                    ScoreTrackingListener scoreTrackingListener) {
        this.keyboardSensor = ks;
        this.animationRunner = ar;
        this.gui = gui;
        this.scoreCounter = scoreCounter;
        this.scoreTrackingListener = scoreTrackingListener;
    }
    /**
     * @param levels list of levels
     */
    public void runLevels(List<LevelInformation> levels) {

        for (LevelInformation levelInfo : levels) {

            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, this.gui,
                    this.scoreCounter, scoreTrackingListener);

            level.initialize();

            while (level.getLevelInformation().numberOfBalls() != 0
                    && level.getLevelInformation().numberOfBlocksToRemove() != 0) {
                level.run();
                break;
            }
            if (level.getLevelInformation().numberOfBalls() == 0) {
                this.animationRunner.run(new EndScreen(keyboardSensor, scoreCounter));
                gui.close();
                break;
            }
        }
        this.animationRunner.run(new WinScreen(keyboardSensor, scoreCounter));
        gui.close();
    }
}
import biuoop.GUI;

import java.util.ArrayList;
import java.util.List;

/**
 * @author neria doron 315351445
 * Ass5Game
 */
public class Ass6Game {
    private static final int ZERO = 0;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    /**
     * @param args ka
     * Run the game -- start the animation loop.
     */
    public static void main(String[] args) {
        Counter scoreCounter =  new Counter();
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(scoreCounter);
        GUI gui = new GUI("title", WIDTH, HEIGHT);
        AnimationRunner runner = new AnimationRunner(gui);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        GameFlow game = new GameFlow(runner, keyboard, gui, scoreCounter, scoreTrackingListener);
        List<LevelInformation> levels = new ArrayList<>();
        for (String lvl:args) {
            if (lvl.equals("1")) {
                levels.add(new DirectHit());
            }
            if (lvl.equals("2")) {
                levels.add(new WideEasy());
            }
            if (lvl.equals("3")) {
                levels.add(new Green());
            }
            if (lvl.equals("4")) {
                levels.add(new FinalFour());
            }
        }
        game.runLevels(levels);
    }
}

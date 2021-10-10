import biuoop.DrawSurface;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Meme Generator.
 */
public class Memes {
    /**
     * @param d surface to draw on
     * add cupoftea meme to surface.
     */
    public void cupOfTea(DrawSurface d) {
        try {
            Scanner s = new Scanner(new File("cupoftea.txt"));
            ArrayList<Color> list = new ArrayList<Color>();
            while (s.hasNextInt()) {
                list.add(new Color(s.nextInt(), s.nextInt(), s.nextInt()));
            }
            s.close();
            int x = 600;
            int y = 100;
            for (Color color : list) {
                if (y == 200) {
                    x = x + 1;
                    y = 100;
                }
                d.setColor(color);
                d.fillRectangle(x, y, 1, 1);
                y = y + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * @param d surface to draw on
     * add cupoftea meme to surface.
     */
    public void shrek(DrawSurface d) {
        try {
            Scanner s = new Scanner(new File("shrek.txt"));
            ArrayList<Color> list = new ArrayList<Color>();
            while (s.hasNextInt()) {
                list.add(new Color(s.nextInt(), s.nextInt(), s.nextInt()));
            }
            s.close();
            int x = 600;
            int y = 200;
            for (Color color : list) {
                if (y == 320) {
                    x = x + 1;
                    y = 200;
                }
                d.setColor(color);
                d.fillRectangle(x, y, 1, 1);
                y = y + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

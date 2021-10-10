import java.util.ArrayList;
import java.util.List;

/**
 * @author neria doron 315351445
 * Game Env
 */
public class GameEnvironment {
    private final List<Collidable> colides = new ArrayList<>();
    /**
     * @param c add collidable
     */
    public void addCollidable(Collidable c) {
        colides.add(c);
    }
    /**
     * @param c remove collidable
     */
    public void removeCollidable(Collidable c) {
        colides.remove(c);
    }
    /**
     * @param trajectory line of trajectory
     * @return collideInfo
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        List<Collidable> colides1 = new ArrayList<Collidable>(this.colides);
        for (Collidable colide : colides1) {
            if (trajectory.closestIntersectionToStartOfLine(colide.getCollisionRectangle()) != null) {
                return new CollisionInfo(trajectory, colide);
            }
        }
        return null;
    }
}
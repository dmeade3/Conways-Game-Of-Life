package Game_Parts;

/**
 *
 * Created by David Meade on 8/11/2016.
 *
 */
public class Cell {

    private int x;
    private int y;
    private boolean dead = false;

    public Cell(int x, int y) {

        this.x = x;
        this.y = y;
    }

    boolean getDeadStatus() {
        return this.dead;
    }

    int getX() {
        return this.x;
    }

    int getY() {
        return this.y;
    }

    void kill() {
        this.dead = true;
    }

    @Override
    public int hashCode() {
        int hash = 17;
        hash = ((hash + x) << 5) - (hash + x);
        hash = ((hash + y) << 5) - (hash + y);
        return hash;
    }
}

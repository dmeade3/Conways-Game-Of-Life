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

    public boolean getDeadStatus() {
        return this.dead;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void kill() {
        this.dead = true;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += this.x * 17;
        hash += this.y * 31;

        return hash;
    }
}

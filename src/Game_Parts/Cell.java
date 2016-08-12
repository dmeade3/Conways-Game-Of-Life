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

    public boolean getLivingStatus() {
        return this.dead;
    }

    public int getX() {
        return this.x;
    }

    public void kill() {
        this.dead = true;
    }

    @Override
    public int hashCode() {
        return  (((x * y) / x) + y + 17);
    }
}

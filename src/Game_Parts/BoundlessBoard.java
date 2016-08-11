package Game_Parts;

import java.util.LinkedList;

/**
 *
 * Created by David Meade on 8/11/2016.
 *
 */

public class BoundlessBoard {


    private int displayHeight = 5;

    private int displayWidth = 5;

    private LinkedList<Cell> cellHolder = new LinkedList();


    public BoundlessBoard(int height, int width) {

        this.displayHeight = height;
        this.displayWidth = width;
    }

    public void addCell() {

    }

    public void cleanDeadCells() {


    }
}

package Game_Parts;

import java.util.*;

/**
 *
 * Created by David Meade on 8/11/2016.
 *
 */

public class BoundlessBoard {

    // Default
    private int displayHeight = 5;

    // Default
    private int displayWidth = 5;

    private int[][] board;

    private Hashtable<Integer, Cell> cellHolder = new Hashtable<>();

    private Hashtable<Integer, Cell> addCellHolder = new Hashtable<>();


    public BoundlessBoard(int width, int height) {

        this.displayHeight = height;
        this.displayWidth = width;
    }

    public void addCell(Cell cellToAdd) {

        if (!this.cellHolder.containsKey(cellToAdd.hashCode())) {
            this.cellHolder.put(cellToAdd.hashCode(), cellToAdd);
        }
    }

    private void cleanDeadCells() {

        LinkedList<Integer> listToRemove = new LinkedList<>();

        // For loop through the cell holder and mark the ones
        // with a status of dead
        for (Object o : cellHolder.entrySet()) {
            Map.Entry pair = (Map.Entry) o;

            Cell cell = (Cell) pair.getValue();

            // If Dead mark to be removed
            if (cell.getDeadStatus()) {
                listToRemove.add(cell.hashCode());
            }
        }

        // Remove
        for (Object o : listToRemove) {

            int cellId = (int) o;

            this.cellHolder.remove(cellId);
        }
    }

    private int rule123(Cell cell) {

        int neighborCount = 0;

        // Count up neighbors for the cell

        // (0,2) (1,2) (2,2)
        // (0,1) (1,1) (2,1)      1,1 is your cell
        // (0,0) (1,0) (2,0)

        Cell tempCell;

        // Checks left column
        if (cell.getX() - 1 >= 0) {

            tempCell = new Cell(cell.getX()-1, cell.getY()-1);
            if (this.cellHolder.containsKey(tempCell.hashCode())) {
                neighborCount++;
            }

            tempCell = new Cell(cell.getX()-1, cell.getY());
            if (this.cellHolder.containsKey(tempCell.hashCode())) {
                neighborCount++;
            }

            tempCell = new Cell(cell.getX()-1, cell.getY()+1);
            if (this.cellHolder.containsKey(tempCell.hashCode())) {
                neighborCount++;
            }
        }

        // Checks top (1)
        if (cell.getY() + 1 <= this.displayHeight-1) {

            tempCell = new Cell(cell.getX(), cell.getY()+1);
            if (this.cellHolder.containsKey(tempCell.hashCode())) {
                neighborCount++;
            }
        }

        // Checks bottom (1)
        if (cell.getY() - 1 >= 0) {

            tempCell = new Cell(cell.getX(), cell.getY()-1);
            if (this.cellHolder.containsKey(tempCell.hashCode())) {
                neighborCount++;
            }
        }

        // Checks right column
        if (cell.getX() + 1 <= this.displayWidth-1) {

            tempCell = new Cell(cell.getX()+1, cell.getY()-1);
            if (this.cellHolder.containsKey(tempCell.hashCode())) {
                neighborCount++;
            }

            tempCell = new Cell(cell.getX()+1, cell.getY());
            if (this.cellHolder.containsKey(tempCell.hashCode())) {
                neighborCount++;
            }

            tempCell = new Cell(cell.getX()+1, cell.getY()+1);
            if (this.cellHolder.containsKey(tempCell.hashCode())) {
                neighborCount++;
            }
        }

        // Each cell with one or no neighbors dies, as if by solitude or
        // Each cell with four or more neighbors dies, as if by overpopulation.
        if ((neighborCount <= 1) || (neighborCount >= 4)) {

            // kill the cell
            cellHolder.getOrDefault(cell.hashCode(), cell).kill();
        }

        // Else Each cell with two or three neighbors survives.

        return neighborCount;
    }

    private void rule4() {

        // Each cell with three neighbors becomes populated.

        int neighborCount;
        Cell tempCell;

        for (int x = 0; x < this.displayWidth; x++) {

            for (int y = 0; y < this.displayHeight; y++) {

                tempCell = new Cell(x, y);

                // Check if tempCell is already a real cell
                if (cellHolder.containsKey(tempCell.hashCode())) {
                    continue;
                }
                else {
                    neighborCount = rule123(tempCell);

                    if (neighborCount == 3) {
                        addCellHolder.put(tempCell.hashCode(), tempCell);
                    }
                }
            }
        }
    }

    public void runCycle() {

        for (Object o : cellHolder.entrySet()) {
            Map.Entry pair = (Map.Entry) o;

            Cell cell = (Cell) pair.getValue();

            rule123(cell);
        }

        rule4();

        // Add in cells that were added in rules
        for (Object o : addCellHolder.entrySet()) {
            Map.Entry pair = (Map.Entry) o;

            Cell cell = (Cell) pair.getValue();

            cellHolder.put(cell.hashCode(), cell);
        }

        cleanDeadCells();
    }

    private void loadBoard() {
        board = new int[displayWidth][displayHeight];

        // Load board
        for (Object o : cellHolder.entrySet()) {
            Map.Entry pair = (Map.Entry) o;

            Cell cell = (Cell) pair.getValue();

            this.board[ cell.getX() ][ cell.getY() ] = 1;
        }
    }

    public void displayBoard() {

        loadBoard();

        // Print Board

        // Separate the board views
        System.out.println("\n\n\n");

        // Border
        for (int i = 0; i < this.displayWidth + 2; i++) {
            System.out.print("-");
        }

        System.out.println();

        // Print Board
        for (int y = displayHeight-1; y >= 0; y--) {

            System.out.print("|");
            for (int x = 0; x < this.displayWidth; x++) {

                if (this.board[x][y] == 1) {
                    System.out.print("*");
                }

                else { System.out.print(" "); }
            }

            System.out.println("|");
        }

        // Bottom border
        for (int i = 0; i < this.displayWidth + 2; i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        BoundlessBoard b1 = new BoundlessBoard(7, 7);

        Cell c1 = new Cell(0, 0);
        Cell c2 = new Cell(6, 0);
        Cell c3 = new Cell(0, 6);
        Cell c4 = new Cell(6, 6);

        b1.addCell(c1);
        b1.addCell(c2);
        b1.addCell(c3);
        b1.addCell(c4);

        b1.displayBoard();

        b1.runCycle();

        b1.displayBoard();

    }
}
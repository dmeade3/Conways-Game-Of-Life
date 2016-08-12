package Main;

import Game_Parts.BoundlessBoard;
import Game_Parts.Cell;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long waitTimeMilli = 500;

        int height = 7;

        int width = 7;

        BoundlessBoard board = new BoundlessBoard(height, width);

        // Set up initial state of the cells here //////////////////////////////////////////////////////////////////////

        Cell c1 = new Cell(3, 3);
        Cell c2 = new Cell(3, 4);
        Cell c3 = new Cell(4, 3);
        Cell c4 = new Cell(4, 4);

        board.addCell(c1);
        board.addCell(c2);
        board.addCell(c3);
        board.addCell(c4);

// ######### Running Actual Game #######################################################################################

        // Print initial Board
        board.displayBoard();

        while (true) {

            // Ask how many moves to go before next stop
            Scanner scanner = new Scanner(System.in);
            int input = 0;
            boolean bError = true;
            while (bError) {
                System.out.println("How many cycles to run before break: ");
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                }
                else {
                    scanner.next();
                    continue;
                }
                bError = false;
            }

            // run n cycles of game
            for (int i = 0; i < input; i++) {

                board.runCycle();

                // Display board
                board.displayBoard();

                // pause in between each cycle
                TimeUnit.MILLISECONDS.sleep(waitTimeMilli);
            }
        }
//######################################################################################################################
    }
}

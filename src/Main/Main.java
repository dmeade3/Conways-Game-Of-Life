package Main;

import Game_Parts.BoundlessBoard;
import Game_Parts.Cell;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long waitTimeMilli = 100;

        int width = 150;

        int height = 30;



        BoundlessBoard board = new BoundlessBoard(width, height);

        // Set up initial state of the cells here //////////////////////////////////////////////////////////////////////

        Cell c1 =  new Cell(70,  15);
        Cell c2 =  new Cell(71,  15);
        Cell c3 =  new Cell(72,  15);
        Cell c4 =  new Cell(73, 15);
        Cell c5 =  new Cell(74, 15);
        Cell c6 =  new Cell(75, 15);
        Cell c7 =  new Cell(76, 15);
        Cell c8 =  new Cell(77, 15);
        Cell c9 =  new Cell(78, 15);
        Cell c10 = new Cell(79, 15);


        board.addCell(c1);
        board.addCell(c2);
        board.addCell(c3);
        board.addCell(c4);
        board.addCell(c5);
        board.addCell(c6);
        board.addCell(c7);
        board.addCell(c8);
        board.addCell(c9);
        board.addCell(c10);

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

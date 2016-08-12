package Main;

import Game_Parts.BoundlessBoard;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import static Structures.Structures.GosperGliderGun;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        long waitTimeMilli = 30;

        int width = 150;

        int height = 30;

        // load the structure
        BoundlessBoard board = GosperGliderGun(width, height);

// ######### Running Actual Game #######################################################################################

        // Print initial Board
        board.displayBoard();

        while (true) {

            // Ask how many moves to go before next stop
            Scanner scanner = new Scanner(System.in);
            int input = 0;
            boolean bError = true;
            while (bError) {
                System.out.println("How many cycles to run before break (0 to quit): ");
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                }
                else {
                    scanner.next();
                    continue;
                }
                bError = false;
            }

            if (input == 0) {
                break;
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

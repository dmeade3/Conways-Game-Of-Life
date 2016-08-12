package Structures;

import Game_Parts.BoundlessBoard;
import Game_Parts.Cell;

/**
 * Created by dcmeade on 8/12/2016.
 */
public class Structures {

    public static BoundlessBoard rowExploder(int width,int height) {
        BoundlessBoard board = new BoundlessBoard(width, height);

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

        return board;
    }


    public static BoundlessBoard GosperGliderGun(int width,int height) {
        BoundlessBoard board = new BoundlessBoard(width, height);

        /*Cell c1 =  new Cell(70 + , 15 + );
        Cell c2 =  new Cell(70 + , 15 + );
        Cell c3 =  new Cell(70 + , 15 + );
        Cell c4 =  new Cell(70 + , 15 + );
        Cell c5 =  new Cell(70 + , 15 + );
        Cell c6 =  new Cell(70 + , 15 + );
        Cell c7 =  new Cell(70 + , 15 + );
        Cell c8 =  new Cell(70 + , 15 + );
        Cell c9 =  new Cell(70 + , 15 + );
        Cell c10 = new Cell(70 + , 15 + );


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
        board.addCell(c11);
        board.addCell(c12);
        board.addCell(c13);
        board.addCell(c14);
        board.addCell(c15);
        board.addCell(c16);
        board.addCell(c17);
        board.addCell(c18);
        board.addCell(c19);
        board.addCell(c20);
        board.addCell(c21);
        board.addCell(c22);
        board.addCell(c23);
        board.addCell(c24);
        board.addCell(c25);
        board.addCell(c26);
        board.addCell(c27);
        board.addCell(c28);
        board.addCell(c29);
        board.addCell(c30);
        board.addCell(c31);
        board.addCell(c32);
        board.addCell(c33);
        board.addCell(c34);
        board.addCell(c35);
        board.addCell(c36);*/

        return board;
    }

}

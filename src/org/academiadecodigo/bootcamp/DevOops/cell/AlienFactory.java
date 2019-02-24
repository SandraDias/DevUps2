package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.bootcamp.DevOops.Grid;

import java.util.LinkedList;

public class AlienFactory {


    private static LinkedList<Alien> alienLinkedList;

    public static Alien getNewAst(Grid grid) {
        int randRow = grid.randAstPosRow();
        int lastRow = randRow;
        int randCol = grid.randAstPosCol();
        for (Alien aste : alienLinkedList) {
            while (lastRow == aste.getRow()) {
                randRow = grid.randAstPosRow();
                lastRow = randRow;

            }

        }

        Alien ast = new Alien(randRow, randCol, DiferentAliens.pickAlien());
        ast.paint();
        return ast;
    }


    public static LinkedList<Alien> getAllAst(Grid grid, int enemiesPerRow) {
        alienLinkedList = new LinkedList();

        for (int i = 0; i < enemiesPerRow; i++) {
            alienLinkedList.add(AlienFactory.getNewAst(grid));
        }


        return alienLinkedList;


    }

}

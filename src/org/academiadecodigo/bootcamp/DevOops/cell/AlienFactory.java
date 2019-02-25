package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.bootcamp.DevOops.Game;
import org.academiadecodigo.bootcamp.DevOops.Grid;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.LinkedList;

public class AlienFactory {


    private static LinkedList<Alien> alienLinkedList;

    public static Alien getNewAst(Grid grid) {
        int randRow = grid.randAstPosRow();
        int lastRow = randRow;
        int randCol = grid.randAstPosCol();

        for (Alien alien : alienLinkedList) {
            while (lastRow == alien.getRow()) {
                randRow = grid.randAstPosRow();
                lastRow = randRow;

            }
        }

        Alien ast = new Alien(lastRow, grid.randAstPosCol(), DiferentAliens.pickAlien());

        return ast;

    }

    public static LinkedList<Alien> getAllAst(Grid grid, int enemiesPerRow) {
        alienLinkedList = new LinkedList<>();

        for (int i = 0; i < enemiesPerRow; i++) {
            alienLinkedList.add(AlienFactory.getNewAst(grid));
        }


        return alienLinkedList;


    }
}







package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.bootcamp.DevOops.Grid;

import java.util.LinkedList;

public class AlienFactory {


    private static LinkedList<Alien> alienLinkedList;
    private static int lastRow;

    public static Alien getNewAst(Grid grid) {
        lastRow = grid.randAstPosRow();
        Alien ast = new Alien(lastRow, grid.randAstPosCol(), DiferentAliens.pickAlien());

        return ast;
    }

    private static void verify(Grid grid, Alien ali,LinkedList<Alien> aliens) {
        int randRow;
        int randCol = grid.randAstPosCol();

        for (Alien alien : aliens) {
                while (alien.getRow() == ali.getRow()) {
                    randRow = grid.randAstPosRow();
                    ali.setRow(randRow);
                    System.out.println(randRow);

                }
            }


        }



        public static LinkedList<Alien> getAllAst (Grid grid,int enemiesPerRow){
            alienLinkedList = new LinkedList<>();

            for (int i = 0; i < enemiesPerRow; i++) {
                Alien alien = getNewAst(grid);
                Alien lastAlien = alien;
                verify(grid,lastAlien,alienLinkedList);
                alienLinkedList.add(lastAlien);
            }



            return alienLinkedList;


        }

    }


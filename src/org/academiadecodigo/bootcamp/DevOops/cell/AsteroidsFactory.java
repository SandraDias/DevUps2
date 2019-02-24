package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.bootcamp.DevOops.Grid;

import java.util.LinkedList;

public class AsteroidsFactory {


    private static LinkedList<Asteroids> ld;

    public static Asteroids getNewAst(Grid grid) {
        int randRow = grid.randAstPosRow();
        int lastRow = randRow;
        int randCol = grid.randAstPosCol();
        for (Asteroids aste : ld) {
            while (lastRow == aste.getRow()) {
                randRow = grid.randAstPosRow();
                lastRow = randRow;

            }

        }

        Asteroids ast = new Asteroids(randRow, randCol, Aliens.pickAlien());
        ast.paint();
        return ast;
    }


    public static LinkedList<Asteroids> getAllAst(Grid grid, int enemiesPerRow) {
        ld = new LinkedList();

        for (int i = 0; i < enemiesPerRow; i++) {
            ld.add(AsteroidsFactory.getNewAst(grid));
        }


        return ld;


    }

}

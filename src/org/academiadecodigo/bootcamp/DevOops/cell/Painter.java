package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.bootcamp.DevOops.cell.Asteroids;
import org.academiadecodigo.bootcamp.DevOops.cell.Cell;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Painter extends Cell {

    private int currentCol;
    private int currentRow;
    private int life;
    private boolean isOutOfLives = false;
    private int movedRow;
    private int movedCol;

    Picture p1;

    public Painter(int row, int life) {
        super(row, 1);
        super.getRectangle();
        p1 = new Picture(PADDING + CELL_SIZE, PADDING + row * CELL_SIZE, "aust1.png");
        p1.draw();

        this.life = life;


    }


    public void up(LinkedList<Asteroids> ldl) {

        super.setRow(getRow() - 1);
        p1.translate(0, -getCELL_SIZE());
    }

    public void right() {

        super.setCol(getCol() + 1);
        p1.translate(getCELL_SIZE(), 0);
    }

    public void left(LinkedList<Asteroids> ldl) {

        super.setCol(getCol() - 1);
        p1.translate(-getCELL_SIZE(), 0);
        checkCollision(ldl);


    }

    public void down(LinkedList<Asteroids> ldl) {

        super.setRow(getRow() + 1);
        p1.translate(0, getCELL_SIZE());


    }

    // proxima do ast == ultima do player && proxima player == ultimate do ast

    public void checkCollision(LinkedList<Asteroids> ldl) {

        currentCol = super.getCol();
        currentRow = super.getRow();

        for (Asteroids ast : ldl) {
            if (this.currentRow == ast.getRow() && currentCol + 1 == ast.getCol() - 1) {
                // ast.rec().delete();
                ast.deleteAlien();
                life = life - 1;
                return;
            }
            if (this.currentRow == ast.getRow() && currentCol == ast.getCol()) {
                //ast.rec().delete();
                ast.deleteAlien();
                life = life - 1;
                return;
            }
        }
    }


    public int getLife() {
        return life;
    }

    public boolean isOutOfLives() {
        return isOutOfLives;
    }

    public void setOutOfLives(boolean outOfLives) {
        isOutOfLives = outOfLives;
    }

    public void setLife(int life) {
        this.life = life;
    }
}

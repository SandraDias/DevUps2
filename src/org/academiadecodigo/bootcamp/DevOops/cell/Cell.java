package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;


public class Cell {

    public static final int CELL_SIZE = 40;
    public static final int PADDING = 10;
    private boolean isFilled = false;

    private Rectangle rectangle;
    private int row;
    private int col;
    private boolean isPainted = false;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;

        rectangle = new Rectangle(PADDING + col * CELL_SIZE, PADDING + row * CELL_SIZE, CELL_SIZE, CELL_SIZE);

    }

    public int getCELL_SIZE() {
        return CELL_SIZE;
    }

    public Rectangle getRectangle() {
        return rectangle;
    }


    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}


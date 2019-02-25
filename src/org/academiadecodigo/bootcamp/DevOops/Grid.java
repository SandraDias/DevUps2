package org.academiadecodigo.bootcamp.DevOops;


import org.academiadecodigo.bootcamp.DevOops.cell.Cell;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Grid {

    private int rows;
    private int cols;
    private Cell[][] cells;

    public Grid(int rows, int cols) {
        Picture pic = new Picture(Cell.PADDING, Cell.PADDING, "Mars.jpg");
        pic.draw();
        this.rows = rows;
        this.cols = cols;
        cells = new Cell[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                cells[row][col] = new Cell(row, col);
            }
        }
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }


    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int randAstPosRow() {

        return (int) (Math.random() * (this.getRows()-1)) + 1;


    }

    public int randAstPosCol(){
        return this.getCols()-1;

    }


}


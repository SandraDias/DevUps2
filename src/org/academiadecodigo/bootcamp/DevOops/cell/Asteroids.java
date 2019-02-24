package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Asteroids extends Cell {

    private Picture alien;

    public Asteroids(int row, int col, String picturePath) {
        super(row, col);
        alien = new Picture(PADDING+col*CELL_SIZE,PADDING + row * CELL_SIZE, picturePath);
        alien.draw();

    }

    public Rectangle rec() {
        return super.getRectangle();
    }


    public void left() {
        super.setCol(getCol() - 1);
        super.getRectangle().translate(-getCELL_SIZE(), 0);
        alien.translate(-getCELL_SIZE(), 0);
    }

    public void deleteAlien() {
        this.alien.delete();
    }


}

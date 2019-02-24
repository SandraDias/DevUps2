package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Alien extends Cell {


    private Picture alien;
    private Picture fire;

    public Alien(int row, int col, String picturePath) {
        super(row, col);
        alien = new Picture(PADDING+col*CELL_SIZE,PADDING + row * CELL_SIZE, picturePath);
        alien.draw();
        fire = new Picture(PADDING+col*CELL_SIZE,PADDING + row * CELL_SIZE, "resources/fire.png");

    }


    public Picture getAlien() {
        return alien;
    }

    public Picture getFire() {
        return fire;
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

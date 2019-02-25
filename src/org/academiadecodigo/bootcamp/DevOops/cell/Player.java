package org.academiadecodigo.bootcamp.DevOops.cell;

import org.academiadecodigo.bootcamp.DevOops.Game;
import org.academiadecodigo.bootcamp.DevOops.SoundPlayer;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.IOException;
import java.util.LinkedList;

public class Player extends Cell {

    private int currentCol;
    private int currentRow;
    private int life;
    private boolean isOutOfLives = false;
    private boolean isPlayerHit = false;
    private int movedRow;
    private int movedCol;
    private Picture lifePicture1;
    private Picture lifePicture2;
    private Picture lifePicture3;
    Picture picturePlayer1;
    private SoundPlayer soundPlayer = new SoundPlayer();


    public Player(int row, int life) {
        super(row, 1);
        super.getRectangle();
        picturePlayer1 = new Picture(PADDING + CELL_SIZE, PADDING + row * CELL_SIZE, "aust1.png");
        picturePlayer1.draw();

        this.life = life;
        this.lifePicture1= new Picture(Cell.PADDING,Cell.PADDING, "life.png");
        lifePicture1.draw();
        this.lifePicture2= new Picture(Cell.PADDING+ Cell.CELL_SIZE,Cell.PADDING, "life.png");
        lifePicture2.draw();
        this.lifePicture3= new Picture(Cell.PADDING+(2*Cell.CELL_SIZE),Cell.PADDING, "life.png");
        lifePicture3.draw();




    }


    public void up(LinkedList<Alien> alienLinkedList) {
        //checkCollisionRow(alienLinkedList,-1);
        super.setRow(getRow() - 1);
        picturePlayer1.translate(0, -getCELL_SIZE());
    }

    public void right(LinkedList<Alien> alienLinkedList) {
    checkCollisionCol(alienLinkedList,+1);
        super.setCol(getCol() + 1);
        picturePlayer1.translate(getCELL_SIZE(), 0);
    }

    public void left(LinkedList<Alien> alienLinkedList) {
        checkCollisionCol(alienLinkedList,-1);
        super.setCol(getCol() - 1);
        picturePlayer1.translate(-getCELL_SIZE(), 0);


    }

    public void down(LinkedList<Alien> alienLinkedList) {
        //checkCollisionRow(alienLinkedList,+1);
        super.setRow(getRow() + 1);
        picturePlayer1.translate(0, getCELL_SIZE());


    }

    public void checkCollisionCol(LinkedList<Alien> alienLinkedList,int LeftOrRight) {

        currentCol = super.getCol();
        currentRow = super.getRow();
        int nextCol = super.getCol() + LeftOrRight;
        int checkCol;
        checkCol = nextCol;

        for (Alien ast : alienLinkedList) {
            if (this.currentRow == ast.getRow() && checkCol == ast.getCol()) {
                try {
                    soundPlayer.explosion();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                life = life - 1;
                    if (life == 1) {
                        lifePicture3.delete();
                    }
                    if (life == 0) {
                        lifePicture2.delete();
                    }
                    ast.deleteAlien();
                    Picture fire = new Picture(10 + ast.getCol() * 40, 10 + ast.getRow() * 40, "fire.png");
                    fire.draw();
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fire.delete();


                }

        }
    }

   /* public void checkCollisionRow(LinkedList<Alien> alienLinkedList,int UPorDown){
        currentCol = super.getCol();
        currentRow = super.getRow();
        int nextRow = super.getRow()+UPorDown;
        int checkRow;
        checkRow = nextRow;

        for (Alien ast : alienLinkedList) {
            if (checkRow == ast.getRow() && currentCol == ast.getCol()) {
                ast.deleteAlien();
                Picture fire = new Picture(10 + ast.getCol() * 40, 10 + ast.getRow() * 40, "resources/fire.png");
                fire.draw();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fire.delete();
                life = life - 1;
                if (life == 1) {
                    lifePicture3.delete();
                }
                if (life == 0) {
                    lifePicture2.delete();
                }

            }

        }
    }*/


    public void checkCollision(LinkedList<Alien> alienLinkedList) {

        currentCol = super.getCol();
        currentRow = super.getRow();

        for (Alien ast : alienLinkedList) {
            if (this.currentRow == ast.getRow() && currentCol == ast.getCol() || this.currentRow  == ast.getRow() && currentCol + 1 == ast.getCol()) {
                try {
                    soundPlayer.explosion();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                life = life - 1;
                    if (life == 1) {
                        lifePicture3.delete();
                    }
                    if (life == 0) {
                        lifePicture2.delete();
                    }
                    ast.deleteAlien();
                    Picture fire = new Picture(10 + ast.getCol() * 40, 10 + ast.getRow() * 40, "fire.png");
                    fire.draw();
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    fire.delete();

                }
            }


            /*if (this.currentRow == ast.getRow() && currentCol == ast.getCol()) {
                ast.deleteAlien();
                Picture fire = new Picture(10+ast.getCol()*40,10+ast.getRow()*40, "resources/fire.png");
                fire.draw();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fire.delete();
                life = life - 1;
                if (life == 1){
                    lifePicture3.delete();
                }
                if (life == 0){
                    lifePicture2.delete();
                }
                return;
            }*/
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

    public boolean isPlayerHit() {
        return isPlayerHit;
    }

    public void setPlayerHit(boolean playerHit) {
        isPlayerHit = playerHit;
    }
}

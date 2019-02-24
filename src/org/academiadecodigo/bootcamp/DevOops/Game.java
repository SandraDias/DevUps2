package org.academiadecodigo.bootcamp.DevOops;

import org.academiadecodigo.bootcamp.DevOops.cell.Asteroids;
import org.academiadecodigo.bootcamp.DevOops.cell.AsteroidsFactory;
import org.academiadecodigo.bootcamp.DevOops.cell.Cell;
import org.academiadecodigo.bootcamp.DevOops.cell.Painter;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Game {

    private Grid grid;
    private Painter painter;
    private Painter painter2;
    private LinkedList<Asteroids> linkedList;
    private int counter = 5;
    private int life = 2;
    private boolean isDead = false;
    private PlayerBar pb;
    private int enemiesPerRow;
    private Picture endScreen;


    public Game(int rows, int cols,int enemiesPerRow) {
        linkedList = new LinkedList<>();
        grid = new Grid(rows, cols);
        painter = new Painter(5,life);
        pb = new PlayerBar(rows,cols);
        this.enemiesPerRow = enemiesPerRow;
    }


    public void start() throws InterruptedException {
        while(!painter.isOutOfLives()){

            Thread.sleep(100);
            if(counter++ == 5) {
                //linkedList.add(AsteroidsFactory.getNewAst(grid));
                linkedList.addAll(AsteroidsFactory.getAllAst(grid,enemiesPerRow));

                counter = 0;
            }

            for (Asteroids ast: linkedList) {
                ast.left();
                if(painter.getCol() == ast.getCol() && painter.getRow() == ast.getRow()){
                    ast.rec().delete();
                    System.out.println((painter.getLife()) + "-1 life");
                    if(painter.getLife() == 0){
                        painter.setOutOfLives(true);
                        continue;
                    }
                    painter.checkCollision(linkedList);
                }
                if (ast.getCol() == -1) {
                    ast.rec().delete();
                }
            }
        }
        endScreen = new Picture(Cell.PADDING ,Cell.PADDING,"gameover1.jpg");
        endScreen.draw();
    }


    public void paint() {

        Cell cell = grid.getCell(painter.getRow(), painter.getCol());

        if (!cell.isPainted()) {
            cell.paint();
            return;
        }

        cell.unpaint();


    }

    public void moveUp() {
        if(!painter.isOutOfLives()) {
            if (painter.getRow() != 1) {
                painter.up(linkedList);
            }
        }

    }

    public void moveLeft() {
        if (!painter.isOutOfLives()) {
            if (painter.getCol() != 1) {
                painter.left(linkedList);
            }
        }
    }

    public void moveRight() {
        if(!painter.isOutOfLives()) {

            if (painter.getCol() != grid.getCols() - 2) {
                painter.right();
            }
        }
    }

    public void moveDown() {
        if(!painter.isOutOfLives()) {
            if (painter.getRow() != grid.getRows() - 2) {
                painter.down(linkedList);
            }
        }
    }


    public void skills() throws Exception{


    }

}



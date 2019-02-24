package org.academiadecodigo.bootcamp.DevOops;

import org.academiadecodigo.bootcamp.DevOops.cell.AlienFactory;
import org.academiadecodigo.bootcamp.DevOops.cell.Alien;
import org.academiadecodigo.bootcamp.DevOops.cell.Cell;
import org.academiadecodigo.bootcamp.DevOops.cell.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;


public class Game  {

    private Grid grid;
    private Player player;
    private Player painter2;
    private LinkedList<Alien> linkedList;
    private int counter = 5;
    private int life = 2;
    private boolean isDead = false;
    private PlayerBar playerBar;
    private int enemiesPerRow;
    private Picture endScreen;
    private Picture startScreen;
    private boolean gameStart = false;



    public Game(int rows, int cols,int enemiesPerRow) {
        startScreen=new Picture(Cell.PADDING, Cell.PADDING, "resources/start.jpg");
        linkedList = new LinkedList<>();
        grid = new Grid(rows, cols);
        player = new Player(5,life);
        playerBar = new PlayerBar(rows,cols);
        this.enemiesPerRow = enemiesPerRow;
        startScreen.draw();
    }



    public void start() throws InterruptedException {

        while(!player.isOutOfLives()){

            Thread.sleep(200);
            if(gameStart) {
                startScreen.delete();
                if (counter++ == 5) {
                    //linkedList.add(AlienFactory.getNewAst(grid));
                    linkedList.addAll(AlienFactory.getAllAst(grid, enemiesPerRow));

                    counter = 0;
                }
            }

            for (Alien ast: linkedList) {
                ast.left();
                if(player.getCol() == ast.getCol() && player.getRow() == ast.getRow()){

                    if(player.getLife() <= 0){
                    player.setOutOfLives(true);
                    continue;
                }
                    ast.getAlien().delete();
                   Picture fire = new Picture(10+ast.getCol()*40,10+ast.getRow()*40, "resources/fire.png");
                    fire.draw();
                    Thread.sleep(150);
                    fire.delete();
                    System.out.println((player.getLife()) + "-1 life");

                    player.checkCollision(linkedList);
                }

                if (ast.getCol() == -1) {
                    ast.getAlien().delete();
                }
                ast.getFire().delete();
            }

        }
        endScreen = new Picture(Cell.PADDING ,Cell.PADDING,"resources/gameover1.jpg");
        endScreen.draw();
        Thread.sleep(2500);
        System.exit(0);
    }


    public void paint() {

        Cell cell = grid.getCell(player.getRow(), player.getCol());

        if (!cell.isPainted()) {
            cell.paint();
            return;
        }

        cell.unpaint();


    }


    public void moveUp() {
        if(!player.isOutOfLives()) {
            if (player.getRow() != 1) {
                player.up(linkedList);
            }
        }

    }

    public void moveLeft() {
        if (!player.isOutOfLives()) {
            if (player.getCol() != 1) {
                player.left(linkedList);
            }
        }
    }

    public void moveRight() {
        if(!player.isOutOfLives()) {

            if (player.getCol() != grid.getCols() - 2) {
                player.right(linkedList);
            }
        }
    }

    public void moveDown() {
        if(!player.isOutOfLives()) {
            if (player.getRow() != grid.getRows() - 1) {
                player.down(linkedList);
            }
        }
    }


    public void setGameStart(boolean gameStart) {
        this.gameStart = gameStart;
    }

}



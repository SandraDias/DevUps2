package org.academiadecodigo.bootcamp.DevOops;

import org.academiadecodigo.bootcamp.DevOops.cell.AlienFactory;
import org.academiadecodigo.bootcamp.DevOops.cell.Alien;
import org.academiadecodigo.bootcamp.DevOops.cell.Cell;
import org.academiadecodigo.bootcamp.DevOops.cell.Player;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.io.IOException;
import java.util.LinkedList;


public class Game  {

    private Grid grid;
    private Player player;
    private Player painter2;
    private LinkedList<Alien> linkedList;
    private int counter = 3;
    private int life = 2;
    private boolean isDead = false;
    private PlayerBar playerBar;
    private int enemiesPerRow;
    private Picture endScreen;
    private Picture startScreen;
    private boolean gameStart = false;
    private SoundPlayer soundPlayer;



    public Game(int rows, int cols,int enemiesPerRow) {
        startScreen=new Picture(Cell.PADDING, Cell.PADDING, "start.jpg");
        linkedList = new LinkedList<>();
        grid = new Grid(rows, cols);
        player = new Player(5,life);
        playerBar = new PlayerBar(rows,cols);
        this.enemiesPerRow = enemiesPerRow;
        startScreen.draw();
    }



    public void start() throws InterruptedException, IOException {

        while(!player.isOutOfLives()){

            Thread.sleep(50);
            if(gameStart) {
                startScreen.delete();
                if (counter++ == 3) {
                    //linkedList.add(AlienFactory.getNewAst(grid));
                    linkedList.addAll(AlienFactory.getAllAst(grid, enemiesPerRow));

                    counter = 0;
                }
            }

            for (Alien ast: linkedList) {
                ast.left();
                soundPlayer = new SoundPlayer();
                if(player.getCol() == ast.getCol() && player.getRow() == ast.getRow()){
                    if(player.getLife() <= 0){
                    player.setOutOfLives(true);
                    continue;
                }

                        ast.getAlien().delete();
                        Picture fire = new Picture(10+ast.getCol()*40,10+ast.getRow()*40, "fire.png");
                        fire.draw();
                        soundPlayer.explosion();
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
            player.setPlayerHit(false);
        }
        endScreen = new Picture(Cell.PADDING ,Cell.PADDING,"gameover1.jpg");
        soundPlayer.explosion();
        endScreen.draw();
        Thread.sleep(2500);
        System.exit(0);
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



package org.academiadecodigo.bootcamp.DevOops;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayerBar{

    private final int CELL_SIZE = 40;
    private final int PADDING = 10;

    private Rectangle rectangle;
    private Rectangle rectangle2;
    private Rectangle rectangle3;
    private Rectangle rectangle4;

    public PlayerBar(int row,int col) {
        rectangle = new Rectangle(PADDING,PADDING,col * CELL_SIZE,CELL_SIZE);
        rectangle2 = new Rectangle(PADDING,PADDING + (row-1) * CELL_SIZE,col * CELL_SIZE,CELL_SIZE);
        rectangle3 = new Rectangle(PADDING,PADDING, CELL_SIZE,row*CELL_SIZE);
        rectangle4 = new Rectangle((col-1)*CELL_SIZE+PADDING,PADDING, CELL_SIZE,row*CELL_SIZE);

        /*rectangle.draw();
        rectangle.fill();
        rectangle.setColor(Color.BLUE);
        rectangle2.draw();
        rectangle2.fill();
        rectangle2.setColor(Color.BLUE);
        rectangle3.draw();
        rectangle3.fill();
        rectangle3.setColor(Color.BLUE);
        rectangle4.draw();
        rectangle4.fill();
        rectangle4.setColor(Color.BLUE);*/

    }
}
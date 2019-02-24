package org.academiadecodigo.bootcamp.DevOops;

import org.academiadecodigo.bootcamp.DevOops.cell.Cell;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Text;

public class StartPage {

    private int rows;
    private int cols;

    public StartPage(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        Rectangle fullStartPage = new Rectangle (Cell.PADDING, Cell.PADDING,cols*Cell.CELL_SIZE, rows*Cell.CELL_SIZE);
        fullStartPage.draw();
        Rectangle startMenu = new Rectangle( Cell.PADDING+ ( cols/8* Cell.CELL_SIZE), Cell.PADDING + (rows/8) * Cell.CELL_SIZE, (cols-(cols/4))*Cell.CELL_SIZE, (rows-(rows/3))*Cell.CELL_SIZE);
        //startMenu.draw();
        Ellipse exitMenu = new Ellipse( cols/2*Cell.CELL_SIZE - (2*Cell.PADDING) , rows*Cell.CELL_SIZE - (Cell.PADDING+1.5*Cell.CELL_SIZE), 2*Cell.CELL_SIZE, 2*Cell.CELL_SIZE);
        exitMenu.setColor(Color.RED);
        exitMenu.fill();
        Text startText = new Text(startMenu.getX()*4.5,startMenu.getY()*4,"START");
        startText.setColor(Color.GREEN);
        startText.draw();
        startText.grow(250, 250);
        Text exitText = new Text(exitMenu.getX()*1.05,exitMenu.getY()*1.08,"EXIT");
        exitText.setColor(Color.WHITE);
        exitText.draw();
        exitText.grow(28,28);

        Rectangle selectDifficultyLevel = new Rectangle( startMenu.getX()*4, startMenu.getY()*2, (cols/6)*Cell.CELL_SIZE, (rows/3)*Cell.CELL_SIZE);
        selectDifficultyLevel.draw();


        Rectangle PlayerMenu1 = new Rectangle( Cell.PADDING, (rows*Cell.CELL_SIZE) - ( 2.5*Cell.CELL_SIZE), 5*Cell.CELL_SIZE, 2.5*Cell.CELL_SIZE+Cell.PADDING);
        PlayerMenu1.draw();
        Rectangle PlayerMenu2 = new Rectangle( (Cell.PADDING+cols*Cell.CELL_SIZE) - (5*Cell.CELL_SIZE), (rows*Cell.CELL_SIZE) - ( 2.5*Cell.CELL_SIZE), 5*Cell.CELL_SIZE, 2.5*Cell.CELL_SIZE+Cell.PADDING);
        PlayerMenu2.draw();


    }



}
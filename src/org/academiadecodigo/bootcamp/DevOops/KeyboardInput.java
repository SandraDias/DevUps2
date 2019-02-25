package org.academiadecodigo.bootcamp.DevOops;

import org.academiadecodigo.bootcamp.DevOops.cell.DiferentAliens;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyboardInput implements KeyboardHandler {

    private Game game;

    public KeyboardInput(Game game) {
        Keyboard k1 = new Keyboard(this);
        this.game = game;
        // UP KEY PRESS
        KeyboardEvent w2 = new KeyboardEvent();
        w2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        w2.setKey(KeyboardEvent.KEY_UP);
        k1.addEventListener(w2);

        // LEFT KEY PRESS
        KeyboardEvent a2 = new KeyboardEvent();
        a2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        a2.setKey(KeyboardEvent.KEY_LEFT);
        k1.addEventListener(a2);

        // DOWN KEY PRESS
        KeyboardEvent s2 = new KeyboardEvent();
        s2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        s2.setKey(KeyboardEvent.KEY_DOWN);
        k1.addEventListener(s2);

        // RIGHT KEY PRESS
        KeyboardEvent d2 = new KeyboardEvent();
        d2.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        d2.setKey(KeyboardEvent.KEY_RIGHT);
        k1.addEventListener(d2);

        // SPACE KEY PRESS
        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        k1.addEventListener(space);

        // SPECIAL FEATURE
        KeyboardEvent j = new KeyboardEvent();
        j.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        j.setKey(KeyboardEvent.KEY_J);
        k1.addEventListener(j);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {


        if (keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {
            game.moveUp();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_LEFT) {
            game.moveLeft();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_RIGHT) {
            game.moveRight();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_DOWN) {
            game.moveDown();
        }
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            game.setGameStart(true);
        }

        if (keyboardEvent.getKey() == KeyboardEvent.KEY_J) {
            DiferentAliens.setNumber(4);
        }


    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}

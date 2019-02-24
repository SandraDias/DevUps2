package org.academiadecodigo.bootcamp.DevOops;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Game g1 = new Game(12, 30,6);

        KeyboardInput k = new KeyboardInput(g1);
        g1.start();

    }
}

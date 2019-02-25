package org.academiadecodigo.bootcamp.DevOops;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {



        Game g1 = new Game(12, 30,6);
        MusicPlayer musicPlayer = new MusicPlayer();
        musicPlayer.music();
        KeyboardInput k = new KeyboardInput(g1);


        g1.start();


    }
}

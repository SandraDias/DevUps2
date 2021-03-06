package org.academiadecodigo.bootcamp.DevOops;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.net.URL;

public class MusicPlayer extends JFrame {
    public void music() throws IOException {
        player("music.wav", true);
    }

    public void explosion() throws IOException {
        player("explosion.wav", true);
    }


    public void player(String filename, boolean loop){
        try {
            URL soundURL = this.getClass().getClassLoader().getResource(filename);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundURL);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

}

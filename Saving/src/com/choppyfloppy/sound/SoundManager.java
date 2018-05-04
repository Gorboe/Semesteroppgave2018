package com.choppyfloppy.sound;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

/**
 * SoundManager is used to manage every sound in the game.
 */
public class SoundManager {

    /**
     * The Method playSound is used to retrieve sound files,
     * give file to audio player and then start the AudioPlayer to
     * run sound file.
     *
     * @param filePath - stores the string value of the sound location.
     */
    public void playSound(String filePath){
        Objects.requireNonNull(filePath);
        try{
            InputStream inputStream = new FileInputStream(new File(filePath));
            AudioStream audioStream = new AudioStream(inputStream);
            AudioPlayer.player.start(audioStream);
        }catch (Exception e){
            System.out.println("Error playSound");
        }
    }

}

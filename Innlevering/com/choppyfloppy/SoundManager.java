package com.choppyfloppy;

import sun.audio.*;
import java.io.*;

public class SoundManager {

    public void playSound(String filePath){

        try{

            InputStream music = new FileInputStream(new File(filePath));
            AudioStream audio = new AudioStream(music);
            AudioPlayer.player.start(audio);

        }catch (Exception e){
            System.out.println("Error");
        }
    }

}

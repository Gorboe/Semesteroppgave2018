package com.choppyfloppy.sound;




import java.util.Objects;
import javafx.scene.media.AudioClip;

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
            //InputStream inputStream = new FileInputStream(new File("com/choppyfloppy/soundfiles/"+filePath));
            String inputStream = SoundManager.class.getResource("/com/choppyfloppy/soundfiles/"+filePath).toExternalForm();

            AudioClip audioClip = new AudioClip(inputStream);
            audioClip.play();
        }catch (Exception e){
            System.out.println("Error playSound");
        }
    }

}

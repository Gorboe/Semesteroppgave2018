package com.choppyfloppy.sound;

import org.junit.Test;

public class SoundTests {

    @Test (expected = NullPointerException.class)
    public void pathfileCanNotBeNull(){
        SoundManager soundManager = new SoundManager();
        soundManager.playSound(null);
    }

}

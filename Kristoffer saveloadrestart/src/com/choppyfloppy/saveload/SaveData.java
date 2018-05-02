package com.choppyfloppy.saveload;

import java.io.Serializable;

/**
 *  The class SaveData implements serializable to save
 *  value in the game. Serializable was chosen to avoid
 *  cheating with the score or level.
 *
 *  The class contains datafields for score and current level
 *  along with getters and setters.
 */
public class SaveData implements Serializable {


    private static final long serialVersionUID = 1L;

    private int score;
    private int currentLevel;

    /**
     * The method is used to get the value of score.
     */
    public int getScore(){
        return score;
    }

    /**
     * The method is used to set the value of score.
     * @param score - contains the value of the score.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * The method is used to get the value of the current level.
     */
    public int getCurrentLevel() {
        return currentLevel;
    }

    /**
     * The method is used to set the value of Current Level.
     * @param currentLevel - contains the value of the current level.
     */
    public void setCurrentLevel(int currentLevel) {
        this.currentLevel = currentLevel;
    }
}


















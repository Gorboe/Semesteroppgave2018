package com.choppyfloppy.views.pausemenu;

import com.choppyfloppy.util.FXTestHelper;
import com.choppyfloppy.views.pausemenu.GameMenu;

import org.junit.BeforeClass;
import org.junit.Test;

public class GameMenuTests {
    @BeforeClass
    public static void run(){
        FXTestHelper.runFX();
    }

    @Test(expected = NullPointerException.class)
    public void setOnResumeClickedCanNotBeNull() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.setOnResumeClicked(null);
    }

    @Test(expected = NullPointerException.class)
    public void setOnRestartClickedCanNotBeNull() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.setOnRestartClicked(null);
    }

    @Test(expected = NullPointerException.class)
    public void setOnSaveClickedCanNotBeNull() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.setOnSaveClicked(null);
    }

    @Test(expected = NullPointerException.class)
    public void setOnQuitToMainClickedCanNotBeNull() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.setOnQuitToMainClicked(null);
    }
    @Test (expected = NullPointerException.class)
    public void setOnExitClickedCanNotBeNull() {
        GameMenu gameMenu = new GameMenu();
        gameMenu.setOnExitClicked(null);
    }
}
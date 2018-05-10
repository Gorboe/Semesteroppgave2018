package com.choppyfloppy.views.titlemenu;

import com.choppyfloppy.util.FXTestHelper;


import org.junit.BeforeClass;
import org.junit.Test;

public class TitleMenuTests {
    @BeforeClass
    public static void run(){
        FXTestHelper.runFX();
    }

    @Test (expected = NullPointerException.class)
    public void setOnNewGameClickedCanNotBeNull() {
        TitleMenu titleMenu = new TitleMenu();
        titleMenu.setOnNewGameClicked(null);
    }

    @Test (expected = NullPointerException.class)
    public void setOnContinueClickedCanNotBeNull() {
        TitleMenu titleMenu = new TitleMenu();
        titleMenu.setOnContinueClicked(null);
    }

    @Test (expected = NullPointerException.class)
    public void setOnExitClickedCanNotBeNull() {
        TitleMenu titleMenu = new TitleMenu();
        titleMenu.setOnExitClicked(null);
    }


}

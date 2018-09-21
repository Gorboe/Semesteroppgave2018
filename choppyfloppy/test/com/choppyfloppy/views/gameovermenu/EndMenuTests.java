package com.choppyfloppy.views.gameovermenu;

import com.choppyfloppy.util.FXTestHelper;
import com.choppyfloppy.views.gameovermenu.EndMenu;
import org.junit.BeforeClass;
import org.junit.Test;

public class EndMenuTests {
    @BeforeClass
    public static void run(){
        FXTestHelper.runFX();
    }

    @Test (expected = NullPointerException.class)
    public void setOnNewGameClickedCanNotBeNull() {
        EndMenu endMenu = new EndMenu();
        endMenu.setOnNewGameClicked(null);
    }

    @Test (expected = NullPointerException.class)
    public void setOnMainMenuClickedCanNotBeNull() {
        EndMenu endMenu = new EndMenu();
        endMenu.setOnMainMenuClicked(null);
    }

    @Test (expected = NullPointerException.class)
    public void setOnExitClickedCanNotBeNull() {
        EndMenu endMenu = new EndMenu();
        endMenu.setOnExitClicked(null);
    }

}

package sample;

import java.util.Objects;

public class Controller {

    private Game game;

    public void init(Game game){this.game = Objects.requireNonNull(game);} //Checks that the specified object reference is not null
}

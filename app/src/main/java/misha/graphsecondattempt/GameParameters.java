package misha.graphsecondattempt;

public class GameParameters {
    private GameParameters() {

    }

    private static Level game;
    static int gameScore = 0;

    static void setGame(Level game) {
        GameParameters.game = game;
    }
}

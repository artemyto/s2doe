package misha.graphsecondattempt;

class GameUtils {
    private GameUtils() {

    }

    static Level game;

    static int gameScore = 0;

    static void setGame(Level game) {
        GameUtils.game = game;
    }
}

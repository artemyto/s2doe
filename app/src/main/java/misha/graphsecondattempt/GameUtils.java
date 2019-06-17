package misha.graphsecondattempt;

public class GameUtils {
    private GameUtils() {

    }

    public static Level game;
    static int gameScore = 0;

    static void setGame(Level game) {
        GameUtils.game = game;
    }
}

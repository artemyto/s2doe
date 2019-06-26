package misha.graphsecondattempt;

class ScreenUtils {

    private static float aspectRatio = 1;
    private static int screenWidth = 1;
    private static int screenHeight = 1;
    private static int screenWidthHalf = 1;
    private static int screenHeightHalf = 1;

    static float transformCoordinateX(float coord) {
        float rez = -2f;
        if (coord > screenWidthHalf) {
            coord -= screenWidthHalf;
            rez = coord / screenWidthHalf;

        } else {
            rez = -1 + coord / screenWidthHalf;

        }
        return rez;
    }

    static float transformCoordinateY(float coord) {
        float rez = -2f;
        if (coord > screenHeightHalf) {
            coord -= screenHeightHalf;
            rez = -coord / screenHeightHalf;

        } else {
            rez = 1 - coord / screenHeightHalf;

        }
        return rez;
    }

    static float transformDistanceX(float a) {
        return a / screenWidthHalf;
    }

    static float transformDistanceY(float a) {
        return a / screenHeightHalf;
    }

    static void setScreenParameters(int widthPixels, int heightPixels) {
        screenWidth = widthPixels;
        screenHeight = heightPixels;
        aspectRatio = ((float) screenHeight) / screenWidth;
        screenWidthHalf = screenWidth / 2;
        screenHeightHalf = screenHeight / 2;
    }

    static float getAspectRatio() {
        return aspectRatio;
    }
}

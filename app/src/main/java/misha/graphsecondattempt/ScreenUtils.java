package misha.graphsecondattempt;

class ScreenUtils {

    private static float aspectRatio = 1;
    private static int screenWidth = 1;
    private static int screenHeight = 1;
    private static int screenWidthHalf = 1;
    private static int screenHeightHalf = 1;

    static float transformXCoordinateScreenToOpengl(float coord) {
        float result = -2f;
        if (coord > screenWidthHalf) {
            coord -= screenWidthHalf;
            result = coord / screenWidthHalf;

        } else {
            result = -1 + coord / screenWidthHalf;

        }
        return result;
    }

    static float transformYCoordinateScreenToOpengl(float coord) {
        float result = -2f;
        if (coord > screenHeightHalf) {
            coord -= screenHeightHalf;
            result = -coord / screenHeightHalf;

        } else {
            result = 1 - coord / screenHeightHalf;

        }
        return result;
    }

    static float transformXCoordinateOpenglToScreen(float coord) {
        float result = -2f;
        if (coord > 0) {
            result = screenWidthHalf + coord*screenWidthHalf;
        } else {
            result = (1 + coord)*screenWidthHalf;
        }
        return result;
    }

    static float transformYCoordinateOpenglToScreen(float coord) {
        float result = -2f;
        if (coord > 0) {
            result = (1 - coord)*screenHeightHalf;

        } else {
            result = screenHeightHalf + (-coord)*screenHeightHalf;
        }
        return result;
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

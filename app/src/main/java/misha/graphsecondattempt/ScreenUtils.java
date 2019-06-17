package misha.graphsecondattempt;

public class ScreenUtils {

    static float aspectRatio = 1;
    static int screenWidth = 1;
    static int screenHeight = 1;
    static int screenWidthHalf = 1;
    static int screenHeightHalf = 1;

    static float transformCoordinate(float coord, char axis) {
        float rez = -2f;
        //float pixelCount=-1000f;
        switch (axis) {
            case 'y'://y, 720
                //pixelCount=720;
                if (coord > screenHeightHalf) {
                    coord -= screenHeightHalf;
                    rez = -coord / screenHeightHalf;

                } else {
                    rez = 1 - coord / screenHeightHalf;

                }
                break;
            case 'x'://x, 1280
                //pixelCount=1280;
                if (coord > screenWidthHalf) {
                    coord -= screenWidthHalf;
                    rez = coord / screenWidthHalf;

                } else {
                    rez = -1 + coord / screenWidthHalf;

                }
                break;
        }

        return rez;
    }

    static float averageCoord(float a, float b, char axis) {

        return transformCoordinate((a + b) / 2, axis);
    }

    static float transformDistance(float a, char axis) {
        float rez = 0.1f;
        switch (axis) {
            case 'x':
                rez = a / screenWidthHalf;
                break;
            case 'y':
                rez = a / screenHeightHalf;
                break;

        }
        return rez;
    }



    public static void setScreenParameters(int widthPixels, int heightPixels) {
        screenWidth = widthPixels;
        screenHeight = heightPixels;
        aspectRatio = ((float) screenHeight) / screenWidth;
        screenWidthHalf = screenWidth / 2;
        screenHeightHalf = screenHeight / 2;
    }
}

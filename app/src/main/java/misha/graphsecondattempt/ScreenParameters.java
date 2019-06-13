package misha.graphsecondattempt;

public class ScreenParameters {

    static float aspectRatio = 1;
    static int screenWidth = 1;
    static int screenHeight = 1;
    static int screenWidth2 = 1;
    static int screenHeight2 = 1;

    static float changeCoordinate(float coord, char axis) {
        float rez = -2f;
        //float pixelCount=-1000f;
        switch (axis) {
            case 'y'://y, 720
                //pixelCount=720;
                if (coord > screenHeight2) {
                    coord -= screenHeight2;
                    rez = -coord / screenHeight2;

                } else {
                    rez = 1 - coord / screenHeight2;

                }
                break;
            case 'x'://x, 1280
                //pixelCount=1280;
                if (coord > screenWidth2) {
                    coord -= screenWidth2;
                    rez = coord / screenWidth2;

                } else {
                    rez = -1 + coord / screenWidth2;

                }
                break;
        }

        return rez;
    }

    static float averageCoord(float a, float b, char axis) {

        return changeCoordinate((a + b) / 2, axis);
    }

    static float changeDistance(float a, char axis) {
        float rez = 0.1f;
        switch (axis) {
            case 'x':
                rez = a / screenWidth2;
                break;
            case 'y':
                rez = a / screenHeight2;
                break;

        }
        return rez;
    }


}

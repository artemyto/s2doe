package misha.graphsecondattempt;

import static android.opengl.GLES20.GL_TRIANGLES;
import static android.opengl.GLES20.GL_TRIANGLE_FAN;

class ObjectTemplates {
    private ObjectTemplates() {

    }

    static float[] getDigit0(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,


        };
        return rez;
    }

    static float[] getDigit1(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

        };

        return rez;
    }

    static float[] getDigit2(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,

        };
        return rez;
    }

    static float[] getDigit3(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,

        };
        return rez;
    }

    static float[] getDigit4(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 5), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 5), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 5), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 5), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 5), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 5), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
        };
        return rez;
    }

    static float[] getDigit5(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
        };
        return rez;
    }

    static float[] getDigit6(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
        };
        return rez;
    }

    static float[] getDigit7(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 2), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 5), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
        };
        return rez;
    }

    static float[] getDigit8(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

        };
        return rez;
    }

    static float[] getDigit9(int x, int y, int step) {
        float[] rez = new float[]{
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 7), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,
                ScreenUtils.transformCoordinateX(x - step), ScreenUtils.transformCoordinateY(y - step * 3), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 2), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step), 0.98f,

                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 6), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 3), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
                ScreenUtils.transformCoordinateX(x - step * 4), ScreenUtils.transformCoordinateY(y - step * 4), 0.98f,
        };
        return rez;
    }

    static ObjectContainer getDigitObject(int x, int y, int step, int digit) {
        ObjectContainer rez = new ObjectContainer();// = new float[0];
        //float[] f;
        rez.setColorR(0f);
        rez.setColorG(0f);
        rez.setColorB(0f);
        rez.setFanOrStrip(GL_TRIANGLES);
        rez.setDrawed(true);


        switch (digit) {
            case 0:
                rez.setName("0");
                rez.setVertices(getDigit0(x, y, step));
                break;
            case 1:
                rez.setName("1");
                rez.setVertices(getDigit1(x, y, step));
                break;
            case 2:
                rez.setName("2");
                rez.setVertices(getDigit2(x, y, step));
                break;
            case 3:
                rez.setName("3");
                rez.setVertices(getDigit3(x, y, step));
                break;
            case 4:
                rez.setName("4");
                rez.setVertices(getDigit4(x, y, step));
                break;
            case 5:
                rez.setName("5");
                rez.setVertices(getDigit5(x, y, step));
                break;
            case 6:
                rez.setName("6");
                rez.setVertices(getDigit6(x, y, step));
                break;
            case 7:
                rez.setName("7");
                rez.setVertices(getDigit7(x, y, step));
                break;
            case 8:
                rez.setName("8");
                rez.setVertices(getDigit8(x, y, step));
                break;
            case 9:
                rez.setName("9");
                rez.setVertices(getDigit9(x, y, step));
                break;


        }
        return rez;
    }

    static int getDigitWidth(int digit, int step) {
        int rez = 0;
        switch (digit) {
            case 0:
                rez = step * 5;
                break;
            case 1:
                rez = step * 4;
                break;
            case 2:
                rez = step * 5;
                break;
            case 3:
                rez = step * 5;
                break;
            case 4:
                rez = step * 6;
                break;
            case 5:
                rez = step * 5;
                break;
            case 6:
                rez = step * 5;
                break;
            case 7:
                rez = step * 5;
                break;
            case 8:
                rez = step * 5;
                break;
            case 9:
                rez = step * 5;
                break;
        }
        return rez;
    }

    static float[] getDigitArray(int x, int y, int step, int digit) {
        float rez[];
        //float[] f;
        switch (digit) {
            case 0:
                rez = getDigit0(x, y, step);
                break;
            case 1:
                rez = getDigit1(x, y, step);
                break;
            case 2:
                rez = getDigit2(x, y, step);
                break;
            case 3:
                rez = getDigit3(x, y, step);
                break;
            case 4:
                rez = getDigit4(x, y, step);
                break;
            case 5:
                rez = getDigit5(x, y, step);
                break;
            case 6:
                rez = getDigit6(x, y, step);
                break;
            case 7:
                rez = getDigit7(x, y, step);
                break;
            case 8:
                rez = getDigit8(x, y, step);
                break;
            case 9:
                rez = getDigit9(x, y, step);
                break;
            default:
                rez = new float[1];
                break;

        }
        return rez;
    }

    static float[] getCircle(float x, float y, float radius, char radiusAxis) {//fan
        float[] ret = new float[2166];
        if (radiusAxis == 'x') {

            float a;
            ret[0] = x;
            ret[1] = y;
            ret[2] = 0.98f;
            float j = 0;
            for (int i = 3; i <= 2165; i += 3, j += 0.5f) {
                a = j / 180.0f * 3.1415f;
                ret[i + 1] = y - radius * (float) Math.sin(a) / ScreenUtils.getAspectRatio();
                ret[i] = x + radius * (float) Math.cos(a);
                ret[i + 2] = 0.98f;

            }
        }


        return ret;
    }

    static float[] getEllipse(float x, float y, float rX, float rY) {//fan
        final int n = 1002;//2166,720*3+6,721*3
        float[] ret = new float[n];
        float a;
        ret[0] = x;
        ret[1] = y;
        ret[2] = 0.98f;
        float j = 0;
        for (int i = 3; i < n; i += 3, j += 1f) {//  1..((n-6)/3)
            a = j / ((n - 6) / 3) * 2 * 3.1415f;
            ret[i + 1] = y - rX * (float) Math.sin(a);
            ret[i] = x + rY * (float) Math.cos(a);
            ret[i + 2] = 0.98f;

        }


        return ret;
    }

    static ObjectContainer generateBullet() {
        ObjectContainer o = new ObjectContainer();
        double rand;
        AnimationContainer a;
        int x, y;
        switch (GameUtils.game.level()) {
            case 1:
                //rand;// = Math.random();

                o.setColorB(0.3f);
                o.setColorG(0.3f);
                o.setColorR(0.3f);
                rand = Math.random();
                //x = (int)(rand*(700-200))+200;
                x = (int) (rand * (1400));
                if (x > 700) {
                    y = x - 700;
                    x = 736;

                } else {
                    y = -31;
                    x += 20;
                }
//            o.vertices = new float[]{
//                    ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y+30), 0.95f,
//                    ScreenUtils.transformCoordinateX(x-15), ScreenUtils.transformCoordinateY(y), 0.95f,
//                    ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y-30), 0.95f,
//                    ScreenUtils.transformCoordinateX(x+15), ScreenUtils.transformCoordinateY(y), 0.95f,
//
//            };
                o.setVertices(getEllipse(ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y), ScreenUtils.transformDistanceX(22.5f), ScreenUtils.transformDistanceY(45)));
                //float sdvig = ScreenUtils.transformCoordinateX(x);
                o.setDrawed(true);
                o.setAnimated(true);
                o.setName("bullet");
                o.setMinX(ScreenUtils.transformDistanceX(22.5f));
                o.setMinY(ScreenUtils.transformDistanceY(45));
                //touchedBullet = o;
                a = new AnimationContainer();
                a.setDurationMillis(10000);
                //e.waitTime = (int)(rand*(750-500))+500;
                //rand = Math.random();
                a.setDistanceX(ScreenUtils.transformDistanceX(x - 10));
                //rand = Math.random();
                a.setDistanceY(ScreenUtils.transformDistanceY(1320 - y));

                //obj.get(3).anim.get(0).isInfinite = true;
                a.setDirectionX(false);
                a.setDirectionY(false);
                a.setRedrawable(true);
                o.getAnim().add(a);
                //o2 = ObjectContainer.copy(o);
                break;
            case 2:
                //rand;// = Math.random();

                o.setColorB(0.3f);
                o.setColorG(0.3f);
                o.setColorR(0.3f);
                rand = Math.random();
                x = (int) (rand * (1400));
                if (x > 700) {
                    y = x - 700;
                    x = -16;

                } else y = -31;
//                o.vertices = new float[]{
//                        ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y+30), 0.95f,
//                        ScreenUtils.transformCoordinateX(x-15), ScreenUtils.transformCoordinateY(y), 0.95f,
//                        ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y-30), 0.95f,
//                        ScreenUtils.transformCoordinateX(x+15), ScreenUtils.transformCoordinateY(y), 0.95f,
//
//                };
                o.setVertices(getEllipse(ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y), ScreenUtils.transformDistanceX(15), ScreenUtils.transformDistanceY(30)));
                //float sdvig = ScreenUtils.transformCoordinateX(.x, );
                o.setDrawed(true);
                o.setAnimated(true);
                o.setName("bullet");
                o.setMinX(ScreenUtils.transformDistanceX(22.5f));
                o.setMinY(ScreenUtils.transformDistanceY(45));
                //touchedBullet = o;
                a = new AnimationContainer();
                a.setDurationMillis(10000);
                //e.waitTime = (int)(rand*(750-500))+500;
                //rand = Math.random();
                a.setDistanceX(ScreenUtils.transformDistanceX(710 - x));
                //rand = Math.random();
                a.setDistanceY(ScreenUtils.transformDistanceY(1320 - y));

                //obj.get(3).anim.get(0).isInfinite = true;
                a.setDirectionX(true);
                a.setDirectionY(false);
                o.getAnim().add(a);
                break;
        }
        return o;
    }

    static float[] getLine(float startX, float startY, float endX, float endY) {
        //GL_TRIANGLE_FAN
        float[] ret = new float[4*3];
        //                            \\
//                             \\
        //x+5,y-5   x-5,y+5
        if ((startX - endX)*(startY - endY) > 0.0f) {
            ret[0] = ScreenUtils.transformCoordinateX(startX + 5);
            ret[1] = ScreenUtils.transformCoordinateY(startY - 5);
            ret[2] = 0.97f;
            ret[3] = ScreenUtils.transformCoordinateX(startX - 5);
            ret[4] = ScreenUtils.transformCoordinateY(startY + 5);
            ret[5] = 0.97f;

            ret[6] = ScreenUtils.transformCoordinateX(endX - 5);
            ret[7] = ScreenUtils.transformCoordinateY(endY + 5);
            ret[8] = 0.97f;
            ret[9] = ScreenUtils.transformCoordinateX(endX + 5);
            ret[10] = ScreenUtils.transformCoordinateY(endY - 5);
            ret[11] = 0.97f;
        }
//                             //
//                            //
        //x+5,y+5   x-5,y-5
        else {
            ret[0] = ScreenUtils.transformCoordinateX(startX + 5);
            ret[1] = ScreenUtils.transformCoordinateY(startY + 5);
            ret[2] = 0.97f;
            ret[3] = ScreenUtils.transformCoordinateX(startX - 5);
            ret[4] = ScreenUtils.transformCoordinateY(startY - 5);
            ret[5] = 0.97f;

            ret[6] = ScreenUtils.transformCoordinateX(endX - 5);
            ret[7] = ScreenUtils.transformCoordinateY(endY - 5);
            ret[8] = 0.97f;
            ret[9] = ScreenUtils.transformCoordinateX(endX + 5);
            ret[10] = ScreenUtils.transformCoordinateY(endY + 5);
            ret[11] = 0.97f;
        }
        return  ret;
    }
}

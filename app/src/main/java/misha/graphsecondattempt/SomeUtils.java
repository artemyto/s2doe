package misha.graphsecondattempt;

import java.util.ArrayList;

import static android.opengl.GLES20.GL_TRIANGLES;

/**
 * Created by master22 on 4/24/2018.
 * Package: ${PACKAGE_NAME}, project: TriforcePower.
 */

class SomeUtils {

    static float aspectRatio = 1;
    static int screenWidth = 1;
    static int screenHeight = 1;
    static int screenWidth2 = 1;
    static int screenHeight2 = 1;
    static int gameScore = 0;

    static boolean needToRebindData = false;


    static ArrayList<ObjectContainer> obj = new ArrayList<ObjectContainer>();
    static ArrayList<EventContainer> events = new ArrayList<>();
    //static ObjectContainer touchedBullet

    static Level game;

    private SomeUtils() {

    }

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

    static float evaluateCenter(float[] f, float dop, char axis) {
        float sum = 0;
        int i = 0;
        switch (axis) {
            case 'x':
                i = 0;
                break;
            case 'y':
                i = 1;
                break;

        }
        for (i = i; i < f.length; i += 3) {
            sum += f[i] + dop;
        }
        return sum / (f.length / 3);
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
        switch (game.level()) {
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
//                    SomeUtils.changeCoordinate(x, 'x'), SomeUtils.changeCoordinate(y+30, 'y'), 0.95f,
//                    SomeUtils.changeCoordinate(x-15, 'x'), SomeUtils.changeCoordinate(y, 'y'), 0.95f,
//                    SomeUtils.changeCoordinate(x, 'x'), SomeUtils.changeCoordinate(y-30, 'y'), 0.95f,
//                    SomeUtils.changeCoordinate(x+15, 'x'), SomeUtils.changeCoordinate(y, 'y'), 0.95f,
//
//            };
                o.setVertices(getEllipse(SomeUtils.changeCoordinate(x, 'x'), SomeUtils.changeCoordinate(y, 'y'), SomeUtils.changeDistance(22.5f, 'x'), SomeUtils.changeDistance(45, 'y')));
                //float sdvig = SomeUtils.changeCoordinate(x, 'x');
                o.setDrawed(true);
                o.setAnimated(true);
                o.setName("bullet");
                o.setMinX(SomeUtils.changeDistance(22.5f, 'x'));
                o.setMinY(SomeUtils.changeDistance(45, 'y'));
                //touchedBullet = o;
                a = new AnimationContainer();
                a.setDuration(10000);
                //e.waitTime = (int)(rand*(750-500))+500;
                //rand = Math.random();
                a.setDistanceX(SomeUtils.changeDistance(x - 10, 'x'));
                //rand = Math.random();
                a.setDistanceY(SomeUtils.changeDistance(1320 - y, 'y'));

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
//                        SomeUtils.changeCoordinate(x, 'x'), SomeUtils.changeCoordinate(y+30, 'y'), 0.95f,
//                        SomeUtils.changeCoordinate(x-15, 'x'), SomeUtils.changeCoordinate(y, 'y'), 0.95f,
//                        SomeUtils.changeCoordinate(x, 'x'), SomeUtils.changeCoordinate(y-30, 'y'), 0.95f,
//                        SomeUtils.changeCoordinate(x+15, 'x'), SomeUtils.changeCoordinate(y, 'y'), 0.95f,
//
//                };
                o.setVertices(getEllipse(SomeUtils.changeCoordinate(x, 'x'), SomeUtils.changeCoordinate(y, 'y'), SomeUtils.changeDistance(15, 'x'), SomeUtils.changeDistance(30, 'y')));
                //float sdvig = SomeUtils.changeCoordinate(x, 'x');
                o.setDrawed(true);
                o.setAnimated(true);
                o.setName("bullet");
                o.setMinX(SomeUtils.changeDistance(22.5f, 'x'));
                o.setMinY(SomeUtils.changeDistance(45, 'y'));
                //touchedBullet = o;
                a = new AnimationContainer();
                a.setDuration(10000);
                //e.waitTime = (int)(rand*(750-500))+500;
                //rand = Math.random();
                a.setDistanceX(SomeUtils.changeDistance(710 - x, 'x'));
                //rand = Math.random();
                a.setDistanceY(SomeUtils.changeDistance(1320 - y, 'y'));

                //obj.get(3).anim.get(0).isInfinite = true;
                a.setDirectionX(true);
                a.setDirectionY(false);
                o.getAnim().add(a);
                break;
        }
        return o;
    }
}

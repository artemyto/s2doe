package misha.graphsecondattempt;


/**
 * Created by master22 on 4/24/2018.
 * Package: ${PACKAGE_NAME}, project: TriforcePower.
 */

class SomeUtils {
    static volatile boolean needToRebindData = false;

    private SomeUtils() {

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

    static float[] concatArray(float[] a, float[] b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        float[] r = new float[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    static void setNeedToRebindData() {
        needToRebindData = true;
    }

    static void setNotNeedToRebindData() {
        needToRebindData = false;
    }

    static boolean isNeedToRebindData() {
        return needToRebindData;
    }
}

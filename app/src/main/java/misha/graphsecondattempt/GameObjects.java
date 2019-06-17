package misha.graphsecondattempt;

import java.util.ArrayList;

public class GameObjects {
    private static ArrayList<ObjectContainer> obj = new ArrayList<>();
    private static ArrayList<String> wantDelete = new ArrayList<>();
    private static volatile boolean objectsChanged = false;

    private GameObjects() {

    }

    public static synchronized ArrayList<ObjectContainer> getObjects() {
        ArrayList<ObjectContainer> arrayList = new ArrayList<>();
        for (ObjectContainer o : obj) {
            arrayList.add(o.getCopy());
        }
        return arrayList;
    }

    public static synchronized ObjectContainer getObject(String name) {
        ObjectContainer ret = null;
        for (ObjectContainer o : obj) {
            if (name.equals(o.getName())) ret = o.getCopy();
        }
        return ret;
    }

    public static synchronized void setObjects(ArrayList<ObjectContainer> o) {
        obj = o;
    }

    public static synchronized void addObject(ObjectContainer o) {
        obj.add(o);
    }

    public static synchronized ArrayList<String> getWantDelete() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(wantDelete);
        return arrayList;
    }

    public static synchronized void removeObject(String s) {
        for (int i = 0; i < obj.size(); ++i) {
            if (obj.get(i).getName().equals(s)) {
                obj.remove(i);
                break;
            }
        }
    }

    public static synchronized void removeObjects(String s) {
        for (int i = 0; i < obj.size(); ++i) {
            if (obj.get(i).getName().equals(s)) {
                obj.remove(i);
                --i;
            }
//            break;
        }
    }

    public static synchronized boolean isWantDeleteContains(String s) {
        return wantDelete.contains(s);
    }

    public static synchronized void addWantDelete(String s) {
        wantDelete.add(s);
    }


    public static synchronized void setWantDelete(ArrayList<String> w) {
        wantDelete = w;
    }

    static synchronized ObjectContainer getTouchedBullet(float x, float y) {
        ObjectContainer ret = null;
        for (ObjectContainer o : obj) {
            if (o.getName().contains("bullet") && Math.abs(x - o.getCenterX()) < ScreenUtils.transformDistance(100, 'x') && Math.abs(y - o.getCenterY()) < ScreenUtils.transformDistance(100, 'x') / ScreenUtils.aspectRatio) {//чему равно чендж дистанс (5)? Для других разрешений, наверное надо брать другое число? не 5, а 5*длину/720...
                //мы оказались здесь, значит, мы нашли пулю, в которую попали. Что, если их больше одной?
                //в любом случае, теперь нам надо ее записать
                ret = o.getCopy();
                break;
            }
        }
        return ret;
    }

    static synchronized String getTouchedBulletName(float x, float y) {
//        ObjectContainer ret = null;
        String ret = "";

        for (ObjectContainer o : obj) {
            if (o.getName().contains("bullet")) {
//                if (Math.abs(x - o.getCenterX()) < ScreenUtils.transformDistance(50, 'x') && Math.abs(y - o.getCenterY()) < ScreenUtils.transformDistance(50, 'x') / ScreenUtils.aspectRatio)
                if ( (x - o.getCenterX())*(x - o.getCenterX()) + (y - o.getCenterY())*ScreenUtils.aspectRatio*(y - o.getCenterY())*ScreenUtils.aspectRatio < ScreenUtils.transformDistance(70, 'x')*ScreenUtils.transformDistance(70, 'x'))
                {
                    ret = o.getName();
                    break;
                } else if ( (x - o.getCenterX())*(x - o.getCenterX()) + (y - o.getCenterY())*ScreenUtils.aspectRatio*(y - o.getCenterY())*ScreenUtils.aspectRatio < ScreenUtils.transformDistance(100, 'x')*ScreenUtils.transformDistance(100, 'x')) {
                    ret = "no!!!";
                    break;
                }
            }
        }
        return ret;
    }

    static synchronized void changeObject(String name, ObjectContainer newObject) {
        for (int i = 0; i < obj.size(); ++i) {
            if (name.equals(obj.get(i).getName())) {
                ObjectContainer.copy(obj.get(i), newObject);//obj.set(i, newObject);
                break;
            }
        }
//        for (ObjectContainer o:obj) {
//            if (name.equals(o.getName())) o = newObject.getCopy();
//        }
        objectsChanged = true;
    }

    static void setObjectsChanged() {
        objectsChanged = true;
    }

    static boolean isObjectsChanged() {
        return objectsChanged;
    }

    public static void setObjectsNotChanged() {
        objectsChanged = false;
    }

    static synchronized void eraseObjects() {
        obj = new ArrayList<>();
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
        return sum / (f.length / 3.0f);
    }



    static boolean isOutOfRange (float[] vertices) {
        boolean outOfRange = true;
//        boolean rez = true;
        for (int x = 0, y=1; x< vertices.length;x+=3,y+=3) {
            outOfRange = outOfRange && (vertices[x]<-1 || vertices[x]>-1) && (vertices[y]<-1 || vertices[y]>-1);
        }
        return outOfRange;
    }
}

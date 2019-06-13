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
        for (ObjectContainer o:obj) {
            arrayList.add(o.getCopy());
        }
        return arrayList;
    }

    public static synchronized void setObjects(ArrayList<ObjectContainer> o) {
        obj = o;
    }

    public static synchronized void addObject(ObjectContainer o) {
        obj.add(o);
    }

    public  static synchronized ArrayList<String> getWantDelete() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.addAll(wantDelete);
        return arrayList;
    }

    public static synchronized void deleteObject(String s) {
        for (int i = 0; i < obj.size();++i) {
            if (obj.get(i).getName().equals(s)) obj.remove(i);
            break;
        }
    }

    public static synchronized void deleteObjects(String s) {
        for (int i = 0; i < obj.size();++i) {
            if (obj.get(i).getName().equals(s)) {
                obj.remove(i);
                --i;
            }
//            break;
        }
    }

    public  static synchronized boolean isWantDeleteContains(String s) {
        return wantDelete.contains(s);
    }

    public  static synchronized void addWantDelete(String s) {
        wantDelete.add(s);
    }



    public  static synchronized void setWantDelete(ArrayList<String> w) {
        wantDelete = w;
    }

    static ObjectContainer getTouchedBullet(float x, float y) {
        ObjectContainer ret = null;
        for (ObjectContainer o : obj) {
            if (o.getName().contains("bullet") && Math.abs(x - o.getCenterX()) < ScreenParameters.changeDistance(100, 'x') && Math.abs(y - o.getCenterY()) < ScreenParameters.changeDistance(100, 'y')) {//чему равно чендж дистанс (5)? Для других разрешений, наверное надо брать другое число? не 5, а 5*длину/720...
                //мы оказались здесь, значит, мы нашли пулю, в которую попали. Что, если их больше одной?
                //в любом случае, теперь нам надо ее записать
                ret = o;
            }
        }
        return ret;
    }

    static void setObjectsChanged() {
        objectsChanged = true;
    }

    static boolean isObjectsChanged() {
        return  objectsChanged;
    }

    static synchronized void eraseObjects() {
        obj = new ArrayList<>();
    }

    /*static boolean isOutOfRange (float[] f) {
        boolean rez = true;
        for (int x = 0, y=1; x< f.length;x+=3,y+=3) {
            outOfRange = outOfRange && (o.vertices[x]<-1 || o.vertices[x]>-1) && (o.vertices[y]<-1 || o.vertices[y]>-1)
        }
        return rez;
    }*/
}

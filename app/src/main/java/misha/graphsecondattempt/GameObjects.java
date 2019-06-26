package misha.graphsecondattempt;

import java.util.ArrayList;

class GameObjects {
    private static ArrayList<ObjectContainer> obj = new ArrayList<>();
    private static volatile boolean objectsChanged = false;

    private GameObjects() {

    }

    static synchronized ArrayList<ObjectContainer> getObjects() {
        ArrayList<ObjectContainer> arrayList = new ArrayList<>();
        for (ObjectContainer o : obj) {
            arrayList.add(o.getCopy());
        }
        return arrayList;
    }

    static synchronized ObjectContainer getObject(String name) {
        ObjectContainer ret = null;
        for (ObjectContainer o : obj) {
            if (name.equals(o.getName())) ret = o.getCopy();
        }
        return ret;
    }

    static synchronized void setObjects(ArrayList<ObjectContainer> objects) {
        obj = new ArrayList<>();
        for (ObjectContainer o : objects)
            obj.add(o.getCopy());
        objectsChanged = true;
    }
    
    static synchronized void addObject(ObjectContainer o) {
        obj.add(o);
    }

    static synchronized void addOrReplaceObject(ObjectContainer o) {
        boolean notReplaced = true;
        for (int i = 0; i < obj.size(); ++i) {
            if (obj.get(i).getName().equals(o.getName())) {
                obj.set(i, o.getCopy());
                notReplaced = false;
                break;
            }
        }
        if (notReplaced) obj.add(o.getCopy());
        GameObjects.objectsChanged = true;
    }

    static synchronized void removeObject(String s) {
        for (int i = 0; i < obj.size(); ++i) {
            if (obj.get(i).getName().equals(s)) {
                obj.remove(i);
                break;
            }
        }
        objectsChanged = true;
    }

    static synchronized void removeObjects(String s) {
        for (int i = 0; i < obj.size(); ++i) {
            if (obj.get(i).getName().equals(s)) {
                obj.remove(i);
                --i;
            }
        }
        objectsChanged = true;
    }

    static synchronized ObjectContainer getTouchedBullet(float x, float y) {
        ObjectContainer ret = null;
        for (ObjectContainer o : obj) {
            if (o.getName().contains("bullet") && Math.abs(x - o.getCenterX()) < ScreenUtils.transformDistanceX(100) && Math.abs(y - o.getCenterY()) < ScreenUtils.transformDistanceX(100) / ScreenUtils.getAspectRatio()) {
                ret = o.getCopy();
                break;
            }
        }
        return ret;
    }

    static synchronized String getTouchedBulletName(float x, float y) {
        String ret = "";

        for (ObjectContainer o : obj) {
            if (o.getName().contains("bullet")) {
                if ((x - o.getCenterX()) * (x - o.getCenterX()) + (y - o.getCenterY()) * ScreenUtils.getAspectRatio() * (y - o.getCenterY()) * ScreenUtils.getAspectRatio() < ScreenUtils.transformDistanceX(70) * ScreenUtils.transformDistanceX(70)) {
                    ret = o.getName();
                    break;
                } else if ((x - o.getCenterX()) * (x - o.getCenterX()) + (y - o.getCenterY()) * ScreenUtils.getAspectRatio() * (y - o.getCenterY()) * ScreenUtils.getAspectRatio() < ScreenUtils.transformDistanceX(100) * ScreenUtils.transformDistanceX(100)) {
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
                ObjectContainer.copy(obj.get(i), newObject);
                break;
            }
        }
        objectsChanged = true;
    }

    static void setObjectsChanged() {
        objectsChanged = true;
    }

    static boolean isObjectsChanged() {
        return objectsChanged;
    }

    static void setObjectsNotChanged() {
        objectsChanged = false;
    }

    static synchronized void eraseObjects() {
        obj = new ArrayList<>();
    }

    static float evaluateCenterX(float[] f) {
        float sum = 0;
        for (int i = 0; i < f.length; i += 3) {
            sum += f[i];
        }
        return sum / (f.length / 3.0f);
    }

    static float evaluateCenterY(float[] f) {
        float sum = 0;
        for (int i = 0; i < f.length; i += 3) {
            sum += f[i];
        }
        return sum / (f.length / 3.0f);
    }

    static boolean isOutOfRange(float[] vertices) {
        boolean outOfRange = true;
        for (int x = 0, y = 1; x < vertices.length; x += 3, y += 3) {
            outOfRange = outOfRange && (vertices[x] < -1 || vertices[x] > -1) && (vertices[y] < -1 || vertices[y] > -1);
        }
        return outOfRange;
    }
}

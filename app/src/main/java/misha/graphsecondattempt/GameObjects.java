package misha.graphsecondattempt;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

class GameObjects {
    private static List<GameObject> obj = new ArrayList<>();
    private static CopyOnWriteArrayList<GameObject> objects = new CopyOnWriteArrayList<>();
    private static volatile boolean objectsChanged = false;

    private GameObjects() {

    }

    static synchronized ArrayList<GameObject> getObjects() {
        ArrayList<GameObject> arrayList = new ArrayList<>();
        for (GameObject o : obj) {
            arrayList.add(o.getCopy());
        }
        return arrayList;
    }

    static CopyOnWriteArrayList<GameObject> getObjectsCopyOnWrite() {
        return objects;
    }

    static synchronized GameObject getObject(String name) {
        GameObject ret = null;
        for (GameObject o : obj) {
            if (name.equals(o.getName())) ret = o.getCopy();
        }
        return ret;
    }

    static GameObject getObjectCopyOnWrite(String name) {
        GameObject ret = null;
        for (GameObject o : obj) {
            if (name.equals(o.getName())) ret = o;
        }
        return ret;
    }

    static synchronized void setObjects(List<GameObject> objects) {
        obj = new ArrayList<>();
        for (GameObject o : objects)
            obj.add(o.getCopy());
        objectsChanged = true;
    }
    
    static synchronized void addObject(GameObject o) {
        obj.add(o);
    }

    static void addObjectCopyOnWrite(GameObject o) {
        objects.add(o);
    }

    static synchronized void addOrReplaceObject(GameObject o) {
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

    static synchronized void changeObject(String name, GameObject newObject) {
        for (int i = 0; i < obj.size(); ++i) {
            if (name.equals(obj.get(i).getName())) {
                GameObject.copy(obj.get(i), newObject);
                break;
            }
        }
        objectsChanged = true;
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

    static synchronized GameObject getTouchedBullet(float x, float y) {
        GameObject ret = null;
        for (GameObject o : obj) {
            if (o.getName().contains("bullet") && Math.abs(x - o.getCenterX()) < ScreenUtils.transformDistanceX(100) && Math.abs(y - o.getCenterY()) < ScreenUtils.transformDistanceX(100) / ScreenUtils.getAspectRatio()) {
                ret = o.getCopy();
                break;
            }
        }
        return ret;
    }
    static synchronized String getTouchedObjectName(float x, float y, String containedString, String notContainedString) {
        String ret = "";
        String name;
        for (GameObject o : obj) {
            name = o.getName();
            if (name.contains(containedString) && (notContainedString.equals("") || !name.contains(notContainedString))) {
                if ((x - o.getCenterX()) * (x - o.getCenterX()) + (y - o.getCenterY()) * ScreenUtils.getAspectRatio() * (y - o.getCenterY()) * ScreenUtils.getAspectRatio() < ScreenUtils.transformDistanceX(70) * ScreenUtils.transformDistanceX(70)) {
                    ret = name;
                    break;
                } else if ((x - o.getCenterX()) * (x - o.getCenterX()) + (y - o.getCenterY()) * ScreenUtils.getAspectRatio() * (y - o.getCenterY()) * ScreenUtils.getAspectRatio() < ScreenUtils.transformDistanceX(100) * ScreenUtils.transformDistanceX(100)) {
                    ret = "no!!!";
                    break;
                }
            }
        }
        return ret;
    }

    static synchronized List<GameObject> getObjectsContainingString(String pattern) {
        List<GameObject> list = new ArrayList<>();
        for (GameObject o : obj) {
            if (o.getName().contains(pattern)) {
                list.add(o.getCopy());
            }
        }
        return list;
    }

    static synchronized List<GameObject> getObjectsContainingString(String[] pattern) {
        List<GameObject> list = new ArrayList<>();
        for (GameObject o : obj) {
            boolean contains = true;
            for (String s : pattern) {
                if (!o.getName().contains(s)) contains = false;
            }
            if (contains) list.add(o.getCopy());
        }
        return list;
    }

    static synchronized String getTouchedBulletName(float x, float y) {
        String ret = "";

        for (GameObject o : obj) {
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
        for (int i = 1; i < f.length; i += 3) {
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

package misha.graphsecondattempt;

import android.os.SystemClock;

import java.util.List;

class AnimationMaker implements Runnable {
    private final Thread thread;

    AnimationMaker() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        boolean continueCycle = true;
        List<GameObject> objects;
        while (continueCycle) {
            objects = GameObjects.getObjects();
            GameObject o;
            boolean animationExists = false;
            boolean notRemoved = true;

            for (int i = 0; i < objects.size(); ++i) {

                o = objects.get(i);
                if (o.isAnimated() && !o.getAnim().isEmpty() && o.getAnim().get(0).isRedrawable()) {
                    notRemoved = true;
                    animationExists = true;
                    GameObjectAnimation a = o.getAnim().get(0);
                    long duration = a.getDurationMillis();
                    float distanceX = a.getDistanceX();
                    float distanceY = a.getDistanceY();
                    long curTime = SystemClock.uptimeMillis();
                    if (!a.isStarted()) {
                        a.setStartTime(curTime);
                        a.setLastTime(curTime);
                        a.setStarted(true);
                        a.setStartCenterX(GameObjects.evaluateCenterX(o.getVertices()));
                        a.setStartCenterY(GameObjects.evaluateCenterY(o.getVertices()));
                    } else {
                        long timePassed = curTime - a.getLastTime();
                        if (curTime - a.getStartTime() >= duration) {
                            if (a.isInfinite()) {
                                a.setStarted(false);
                            } else {
                                o.getAnim().remove(0);
                                if (o.getAnim().size() == 0) {
                                    o.setAnimated(false);
                                    boolean outOfRange = true;
                                    for (int x = 0, y = 1; x < o.getVertices().length; x += 3, y += 3) {
                                        outOfRange = outOfRange && (o.getVertices()[x] < -1 || o.getVertices()[x] > 1) && (o.getVertices()[y] < -1 || o.getVertices()[y] > 1);
                                    }
                                    if (outOfRange) {
                                        GameObjects.removeObject(objects.get(i).getName());
                                        objects.remove(i);
                                        --i;
                                        notRemoved = false;
                                    }
                                }
                            }
                        } else {
                            float transX = 0;
                            float transY = 0;
                            if (distanceX > 0) {
                                transX = (float) timePassed / duration * distanceX;
                                if (!a.isDirectionX()) {
                                    transX = -transX;
                                }
                            }
                            if (distanceY > 0) {
                                transY = (float) timePassed / duration * distanceY;
                                if (!a.isDirectionY()) {
                                    transY = -transY;
                                }
                            }

                            float[] vertices = o.getVertices();
                            for (int x = 0, y = 1; x < vertices.length; x += 3, y += 3) {
                                vertices[x] += transX;
                                vertices[y] += transY;
                            }

//                            o.setVertices(vertices);
//                            o.increaseCenterX(transX);
//                            o.increaseCenterY(transY);
                            o.setCenterX(GameObjects.evaluateCenterX(vertices));
                            o.setCenterY(GameObjects.evaluateCenterY(vertices));

                            a.setLastTime(curTime);
                        }
                    }
                    if (notRemoved) GameObjects.addOrReplaceObject(o);
//                    if (notRemoved) GameObjects.changeObject(o.getName(), o);
                }
            }
//            GameObjects.setObjects(objects);
//            if (!animationExists) continueCycle = false;
        }
    }

    synchronized boolean isRunning() {
        return thread.isAlive();
    }

}

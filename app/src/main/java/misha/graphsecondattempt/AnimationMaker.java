package misha.graphsecondattempt;

import android.os.SystemClock;

import java.util.ArrayList;

public class AnimationMaker implements Runnable {
    private Thread thread;

    AnimationMaker() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        boolean continueCycle = true;
        ArrayList<ObjectContainer> objects;
        while (continueCycle) {
            objects = GameObjects.getObjects();
            ObjectContainer o;
            boolean animationExists = false;
            boolean notRemoved = true;

            for (int i = 0; i < objects.size(); ++i) {

                o = objects.get(i);
                if (o.isAnimated() && !o.getAnim().isEmpty() && o.getAnim().get(0).isRedrawable()) {
                    notRemoved = true;
                    animationExists = true;
                    AnimationContainer a = o.getAnim().get(0);
                    long duration = a.getDuration();
                    float distanceX = a.getDistanceX();
                    float distanceY = a.getDistanceY();
                    long curTime = SystemClock.uptimeMillis();
                    if (!a.isStarted()) {
                        a.setStartTime(curTime);
                        a.setLastTime(curTime);
                        a.setStarted(true);
//                o.centerX = GameObjects.evaluateCenter(o.vertices, transX, 'x');
//                o.centerY = GameObjects.evaluateCenter(o.vertices, transY, 'y');
                        a.setStartCenterX(GameObjects.evaluateCenter(o.getVertices(), 0, 'x'));
                        a.setStartCenterY(GameObjects.evaluateCenter(o.getVertices(), 0, 'y'));
                    } else {
                        //TODO is passed a right word?
                        long timePassed = curTime - a.getLastTime();
                        if (curTime - a.getStartTime() >= duration) {
                            if (a.isInfinite()) {
                                a.setStarted(false);
                            } else {
                                o.getAnim().remove(0);
                                if (o.getAnim().size() == 0) {
                                    o.setAnimated(false);
                                    //TODO outOfRange for all anims, not only ended. If centerX/Y is outOfRAnge, then we can check are all vertices outOfRange. But object may not want to be deleted, when it moves besides the screen!
                                    boolean outOfRange = true;
                                    for (int x = 0, y = 1; x < o.getVertices().length; x += 3, y += 3) {
                                        outOfRange = outOfRange && (o.getVertices()[x] < -1 || o.getVertices()[x] > 1) && (o.getVertices()[y] < -1 || o.getVertices()[y] > 1);
                                    }
                                    if (outOfRange) {
//                                        o.setNeedToDelete(true);
//                                        GameObjects.removeObject(objects.get(i).getName());
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

                            float vertices[] = o.getVertices();
                            for (int x = 0, y = 1; x < vertices.length; x += 3, y += 3) {
                                vertices[x] += transX;
                                vertices[y] += transY;
                            }

                            o.setVertices(vertices);
                            o.increaseCenterX(transX);

                            o.increaseCenterY(transY);
//                            o.setCenterX(GameObjects.evaluateCenter(vertices, 0, 'x'));
//                            o.setCenterY(GameObjects.evaluateCenter(vertices, 0, 'y'));
                            a.setLastTime(curTime);
                        }
                    }
                    if (notRemoved) GameObjects.addOrReplaceObject(objects.get(i));
                }
            }
//            GameObjects.setObjects(objects);
//            if (!animationExists) continueCycle = false;
        }
    }

    public synchronized boolean isRunning() {
        return thread.isAlive();
    }

}

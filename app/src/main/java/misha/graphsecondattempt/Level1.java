package misha.graphsecondattempt;

import android.os.SystemClock;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;

//import android.widget.Toast;

/**
 * Created by master22 on 5/1/2018.
 * Package: bg.fallingbullets, project: FallingBullets.
 */

class Level1 extends Level {
    private boolean isRunning = false;
    private EventContainer eventContainer;
    private ObjectContainer objectContainer;
    private AnimationContainer animationContainer;


    private float clDist, clSin, clCos;

    private float touchBeginX = 0, touchBeginY = 0, touchCurX = 0, touchCurY = 0, touchLastX = 0, touchLastY = 0;

    private int score;

    private EventMaker eventMaker;
    private AnimationMaker animationMaker;

    private long curTime = SystemClock.uptimeMillis();
    private int lastTouchAction = 0;
    private int count = 0;
    private long lastTouchTime = 0;
    private boolean doubleTouch = false;
    private String touchedObjectName = "";
    private String creatingEdgeName = "";
    private boolean creatingEdge = false;

    @Override
    void isClosely(ObjectContainer o) {

    }

    @Override
    void start() {
        isRunning = true;
        GameObjects.eraseObjects();
        objectContainer = new ObjectContainer();
        objectContainer.setVertices(new float[]{ScreenUtils.transformCoordinateX(0), ScreenUtils.transformCoordinateY(0), 0.99f,
                                                ScreenUtils.transformCoordinateX(720), ScreenUtils.transformCoordinateY(0), 0.99f,
                                                ScreenUtils.transformCoordinateX(720), ScreenUtils.transformCoordinateY(1280), 0.99f,
                                                ScreenUtils.transformCoordinateX(0), ScreenUtils.transformCoordinateY(1280), 0.99f});
        objectContainer.setColorR(0.50f);
        objectContainer.setColorG(0.50f);
        objectContainer.setColorB(0.50f);
        objectContainer.setStartPoint(0);
        objectContainer.setNumberOfPoints(4);
        objectContainer.setName("background");
        objectContainer.setDrawed(true);
        objectContainer.setInOpenglCache(true);
        objectContainer.setMinX(-1);
        objectContainer.setMinY(-1);
        GameObjects.addObject(objectContainer);
    }

    @Override
    void wasTouched(float x, float y, int type) {
        final int ACTION_DOWN = 0;
        final int ACTION_MOVE = 1;
        final int ACTION_UP = 2;
        curTime = SystemClock.uptimeMillis();

        switch (type) {

            case ACTION_DOWN:
                doubleTouch = curTime - lastTouchTime <= 500;

                lastTouchTime = curTime;
                touchedObjectName = GameObjects.getTouchedBulletName(ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y));
                if (touchedObjectName.equals("")) {

                    objectContainer = new ObjectContainer();
                    objectContainer.setVertices(ObjectTemplates.getCircle(ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y), ScreenUtils.transformDistanceX(50), 'x'));
                    objectContainer.setColorR(0.10f);
                    objectContainer.setColorG(0.50f);
                    objectContainer.setColorB(0.90f);
                    objectContainer.setStartPoint(0);
                    objectContainer.setNumberOfPoints(4);
                    objectContainer.setName("bullet" + count);
                    objectContainer.setDrawed(true);
                    objectContainer.setInOpenglCache(true);
                    objectContainer.setMinX(-1);
                    objectContainer.setMinY(-1);
                    objectContainer.setCenterX(GameObjects.evaluateCenterX(objectContainer.getVertices()));
                    objectContainer.setCenterY(GameObjects.evaluateCenterY(objectContainer.getVertices()));

                    animationContainer = new AnimationContainer();
                    animationContainer.setRedrawable(true);
                    animationContainer.setDistanceX(ScreenUtils.transformDistanceX(100));
                    animationContainer.setDistanceY(ScreenUtils.transformDistanceY(100));
                    animationContainer.setDurationMillis(2000);

//                    objectContainer.addAnimation(animationContainer);
//                    objectContainer.setAnimated(true);

                    eventContainer = new EventContainer();
                    eventContainer.setRandomizedTime(false);
                    eventContainer.setWaitTime(0);
                    eventContainer.setCycled(false);
                    eventContainer.setKindOfEvent('a');
                    eventContainer.setNeedToRebindData();

                    eventContainer.setObject(objectContainer);
                    eventContainer.setName("bullet" + count);
                    count++;
//                    GameEvents.addEvent(eventContainer);
                    if (eventMaker == null || !eventMaker.isRunning())
                        eventMaker = new EventMaker();
                    if (animationMaker == null || !animationMaker.isRunning())
                        animationMaker = new AnimationMaker();

                    GameObjects.addOrReplaceObject(objectContainer);
                } else if (touchedObjectName.contains("bullet")){
                    touchBeginX = x;
                    touchBeginY = y;
                    if (!(doubleTouch && Math.abs(ScreenUtils.transformCoordinateX(x) - ScreenUtils.transformCoordinateX(touchLastX)) < ScreenUtils.transformDistanceX(40) && Math.abs(ScreenUtils.transformCoordinateY(y) - ScreenUtils.transformCoordinateY(touchLastY)) < ScreenUtils.transformDistanceY(40))) {
                        doubleTouch = false;
                    }
                    if (doubleTouch) {
                        ObjectContainer touchedObject = GameObjects.getObject(touchedObjectName);
                        touchBeginX = touchedObject.getCenterX();
                        touchBeginY = touchedObject.getCenterY();
                    }
                    touchCurX = touchLastX = touchBeginX;
                    touchCurY = touchLastY = touchBeginY;

                }
                lastTouchAction = ACTION_DOWN;
                break;

            case ACTION_MOVE:
                touchCurY = y;
                touchCurX = x;

                if (touchedObjectName.contains("bullet")) {
                    if (doubleTouch) {
                        if (!creatingEdge) {
                            creatingEdgeName = "edgev" + touchedObjectName.substring(6);
                            objectContainer = new ObjectContainer();
                            objectContainer.setVertices(ObjectTemplates.getCircle(ScreenUtils.transformCoordinateX(touchBeginX), ScreenUtils.transformCoordinateY(touchBeginY), ScreenUtils.transformDistanceX(50), 'x'));

                            objectContainer.setColorR(0.90f);
                            objectContainer.setColorG(0.50f);
                            objectContainer.setColorB(0.10f);
                            objectContainer.setStartPoint(0);
                            objectContainer.setNumberOfPoints(4);
                            objectContainer.setName(creatingEdgeName);
                            objectContainer.setDrawed(true);
                            objectContainer.setInOpenglCache(true);
                            objectContainer.setMinX(-1);
                            objectContainer.setMinY(-1);
                            objectContainer.setCenterX(GameObjects.evaluateCenterX(objectContainer.getVertices()));
                            objectContainer.setCenterY(GameObjects.evaluateCenterY(objectContainer.getVertices()));
                            creatingEdge = true;
                        }
                        else {
                            objectContainer = GameObjects.getObject(creatingEdgeName);
                        }
                        objectContainer.setFanOrStrip(GL_TRIANGLE_FAN);
                        objectContainer.setVertices(ObjectTemplates.getLine(touchBeginX, touchBeginY, touchCurX, touchCurY));
//                        objectContainer.setVertices();
                        GameObjects.addOrReplaceObject(objectContainer);
                    }
                    else {
                        ObjectContainer touchedObject = GameObjects.getObject(touchedObjectName);
                        if (touchedObject != null) {
                            float[] v = touchedObject.getVertices();
                            for (int i = 0; i < v.length; i += 3) {
                                v[i] = v[i] + ScreenUtils.transformDistanceX(touchCurX - touchLastX);
                                v[i + 1] = v[i + 1] - ScreenUtils.transformDistanceY(touchCurY - touchLastY);
                            }
                            touchedObject.setCenterX(GameObjects.evaluateCenterX(v));
                            touchedObject.setCenterY(GameObjects.evaluateCenterY(v));
                            GameObjects.changeObject(touchedObjectName, touchedObject);
                            touchLastX = touchCurX;
                            touchLastY = touchCurY;
                        }
                    }
                }
                else doubleTouch = false;
                lastTouchAction = ACTION_MOVE;
                break;

            case ACTION_UP:

                touchedObjectName = "";
//                if (lastTouchAction == ACTION_MOVE && doubleTouch) {
//                    touchedObjectName = GameObjects.getTouchedBulletName(ScreenUtils.transformCoordinateX(x), ScreenUtils.transformCoordinateY(y));
//
//                    doubleTouch = false;
//                }
                creatingEdge = false;

                break;
        }
    }

    @Override
    boolean isRunning() {
        return isRunning;
    }

    private MyCallback mycallback;

    @Override
    void registerCallBack(MyCallback callback) {
        //mycallback.id = 0;
        this.mycallback = callback;
        //mycallback.id = 1;

    }

    @Override
    int level() {
        return 1;
    }


}

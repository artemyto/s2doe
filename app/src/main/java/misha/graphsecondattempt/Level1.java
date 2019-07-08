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
    private GameObjectEvent gameObjectEvent;
    private GameObject gameObject;
    private GameObjectAnimation gameObjectAnimation;


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
    void isClosely(GameObject o) {

    }

    @Override
    void start() {
        isRunning = true;
        GameObjects.eraseObjects();
        gameObject = new GameObject();
        gameObject.setVertices(new float[]{ScreenUtils.transformXCoordinateScreenToOpengl(0), ScreenUtils.transformYCoordinateScreenToOpengl(0), 0.99f,
                                                ScreenUtils.transformXCoordinateScreenToOpengl(720), ScreenUtils.transformYCoordinateScreenToOpengl(0), 0.99f,
                                                ScreenUtils.transformXCoordinateScreenToOpengl(720), ScreenUtils.transformYCoordinateScreenToOpengl(1280), 0.99f,
                                                ScreenUtils.transformXCoordinateScreenToOpengl(0), ScreenUtils.transformYCoordinateScreenToOpengl(1280), 0.99f});
        gameObject.setColorR(0.50f);
        gameObject.setColorG(0.50f);
        gameObject.setColorB(0.50f);
        gameObject.setStartPoint(0);
        gameObject.setNumberOfPoints(4);
        gameObject.setName("background");
        gameObject.setDrawed(true);
        gameObject.setInOpenglCache(true);
        gameObject.setMinX(-1);
        gameObject.setMinY(-1);
        GameObjects.addObject(gameObject);
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
                touchedObjectName = GameObjects.getTouchedBulletName(ScreenUtils.transformXCoordinateScreenToOpengl(x), ScreenUtils.transformYCoordinateScreenToOpengl(y));
                if (touchedObjectName.equals("")) {

                    gameObject = new GameObject();
                    gameObject.setVertices(ObjectTemplates.getCircle(ScreenUtils.transformXCoordinateScreenToOpengl(x), ScreenUtils.transformYCoordinateScreenToOpengl(y), ScreenUtils.transformDistanceX(50), 'x'));
                    gameObject.setColorR(0.10f);
                    gameObject.setColorG(0.50f);
                    gameObject.setColorB(0.90f);
                    gameObject.setStartPoint(0);
                    gameObject.setNumberOfPoints(4);
                    gameObject.setName("bullet" + count);
                    gameObject.setDrawed(true);
                    gameObject.setInOpenglCache(true);
                    gameObject.setMinX(-1);
                    gameObject.setMinY(-1);
                    gameObject.setCenterX(GameObjects.evaluateCenterX(gameObject.getVertices()));
                    gameObject.setCenterY(GameObjects.evaluateCenterY(gameObject.getVertices()));

                    gameObjectAnimation = new GameObjectAnimation();
                    gameObjectAnimation.setRedrawable(true);
                    gameObjectAnimation.setDistanceX(ScreenUtils.transformDistanceX(100));
                    gameObjectAnimation.setDistanceY(ScreenUtils.transformDistanceY(100));
                    gameObjectAnimation.setDurationMillis(2000);

//                    gameObject.addAnimation(gameObjectAnimation);
//                    gameObject.setAnimated(true);

                    gameObjectEvent = new GameObjectEvent();
                    gameObjectEvent.setRandomizedTime(false);
                    gameObjectEvent.setWaitTime(0);
                    gameObjectEvent.setCycled(false);
                    gameObjectEvent.setKindOfEvent('a');
                    gameObjectEvent.setNeedToRebindData();

                    gameObjectEvent.setObject(gameObject);
                    gameObjectEvent.setName("bullet" + count);
                    count++;
                    GameEvents.addEvent(gameObjectEvent);
                    if (eventMaker == null || !eventMaker.isRunning())
                        eventMaker = new EventMaker();
                    if (animationMaker == null || !animationMaker.isRunning())
                        animationMaker = new AnimationMaker();

//                    GameObjects.addOrReplaceObject(gameObject);
                } else if (touchedObjectName.contains("bullet")){
                    touchBeginX = x;
                    touchBeginY = y;
                    if (!(doubleTouch && Math.abs(ScreenUtils.transformXCoordinateScreenToOpengl(x) - ScreenUtils.transformXCoordinateScreenToOpengl(touchLastX)) < ScreenUtils.transformDistanceX(40) && Math.abs(ScreenUtils.transformYCoordinateScreenToOpengl(y) - ScreenUtils.transformYCoordinateScreenToOpengl(touchLastY)) < ScreenUtils.transformDistanceY(40))) {
                        doubleTouch = false;
                    }
                    if (doubleTouch) {
                        GameObject touchedObject = GameObjects.getObject(touchedObjectName);
                        touchBeginX = ScreenUtils.transformXCoordinateOpenglToScreen(touchedObject.getCenterX());
                        touchBeginY = ScreenUtils.transformYCoordinateOpenglToScreen(touchedObject.getCenterY());
                    }
                    touchCurX = touchLastX = touchBeginX;
                    touchCurY = touchLastY = touchBeginY;

                }
                lastTouchAction = ACTION_DOWN;
                break;

            case ACTION_MOVE:
                touchCurY = y;
                touchCurX = x;
//                doubleTouch = false;
                if (touchedObjectName.contains("bullet")) {
                    if (doubleTouch) {
                        if (!creatingEdge) {
                            creatingEdgeName = "edgev" + touchedObjectName.substring(6);
                            gameObject = new GameObject();
                            gameObject.setVertices(ObjectTemplates.getCircle(ScreenUtils.transformXCoordinateScreenToOpengl(touchBeginX), ScreenUtils.transformYCoordinateScreenToOpengl(touchBeginY), ScreenUtils.transformDistanceX(50), 'x'));

                            gameObject.setColorR(0.90f);
                            gameObject.setColorG(0.50f);
                            gameObject.setColorB(0.10f);
                            gameObject.setStartPoint(0);
                            gameObject.setNumberOfPoints(4);
                            gameObject.setName(creatingEdgeName);
                            gameObject.setDrawed(true);
                            gameObject.setInOpenglCache(true);
                            gameObject.setMinX(-1);
                            gameObject.setMinY(-1);
                            gameObject.setCenterX(GameObjects.evaluateCenterX(gameObject.getVertices()));
                            gameObject.setCenterY(GameObjects.evaluateCenterY(gameObject.getVertices()));
                            creatingEdge = true;
                        }
                        else {
                            gameObject = GameObjects.getObject(creatingEdgeName);
                        }
                        gameObject.setFanOrStrip(GL_TRIANGLE_FAN);
                        gameObject.setVertices(ObjectTemplates.getLine(touchBeginX, touchBeginY, touchCurX, touchCurY));
//                        gameObject.setVertices();
                        GameObjects.addOrReplaceObject(gameObject);
                    }
                    else {
                        GameObject touchedObject = GameObjects.getObject(touchedObjectName);
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
//                    touchedObjectName = GameObjects.getTouchedBulletName(ScreenUtils.transformXCoordinateScreenToOpengl(x), ScreenUtils.transformYCoordinateScreenToOpengl(y));
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

package misha.graphsecondattempt;

import android.os.SystemClock;

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

    private int count = 0;
    private long touchTime = 0;
    private boolean doubleTouch = false;

    private String touchedObjectName = "";
    private long lastTime;

    private float clDist, clSin, clCos;

    private float touchBeginX = 0, touchBeginY = 0, touchCurX = 0, touchCurY = 0, touchLastX = 0, touchLastY = 0;

    private ObjectContainer touchedBullet = null;

    private int score;

    private EventMaker eventMaker;
    private AnimationMaker animationMaker;

    private final int ACTION_DOWN = 0;
    private final int ACTION_MOVE = 1;
    private final int ACTION_UP = 2;

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
        long curTime = SystemClock.uptimeMillis();
        switch (type) {

            case ACTION_DOWN:
                if (curTime - touchTime <= 500) doubleTouch = true;
                else doubleTouch = false;
                touchTime = curTime;
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

                    objectContainer.addAnimation(animationContainer);
                    objectContainer.setAnimated(true);

                    eventContainer = new EventContainer();
                    eventContainer.setRandomizedTime(false);
                    eventContainer.setWaitTime(0);
                    eventContainer.setCycled(false);
                    eventContainer.setKindOfEvent('a');
                    eventContainer.setNeedToRebindData();

                    eventContainer.setObject(objectContainer);
                    eventContainer.setName("bullet" + count);
                    count++;
                    GameEvents.addEvent(eventContainer);
                    if (eventMaker == null || !eventMaker.isRunning())
                        eventMaker = new EventMaker();
                    if (animationMaker == null || !animationMaker.isRunning())
                        animationMaker = new AnimationMaker();
                } else {
                    touchBeginX = x;
                    touchBeginY = y;
                    touchCurX = touchLastX = touchBeginX;
                    touchCurY = touchLastY = touchBeginY;
                }
                break;

            case ACTION_MOVE:
                touchCurY = y;
                touchCurX = x;

                if (!touchedObjectName.equals("") && !doubleTouch) {
                    touchedBullet = GameObjects.getObject(touchedObjectName);
                    if (touchedBullet != null) {
                        float[] v = touchedBullet.getVertices();
                        for (int i = 0; i < v.length; i += 3) {
                            v[i] = v[i] + ScreenUtils.transformDistanceX(touchCurX - touchLastX);
                            v[i + 1] = v[i + 1] - ScreenUtils.transformDistanceY(touchCurY - touchLastY);
                        }
                        touchedBullet.setCenterX(GameObjects.evaluateCenterX(v));
                        touchedBullet.setCenterY(GameObjects.evaluateCenterY(v));
                        GameObjects.changeObject(touchedObjectName,touchedBullet);
                        touchLastX = touchCurX;
                        touchLastY = touchCurY;
                    }
                }
                break;

            case ACTION_UP:
                touchedObjectName = "";

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

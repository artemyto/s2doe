package misha.graphsecondattempt;

import android.os.SystemClock;

//import android.widget.Toast;

/**
 * Created by master22 on 5/1/2018.
 * Package: bg.fallingbullets, project: FallingBullets.
 */

public class Level1 extends Level {
    private boolean isRunning = false;
    private EventContainer eventContainer;
    private ObjectContainer objectContainer;
    private AnimationContainer animationContainer;

    private int count = 0;

    private String touchedObjectName = "";
    //    ObjectContainer touchedBullet;
    private long lastTime;

    private float clDist, clSin, clCos;

    private float touchBeginX = 0, touchBeginY = 0, touchCurX = 0, touchCurY = 0, touchLastX = 0, touchLastY = 0;

    private ObjectContainer touchedBullet = null;

    private int score;

    private EventMaker eventMaker;


    @Override
    void isClosely(ObjectContainer o) {

    }

    @Override
    void start() {
        isRunning = true;
//        SomeUtils.obj = new ArrayList<>();
        GameObjects.eraseObjects();
//        SomeUtils.events = new ArrayList<>();

        objectContainer = new ObjectContainer();
        objectContainer.setVertices(new float[]{ScreenUtils.transformCoordinate(0, 'x'), ScreenUtils.transformCoordinate(0, 'y'), 0.99f,
                ScreenUtils.transformCoordinate(720, 'x'), ScreenUtils.transformCoordinate(0, 'y'), 0.99f,
                ScreenUtils.transformCoordinate(720, 'x'), ScreenUtils.transformCoordinate(1280, 'y'), 0.99f,
                ScreenUtils.transformCoordinate(0, 'x'), ScreenUtils.transformCoordinate(1280, 'y'), 0.99f});
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
//        SomeUtils.obj.add(objectContainer);
//        GameEvents.addEvent(objectContainer);
        GameObjects.addObject(objectContainer);


//        objectContainer = new ObjectContainer();
////                objectContainer.setVertices(SomeUtils.getCircle(objectContainer.getCenterX(), objectContainer.getCenterY(), objectContainer.getMinX()));
//        objectContainer.setVertices(SomeUtils.getDigit2(300, 300, 30));
//        objectContainer.setVertices(SomeUtils.getCircle(1, 1, 1));
//        objectContainer.setColorR(0.10f);
//        objectContainer.setColorG(0.50f);
//        objectContainer.setColorB(0.90f);
//        objectContainer.setStartPoint(0);
//        objectContainer.setNumberOfPoints(4);
//        objectContainer.setName("background");
//        objectContainer.setDrawed(true);
//        objectContainer.setInOpenglCache(true);
//        objectContainer.setMinX(-1);
//        objectContainer.setMinY(-1);
//
//        SomeUtils.obj.add(objectContainer);

    }

    @Override
    void wasTouched(float x, float y, int type) {
        long curTime = SystemClock.uptimeMillis();
//        String name = GameObjects.getTouchedBulletName(ScreenUtils.transformCoordinate(x, 'x'), ScreenUtils.transformCoordinate(y, 'y'));
        switch (type) {
            //action_down
            case 0:
//            case 1:
                touchedObjectName = GameObjects.getTouchedBulletName(ScreenUtils.transformCoordinate(x, 'x'), ScreenUtils.transformCoordinate(y, 'y'));
//                objectContainer = GameObjects.getTouchedBullet(ScreenUtils.transformCoordinate(x, 'x'), ScreenUtils.transformCoordinate(y, 'y'));
//                objectContainer = null;

//                if (objectContainer == null) {
                if (touchedObjectName.equals("")) {
                    objectContainer = new ObjectContainer();
//                objectContainer.setVertices(SomeUtils.getCircle(objectContainer.getCenterX(), objectContainer.getCenterY(), objectContainer.getMinX()));
//                    objectContainer.setVertices(ObjectTemplates.getDigit2(300, 300, 30));
                    objectContainer.setVertices(ObjectTemplates.getCircle(ScreenUtils.transformCoordinate(x, 'x'), ScreenUtils.transformCoordinate(y, 'y'), ScreenUtils.transformDistance(50, 'x'), 'x'));
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
                    objectContainer.setCenterX(GameObjects.evaluateCenter(objectContainer.getVertices(), 0, 'x'));
                    objectContainer.setCenterY(GameObjects.evaluateCenter(objectContainer.getVertices(), 0, 'y'));
//                SomeUtils.obj.add(objectContainer);
                    eventContainer = new EventContainer();
                    eventContainer.setRandomizedTime(false);
                    eventContainer.setWaitTime(0);
                    eventContainer.setCycled(false);
                    eventContainer.setKindOfEvent('a');
                    eventContainer.setNeedToRebindData(true);
                    //eventContainer.needToGenerateObject = true;
//                eventContainer.setRandomTop(4500);
//                eventContainer.setRandomBottom(3000);
//                eventContainer.setNeedToGenerateObject(1);
                    eventContainer.setO(objectContainer);
//                    SomeUtils.events.add(eventContainer);
//                    long curTime = SystemClock.uptimeMillis();
                    eventContainer.setName("bullet" + count);
                    count++;
                    GameEvents.addEvent(eventContainer);
                    if (eventMaker == null || !eventMaker.isRunning())
                        eventMaker = new EventMaker();
                } else {
                    touchBeginX = x;
                    touchBeginY = y;
                    touchCurX = touchLastX = touchBeginX;
                    touchCurY = touchLastY = touchBeginY;
//                    touchedBullet = objectContainer;
                }
                break;
            //action_move
            case 1:
                touchCurY = y;
                touchCurX = x;
                if (!touchedObjectName.equals("")) {
                    touchedBullet = GameObjects.getObject(touchedObjectName);
                    if (touchedBullet != null) {
                        float[] v = touchedBullet.getVertices();
                        for (int i = 0; i < v.length; i += 3) {
                            v[i] = v[i] + ScreenUtils.transformDistance(touchCurX - touchLastX, 'x');
                            v[i + 1] = v[i + 1] - ScreenUtils.transformDistance(touchCurY - touchLastY, 'y');
//                            v[i+1] = 1;
//                            v[i] = 1;
                        }
//                        touchedBullet.setVertices(v);
                        touchedBullet.setCenterX(GameObjects.evaluateCenter(v, 0, 'x'));
                        touchedBullet.setCenterY(GameObjects.evaluateCenter(v, 0, 'y'));
                        GameObjects.changeObject(touchedObjectName,touchedBullet);
                        touchLastX = touchCurX;
                        touchLastY = touchCurY;
                    }
                }
                break;
            case 2://action_down
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

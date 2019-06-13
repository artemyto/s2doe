package misha.graphsecondattempt;

import android.os.SystemClock;

import java.util.ArrayList;

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
        objectContainer.setVertices(new float[]{ScreenParameters.changeCoordinate(0, 'x'), ScreenParameters.changeCoordinate(0, 'y'), 0.99f,
                                  ScreenParameters.changeCoordinate(720, 'x'), ScreenParameters.changeCoordinate(0, 'y'), 0.99f,
                                  ScreenParameters.changeCoordinate(720, 'x'), ScreenParameters.changeCoordinate(1280, 'y'), 0.99f,
                                  ScreenParameters.changeCoordinate(0, 'x'), ScreenParameters.changeCoordinate(1280, 'y'), 0.99f});
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
        switch(type) {
            //action_down
            case 0:
                objectContainer = GameObjects.getTouchedBullet(ScreenParameters.changeCoordinate(x,'x'), ScreenParameters.changeCoordinate(y, 'y'));
                if (objectContainer == null) {
                    objectContainer = new ObjectContainer();
//                objectContainer.setVertices(SomeUtils.getCircle(objectContainer.getCenterX(), objectContainer.getCenterY(), objectContainer.getMinX()));
                    objectContainer.setVertices(ObjectTemplates.getDigit2(300, 300, 30));
                    objectContainer.setVertices(ObjectTemplates.getCircle(ScreenParameters.changeCoordinate(x, 'x'), ScreenParameters.changeCoordinate(y, 'y'), ScreenParameters.changeDistance(50, 'x')));
                    objectContainer.setColorR(0.10f);
                    objectContainer.setColorG(0.50f);
                    objectContainer.setColorB(0.90f);
                    objectContainer.setStartPoint(0);
                    objectContainer.setNumberOfPoints(4);
                    objectContainer.setName("bullet");
                    objectContainer.setDrawed(true);
                    objectContainer.setInOpenglCache(true);
                    objectContainer.setMinX(-1);
                    objectContainer.setMinY(-1);

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
                    GameEvents.addEvent(eventContainer);
                    if (eventMaker == null || !eventMaker.isRunning()) eventMaker = new EventMaker();
                }
                else {
                    touchBeginX = x;
                    touchBeginY = y;
                    touchCurX = touchLastX = touchBeginX;
                    touchCurY = touchLastY = touchBeginY;
                    touchedBullet = objectContainer;
                }
                break;
                //action_move
            case 1:
                touchCurY = y;
                touchCurX = x;
                if (touchedBullet != null) {
                    float[] v = touchedBullet.getVertices();
                    for(int i = 0; i < v.length; i+=3) {
                        v[i] = v[i] + ScreenParameters.changeDistance(touchCurX-touchLastX, 'x');
                        v[i+1] = v[i+1] + ScreenParameters.changeDistance(touchCurY-touchLastY, 'y');
                    }
                    touchLastX = touchCurX;
                    touchLastY = touchCurY;
                }
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

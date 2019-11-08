package misha.graphsecondattempt;

import android.os.SystemClock;

import java.util.List;

import static android.opengl.GLES20.GL_TRIANGLE_FAN;


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
        gameObject = new GameObject.Builder()
                .color(0.50f,0.50f, 0.50f).drawn().name("background")
                .vertices(new float[]{ScreenUtils.transformXCoordinateScreenToOpengl(0), ScreenUtils.transformYCoordinateScreenToOpengl(0), 0.99f,
                                      ScreenUtils.transformXCoordinateScreenToOpengl(720), ScreenUtils.transformYCoordinateScreenToOpengl(0), 0.99f,
                                      ScreenUtils.transformXCoordinateScreenToOpengl(720), ScreenUtils.transformYCoordinateScreenToOpengl(1280), 0.99f,
                                      ScreenUtils.transformXCoordinateScreenToOpengl(0), ScreenUtils.transformYCoordinateScreenToOpengl(1280), 0.99f}).build();
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
                touchedObjectName = GameObjects.getTouchedObjectName(ScreenUtils.transformXCoordinateScreenToOpengl(x), ScreenUtils.transformYCoordinateScreenToOpengl(y), "vertice", "edge");
                if (touchedObjectName.equals("")) {

                    gameObject = new GameObject.Builder()
                            .color(0.90f,0.50f, 0.10f).drawn().name("vertice" + count)
                            .vertices(ObjectTemplates.getCircle(ScreenUtils.transformXCoordinateScreenToOpengl(x), ScreenUtils.transformYCoordinateScreenToOpengl(y), ScreenUtils.transformDistanceX(50), 'x'))
                            .build();
                    gameObjectEvent = new GameObjectEvent.Builder()
                            .addObject(gameObject)
                            .name("vertice" + count++)
                            .build();
                    GameEvents.addEvent(gameObjectEvent);
                    if (eventMaker == null || !eventMaker.isRunning())
                        eventMaker = new EventMaker();
                    if (animationMaker == null/* || !animationMaker.isRunning()*/) {
                        animationMaker = new AnimationMaker();
                        animationMaker.execute();
                    }
                } else if (touchedObjectName.contains("vertice")) {
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
                if (touchedObjectName.contains("vertice")) {
                    if (doubleTouch) {
                        if (!creatingEdge) {
                            creatingEdgeName = "edge" + touchedObjectName;
                            gameObject = new GameObject.Builder()
                                    .color(0.10f,0.50f, 0.90f).drawn().name(creatingEdgeName)
                                    .vertices(ObjectTemplates.getCircle(ScreenUtils.transformXCoordinateScreenToOpengl(touchBeginX), ScreenUtils.transformYCoordinateScreenToOpengl(touchBeginY), ScreenUtils.transformDistanceX(50), 'x'))
                                    .build();
                            creatingEdge = true;
                        } else {
                            gameObject = GameObjects.getObject(creatingEdgeName);
                        }
                        gameObject.setOpenglDrawingMode(GL_TRIANGLE_FAN);
                        gameObject.setVertices(ObjectTemplates.getLine(touchBeginX, touchBeginY, touchCurX, touchCurY));
                        GameObjects.addOrReplaceObject(gameObject);
                    } else {
                        GameObject touchedObject = GameObjects.getObject(touchedObjectName);
                        if (touchedObject != null) {
                            float[] v = touchedObject.getVertices();
                            for (int i = 0; i < v.length; i += 3) {
                                v[i] += ScreenUtils.transformDistanceX(touchCurX - touchLastX);
                                v[i + 1] -= ScreenUtils.transformDistanceY(touchCurY - touchLastY);
                            }
                            touchedObject.setCenterX(GameObjects.evaluateCenterX(v));
                            touchedObject.setCenterY(GameObjects.evaluateCenterY(v));
                            GameObjects.changeObject(touchedObjectName, touchedObject);

                            String[] pattern = new String[]{"edge", touchedObjectName};
                            List<GameObject> list = GameObjects.getObjectsContainingString(pattern);
                            for (GameObject o : list) {
                                //0, 1 - start point, 2, 3 - end point
                                float[] edgePoints = ObjectTemplates.getLinePoints(o.getVertices());
                                if (o.getName().indexOf(touchedObjectName) == "edge".length())
                                    o.setVertices(ObjectTemplates.getLine(edgePoints[0] + touchCurX - touchLastX, edgePoints[1] + touchCurY - touchLastY, edgePoints[2], edgePoints[3]));
                                else o.setVertices(ObjectTemplates.getLine(edgePoints[0], edgePoints[1], edgePoints[2] + touchCurX - touchLastX, edgePoints[3] + touchCurY - touchLastY));
                                o.setCenterX(GameObjects.evaluateCenterX(v));
                                o.setCenterY(GameObjects.evaluateCenterY(v));
                                GameObjects.changeObject(o.getName(), o);
                            }
                            touchLastX = touchCurX;
                            touchLastY = touchCurY;
                        }
                    }
                } else doubleTouch = false;
                lastTouchAction = ACTION_MOVE;
                break;

            case ACTION_UP:
                if (creatingEdge) {
                    touchedObjectName = GameObjects.getTouchedObjectName(ScreenUtils.transformXCoordinateScreenToOpengl(x), ScreenUtils.transformYCoordinateScreenToOpengl(y), "vertice", "edge");
                    if (touchedObjectName.contains("vertice")) {
                        gameObject = GameObjects.getObject(touchedObjectName);
                        touchCurX = ScreenUtils.transformXCoordinateOpenglToScreen(gameObject.getCenterX());
                        touchCurY = ScreenUtils.transformYCoordinateOpenglToScreen(gameObject.getCenterY());
                        gameObject = GameObjects.getObject(creatingEdgeName);
                        gameObject.setName(creatingEdgeName + touchedObjectName);
                        gameObject.setVertices(ObjectTemplates.getLine(touchBeginX, touchBeginY, touchCurX, touchCurY));
                        GameObjects.removeObject(creatingEdgeName);
                        GameObjects.addOrReplaceObject(gameObject);
                    }
                    else GameObjects.removeObject(creatingEdgeName);
                    creatingEdgeName = "";
                    creatingEdge = false;
                }

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

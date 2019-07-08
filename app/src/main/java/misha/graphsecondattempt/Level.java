package misha.graphsecondattempt;

/**
 * Created by master22 on 5/1/2018.
 * Package: bg.fallingbullets, project: FallingBullets.
 */

public abstract class Level {
    abstract void start();

    abstract void isClosely(GameObject o);

    abstract void wasTouched(float x, float y, int type);

    abstract  boolean isRunning();

    interface MyCallback {
        void callBackReturn(int id);
    }
    //mycallback.callBackReturn();
    abstract void registerCallBack(MyCallback callback);
    abstract int level();
}

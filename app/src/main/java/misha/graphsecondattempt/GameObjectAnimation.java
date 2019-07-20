package misha.graphsecondattempt;

/**
 * Created by master22 on 4/24/2018.
 Package: ${PACKAGE_NAME}, project: TriforcePower.
 */

class GameObjectAnimation {

    private boolean directionX = true;
    private boolean directionY = true;
    private float distanceX = 0;
    private float distanceY = 0;
    private long duration = 0;
    private boolean isInfinite = false;
    private boolean isRedrawable = false;
    private boolean isStarted = false;
    private long lastTime = 0;
    private float startCenterX = 0;
    private float startCenterY = 0;
    private long startTime = 0;
    private boolean wantStop = false;


    GameObjectAnimation() {
    }

    GameObjectAnimation(Builder builder) {
        directionX = builder.directionX;
        directionY = builder.directionY;
        distanceX = builder.distanceX;
        distanceY = builder.distanceY;
        duration = builder.duration;
        isInfinite = builder.isInfinite;
        isRedrawable = builder.isRedrawable;
        isStarted = builder.isStarted;
        lastTime = builder.lastTime;
        startCenterX = builder.startCenterX;
        startCenterY = builder.startCenterY;
        startTime = builder.startTime;
        wantStop = builder.wantStop;
    }

    static class Builder {
        private boolean directionX = true;
        private boolean directionY = true;
        private float distanceX = 0;
        private float distanceY = 0;
        private long duration = 0;
        private boolean isInfinite = false;
        private boolean isRedrawable = false;
        private boolean isStarted = false;
        private long lastTime = 0;
        private float startCenterX = 0;
        private float startCenterY = 0;
        private long startTime = 0;
        private boolean wantStop = false;

        Builder infinite() {
            isInfinite = true;
            return this;
        }

        Builder trajectory(float x, float y) {
            if (x < 0) {
                distanceX = -x;
                directionX = false;
            }
            else distanceX = x;
            if (y < 0) {
                distanceY = -y;
                directionY = false;
            }
            else distanceY = y;
            return this;
        }

        Builder time(long time) {
            duration = time;
            return this;
        }



        GameObjectAnimation build() {
            return new GameObjectAnimation(this);
        }
    }

    static GameObjectAnimation copy (GameObjectAnimation oldA) {
        GameObjectAnimation newA = new GameObjectAnimation();
        newA.duration = oldA.duration;
        newA.distanceX = oldA.distanceX;
        newA.distanceY = oldA.distanceY;
        newA.directionX = oldA.directionX;
        newA.directionY = oldA.directionY;
        newA.wantStop = oldA.wantStop;
        newA.isInfinite = oldA.isInfinite;
        newA.isStarted = oldA.isStarted;
//        newA.isInfinite = oldA.isInfinite;
        newA.startCenterX = oldA.startCenterX;
        newA.startCenterY = oldA.startCenterY;
        newA.isRedrawable = oldA.isRedrawable;
        newA.lastTime = oldA.lastTime;
        newA.startTime = oldA.startTime;
        return newA;
    }

    GameObjectAnimation getCopy() {
        GameObjectAnimation newA = new GameObjectAnimation();
        newA.duration = duration;
        newA.distanceX = distanceX;
        newA.distanceY = distanceY;
        newA.directionX = directionX;
        newA.directionY = directionY;
        newA.wantStop = wantStop;
        newA.isInfinite = isInfinite;
        newA.isStarted = isStarted;
//        newA.isInfinite = oldA.isInfinite;
        newA.startCenterX = startCenterX;
        newA.startCenterY = startCenterY;
        newA.isRedrawable = isRedrawable;
        newA.lastTime = lastTime;
        newA.startTime = startTime;
        return newA;
    }

    long getDurationMillis() {
        return duration;
    }

    void setDurationMillis(long duration) {
        this.duration = duration;
    }

    float getDistanceX() {
        return distanceX;
    }

    void setDistanceX(float distanceX) {
        this.distanceX = distanceX;
    }

    float getDistanceY() {
        return distanceY;
    }

    void setDistanceY(float distanceY) {
        this.distanceY = distanceY;
    }

    long getStartTime() {
        return startTime;
    }

    void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    long getLastTime() {
        return lastTime;
    }

    void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    float getStartCenterX() {
        return startCenterX;
    }

    void setStartCenterX(float startCenterX) {
        this.startCenterX = startCenterX;
    }

    float getStartCenterY() {
        return startCenterY;
    }

    void setStartCenterY(float startCenterY) {
        this.startCenterY = startCenterY;
    }

    boolean isDirectionX() {
        return directionX;
    }

    void setDirectionX(boolean directionX) {
        this.directionX = directionX;
    }

    boolean isDirectionY() {
        return directionY;
    }

    void setDirectionY(boolean directionY) {
        this.directionY = directionY;
    }

    boolean isStarted() {
        return isStarted;
    }

    void setStarted(boolean started) {
        isStarted = started;
    }

    boolean isInfinite() {
        return isInfinite;
    }

    void setInfinite(boolean infinite) {
        isInfinite = infinite;
    }

    boolean isWantStop() {
        return wantStop;
    }

    void setWantStop(boolean wantStop) {
        this.wantStop = wantStop;
    }

    boolean isRedrawable() {
        return isRedrawable;
    }

    void setRedrawable(boolean redrawable) {
        isRedrawable = redrawable;
    }
}

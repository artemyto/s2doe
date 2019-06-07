package misha.graphsecondattempt;

/**
 * Created by master22 on 4/24/2018.
 Package: ${PACKAGE_NAME}, project: TriforcePower.
 */

class AnimationContainer {

//    private boolean directionY;
    private long duration;
    private float distanceX = 0;
    private float distanceY = 0;
    private long startTime = 0;
    private long lastTime = 0;
    private float startCenterX = 0;
    private float startCenterY = 0;
    private boolean directionX = true;
    private boolean directionY = true;
    private boolean isStarted = false;
    private boolean isInfinite = false;
    private boolean wantStop = false;
    private boolean isRedrawable = false;
    AnimationContainer() {
        distanceX = 0;
        distanceY = 0;
        directionX = true;
        directionY = true;
        isStarted = false;
        isInfinite = false;
        wantStop = false;
    }
    static AnimationContainer copy (AnimationContainer oldA) {
        AnimationContainer newA = new AnimationContainer();
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
        return newA;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public float getDistanceX() {
        return distanceX;
    }

    public void setDistanceX(float distanceX) {
        this.distanceX = distanceX;
    }

    public float getDistanceY() {
        return distanceY;
    }

    public void setDistanceY(float distanceY) {
        this.distanceY = distanceY;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getLastTime() {
        return lastTime;
    }

    public void setLastTime(long lastTime) {
        this.lastTime = lastTime;
    }

    public float getStartCenterX() {
        return startCenterX;
    }

    public void setStartCenterX(float startCenterX) {
        this.startCenterX = startCenterX;
    }

    public float getStartCenterY() {
        return startCenterY;
    }

    public void setStartCenterY(float startCenterY) {
        this.startCenterY = startCenterY;
    }

    public boolean isDirectionX() {
        return directionX;
    }

    public void setDirectionX(boolean directionX) {
        this.directionX = directionX;
    }

    public boolean isDirectionY() {
        return directionY;
    }

    public void setDirectionY(boolean directionY) {
        this.directionY = directionY;
    }

    public boolean isStarted() {
        return isStarted;
    }

    public void setStarted(boolean started) {
        isStarted = started;
    }

    public boolean isInfinite() {
        return isInfinite;
    }

    public void setInfinite(boolean infinite) {
        isInfinite = infinite;
    }

    public boolean isWantStop() {
        return wantStop;
    }

    public void setWantStop(boolean wantStop) {
        this.wantStop = wantStop;
    }

    public boolean isRedrawable() {
        return isRedrawable;
    }

    public void setRedrawable(boolean redrawable) {
        isRedrawable = redrawable;
    }
    //TODO добавить зацикленность isCycled - когда повторяется не одно действие, а весь список
}

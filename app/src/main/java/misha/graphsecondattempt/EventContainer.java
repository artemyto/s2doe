package misha.graphsecondattempt;

/**
 * Created by master22 on 4/24/2018.
 Package: ${PACKAGE_NAME}, project: TriforcePower.
 */
class EventContainer {
    private char kindOfEvent=' ';

//        a=появление нового объекта
//        b=уничтожение объекта с name
//        c=добавление объекту анимации
//        g=замена анимации объекта
//        e=остановка анимации объекта
//        f=возобновление анимации объекта
//        d=изменение анимации объекта (например, сдвиг траектории по пальцу)
    //h=rebind data
private String nameOfObject;//not use '==' !
    private boolean needToRebindData = false;
    private AnimationContainer[] a;
    private ObjectContainer o;
    private int needToGenerateObject = 0;
    private boolean cycled;
    private boolean randomizedTime;
    private int randomTop;
    private int randomBottom;
    private long waitTime = -1;
    private boolean pass = false;
    private boolean timed = false;
    private long prevTime = -1;
    private float newAnimX;
    private float newAnimY;

    private String name;

    char getKindOfEvent() {
        return kindOfEvent;
    }

    void setKindOfEvent(char kindOfEvent) {
        this.kindOfEvent = kindOfEvent;
    }

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    String getNameOfObject() {
        return nameOfObject;
    }

    void setNameOfObject(String nameOfObject) {
        this.nameOfObject = nameOfObject;
    }

    boolean isNeedToRebindData() {
        return needToRebindData;
    }

    void setNeedToRebindData() {
        this.needToRebindData = true;
    }

    int getNeedToGenerateObject() {
        return needToGenerateObject;
    }

    void setNeedToGenerateObject(int needToGenerateObject) {
        this.needToGenerateObject = needToGenerateObject;
    }

    boolean isCycled() {
        return cycled;
    }

    void setCycled(boolean cycled) {
        this.cycled = cycled;
    }

    float getNewAnimX() {
        return newAnimX;
    }

    void setNewAnimX(float newAnimX) {
        this.newAnimX = newAnimX;
    }

    float getNewAnimY() {
        return newAnimY;
    }

    void setNewAnimY(float newAnimY) {
        this.newAnimY = newAnimY;
    }

    boolean isRandomizedTime() {
        return randomizedTime;
    }

    void setRandomizedTime(boolean randomizedTime) {
        this.randomizedTime = randomizedTime;
    }

    int getRandomBottom() {
        return randomBottom;
    }

    void setRandomBottom(int randomBottom) {
        this.randomBottom = randomBottom;
    }

    int getRandomTop() {
        return randomTop;
    }

    void setRandomTop(int randomTop) {
        this.randomTop = randomTop;
    }

    long getWaitTime() {
        return waitTime;
    }

    void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    boolean isPass() {
        return pass;
    }

    void setPass(boolean pass) {
        this.pass = pass;
    }

    boolean isTimed() {
        return timed;
    }

    void setTimed(boolean timed) {
        this.timed = timed;
    }

    long getPrevTime() {
        return prevTime;
    }

    void setPrevTime(long prevTime) {
        this.prevTime = prevTime;
    }

    void setA(AnimationContainer[] a) {
        this.a = a;
    }

    AnimationContainer[] getA() {
        return a;
    }

    void setObject(ObjectContainer o) {
        this.o = o;
    }

    ObjectContainer getO() {
        return o;
    }

    EventContainer getCopy() {
        EventContainer e = new EventContainer();
        e.kindOfEvent = kindOfEvent;
        e.nameOfObject = nameOfObject;
        e.needToRebindData = false;
//        e.a = a.get;
        if (a != null) {
            e.a = new AnimationContainer[a.length];
            for (int i = 0; i < a.length; ++i) {
                e.a[i] = a[i].getCopy();
            }
        }
        else e.a = null;
        e.o = o.getCopy();
        e.needToGenerateObject = needToGenerateObject;
        e.cycled = cycled;
        e.randomizedTime = randomizedTime;
        e.randomTop = randomTop;
        e.randomBottom = randomBottom;
        e.waitTime = waitTime;
        e.pass = pass;
        e.timed = timed;
        e.prevTime = prevTime;
        e.newAnimX = newAnimX;
        e.newAnimY = newAnimY;
        e.name = name;
        return e;
    }
}

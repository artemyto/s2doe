package misha.graphsecondattempt;

/**
 * Created by master22 on 4/24/2018.
 Package: ${PACKAGE_NAME}, project: TriforcePower.
 */
//TODO условия наступления для событий! Доп., переменная level в каждом событии, ее сравниваем с переменной в гейме. Так можно делать уровни!
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

    public char getKindOfEvent() {
        return kindOfEvent;
    }

    public void setKindOfEvent(char kindOfEvent) {
        this.kindOfEvent = kindOfEvent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameOfObject() {
        return nameOfObject;
    }

    public void setNameOfObject(String nameOfObject) {
        this.nameOfObject = nameOfObject;
    }

    public boolean isNeedToRebindData() {
        return needToRebindData;
    }

    public void setNeedToRebindData(boolean needToRebindData) {
        this.needToRebindData = needToRebindData;
    }

    public int getNeedToGenerateObject() {
        return needToGenerateObject;
    }

    public void setNeedToGenerateObject(int needToGenerateObject) {
        this.needToGenerateObject = needToGenerateObject;
    }

    public boolean isCycled() {
        return cycled;
    }

    public void setCycled(boolean cycled) {
        this.cycled = cycled;
    }

    public float getNewAnimX() {
        return newAnimX;
    }

    public void setNewAnimX(float newAnimX) {
        this.newAnimX = newAnimX;
    }

    public float getNewAnimY() {
        return newAnimY;
    }

    public void setNewAnimY(float newAnimY) {
        this.newAnimY = newAnimY;
    }

    public boolean isRandomizedTime() {
        return randomizedTime;
    }

    public void setRandomizedTime(boolean randomizedTime) {
        this.randomizedTime = randomizedTime;
    }

    public int getRandomBottom() {
        return randomBottom;
    }

    public void setRandomBottom(int randomBottom) {
        this.randomBottom = randomBottom;
    }

    public int getRandomTop() {
        return randomTop;
    }

    public void setRandomTop(int randomTop) {
        this.randomTop = randomTop;
    }

    public long getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(long waitTime) {
        this.waitTime = waitTime;
    }

    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public boolean isTimed() {
        return timed;
    }

    public void setTimed(boolean timed) {
        this.timed = timed;
    }

    public long getPrevTime() {
        return prevTime;
    }

    public void setPrevTime(long prevTime) {
        this.prevTime = prevTime;
    }

    public void setA(AnimationContainer[] a) {
        this.a = a;
    }

    public AnimationContainer[] getA() {
        return a;
    }

    public void setO(ObjectContainer o) {
        this.o = o;
    }

    public ObjectContainer getO() {
        return o;
    }

    EventContainer getCopy() {
        EventContainer e = new EventContainer();
        e.kindOfEvent = kindOfEvent;
        e.nameOfObject = nameOfObject;
        e.needToRebindData = false;
//        e.a = a.get;
        e.a = new AnimationContainer[a.length];
        for (int i = 0; i < a.length; ++i) {
            e.a[i] = a[i].getCopy();
        }
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

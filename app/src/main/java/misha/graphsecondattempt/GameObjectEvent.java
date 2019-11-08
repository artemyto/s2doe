package misha.graphsecondattempt;

class GameObjectEvent {
    static final int EVENT_TYPE_ADD_ANIMATION = 3;
    static final int EVENT_TYPE_ADD_OBJECT = 1;
    static final int EVENT_TYPE_CHANGE_ANIMATION = 7;
    static final int EVENT_TYPE_DESTROY_OBJECT = 2;
    static final int EVENT_TYPE_REBIND_DATA = 8;
    static final int EVENT_TYPE_REPLACE_ANIMATION = 4;
    static final int EVENT_TYPE_RESUME_ANIMATION = 6;
    static final int EVENT_TYPE_STOP_ANIMATION = 5;
    static final int GENERATE_BULLET = 1;

    private GameObjectAnimation[] a;
    private boolean cycled;
    private long delay = -1;
    private int eventType = 0;
    private String name;
    private String nameOfObject;
    private int needToGenerateObject = 0;
    private boolean needToRebindData = false;
    private GameObject o;
    private boolean pass = false;
    private long prevTime = -1;
    private boolean randomizedTime;
    private int randomBottom;
    private int randomTop;
    private boolean timed = false;
    private float newAnimX;
    private float newAnimY;

    GameObjectEvent() {

    }

    private GameObjectEvent(Builder builder) {
        a = builder.a;
        cycled = builder.cycled;
        delay = builder.delay;
        eventType = builder.eventType;
        name = builder.name;
        nameOfObject = builder.nameOfObject;
        needToGenerateObject = builder.needToGenerateObject;
        needToRebindData = builder.needToRebindData;
        o = builder.o;
        pass = builder.pass;
        prevTime = builder.prevTime;
        randomizedTime = builder.randomizedTime;
        randomBottom = builder.randomBottom;
        randomTop = builder.randomTop;
        timed = builder.timed;
    }

    static class Builder {
        private GameObjectAnimation[] a;
        private boolean cycled = false;
        private long delay = -1;
        private int eventType = 0;
        private char kindOfEvent = ' ';
        private String name = " ";
        private String nameOfObject;
        private int needToGenerateObject = 0;
        private boolean needToRebindData = false;
        private GameObject o;
        private boolean pass = false;
        private long prevTime = -1;
        private boolean randomizedTime = false;
        private int randomBottom;
        private int randomTop;
        private boolean timed = false;

        Builder addObject(GameObject object) {
            o = object;
            nameOfObject = object.getName();
            needToRebindData = true;
            kindOfEvent = 'a';
            eventType = EVENT_TYPE_ADD_OBJECT;
            return this;
        }

        GameObjectEvent build() {
            return new GameObjectEvent(this);
        }

        Builder cycled() {
            cycled = true;
            return this;
        }

        Builder delay(int delay) {
            this.delay = delay;
            return this;
        }

        Builder generateObject(int generatedObjectType) {
            needToGenerateObject = generatedObjectType;
            eventType = EVENT_TYPE_ADD_OBJECT;
            return this;
        }

        Builder kindOfEvent(char kind) {
            kindOfEvent = kind;
            return this;
        }

        Builder name(String name) {
            this.name = name;
            return this;
        }

        Builder randomizedTime (int bottom, int top) {
            randomizedTime = true;
            randomBottom = bottom;
            randomTop = top;
            return this;
        }
        Builder rebindData() {
            this.needToRebindData = true;
            return this;
        }

    }

    int getEventType() {
        return eventType;
    }

    void setEventType(int type) {
        eventType = type;
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

    long getDelay() {
        return delay;
    }

    void setDelay(long delay) {
        this.delay = delay;
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

    void setA(GameObjectAnimation[] a) {
        this.a = a;
    }

    GameObjectAnimation[] getA() {
        return a;
    }

    void setObject(GameObject o) {
        this.o = o;
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

    GameObject getO() {
        return o;
    }

    GameObjectEvent getCopy() {
        GameObjectEvent e = new GameObjectEvent();
        e.eventType = eventType;
        e.nameOfObject = nameOfObject;
        e.needToRebindData = needToRebindData;
        if (a != null) {
            e.a = new GameObjectAnimation[a.length];
            for (int i = 0; i < a.length; ++i) {
                e.a[i] = a[i].getCopy();
            }
        } else e.a = null;
        e.o = o.getCopy();
        e.needToGenerateObject = needToGenerateObject;
        e.cycled = cycled;
        e.randomizedTime = randomizedTime;
        e.randomTop = randomTop;
        e.randomBottom = randomBottom;
        e.delay = delay;
        e.pass = pass;
        e.timed = timed;
        e.prevTime = prevTime;
        e.name = name;
        return e;
    }
}

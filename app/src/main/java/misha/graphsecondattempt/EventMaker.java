package misha.graphsecondattempt;

import android.os.SystemClock;

import java.util.ArrayList;

class EventMaker implements Runnable {
    private final Thread thread;

    EventMaker() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        boolean continueCycle = true;
        ArrayList<GameObjectEvent> events;
        while (continueCycle) {
            events = GameEvents.getEvents();
            long curTime = SystemClock.uptimeMillis();
            for (int i = 0; i < events.size(); ++i) {
                GameObjectEvent e = events.get(i);
                if (!e.isPass()) {

                    if (e.getPrevTime() < 0) {
                        e.setPrevTime(curTime);
                    }

                    if (e.isRandomizedTime() && e.getDelay() < 0) {
                        double rand = Math.random();
                        e.setDelay((int) (rand * (e.getRandomTop() - e.getRandomBottom())) + e.getRandomBottom());
                    }
                    if (e.getDelay() <= curTime - e.getPrevTime()) {
                        switch (e.getEventType()) {
                            case GameObjectEvent.EVENT_TYPE_ADD_OBJECT:
                                //new object
                                //e.o -> SomeUtils.obj

                                GameObject newO;
                                if (e.getNeedToGenerateObject() == GameObjectEvent.GENERATE_BULLET)
                                    newO = ObjectTemplates.generateBullet();
                                else
                                    newO = GameObject.copy(e.getO());
//                                    SomeUtils.obj.add(newO);
                                GameObjects.addObject(newO);
                                GameObjects.setObjectsChanged();

                                break;
                            case GameObjectEvent.EVENT_TYPE_DESTROY_OBJECT:
                                GameObjects.removeObject(e.getName());
                                break;
                            case GameObjectEvent.EVENT_TYPE_ADD_ANIMATION:
                                //add animation


                                break;
                            case GameObjectEvent.EVENT_TYPE_CHANGE_ANIMATION:
                                //change animation
                                //ссылка на объект записана в событии
                                //тупо делаем уже описанное! ничего сверхестественного!
                                //e.newAnimX
                                //e.newAnimY
                                //e.o
                                GameObjectAnimation an = e.getO().getAnim().get(0);
                                // float speedX = an.distanceX/an.duration;
//                            float speedY = an.distanceY/an.duration;
//                            float distance = (float)Math.sqrt(an.distanceX*an.distanceX+an.distanceY*an.distanceY);
                                float canonDist1 = (float) Math.sqrt(an.getDistanceX() * an.getDistanceX() + an.getDistanceY() / ScreenUtils.getAspectRatio() * an.getDistanceY() / ScreenUtils.getAspectRatio());
//                            float speed = distance/an.duration;
//                                an.setDistanceX(e.getNewAnimX() - e.getO().getCenterX());
                                if (an.getDistanceX() < 0) {
                                    an.setDistanceX(-an.getDistanceX());
                                    an.setDirectionX(false);
                                } else an.setDirectionX(true);
//                                an.setDistanceY(e.getNewAnimY() - e.getO().getCenterY());
                                if (an.getDistanceY() < 0) {
                                    an.setDistanceY(-an.getDistanceY());
                                    an.setDirectionY(false);
                                } else an.setDirectionY(true);
//                            distance = (float)Math.sqrt(an.distanceX*an.distanceX+an.distanceY*an.distanceY);
                                float canonDist2 = (float) Math.sqrt(an.getDistanceX() * an.getDistanceX() + an.getDistanceY() / ScreenUtils.getAspectRatio() * an.getDistanceY() / ScreenUtils.getAspectRatio());
//                            an.duration = Math.round(distance/speed);
                                an.setDurationMillis(Math.round(canonDist2 / canonDist1 * an.getDurationMillis()));
                                //an.duration = Math.round(an.distanceX/speedX);
                                an.setStarted(false);
                                float differenceX = e.getO().getCenterX() - an.getStartCenterX();
                                float differenceY = e.getO().getCenterY() - an.getStartCenterY();
                                for (int j = 0; j < e.getO().getVertices().length; j += 3) {
                                    e.getO().getVertices()[j] += differenceX;
                                    e.getO().getVertices()[j + 1] += differenceY;
                                }

                                break;
                        }
                        if (e.isNeedToRebindData()) {
//                        this.needToBindData = true;
//                            SomeUtils.setNeedToRebindData();
                            //prepareData();
                            //bindData();
                            GameObjects.setObjectsChanged();
                        }
                        if (!e.isCycled()) {
                            e.setPass(true);
                            //SomeUtils.events.remove(i);
                            GameEvents.removeEvent(e.getName());
                            events.remove(i);
                               --i;
                        }
                        e.setPrevTime(curTime);
                        if (e.isRandomizedTime()) {
                            //double rand = Math.random();
                            e.setDelay(-1);
                        }
                    }

                }
                //sleepTime = Math.max(sleepTime, e.waitTime);

            }
//            GameEvents.setEvents(events);
            if (events.isEmpty()) continueCycle = false;
        }


    }

    synchronized boolean isRunning() {
        return thread.isAlive();
    }

}

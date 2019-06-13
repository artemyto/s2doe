package misha.graphsecondattempt;

import android.os.SystemClock;

import java.util.ArrayList;
import java.util.Objects;

public class EventMaker implements Runnable {
    private Thread thread;

    EventMaker() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        boolean continueCycle = true;
        ArrayList<EventContainer> events;
        while (continueCycle) {
            events = GameEvents.getEvents();
            //совершение событий, которые должны были произойти к этому моменту, но еще не произошли
            long curTime = SystemClock.uptimeMillis();
            for (int i = 0; i < events.size(); ++i) {
                EventContainer e = events.get(i);
                if (!e.isPass()) {

                    if (e.getPrevTime() < 0) {
                        e.setPrevTime(curTime);
                    }

                    if (e.isRandomizedTime() && e.getWaitTime() < 0) {
                        double rand = Math.random();
                        e.setWaitTime((int) (rand * (e.getRandomTop() - e.getRandomBottom())) + e.getRandomBottom());
                    }
                    if (e.getWaitTime() <= curTime - e.getPrevTime()) {
                        switch (e.getKindOfEvent()) {
                            case 'a':
                                //new object
                                //e.o -> SomeUtils.obj

                                    ObjectContainer newO;
                                    if (e.getNeedToGenerateObject() == 1)
                                        newO = ObjectTemplates.generateBullet();
                                    else
                                        newO = ObjectContainer.copy(e.getO());
//                                    SomeUtils.obj.add(newO);
                                    GameObjects.addObject(newO);


                                break;
                            case 'b':
                                GameObjects.deleteObject(e.getName());
//                                if (!GameObjects.isWantDeleteContains(e.getName()))
//
//                                    GameObjects.wantDelete.add(e.getName());
                                break;
                            case 'c':
                                //add animation


                                break;
                            case 'd':
                                //change animation
                                //ссылка на объект записана в событии
                                //тупо делаем уже описанное! ничего сверхестественного!
                                //e.newAnimX
                                //e.newAnimY
                                //e.o
                                AnimationContainer an = e.getO().getAnim().get(0);
                                // float speedX = an.distanceX/an.duration;
//                            float speedY = an.distanceY/an.duration;
//                            float distance = (float)Math.sqrt(an.distanceX*an.distanceX+an.distanceY*an.distanceY);
                                float canonDist1 = (float) Math.sqrt(an.getDistanceX() * an.getDistanceX() + an.getDistanceY() / ScreenParameters.aspectRatio * an.getDistanceY() / ScreenParameters.aspectRatio);
//                            float speed = distance/an.duration;
                                an.setDistanceX(e.getNewAnimX() - e.getO().getCenterX());
                                if (an.getDistanceX() < 0) {
                                    an.setDistanceX(-an.getDistanceX());
                                    an.setDirectionX(false);
                                } else an.setDirectionX(true);
                                an.setDistanceY(e.getNewAnimY() - e.getO().getCenterY());
                                if (an.getDistanceY() < 0) {
                                    an.setDistanceY(-an.getDistanceY());
                                    an.setDirectionY(false);
                                } else an.setDirectionY(true);
//                            distance = (float)Math.sqrt(an.distanceX*an.distanceX+an.distanceY*an.distanceY);
                                float canonDist2 = (float) Math.sqrt(an.getDistanceX() * an.getDistanceX() + an.getDistanceY() / ScreenParameters.aspectRatio * an.getDistanceY() / ScreenParameters.aspectRatio);
//                            an.duration = Math.round(distance/speed);
                                an.setDuration(Math.round(canonDist2 / canonDist1 * an.getDuration()));
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
                            //   --i;
                        }
                        e.setPrevTime(curTime);
                        if (e.isRandomizedTime()) {
                            //double rand = Math.random();
                            e.setWaitTime(-1);
                        }
                    }

                }
                //sleepTime = Math.max(sleepTime, e.waitTime);

            }
            GameEvents.setEvents(events);
            if (events.isEmpty()) continueCycle = false;
        }


    }

    public synchronized boolean isRunning() {
        return thread.isAlive();
    }

}

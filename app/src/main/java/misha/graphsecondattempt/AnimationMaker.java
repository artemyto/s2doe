package misha.graphsecondattempt;

public class AnimationMaker implements Runnable  {
    Thread thread;

    AnimationMaker() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

    }

    public synchronized boolean isRunning() {
        return thread.isAlive();
    }

}

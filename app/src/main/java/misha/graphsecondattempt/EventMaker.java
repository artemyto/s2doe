package misha.graphsecondattempt;

public class EventMaker implements Runnable {
    Thread thread;

    EventMaker() {
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

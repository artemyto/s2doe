package misha.graphsecondattempt;

public class First_Thread implements Runnable {

    Thread thread;

    First_Thread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {

    }
}

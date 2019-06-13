package misha.graphsecondattempt;

import java.util.ArrayList;

public class GameEvents {
    static ArrayList<EventContainer> events = new ArrayList<>();

    public  static synchronized void setEvents(ArrayList<EventContainer> e) {
        events = e;
    }

    public  static synchronized ArrayList<EventContainer> getEvents() {
        ArrayList<EventContainer> arrayList = new ArrayList<>();
        for (EventContainer e:events) {
            arrayList.add(e.getCopy());
        }
        return arrayList;
    }

    static synchronized void eraseEvents() {
        events = new ArrayList<>();
    }

    public  static synchronized void addEvent(EventContainer e) {
        events.add(e);
    }

}

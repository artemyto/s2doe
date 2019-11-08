package misha.graphsecondattempt;

import java.util.ArrayList;
import java.util.List;

class GameEvents {
    private static ArrayList<GameObjectEvent> events = new ArrayList<>();

    static synchronized void setEvents(ArrayList<GameObjectEvent> e) {
        events = e;
    }

    static synchronized ArrayList<GameObjectEvent> getEvents() {
        ArrayList<GameObjectEvent> arrayList = new ArrayList<>();
        for (GameObjectEvent e:events) {
            arrayList.add(e.getCopy());
        }
        return arrayList;
    }

    static synchronized void eraseEvents() {
        events = new ArrayList<>();
    }

    static synchronized void addEvent(GameObjectEvent e) {
        events.add(e);
    }

    static synchronized void removeEvent(String s) {
        for (int i = 0; i < events.size(); ++i) {
            if (events.get(i).getName().equals(s)) {
                events.remove(i);
                break;
            }
        }
    }

    static List<GameObjectEvent> getEventsReference() {
        return events;
    }

}

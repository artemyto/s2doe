package misha.graphsecondattempt;

import java.util.ArrayList;

public class GameEvents {
    static ArrayList<GameObjectEvent> events = new ArrayList<>();

    public  static synchronized void setEvents(ArrayList<GameObjectEvent> e) {
        events = e;
    }

    public  static synchronized ArrayList<GameObjectEvent> getEvents() {
        ArrayList<GameObjectEvent> arrayList = new ArrayList<>();
        for (GameObjectEvent e:events) {
            arrayList.add(e.getCopy());
        }
        return arrayList;
    }

    static synchronized void eraseEvents() {
        events = new ArrayList<>();
    }

    public  static synchronized void addEvent(GameObjectEvent e) {
        events.add(e);
    }

    public static synchronized void removeEvent(String s) {
        for (int i = 0; i < events.size(); ++i) {
            if (events.get(i).getName().equals(s)) {
                events.remove(i);
                break;
            }
        }
    }
}

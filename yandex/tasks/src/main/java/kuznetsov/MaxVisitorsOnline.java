package kuznetsov;

import java.util.Arrays;
import java.util.Comparator;

// Сайт посетило N человек, для каждого известно время входа на сайт In,
// и время выхода с сайта Out.
// Считается, что человек был на сайте с момента In по Out включительно.
//
// Определите, какое максимальное количество человек было на сайте одновременно.
public class MaxVisitorsOnline {

    public int maxVisitorsOnline(int len, int[] tin, int[] tout) {
        Event[] events = new Event[2 * len];
        for (int i = 0; i < len; i++) {
            events[i] = new Event(tin[i], 1);
        }
        for (int i = len; i < 2 * len; i++) {
            events[i] = new Event(tout[i - len], -1);
        }
        Arrays.sort(events, Event::compareTo);

        int currOnline = 0;
        int maxOnline = 0;
        for (Event e : events) {
            if (e.getType() == 1) {
                currOnline += 1;
            } else if (e.getType() == -1) {
                currOnline -= 1;
            }
            maxOnline = Math.max(currOnline, maxOnline);
        }

        return maxOnline;
    }
}

class Event implements Comparable<Event> {
    private final int time;
    private final int type;

    Event(int time, int type) {
        this.time = time;
        this.type = type;
    }

    int getTime() {
        return time;
    }

    int getType() {
        return type;
    }

    @Override
    public int compareTo(Event o) {
        return Comparator.comparing(Event::getTime)
                .thenComparing(Event::getType)
                .compare(this, o);
    }
}
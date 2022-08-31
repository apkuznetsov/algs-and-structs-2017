package kuznetsov;

import java.util.Arrays;

// Сайт посетило N человек, для каждого известно время входа на сайт In,
// и время выхода с сайта Out.
// Считается, что человек был на сайте с момента In по Out включительно.
//
// Определите, какое суммарное время на сайте был хотя бы один человек.
public class TimeWithVisitors {
    public int timeWithVisitors(int len, int[] tin, int[] tout) {
        Event[] events = new Event[2 * len];
        for (int i = 0; i < len; i++) {
            events[i] = new Event(tin[i], 1);
        }
        for (int i = len; i < 2 * len; i++) {
            events[i] = new Event(tout[i - len], -1);
        }
        Arrays.sort(events, Event::compareTo);

        int currOnline = 0;
        int notEmptyTime = 0;
        for (int i = 0; i < events.length; i++) {
            if (currOnline > 0) {
                notEmptyTime += events[i].getTime() - events[i - 1].getTime();
            } else if (events[i].getType() == -1) {
                currOnline -= 1;
            } else {
                currOnline += 1;
            }
            notEmptyTime = Math.max(currOnline, notEmptyTime);
        }

        return notEmptyTime;
    }
}

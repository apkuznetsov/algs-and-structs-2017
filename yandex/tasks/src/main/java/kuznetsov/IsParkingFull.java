package kuznetsov;

import java.util.Arrays;
import java.util.Comparator;

// На парковке в торговом центре N мест (занумерованных от 1 до N).
// За день в ТЦ приезжало M автомобилей, при этом некоторые из них длинные
// и занимали несколько подряд идущих парковочных мест.
//
// Для каждого автомобиля известно время приезда и отъезда,
// а также два числа – с какого по какое парковочные места он занимал.
//
// Если в какой-то момент времени один автомобиль уехал с парковочного места,
// то место считается освободившимся и в тот же момент времени на его место может встать другой.
//
// Необходимо определить, был ли момент, в который были заняты все парковочные места.
public class IsParkingFull {

    public boolean isParkingFull(int parkingSize, CarEvent[] c) {
        ParkingEvent[] events = new ParkingEvent[c.length];
        for (int n = 0, m = 0; n < c.length; n++) {
            int carSize = c[n].getPlaceTo() - c[n].getPlaceFrom() + 1;
            events[m] = new ParkingEvent(c[n].getTimeIn(), 1, carSize);
            m++;
            events[m] = new ParkingEvent(c[n].getTimeOut(), -1, carSize);
            m++;
        }
        Arrays.sort(events, ParkingEvent::compareTo);

        int currOccupied = 0;
        for (ParkingEvent e : events) {
            if (e.getType() == -1) {
                currOccupied -= e.getSize();
            } else if (e.getType() == 1) {
                currOccupied += e.getSize();
            }

            if (currOccupied == parkingSize) {
                return true;
            }
        }

        return false;
    }
}

class CarEvent {

    private final int timeIn;
    private final int timeOut;
    private final int placeFrom;
    private final int placeTo;

    CarEvent(int timeIn, int timeOut, int placeFrom, int placeTo) {
        this.timeIn = timeIn;
        this.timeOut = timeOut;
        this.placeFrom = placeFrom;
        this.placeTo = placeTo;
    }

    int getTimeIn() {
        return timeIn;
    }

    int getTimeOut() {
        return timeOut;
    }

    int getPlaceFrom() {
        return placeFrom;
    }

    int getPlaceTo() {
        return placeTo;
    }
}

class ParkingEvent implements Comparable<ParkingEvent> {

    private final int time;
    private final int type;
    private final int size;

    ParkingEvent(int time, int type, int size) {
        this.time = time;
        this.type = type;
        this.size = size;
    }

    int getTime() {
        return time;
    }

    int getType() {
        return type;
    }

    int getSize() {
        return size;
    }

    @Override
    public int compareTo(ParkingEvent o) {
        return Comparator.comparing(ParkingEvent::getTime)
                .thenComparing(ParkingEvent::getType)
                .compare(this, o);
    }
}

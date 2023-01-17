package kuznetsov;

import java.util.ArrayList;
import java.util.Arrays;

// Сайт посетило N человек, для каждого известно время входа на сайт In,
// и время выхода с сайта Out.
// Считается, что человек был на сайте с момента In по Out включительно.
//
// Начальник заходил на сайт M раз в моменты времени Boss,
// и смотрел, сколько людей сейчас онлайн.
// Посещения сайта начальником упорядочены во возрастанию времени.
//
// Определите, какие показания счётчика людей онлайн увидел начальник.
public class BossCounters {
    
  public ArrayList<Integer> bossCounters(
      int ecnt, int[] etin, int[] etout, int bcnt, int[] btin) {
      
    Event[] events = new Event[2 * ecnt + bcnt];
    for (int i = 0; i < ecnt; i++) {
      events[i] = new Event(etin[i], 1);
    }
    for (int i = ecnt; i < 2 * ecnt; i++) {
      events[i] = new Event(etout[i - ecnt], -1);
    }
    for (int i = 2 * ecnt; i < 2 * ecnt + bcnt; i++) {
      events[i] = new Event(btin[i - 2 * ecnt], 0);
    }
    Arrays.sort(events, Event::compareTo);

    int currOnline = 0;
    ArrayList<Integer> bossAns = new ArrayList<>(bcnt);
    for (Event event : events) {
      if (event.getType() == 1) {
        currOnline += 1;
      } else if (event.getType() == -1) {
        currOnline -= 1;
      } else {
        bossAns.add(currOnline);
      }
    }

    return bossAns;
  }

}

package kuznetsov;

import java.util.LinkedHashMap;
import java.util.Map;

// На шахматной доске N x N находятся M ладей
// (ладья бьёт клетки на той же горизонтали или вертикали до ближайшей занятой).
//
// Ладьи задаются парой чисел I и J, обзначающих координаты клетки
// 1 <= N <= 10^9, 0 <= M <= 2 * 10^5.
//
// Определите, сколько пар ладей бьют друг друга.
class CountBeatingRooks {

  private void addValToMap(Map<Integer, Integer> m, int val) {
    if (m.containsKey(val)) {
      int currCnt = m.get(val);
      m.put(val, currCnt + 1);
    } else {
      m.put(val, 1);
    }
  }

  private int sumMapVals(Map<Integer, Integer> m) {
    int sum = 0;

    for (int v : m.values()) {
      sum += (v - 1);
    }

    return sum;
  }

  public int countBeatingRooks(Coords[] coords) {
    Map<Integer, Integer> cols = new LinkedHashMap<>();
    Map<Integer, Integer> rows = new LinkedHashMap<>();

    for (Coords c : coords) {
      addValToMap(cols, c.x());
      addValToMap(rows, c.y());
    }

    return sumMapVals(cols) + sumMapVals(rows);
  }

}

class Coords {

  int x() {
    return 0;
  }

  int y() {
    return 0;
  }

}

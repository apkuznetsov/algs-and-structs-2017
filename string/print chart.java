package kuznetsov;

import java.util.Map;
import java.util.TreeMap;

// Дана строка S.
// S = Hello, world!
//
// Выведите гистограмму как в примере (коды символов отсортированы)
//       #
//       ##
// ##########
//  !,Hdelorw
public class PrintChart {

  public static void main(String[] args) {
    printChart("Hello, World!".toCharArray());
  }

  public static void printChart(char[] str) {
    Map<Character, Integer> m = new TreeMap<>();
    int maxCnt = 0;

    for (char c : str) {
      if (m.containsKey(c)) {
        int incedCnt = m.get(c) + 1;
        m.put(c, incedCnt);
        if (incedCnt > maxCnt) {
          maxCnt = incedCnt;
        }
      } else {
        m.put(c, 1);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int j = maxCnt; j > 0; j--) {
      for (Map.Entry<Character, Integer> e : m.entrySet()) {
        if (e.getValue() >= j) {
          sb.append("#");
        } else {
          sb.append(" ");
        }
      }
      sb.append("\n");
    }

    for (char k : m.keySet()) {
      sb.append(k);
    }

    System.out.println(sb);
  }

}

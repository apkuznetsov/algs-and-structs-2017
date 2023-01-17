package kuznetsov;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        firstUniqChar("aabb")
    );
  }

  public static int firstUniqChar(String s) {
    Map<Character, Integer> charToIdx = new LinkedHashMap<>(256);
    for (int i = 0; i < s.length(); i++) {
      Character currChar = s.charAt(i);
      Integer oldIdx = charToIdx.get(currChar);
      int newIdx = oldIdx != null ? -1 : i;
      charToIdx.put(currChar, newIdx);
    }

    return charToIdx.values().stream()
        .filter(v -> v > -1).findFirst().orElse(-1);
  }

}

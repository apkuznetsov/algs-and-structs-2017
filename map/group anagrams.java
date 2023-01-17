package kuznetsov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    String[] a = new String[] {"eat", "tea", "tan", "ate", "nat", "bat"};

    System.out.println(
        groupAnagrams(a)
    );
  }

  public static List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();

    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] sChars = s.toCharArray();
      Arrays.sort(sChars);
      String key = new String(sChars);
      List<String> val = map.get(key);
      if (val == null) {
        val = new ArrayList<>();
        val.add(s);
        map.put(key, val);
        result.add(val);
      } else {
        val.add(s);
      }
    }

    return result;
  }

}

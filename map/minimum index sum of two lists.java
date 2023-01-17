package kuznetsov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    String[] list1 = new String[] {"Shogun", "Tapioca Express", "Burger King", "KFC"};
    String[] list2 =
        new String[] {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};

    System.out.println(
        Arrays.toString(findRestaurant(list1, list2))
    );
  }

  public static String[] findRestaurant(String[] list1, String[] list2) {
    String[] longer = list1.length > list2.length ? list1 : list2;
    String[] shorter = list1.length <= list2.length ? list1 : list2;

    Map<String, Integer> map = new HashMap<>(longer.length);
    for (int i = 0; i < shorter.length; i++) {
      map.put(shorter[i], i);
    }

    int minIdxSum = -1;
    List<String> minIdxSumWords = new ArrayList<>();
    for (int i = 0; i < longer.length; i++) {
      String currWord = longer[i];
      Integer j = map.get(currWord);
      if (j != null) {
        int sumIdxes = i + j;
        if (sumIdxes < minIdxSum) {
          minIdxSum = sumIdxes;
          minIdxSumWords.clear();
          minIdxSumWords.add(currWord);
        } else if (sumIdxes == minIdxSum) {
          minIdxSumWords.add(currWord);
        } else if (minIdxSum == -1) {
          minIdxSum = sumIdxes;
          minIdxSumWords.add(currWord);
        }
      }
    }

    return minIdxSumWords.toArray(new String[0]);
  }

}

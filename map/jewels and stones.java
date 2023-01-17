package kuznetsov;

import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        numJewelsInStones("z", "ZZ")
    );
  }

  public static int numJewelsInStones(String jewels, String stones) {
    Set<Integer> set = jewels.chars().boxed()
        .collect(Collectors.toSet());
    return (int) stones.chars()
        .filter(set::contains)
        .count();
  }

}

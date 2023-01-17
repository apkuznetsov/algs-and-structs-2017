package kuznetsov;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {
//    String[] deadends = new String[] {"0201", "0101", "0102", "1212", "2002"};
//    String target = "0202";
    String[] deadends = new String[] {"2111", "2202", "2210", "0201", "2210"};
    String target = "2201";

    System.out.println(
        openLock(deadends, target)
    );
  }

  public static int openLock(String[] deadends, String target) {
    Set<String> deadendsSet = Arrays.stream(deadends).collect(Collectors.toSet());
    Queue<String> codesProcessing = new ArrayDeque<>();
    Set<String> codesVisited = new HashSet<>();
    String root = "0000";
    codesProcessing.add(root);
    codesVisited.add(root);

    int rotatesCounter = 0;

    while (!codesProcessing.isEmpty()) {
      int queueSize = codesProcessing.size();

      for (int i = 0; i < queueSize; ++i) {
        String curr = codesProcessing.poll();
        if (Objects.equals(curr, target)) {
          return rotatesCounter;
        }
        if (deadendsSet.contains(curr)) {
          continue;
        }

        String[] neighbors = new String[8];
        for (int iPos = 0, iNeigh = 0; iPos < 4; iPos++) {
          neighbors[iNeigh] = rotateUpLockCode(curr, iPos);
          iNeigh++;
          neighbors[iNeigh] = rotateDownLockCode(curr, iPos);
          iNeigh++;
        }

        for (String next : neighbors) {
          if (!codesVisited.contains(next)) {
            codesProcessing.add(next);
            codesVisited.add(next);
          }
        }
      }

      rotatesCounter = rotatesCounter + 1;
    }

    return -1;
  }

  private static String rotateUpLockCode(String lockCode, int pos) {
    char[] chars = lockCode.toCharArray();
    char posChar = chars[pos];
    if (posChar == '9') {
      chars[pos] = '0';
    } else {
      chars[pos] = (char) (posChar + 1);
    }

    return String.valueOf(chars);
  }

  private static String rotateDownLockCode(String lockCode, int pos) {
    char[] chars = lockCode.toCharArray();
    char posChar = chars[pos];
    if (posChar == '0') {
      chars[pos] = '9';
    } else {
      chars[pos] = (char) (posChar - 1);
    }

    return String.valueOf(chars);
  }

}

class Node {

  public Node[] neighbors;

}

package kuznetsov;

public class Main {
  public static void main(String[] args) {
    System.out.println(
        strStr("a", "a")
    );
  }

  public static int strStr(String a, String b) {
    int aLen = a.length();
    int bLen = b.length();

    for (int aIdx = 0; aIdx <= aLen - bLen; aIdx++) {
      boolean areEqual = true;
      int tempIdx = aIdx;
      for (int bIdx = 0; bIdx < bLen; bIdx++, tempIdx++) {
        if (b.charAt(bIdx) != a.charAt(tempIdx)) {
          areEqual = false;
          break;
        }
      }
      if (areEqual) {
        return aIdx;
      }
    }

    return -1;
  }

}
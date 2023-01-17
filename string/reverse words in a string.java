package kuznetsov;

public class Main {
  public static void main(String[] args) {
    System.out.print("01 ... ");
    System.out.println(
        reverseString(new char[] {'h', 'e', 'l', 'l', 'o'})
    );
    System.out.print("02 ... ");
    System.out.println(
        reverseString(new char[] {'h', 'e', 'l', 'l', 'o', ' '})
    );
    System.out.print("03 ... ");
    System.out.println(
        reverseString(new char[] {'h', 'e', 'l', 'l', 'o', ' ', ' ', ' '})
    );
    System.out.print("04 ... ");
    System.out.println(
        reverseString(
            new char[] {'h', 'e', 'l', 'l', 'o', ' ', 'm', 'y', ' ', 'w', 'o', 'r', 'l', 'd', ' ',
                ' ', ' '})
    );
    System.out.print("05 ... ");
    System.out.println(
        reverseString(
            new char[] {'t', 'h', 'e', ' ', 's', 'k', 'y', ' ', 'i', 's', ' ', 'b', 'l', 'u', 'e'})
    );
    System.out.print("06 ... ");
    System.out.println(
        reverseString(
            new char[] {' ', ' ', 'h', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', ' ', ' '})
    );
    System.out.print("07 ... ");
    System.out.println(
        reverseString(
            new char[] {'a', ' ', 'g', 'o', 'o', 'd', ' ', ' ', ' ', 'e', 'x', 'a', 'm', 'p', 'l',
                'e'})
    );
  }

  public static char[] reverseString(char[] str) {
    int strLen = str.length;
    int endSpacesCounter = countEndSpaces(str);
    int i = 0;
    int j = strLen - 1 - endSpacesCounter;

    reverseChars(str, i, j);
    removeExtraSpaces(str);
    appendNil(str, endSpacesCounter);
    reverseWords(str);

    return str;
  }

  private static int countEndSpaces(char[] str) {
    int endSpacesCounter = 0;

    int leftIdx = 0;
    int rightIdx = str.length - 1;
    char rightChar;
    rightChar = str[rightIdx];
    while (rightChar == ' ' && leftIdx < rightIdx) {
      --rightIdx;
      ++endSpacesCounter;
      rightChar = str[rightIdx];
    }

    return endSpacesCounter;
  }

  private static void reverseChars(char[] str, int i, int j) {
    while (i < j) {
      char temp = str[i];
      str[i] = str[j];
      str[j] = temp;
      i++;
      j--;
    }
  }

  private static void removeExtraSpaces(char[] str) {
    int write = 0;
    for (int j = 0; j < str.length; j++) {
      if (str[j] == ' ' && (j - 1 >= 0) && (str[j - 1] == ' ')) {
        continue;
      }
      if (str[j] == ' ' && j - 1 == -1) {
        continue;
      }

      str[write] = str[j];
      write++;
    }
    if (write < str.length - 1) {
      while (write != str.length) {
        str[write] = ' ';
        write++;
      }
    }
  }

  private static void appendNil(char[] str, int endSpacesCounter) {
    int end = endSpacesCounter > 0
        ? str.length - endSpacesCounter
        : str.length;
    while (end - 1 >= 0 && str[end - 1] == ' ') {
      --end;
    }
    if (end != str.length) {
      str[end] = '\0';
    }
  }

  private static void reverseWords(char[] str) {
    int left = -1;
    int right = 0;
    for (int i = 0; i < str.length; i++) {
      if (str[i] == '\0') {
        reverseChars(str, left + 1, i - 1);
        break;
      }
      if (i + 1 == str.length) {
        reverseChars(str, left + 1, i);
        break;
      }
      if (str[right] == ' ') {
        reverseChars(str, left + 1, right - 1);
        left = right;
      }
      right++;
    }
  }

}

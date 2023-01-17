package kuznetsov;

public class Main {
  public static void main(String[] args) {
    System.out.println(
        //reverseString(new char[]{'h', 'e', 'l', 'l', 'o'})
    );
  }

  public static void reverseString(char[] str) {
    int i = 0;
    int j = str.length - 1;
    while (i < j) {
      char temp = str[i];
      str[i] = str[j];
      str[j] = temp;
      i++;
      j--;
    }
  }

}
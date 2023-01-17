package kuznetsov;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        isIsomorphic("abcd", "aaaa"));
  }

  public static boolean isIsomorphic(String str_a, String str_b) {
    if (str_a.length() != str_b.length()) {
      return false;
    }

    Map<Character, Character> a_to_b = new HashMap<>(256);
    Map<Character, Character> b_to_a = new HashMap<>(256);

    for (int i = 0; i < str_a.length(); i++) {
      Character char_a = str_a.charAt(i);
      Character char_b = str_b.charAt(i);

      Character val_b = a_to_b.get(char_a);
      if (val_b == null) {
        a_to_b.put(char_a, char_b);
      } else {
        if (val_b != char_b) {
          return false;
        }
      }

      Character val_a = b_to_a.get(char_b);
      if (val_a == null) {
        b_to_a.put(char_b, char_a);
      } else {
        if (val_b != char_b) {
          return false;
        }
      }
    }

    return true;
  }

}

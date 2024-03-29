package kuznetsov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jetbrains.annotations.NotNull;

public class RobinKarpAlg {

  /* 1. In this implementation, we use a method charToLong to associate each symbol with some number.
   * For example, for upper-case letters, it returns the sequence number of a letter in the alphabet,
   * for lower-case letters it returns the sequence number plus 32. */
  public static long charToLong(char ch) {
    return ch - 'A' + 1;
  }

  public static List<Integer> searchOccurrencesByRobinKarpAlg(
      @NotNull String text,
      @NotNull String pattern) {

    /* 2. For the Rabin-Karp algorithm we need to choose constants a and m.
     * In this implementation, the constants are equal 53 and 10^9 + 9 respectively. */
    final int a = 53;
    final long m = 1_000_000_000 + 9;

    /* 3. First, we need to calculate a hash value for the pattern and for the first substring of the text
     * using the formula of the polynomial hash directly.
     * We perform it simultaneously in the for loop.
     *
     * Also, we store the current power of aa in a variable pow.
     * After the last multiplication, it is equal to a^{|p| - 1}
     * and the value will be used in further computations. */
    long patternHash = 0;
    long currSubstrHash = 0;
    long pow = 1;

    for (int i = 0; i < pattern.length(); i++) {
      patternHash += charToLong(pattern.charAt(i)) * pow;
      patternHash %= m;

      currSubstrHash += charToLong(text.charAt(text.length() - pattern.length() + i)) * pow;
      currSubstrHash %= m;

      if (i != pattern.length() - 1) {
        pow = pow * a % m;
      }
    }

    /* 4. Here we create a list to store occurrences of the pattern.
     * Then, we move along the text from the right to the left
     * calculating and comparing the hash values of the pattern and the current substring.
     *
     * If they are equal, we perform a symbol-by-symbol comparison.
     * If the strings are indeed equal, we add the index of the current substring to the list of all occurrences.
     * At the end of the for loop, we update the hash value for the current substring.
     *
     * After the loop is finished, we return the list of all occurrences as a final result. */
    ArrayList<Integer> occurrences = new ArrayList<>();

    for (int i = text.length(); i >= pattern.length(); i--) {
      if (patternHash == currSubstrHash) {
        boolean patternIsFound = true;

        for (int j = 0; j < pattern.length(); j++) {
          if (text.charAt(i - pattern.length() + j) != pattern.charAt(j)) {
            patternIsFound = false;
            break;
          }
        }

        if (patternIsFound) {
          occurrences.add(i - pattern.length());
        }
      }

      if (i > pattern.length()) {
        currSubstrHash = (currSubstrHash - charToLong(text.charAt(i - 1)) * pow % m + m) * a % m;
        currSubstrHash = (currSubstrHash + charToLong(text.charAt(i - pattern.length() - 1))) % m;
      }
    }

    Collections.reverse(occurrences);
    return occurrences;
  }
}

/* Реализуйте метод для выполнения простейшего сжатия строк с использованием счётчика повторяющихся символов.
 * Например, строка ааЬсссссааа превращается в а2b1c5аЗ.
 * Если сжатая строка не становится короче исходной,
 * то метод возвращает исходную строку.
 * Предполагается, что строка состоит только из букв верхнего и нижнего регистра (a-z). */

package kuznetsov;

public class Main {

  public static void main(String[] args) {
  }

  public String compressString(String str) {
    StringBuilder compressed = new StringBuilder(str.length());
    int counter = 0;

    for (int i = 0; i < str.length(); i++) {
      counter++;
      if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
        compressed.append(str.charAt(i));
        compressed.append(counter);
        counter = 0;
      }
    }

    return compressed.length() < str.length()
        ? compressed.toString()
        : str;
  }
}

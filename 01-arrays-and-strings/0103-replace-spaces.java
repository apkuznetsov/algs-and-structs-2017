/* Напишите метод, заменяющий все пробелы в строке символами '%20'.
 * Можете считать, что длина строки позволяет сохранить дополнительные символы,
 * а фактическая длина строки известна заранее.
 * (Примечание: при реализации метода нa Java
 * для выполнения операции на месте используйте символьный массив.) */

package ssau.kuznetsov;

public class Main {

    public static void main(String[] args) {
    }

    public void replaceSpaces(char[] str, int strLen) {
        int spacesCounter = 0;
        for (int i = 0; i < strLen; i++) {
            if (str[i] == ' ') {
                spacesCounter++;
            }
        }

        int newStrLen = strLen + 2 * spacesCounter;
        int currPos = newStrLen - 1;

        for (int i = currPos; i >= 0; i--) {
            if (str[i] == ' ') {
                str[currPos--] = '0';
                str[currPos--] = '2';
                str[currPos--] = '%';
            } else {
                str[currPos--] = str[i];
            }
        }
    }
}

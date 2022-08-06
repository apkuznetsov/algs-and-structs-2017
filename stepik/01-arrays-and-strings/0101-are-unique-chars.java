/* Реализуйте алгоритм, определяющий, все ли символы в строке встречаются только один раз.
 * А если при этом запрещено использование дополнительных структур данных? */

package ssau.kuznetsov;

public class Main {

    public static void main(String[] args) {
    }

    public boolean areUniqueChars(String str) {
        int ASCII_LEN = 255;
        boolean[] checkingArr = new boolean[ASCII_LEN];

        int asciiCode;
        for (int i = 0; i < str.length(); i++) {
            asciiCode = str.charAt(i);
            if (checkingArr[asciiCode]) {
                return false;
            }
            checkingArr[asciiCode] = true;
        }

        return true;
    }
}

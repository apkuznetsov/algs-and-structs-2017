/* Напишите алгоритм, реализующий следующее условие:
 * если элемент матрицы MxN равен О,
 * то весь столбец и вся строка обнуляются. */

package kuznetsov;

public class Main {

  public static void main(String[] args) {
  }

  public void setZeros(int[][] m) {
    boolean[] zeroRows = new boolean[m.length];
    boolean[] zeroCols = new boolean[m[0].length];

    for (int r = 0; r < m.length; r++) {
      if (zeroRows[r]) {
        continue;
      }
      for (int c = 0; c < m[0].length; c++) {
        if (zeroCols[c]) {
          continue;
        }
        setZerosHelper(m, r, c);
        zeroRows[r] = true;
        zeroCols[c] = true;
      }
    }
  }

  private void setZerosHelper(int[][] m, int r, int c) {
    for (int i = 0; i < m.length; i++) {
      m[i][c] = 0;
    }
    for (int i = 0; i < m[0].length; i++) {
      m[r][i] = 0;
    }
  }

}

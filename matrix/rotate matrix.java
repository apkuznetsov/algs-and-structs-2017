/* Имеется изображение, представленное матрицей NxN;
 * каждый пиксел представлен 4 байтами.
 * Напишите метод для поворота изображения на 90 градусов.
 * У дастся ли вам выполнить эту операцию «На месте»? */

package kuznetsov;

public class Main {

  public static void main(String[] args) {
  }

  public void rotate(int[][] matrix, int len) {
    for (int circleNum = 0; circleNum < len / 2; ++circleNum) {
      int last = len - 1 - circleNum;
      for (int curr = circleNum; curr < last; curr++) {
        int offset = curr - circleNum;
        int top = matrix[circleNum][curr];

        matrix[circleNum][curr] = matrix[last - offset][circleNum];
        matrix[last - offset][circleNum] = matrix[last][last - offset];
        matrix[last][last - offset] = matrix[curr][last];
        matrix[curr][last] = top;
      }
    }
  }

}

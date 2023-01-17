package kuznetsov;

import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        Arrays.toString(
            findDiagonalOrder(
                new int[][] {
                    {1, 2, 3, 4, 5},
                    {6, 7, 8, 9, 10},
                    {11, 12, 13, 14, 15},
                    {16, 17, 18, 19, 20},
                }
            )
        )
    );
  }

  public static int[] findDiagonalOrder(int[][] m) {
    if (m == null || m.length == 0) {
      return new int[0];
    }

    int rowsNum = m.length;
    int colsNum = m[0].length;
    int iRow = 0;
    int iCol = 0;
    int direction = 1;

    int[] res = new int[rowsNum * colsNum];
    int iRes = 0;

    while (iRow < rowsNum && iCol < colsNum) {
      res[iRes] = m[iRow][iCol];
      iRes++;

      int newRowIdx = iRow + (direction == 1 ? -1 : 1);
      int newColIdx = iCol + (direction == 1 ? 1 : -1);

      boolean isOutsideMatrix = newRowIdx < 0
          || newRowIdx == rowsNum
          || newColIdx < 0
          || newColIdx == colsNum;
      if (!isOutsideMatrix) {
        iRow = newRowIdx;
        iCol = newColIdx;
        continue;
      }

      if (direction == 1) {
        iRow += (iCol == colsNum - 1 ? 1 : 0);
        iCol += (iCol < colsNum - 1 ? 1 : 0);
      } else {
        iCol += (iRow == rowsNum - 1 ? 1 : 0);
        iRow += (iRow < rowsNum - 1 ? 1 : 0);
      }

      direction = 1 - direction;
    }

    return res;
  }

}

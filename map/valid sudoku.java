package kuznetsov;

import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    char[][] a = new char[][] {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };

    boolean isTrue = isValidSudoku(a);
    System.out.println(isTrue);
  }

  public static boolean isValidSudoku(char[][] board) {
    Map<Integer, Integer> map = new HashMap<>(10);
    final int rowLen = board.length;
    final int colLen = board[0].length;
    final int point = '.';

    // check rows
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        int key = board[row][col];
        if (key != point) {
          if (map.containsKey(key)) {
            return false;
          }
          map.put(key, 1);
        }
      }
      map.clear();
    }

    // check cols
    for (int col = 0; col < colLen; col++) {
      for (int row = 0; row < rowLen; row++) {
        int key = board[row][col];
        if (key != point) {
          if (map.containsKey(key)) {
            return false;
          }
          map.put(key, 1);
        }
      }
      map.clear();
    }

    // check cells
    // cell row
    for (int cellRow = 0; cellRow <= rowLen - 3; cellRow = cellRow + 3) {
      // cell col
      for (int cellCol = 0; cellCol <= colLen - 3; cellCol = cellCol + 3) {
        // cell
        int row = cellRow;
        int col = cellCol;
        int rowBorder = cellRow + 3;
        int colBorder = cellCol + 3;
        do {
          int key = board[row][col];
          if (key != point) {
            if (map.containsKey(key)) {
              return false;
            }
            map.put(key, 1);
          }
          col++;
          if (col >= colBorder) {
            col = cellCol;
            row++;
            if (row >= rowBorder) {
              break;
            }
          }
        } while (true);
        map.clear();
      }
    }

    return true;
  }

}

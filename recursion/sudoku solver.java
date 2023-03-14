package kuznetsov;

class Main {

  public void solveSudoku(char[][] board) {
    if (board == null || board.length == 0) {
      return;
    }
    solve(board);
  }

  private boolean solve(char[][] board) {

    for (int iRow = 0; iRow < board.length; iRow++) {
      for (int iCol = 0; iCol < board[0].length; iCol++) {

        if (board[iRow][iCol] == '.') {
          for (char digit = '1'; digit <= '9'; digit++) {
            if (isValid(board, iRow, iCol, digit)) {
              board[iRow][iCol] = digit;

              if (solve(board)) {
                return true;
              } else {
                board[iRow][iCol] = '.';
              }
            }
          }

          return false;
        }

      }
    }

    return true;
  }

  private boolean isValid(char[][] board, int iRow, int iCol, char digit) {
    for (int i = 0; i < 9; i++) {
      boolean isCorrectRow = board[i][iCol] != '.' && board[i][iCol] == digit;
      if (isCorrectRow) {
        return false;
      }

      boolean isCorrectCol = board[iRow][i] != '.' && board[iRow][i] == digit;
      if (isCorrectCol) {
        return false;
      }

      boolean isCorrectBlock = board[3 * (iRow / 3) + i / 3][3 * (iCol / 3) + i % 3] != '.'
          && board[3 * (iRow / 3) + i / 3][3 * (iCol / 3) + i % 3] == digit;
      if (isCorrectBlock) {
        return false;
      }
    }

    return true;
  }

}

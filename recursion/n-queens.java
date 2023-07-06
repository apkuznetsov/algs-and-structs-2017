package kuznetsov;

class Main {

    private int solutionsCounter = 0;

    public int totalNQueens(int size) {
        boolean[] cols = new boolean[size];

        int diagsNum = 2 * size - 1;
        boolean[] tdDiags = new boolean[diagsNum];
        boolean[] buDiags = new boolean[diagsNum];

        total(0, size, cols, tdDiags, buDiags);

        return solutionsCounter;
    }

    private void total(int iRow, int size, boolean[] cols, boolean[] tdDiags, boolean[] buDiags) {
        if (iRow == size) {
            solutionsCounter++;
            return;
        }

        for (int iCol = 0; iCol < size; iCol++) {
            int iTdd = iRow + iCol;
            int iBud = iRow - iCol + size - 1;

            if (!cols[iCol] && !tdDiags[iTdd] && !buDiags[iBud]) {
                cols[iCol] = true;
                tdDiags[iTdd] = true;
                buDiags[iBud] = true;

                total(iRow + 1, size, cols, tdDiags, buDiags);

                cols[iCol] = false;
                tdDiags[iTdd] = false;
                buDiags[iBud] = false;
            }
        }
    }

}

package kuznetsov;

class Main {

    public static void main(String[] args) {
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int rowMax = matrix.length - 1;
        int colMin = 0;

        int rowIdx = 0;
        int colIdx = matrix[0].length - 1;

        while (rowIdx <= rowMax && colIdx >= colMin) {
            int curr = matrix[rowIdx][colIdx];
            if (target == curr) {
                return true;
            } else if (target > curr) {
                rowIdx++;
            } else {
                colIdx--;
            }
        }

        return false;
    }

}

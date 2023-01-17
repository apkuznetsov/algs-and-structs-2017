public class Main {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    public static int[] sortWithInsertion(int[] arr) {
        int idxSwap;
        int temp;
        for (int idxCurr = 1; idxCurr < arr.length; idxCurr++) {
            idxSwap = idxCurr;
            while (idxSwap > 1 && arr[idxSwap] < arr[idxSwap - 1]) {
                temp = arr[idxSwap];
                arr[idxSwap] = arr[idxSwap - 1];
                arr[idxSwap - 1] = temp;
                idxSwap--;
            }
        }

        return arr;
    }
}

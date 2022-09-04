package kuznetsov;

// Задана отсортированная по неубыванию последовательность из N чисел и число X.
// Необходимо определить сколько раз число X входит в последовательность.
//
// Найдём одним левым двоичпоиском первое число больше либо равное X,
// а вторым левым двоичпоиском – число строго больше X/
// Разность индексов будет количеством вхождений.
public class BinarySearchCountX {

    private static int gtLeftBinsearch(int[] a, int x) {
        int l = 0;
        int r = a.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] > x) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    private static int geLeftBinsearch(int[] a, int x) {
        int l = 0;
        int r = a.length;

        while (l < r) {
            int m = (l + r) / 2;
            if (a[m] >= x) {
                r = m;
            } else {
                l = m + 1;
            }
        }

        return l;
    }

    public static int countX(int[] a, int x) {
        int gtIdx = gtLeftBinsearch(a, x);
        int geIdx = geLeftBinsearch(a, x);
        return gtIdx - geIdx;
    }

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 9};
        int x = 4;
        System.out.println(countX(a, x));
    }
}

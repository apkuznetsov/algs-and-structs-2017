/* 4.2. Напишите алгоритм создания бинарного дерева поиска
 * с минимальной высотой для отсортированного (по возрастанию) массива
 * с уникальными целочисленными элементами.*/

package ssau.kuznetsov;

class Tree {
    public TreeNode root;
}

class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

public class Main {

    public static void main(String[] args) {
    }

    TreeNode createMinimalBst(int[] array) {
        return createMinimalBst(array, 0, array.length - 1);
    }

    TreeNode createMinimalBst(int[] arr, int start, int end) {
        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode n = new TreeNode(arr[mid]);

        n.left = createMinimalBst(arr, start, mid - 1);
        n.right = createMinimalBst(arr, mid + 1, end);

        return n;
    }
}

/* 4.5. Реализуйте функцию для проверки того,
 * является ли двоичное дерево двоичным деревом поиска. */

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

    boolean checkBst(TreeNode n) {
        return checkBst(n, null, null);
    }

    boolean checkBst(TreeNode n, Integer min, Integer max) {
        if (n == null)
            return true;

        if ((min != null && n.data <= min) || (max != null && n.data > max))
            return false;

        return checkBst(n.left, min, n.data) && checkBst(n.right, n.data, max);
    }
}

/* 4.10. T1 и T2 – два очень больших двоичных дерева,
 * причём T1 значительно больше T2.
 * Создайте алгоритм, проверяющий, является ли T2 поддеревом T1.
 *
 * Дерево T2 считается поддеревом T1, если существует такой узел n в T1,
 * что поддерево, "растущее" из n, идентично дерево T2.
 * (Иначе говоря, если вырезать дерево в узле n, оно будет идентично T2.) */

package ssau.kuznetsov;

class Tree {
    public TreeNode root;
}

class TreeNode {
    public int data;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }
}

public class Main {

    public static void main(String[] args) {
    }

    boolean matchTree(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        } else if (r1 == null || r2 == null) {
            return false;
        } else if (r1.data != r2.data) {
            return false;
        } else {
            return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
        }
    }

    boolean subTree(TreeNode r1, TreeNode r2) {
        if (r1 == null) {
            return false;
        } else if (r1.data == r2.data && matchTree(r1, r2)) {
            return true;
        }

        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    boolean containsTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) return true;
        return subTree(t1, t2);
    }
}

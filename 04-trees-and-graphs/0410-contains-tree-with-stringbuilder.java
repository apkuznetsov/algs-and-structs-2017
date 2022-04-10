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

    boolean containsTree(TreeNode t1, TreeNode t2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();

        getOrderString(t1, str1);
        getOrderString(t2, str2);

        return str1.indexOf(str2.toString()) != -1;
    }

    void getOrderString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("X");
            return;
        }

        sb.append(node.data + " ");
        getOrderString(node.left, sb);
        getOrderString(node.right, sb);
    }
}

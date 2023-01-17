/* 4.8. Создайте алгоритм и напишите код поиска первого общего предка
 * двух узлов двоичного дерева.
 * Постарайтесь избежать хранения дополнительных узлов в структуре данных.
 * Примечание: двоичное дерево не обязательно является д.д. поиска. */

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

    TreeNode commonAncestor(TreeNode p, TreeNode q) {
        int delta = depth(p) - depth(q);
        TreeNode first = delta > 0 ? q : p;
        TreeNode second = delta > 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));

        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    TreeNode goUpBy(TreeNode node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }

        return node;
    }

    int depth(TreeNode node) {
        int depth = 0;

        while (node != null) {
            node = node.parent;
            depth++;
        }

        return depth;
    }
}

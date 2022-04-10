/* 4.6. Напишите алгоритм поиска следующего узла для заданного узла в двоичном дереве поиска.
 * Считайте, что у каждого узла есть ссылка на его родителя. */

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

    TreeNode inorderSucc(TreeNode curr) {
        if (curr == null) return null;

        if (curr.right != null) {
            return leftMostChild(curr.right);
        } else {
            TreeNode tempCurr = curr;
            TreeNode parent = tempCurr.parent;

            while (parent != null && parent.left != tempCurr) {
                tempCurr = parent;
                parent = parent.parent;
            }

            return parent;
        }
    }

    TreeNode leftMostChild(TreeNode curr) {
        if (curr == null) {
            return null;
        }

        while (curr.left != null) {
            curr = curr.left;
        }

        return curr;
    }
}

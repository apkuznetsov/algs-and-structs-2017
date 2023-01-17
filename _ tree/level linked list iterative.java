/* 4.3. Для бинарного дерева разработайте алгоритм,
 * который создаёт связный список всех узлов,
 * находящихся на каждой глубине
 * (для дерева с глубиной D должно получиться D связных списков). */

package ssau.kuznetsov;

import java.util.ArrayList;
import java.util.LinkedList;

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

    ArrayList<LinkedList<TreeNode>> createLevelLinkedListIterative(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<>();

        LinkedList<TreeNode> current = new LinkedList<>();

        if (root != null) {
            current.add(root);
        }

        while (current.size() > 0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<>();
            for (TreeNode parent : parents) {
                if (parent.left != null) {
                    current.add(parent.left);
                }
                if (parent.right != null) {
                    current.add(parent.right);
                }
            }
        }

        return result;
    }
}

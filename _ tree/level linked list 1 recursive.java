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

    void createLevelLinkedListRecursive(TreeNode root,
                                        ArrayList<LinkedList<TreeNode>> lists,
                                        int level) {
        if (root == null) return;

        LinkedList<TreeNode> list;
        if (lists.size() == level) {
            list = new LinkedList<>();
            lists.add(list);
        } else {
            list = lists.get(level);
        }

        list.add(root);
        createLevelLinkedListRecursive(root.left, lists, level + 1);
        createLevelLinkedListRecursive(root.right, lists, level + 1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedListRecursive(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
        createLevelLinkedListRecursive(root, lists, 0);
        return lists;
    }
}

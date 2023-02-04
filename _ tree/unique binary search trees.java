package kuznetsov;

import java.util.LinkedList;
import java.util.List;

class Main {

    public static void main(String[] args) {
        int n = 3;
        List<TreeNode> trees = generateTrees(n);
        System.out.println();
    }

    public static List<TreeNode> generateTrees(int n) {
        return generateSubtrees(1, n);
    }

    private static List<TreeNode> generateSubtrees(int start, int end) {
        List<TreeNode> subtrees = new LinkedList<>();
        if (start > end) {
            subtrees.add(null);
            return subtrees;
        }

        for (int i = start; i <= end; ++i) {
            List<TreeNode> leftSubtrees = generateSubtrees(start, i - 1);
            List<TreeNode> rightSubtrees = generateSubtrees(i + 1, end);
            for (TreeNode left : leftSubtrees) {
                for (TreeNode right : rightSubtrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    subtrees.add(root);
                }
            }
        }

        return subtrees;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

}

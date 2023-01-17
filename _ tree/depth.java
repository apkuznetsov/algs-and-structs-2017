package kuznetsov;

class Main {

  public static void main(String[] args) {
  }

  public static int maxDepth(TreeNode root) {
    if (root == null) {
      return 0;
    }

    int l = root.left == null ? 1 : 1 + maxDepth(root.left);
    int r = root.right == null ? 1 : 1 + maxDepth(root.right);
    return Math.max(l, r);
  }

}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

}

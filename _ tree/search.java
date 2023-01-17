package kuznetsov;

class Main {

  public static void main(String[] args) {
  }

  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null) {
      return null;
    }
    if (root.val == val) {
      return root;
    }

    TreeNode left = searchBST(root.left, val);
    TreeNode right = searchBST(root.right, val);

    return left != null ? left : right;
  }

}

class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

}

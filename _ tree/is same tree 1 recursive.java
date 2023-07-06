package kuznetsov;

class Main {

  public static void main(String[] args) {
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }

    if (q == null || p == null) {
      return false;
    }

    if (p.val != q.val) {
      return false;
    }

    return isSameTree(p.right, q.right)
        && isSameTree(p.left, q.left);
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

}

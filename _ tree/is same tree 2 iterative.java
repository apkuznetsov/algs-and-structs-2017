package kuznetsov;

import java.util.ArrayDeque;

class Main {

  public static void main(String[] args) {
  }

  private boolean areNotEqual(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return false;
    }
    if (q == null || p == null) {
      return true;
    }
    return p.val != q.val;
  }

  public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) {
      return true;
    }
    if (areNotEqual(p, q)) {
      return false;
    }

    ArrayDeque<TreeNode> deqP = new ArrayDeque<>();
    ArrayDeque<TreeNode> deqQ = new ArrayDeque<>();
    deqP.addLast(p);
    deqQ.addLast(q);

    while (!deqP.isEmpty()) {
      p = deqP.removeFirst();
      q = deqQ.removeFirst();

      if (areNotEqual(p, q)) {
        return false;
      }

      if (areNotEqual(p.left, q.left)) {
        return false;
      }
      if (p.left != null) {
        deqP.addLast(p.left);
        deqQ.addLast(q.left);
      }

      if (areNotEqual(p.right, q.right)) {
        return false;
      }
      if (p.right != null) {
        deqP.addLast(p.right);
        deqQ.addLast(q.right);
      }
    }

    return true;
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
  }

}

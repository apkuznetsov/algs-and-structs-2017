package kuznetsov;

public class Main {

  public static void main(String[] args) {
    System.out.println();
  }

  public boolean hasCycle(ListNode head) {
    if (head == null) {
      return false;
    }

    ListNode turtle = head;
    ListNode hare = head;

    while (turtle != null && hare != null) {
      turtle = turtle.next;

      hare = hare.next;
      if (hare == null) {
        return false;
      }
      hare = hare.next;

      if (turtle == hare) {
        return true;
      }
    }

    return false;
  }

}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }

}


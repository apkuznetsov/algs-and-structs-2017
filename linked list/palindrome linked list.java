package kuznetsov;

public class Main {

  public static void main(String[] args) {
    //ListNode n6 = new ListNode(1, null);
    ListNode n5 = new ListNode(1, null);
    ListNode n4 = new ListNode(2, n5);
    ListNode n3 = new ListNode(3, n4);
    ListNode n2 = new ListNode(2, n3);
    ListNode n1 = new ListNode(1, n2);
    boolean res = isPalindrome(n1);
    System.out.println(res);
  }

  public static boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) {
      return true;
    }
    ListNode curr;
    int i;

    curr = head;
    int size = 0;
    while (curr != null) {
      curr = curr.next;
      size++;
    }
    boolean isEven = size % 2 == 0;
    int half = size / 2;

    curr = head;
    ListNode oldHead;
    ListNode newHead;
    i = 1;
    while (i < half) {
      newHead = curr.next;
      curr.next = newHead.next;
      oldHead = head;
      head = newHead;
      head.next = oldHead;
      ++i;
    }

    ListNode left = head;
    ListNode right = curr.next;
    right = isEven ? right : right.next;
    i = 1;
    while (i <= half) {
      if (left.val != right.val) {
        return false;
      }
      left = left.next;
      right = right.next;
      ++i;
    }

    return true;
  }
}

class ListNode {

  int val;

  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this.val = val;
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;
  }

}
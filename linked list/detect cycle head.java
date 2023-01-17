package kuznetsov;

public class Main {

  public static void main(String[] args) {
    System.out.println();
  }

  LinkedListNode FindBeginning(LinkedListNode head) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      if (slow == fast) {
        break;
      }
    }

    if (fast == null || fast.next == null) {
      return null;
    }

    slow = head;
    while (slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }

    return fast;
  }
}

class LinkedListNode {

  int val;
  LinkedListNode next;

  LinkedListNode(int x) {
    val = x;
    next = null;
  }

}

package kuznetsov;

public class Main {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, null);
    head = removeNthFromEnd(head, 1);
    System.out.println(head);
  }

  public static ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode slow = head;
    ListNode fast = head;

    while (n > 0) {
      if (fast == null) {
        return head;
      }
      fast = fast.next;
      n--;
    }

    if (fast == null) {
      head = head.next;
      return head;
    }

    while (fast.next != null) {
      slow = slow.next;
      fast = fast.next;
    }

    if (slow.next != null && slow.next.next != null) {
      slow.next = slow.next.next;
    } else {
      slow.next = null;
    }
    return head;
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
package kuznetsov;

public class Main {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, null);
    System.out.println(head);
  }

  public ListNode reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }

    ListNode main = head;
    ListNode oldHead;
    ListNode newHead;

    while (main.next != null) {
      newHead = main.next;
      main.next = newHead.next;
      oldHead = head;
      head = newHead;
      head.next = oldHead;
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
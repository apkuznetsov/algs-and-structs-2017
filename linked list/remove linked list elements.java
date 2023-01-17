package kuznetsov;

public class Main {

  public static void main(String[] args) {
    ListNode head = new ListNode(1, null);
    System.out.println(head);
  }

  public ListNode removeElements(ListNode head, int val) {
    if (head == null) {
      return null;
    }

    ListNode prev = head;
    ListNode curr = head;
    while (curr != null) {
      if (curr.val == val) {
        prev.next = curr.next;
      } else {
        prev = curr;
      }
      curr = prev.next;
    }

    if (head.val == val) {
      head = head.next;
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
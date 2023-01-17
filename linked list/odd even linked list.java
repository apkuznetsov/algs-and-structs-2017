package kuznetsov;

public class Main {

  public static void main(String[] args) {
    ListNode n6 = new ListNode(6, null);
    ListNode n5 = new ListNode(5, n6);
    ListNode n4 = new ListNode(4, n5);
    ListNode n3 = new ListNode(3, n4);
    ListNode n2 = new ListNode(2, n3);
    ListNode n1 = new ListNode(1, n2);
    oddEvenList(n1);
    System.out.println();
  }

  public static ListNode oddEvenList(ListNode head) {
    if (head == null) {
      return null;
    }

    ListNode odd = head;
    ListNode even = head.next;
    ListNode evenHead = even;

    while (even != null && even.next != null) {
      odd.next = even.next;
      odd = odd.next;
      even.next = odd.next;
      even = even.next;
    }

    odd.next = evenHead;
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
package kuznetsov;

public class Main {

  public static void main(String[] args) {

  }
  
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode head = new ListNode();
    ListNode tail = head;

    int carry = 0;
    while (l1 != null || l2 != null || carry != 0) {
      int x = (l1 != null) ? l1.val : 0;
      int y = (l2 != null) ? l2.val : 0;
      int sum = carry + x + y;

      carry = sum / 10;
      tail.next = new ListNode(sum % 10);
      tail = tail.next;

      if (l1 != null) {
        l1 = l1.next;
      }
      if (l2 != null) {
        l2 = l2.next;
      }
    }

    return head.next;
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

package kuznetsov;

class Main {

  public static void main(String[] args) {
  }

  public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) {
      return head;
    }
    if (head.next.next == null) {
      ListNode newHead = head.next;
      head.next = null;
      newHead.next = head;
      return newHead;
    }

    head.next.next = swapPairs(head.next.next);

    ListNode newHead = head.next;
    head.next = head.next.next;
    newHead.next = head;
    return newHead;
  }

}

class ListNode {

  int val;
  ListNode next;

  ListNode() {
  }

  ListNode(int val) {
    this(val, null);
  }

  ListNode(int val, ListNode next) {
    this.val = val;
    this.next = next;

  }

}


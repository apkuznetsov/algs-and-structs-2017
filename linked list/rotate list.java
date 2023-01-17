package kuznetsov;

public class Main {

  public static void main(String[] args) {
//    ListNode n5 = new ListNode(5, null);
//    ListNode n4 = new ListNode(4, n5);
//    ListNode n3 = new ListNode(3, n4);
//    ListNode n2 = new ListNode(2, null);
    ListNode n1 = new ListNode(2, null);
    ListNode n0 = new ListNode(1, n1);
    int k = 2;

    ListNode head = rotateRight(n0, k);
    System.out.println(head);
  }

  public static ListNode rotateRight(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return head;
    }

    // reverse(nums, 0, nums.length - 1);
    HeadWithSize r1 = reverseList(head);
    head = r1.head;
    int size = r1.size;

    // reverse(nums, 0, k - 1);
    k = k % size;
    if (k == 0) {
      return reverseList(head).head;
    }
    HeadWithKth r2 = reverseListUntilKthAndReturnKth(head, k);
    head = r2.head;
    ListNode kth = r2.kth;

    // reverse(nums, k, nums.length - 1);
    ListNode tempHead = kth.next;
    kth.next = null;
    HeadWithSize r3 = reverseList(tempHead);
    tempHead = r3.head;
    kth.next = tempHead;

    return head;
  }

  public static HeadWithSize reverseList(ListNode head) {
    if (head == null || head.next == null) {
      return new HeadWithSize(head, 0);
    }

    ListNode curr = head;
    ListNode oldHead;
    ListNode newHead;

    int size = 1;
    while (curr.next != null) {
      newHead = curr.next;
      curr.next = newHead.next;
      oldHead = head;
      head = newHead;
      head.next = oldHead;
      ++size;
    }

    return new HeadWithSize(head, size);
  }

  private static HeadWithKth reverseListUntilKthAndReturnKth(ListNode head, int k) {
    if (head == null || head.next == null || k == 0) {
      return new HeadWithKth(head, null);
    }

    ListNode curr = head;
    ListNode oldHead;
    ListNode newHead;

    int i = 1;
    while (curr.next != null && i < k) {
      newHead = curr.next;
      curr.next = newHead.next;
      oldHead = head;
      head = newHead;
      head.next = oldHead;
      ++i;
    }

    return new HeadWithKth(head, curr);
  }

  static class HeadWithSize {
    ListNode head;
    int size;

    HeadWithSize(ListNode head, int size) {
      this.head = head;
      this.size = size;
    }
  }

  static class HeadWithKth {
    ListNode head;
    ListNode kth;

    HeadWithKth(ListNode head, ListNode kth) {
      this.head = head;
      this.kth = kth;
    }
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

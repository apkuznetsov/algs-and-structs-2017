package kuznetsov;

public class Main {

  public static void main(String[] args) {
//    ListNode a3 = new ListNode(4, null);
//    ListNode a2 = new ListNode(2, a3);
    ListNode a1 = null;

//    ListNode b3 = new ListNode(4, null);
//    ListNode b2 = new ListNode(3, b3);
    ListNode b1 = new ListNode(1, null);

    mergeTwoLists(b1, null);
  }

  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode();
    ListNode tail = head;

    while (list1 != null || list2 != null) {
      if (list1 == null) {
        tail.next = list2;
        list2 = list2.next;
      } else if (list2 == null) {
        tail.next = list1;
        list1 = list1.next;
      } else if (list1.val <= list2.val) {
        tail.next = list1;
        list1 = list1.next;
      } else {
        tail.next = list2;
        list2 = list2.next;
      }

      tail = tail.next;
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

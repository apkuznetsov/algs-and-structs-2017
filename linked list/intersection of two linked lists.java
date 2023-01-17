package kuznetsov;

public class Main {

  public static void main(String[] args) {
  }

  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    // A
    ListNode currA = headA;
    int sizeA = 1;
    while (currA.next != null) {
      currA = currA.next;
      sizeA++;
    }

    // B
    ListNode currB = headB;
    int sizeB = 1;
    while (currB.next != null) {
      currB = currB.next;
      sizeB++;
    }

    if (currA != currB) {
      return null;
    }

    ListNode shorter = sizeA < sizeB ? headA : headB;
    ListNode longer = sizeA < sizeB ? headB : headA;

    int k = Math.abs(sizeA - sizeB);
    while (k > 0 && longer != null) {
      longer = longer.next;
      k--;
    }

    while (longer != shorter) {
      longer = longer.next;
      shorter = shorter.next;
    }

    return longer;
  }
}

class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
    next = null;
  }

}

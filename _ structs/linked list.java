package kuznetsov;

public class Main {

  public static void main(String[] args) {
    MyLinkedList obj = new MyLinkedList();

//    obj.addAtHead(1);
//    obj.deleteAtIndex(0);

//    obj.addAtIndex(0, 10);
//    obj.addAtIndex(0, 20);
//    obj.addAtIndex(0, 30);
//    obj.get(0);

//    obj.addAtTail(1);
//    obj.get(0);

//    obj.addAtHead(84);
//    obj.addAtTail(2);
//    obj.addAtTail(39);
//    obj.get(3);
//    obj.get(1);
//    obj.addAtTail(42); //+
//    obj.addAtIndex(1, 80); //+
//    obj.addAtHead(14); //+
//    obj.addAtHead(1);
//    obj.addAtTail(53);
//    obj.addAtTail(98);
//    obj.addAtTail(19);
//    obj.addAtTail(12);
//    obj.get(2); //+
//    obj.addAtHead(16);
//    obj.addAtHead(33);  // +
//    obj.addAtIndex(4, 17);
//    obj.addAtIndex(6, 8);
//    obj.addAtHead(37);
//    obj.addAtTail(43); //+
//    obj.deleteAtIndex(11); //+
//    obj.addAtHead(80);
//    obj.addAtHead(31); //+
//    obj.addAtIndex(13, 23);
//    obj.addAtTail(17);
//    obj.get(4); //+
//    obj.addAtIndex(10, 0);
//    obj.addAtTail(21);
//    obj.addAtHead(73);
//    obj.addAtHead(22);
//    obj.addAtIndex(24, 37);
//    obj.addAtTail(14);
//    obj.addAtHead(97);
//    obj.addAtHead(8);
//    obj.get(6);
//    obj.deleteAtIndex(17);
//    obj.addAtTail(50);
//    obj.addAtTail(28);
//    obj.addAtHead(76);
//    obj.addAtTail(79);
//    obj.get(18);
//    obj.deleteAtIndex(30);
//    obj.addAtTail(5);
//    obj.addAtHead(9);
//    obj.addAtTail(83);
//    obj.deleteAtIndex(3);
//    obj.addAtTail(40);
//    obj.deleteAtIndex(26);
//    obj.addAtIndex(20, 90);
//    obj.deleteAtIndex(30);

    obj.addAtHead(7);
    obj.addAtHead(2);
    obj.addAtHead(3);
    obj.addAtIndex(3, 0);
    obj.deleteAtIndex(2);
    obj.addAtHead(6);
    obj.addAtTail(4);
    obj.get(4);

    System.out.println(obj.get(0));
  }

}

class MyLinkedList {

  private Node head;
  private Node tail;
  private int size;

  public MyLinkedList() {
    head = null;
    tail = null;
    size = 0;
  }

  public Node getNode(int index) {
    if (index < 0 || index >= size) {
      return null;
    }

    Node curr = head;
    int counter = 0;
    while (counter < index) {
      curr = curr.next;
      ++counter;
    }

    return curr;
  }

  public int get(int index) {
    Node curr = getNode(index);
    return curr == null ? -1 : curr.value;
  }

  public void addAtHead(int value) {
    Node node = new Node(value);

    // size 0 -> 1
    if (head == null) {
      head = node;
      tail = null;
      size = 1;
      return;
    }

    // size 1 -> 2
    if (tail == null) {
      tail = head;
      node.next = head;
      head = node;
      size = 2;
      return;
    }

    node.next = head;
    head = node;
    ++size;
  }

  public void addAtTail(int value) {
    Node node = new Node(value);

    // size 0 -> 1
    if (head == null) {
      addAtHead(value);
      return;
    }

    // size 1 -> 2
    if (tail == null) {
      head.next = node;
      tail = node;
      size = 2;
      return;
    }

    tail.next = node;
    tail = node;
    ++size;
  }

  public void addAtIndex(int index, int value) {
    if (index < 0 || index > size) {
      return;
    }

    // head
    if (index == 0) {
      addAtHead(value);
      return;
    }

    // tail
    if (index == size) {
      addAtTail(value);
      return;
    }

    Node prev = getNode(index - 1);
    Node oldPrevNext = prev.next;
    prev.next = new Node(value, oldPrevNext);
    ++size;
  }

  public void deleteAtIndex(int index) {
    if (index < 0 || index >= size) {
      return;
    }
    if (index == 0 && head == null) {
      return;
    }

    if (index == 0) {
      Node headNext = head.next;
      if (headNext == null) {
        head = null;
        tail = null;
        size = 0;
      } else {
        head = headNext;
        if (head.next == null) {
          tail = null;
        }
        --size;
      }
      return;
    }

    if (index == size - 1) {
      Node prev = getNode(index - 1);
      prev.next = null;
      tail = prev;
      --size;
      return;
    }

    Node prev = getNode(index - 1);
    Node oldPrevNext = prev.next;
    prev.next = oldPrevNext.next;
    --size;
  }

  static class Node {

    int value;
    Node next;

    public Node(int value) {
      this(value, null);
    }

    public Node(int value, Node next) {
      this.value = value;
      this.next = next;
    }

  }
}

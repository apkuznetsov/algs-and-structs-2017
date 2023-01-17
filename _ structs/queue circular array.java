package kuznetsov;


public class Main {

  public static void main(String[] args) {
    MyCircularQueue myCircularQueue = new MyCircularQueue(3);

    System.out.println(myCircularQueue.enQueue(1)); // return True
    System.out.println(myCircularQueue.enQueue(2));  // return True
    System.out.println(myCircularQueue.enQueue(3)); // return True
    System.out.println(myCircularQueue.enQueue(4)); // return False
    System.out.println(myCircularQueue.Rear()); // return 3
    System.out.println(myCircularQueue.isFull()); // return True
    System.out.println(myCircularQueue.deQueue()); // return True
    System.out.println(myCircularQueue.enQueue(4)); // return True
    System.out.println(myCircularQueue.Rear()); // return 4
  }

}

class MyCircularQueue {

  private final int[] storage;
  private final int size;
  private int head;
  private int tail;

  public MyCircularQueue(int size) {
    if (size < 1 || size > 1000) {
      throw new IllegalArgumentException();
    }
    this.size = size;
    this.storage = new int[this.size];
    this.head = -1;
    this.tail = -1;
  }

  public boolean enQueue(int x) {
    if (isFull()) {
      return false;
    }

    if (isEmpty()) {
      head = 0;
    }

    tail = (tail + 1) % size;
    storage[tail] = x;
    return true;
  }

  public boolean deQueue() {
    if (isEmpty()) {
      return false;
    }

    if (head == tail) {
      head = -1;
      tail = -1;
      return true;
    }

    head = (head + 1) % size;
    return true;
  }

  public int Front() {
    if (isEmpty()) {
      return -1;
    }
    return storage[head];
  }

  public int Rear() {
    if (isEmpty()) {
      return -1;
    }
    return storage[tail];
  }

  public boolean isEmpty() {
    return head == -1;
  }

  public boolean isFull() {
    return ((tail + 1) % size) == head;
  }

}

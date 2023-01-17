package kuznetsov;

import java.util.ArrayList;


public class Main {

  public static void main(String[] args) {
    ArrayListQueue q = new ArrayListQueue();
    q.enqueue(5);
    q.enqueue(3);
    if (!q.isEmpty()) {
      System.out.println(q.front());
    }
    q.dequeue();
    if (!q.isEmpty()) {
      System.out.println(q.front());
    }
    q.dequeue();
    if (!q.isEmpty()) {
      System.out.println(q.front());
    }
  }

}

class ArrayListQueue {

  private final ArrayList<Integer> storage;
  private int startIdx;

  public ArrayListQueue() {
    storage = new ArrayList<>();
    startIdx = 0;
  }

  public boolean enqueue(int x) {
    storage.add(x);
    return true;
  }

  public boolean dequeue() {
    if (isEmpty()) {
      return false;
    }
    startIdx++;
    return true;
  }

  public int front() {
    return storage.get(startIdx);
  }

  public boolean isEmpty() {
    return startIdx >= storage.size();
  }

}

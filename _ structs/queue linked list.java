package kuznetsov;

import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class Main {

  public static void main(String[] args) {

  }

}

class LinkedListQueue<T> {

  private QueueNode<T> first;
  private QueueNode<T> last;

  public void add(T item) {
    QueueNode<T> t = new QueueNode<T>(item);
    if (last != null) {
      last.next = t;
    }
    last = t;
    if (first == null) {
      first = last;
    }
  }

  public T remove() {
    if (first == null) {
      throw new NoSuchElementException();
    }

    T data = first.data;
    first = first.next;
    if (first == null) {
      last = null;
    }

    return data;
  }

  public T peek() {
    if (first == null) {
      throw new EmptyStackException();
    }
    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }

  private static class QueueNode<T> {
    private final T data;
    private QueueNode<T> next;

    public QueueNode(T data) {
      this.data = data;
    }
  }
}

package kuznetsov;

import java.util.EmptyStackException;

class Stack<T> {

  private StackNode<T> top;

  public T pop() {
    if (top == null) {
      throw new EmptyStackException();
    }

    T item = top.data;
    top = top.next;

    return item;
  }

  public void push(T item) {
    StackNode<T> newTop = new StackNode<T>(item);
    newTop.next = top;
    top = newTop;
  }

  public T peek() {
    if (top == null) {
      throw new EmptyStackException();
    }
    return top.data;
  }

  public boolean isEmpty() {
    return top == null;
  }

  private static class StackNode<T> {
    private final T data;
    private StackNode<T> next;

    public StackNode(T data) {
      this.data = data;
    }
  }

}

package kuznetsov;

import java.util.ArrayList;

public class Main {

  public static void main(String[] args) {
    ArrayListStack stack = new ArrayListStack();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    for (int i = 0; i < 4; ++i) {
      if (!stack.isEmpty()) {
        System.out.println(stack.top());
      }
      System.out.println(stack.pop());
    }
  }

}

class ArrayListStack {

  private final ArrayList<Integer> storage;

  public ArrayListStack() {
    storage = new ArrayList<>();
  }

  public void push(int x) {
    storage.add(x);
  }

  public boolean isEmpty() {
    return storage.isEmpty();
  }

  public int top() {
    return storage.get(storage.size() - 1);
  }

  public boolean pop() {
    if (isEmpty()) {
      return false;
    }
    storage.remove(storage.size() - 1);
    return true;
  }
  
}

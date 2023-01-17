package kuznetsov;

import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    MyQueue myQueue = new MyQueue();
    myQueue.push(1); // queue is: [1]
    myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
    System.out.println(myQueue.peek()); // return 1
    System.out.println(myQueue.pop()); // return 1, queue is [2]
    System.out.println(myQueue.empty()); // return false
  }

}

class MyQueue {

  Stack<Integer> back;
  Stack<Integer> front;

  public MyQueue() {
    back = new Stack<>();
    front = new Stack<>();
  }

  public void push(int x) {
    back.push(x);
  }

  public int pop() {
    if (front.isEmpty()) {
      while (!back.isEmpty()) {
        front.push(back.pop());
      }
    }
    return front.pop();
  }

  public int peek() {
    if (front.isEmpty()) {
      while (!back.isEmpty()) {
        front.push(back.pop());
      }
    }
    return front.peek();
  }

  public boolean empty() {
    return back.isEmpty() && front.empty();
  }

}

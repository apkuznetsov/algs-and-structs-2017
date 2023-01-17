package kuznetsov;

public class Main {

  public static void main(String[] args) {
    Heap heap = new Heap(31);
    heap.insert(120);
    heap.insert(40);
    heap.insert(50);
    heap.insert(80);
    heap.insert(20);
    heap.insert(100);
    heap.insert(150);
    heap.insert(30);
    heap.insert(210);
    heap.insert(180);
    heap.insert(10);
    heap.insert(90);
  }

  static class Node {
    private int value;

    public Node(int value) {
      this.value = value;
    }

    public int getValue() {
      return this.value;
    }

    public void setValue(int value) {
      this.value = value;
    }
  }

  static class Heap {
    private final Node[] array;
    private int size;

    public Heap(int capacity) {
      array = new Node[capacity];
      this.size = 0;
    }

    private void top(int index) {
      Node child = array[index];
      int parentIndex = (index - 1) / 2;

      while (index > 0 && array[parentIndex].getValue() < child.getValue()) {
        array[index] = array[parentIndex];
        index = parentIndex;

        parentIndex = (parentIndex - 1) / 2;
      }

      array[index] = child;
    }


    private void bottom(int index) {
      Node nodeToBottom = array[index];

      int largerChild;
      while (index < size / 2) {
        int leftChild = 2 * index + 1;
        int rightChild = leftChild + 1;

        if (rightChild < size && array[leftChild].getValue() < array[rightChild].getValue()) {
          largerChild = rightChild;
        } else {
          largerChild = leftChild;
        }

        if (nodeToBottom.getValue() >= array[largerChild].getValue()) {
          break;
        }

        array[index] = array[largerChild];
        index = largerChild;
      }

      array[index] = nodeToBottom;
    }

    public boolean insert(int value) {
      boolean isFull = size == array.length;
      if (isFull) {
        return false;
      }

      Node nodeToInsert = new Node(value);
      int newLastIndex = size++;
      array[newLastIndex] = nodeToInsert;

      top(newLastIndex);
      return true;
    }

    public Node delete(int index) {
      boolean isOutOfRange = index < 0 || index >= size;
      if (isOutOfRange) {
        return null;
      }

      Node nodeToDelete = array[index];
      int lastNodeIndex = --size;
      array[index] = array[lastNodeIndex];
      array[size] = null;

      bottom(index);
      return nodeToDelete;
    }

    public boolean change(int index, int newValue) {
      boolean isOutOfRange = index < 0 || index >= size;
      if (isOutOfRange) {
        return false;
      }

      int oldValue = array[index].getValue();
      array[index].setValue(newValue);

      if (oldValue < newValue) {
        top(index);
      } else {
        bottom(index);
      }

      return true;
    }
  }
}

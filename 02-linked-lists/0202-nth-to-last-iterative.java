/* 2.2. Реализуйте алгоритм для нахождения в односвязном списке k-го элемента с конца. */

package ssau.kuznetsov;

public class Main {

    public static void main(String[] args) {
    }

    public static Node nthToLastIterative(Node head, int k) {
        Node a = head;
        Node b = head;

        for (int i = 0; i < k; i++) {
            if (b == null) return null;
            b = b.next;
        }

        while (b != null) {
            a = a.next;
            b = b.next;
        }

        return a;
    }
}

class Node {
    final int data;
    Node next = null;

    public Node(int d) {
        data = d;
    }

    public void append(int d) {
        Node end = new Node(d);
        Node n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    public Node delete(Node head, int d) {
        Node n = head;

        if (n.data == d) {
            return head.next;
        }

        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;
            }

            n = n.next;
        }

        return head;
    }
}


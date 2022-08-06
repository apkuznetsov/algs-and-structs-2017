package kuznetsov;

public class MySet {

    Node[] a;

    MySet() {
        a = new Node[10];
    }

    void add(int x) {
        if (find(x))
            return;

        if (a[x % 10] == null)
            a[x % 10] = new Node(10);
        else {
            Node old = a[x % 10];
            a[x % 10] = new Node(10, old);
        }
    }

    boolean find(int x) {
        if (a[x % 10] == null)
            return false;

        Node n = a[x % 10];
        if (n.value == x)
            return true;

        while (n.next != null) {
            n = n.next;
            if (n.value == x)
                return true;
        }

        return false;
    }

    void delete(int x) {
        Node n = a[x % 10];
        if (n.value == x) {
            a[x % 10] = n.next;
            return;
        }

        while (n.next != null) {
            Node last = n;
            n = n.next;
            if (n.value == x) {
                last.next = n.next;
                return;
            }
        }
    }

    class Node {
        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this(value);
            this.value = value;
        }
    }
}

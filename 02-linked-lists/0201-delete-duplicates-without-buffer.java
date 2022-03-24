/* 2.1. Напиште код для удаления дубликатов из несортированного связного списка.
 * Как вы будете решать задачу, если использовать временный буфер запрещено? */

package ssau.kuznetsov;

public class Main {

    public static void main(String[] args) {
    }

    public static void deleteDuplicateWithoutBuffer(Node head) {
        Node curr = head;
        Node runner = null;

        while (curr.next != null) {
            runner = curr;
            while (runner.next != null) {
                if (runner.next.data == curr.data) {
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }

            curr = curr.next;
        }
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


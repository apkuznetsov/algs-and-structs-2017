/* 2.5. Два числа хранятся в виде связных списков, в которых каждый узел представляет один разряд.
 * Все цифры хранятся в обратном порядке, при этом младший разряд (единицы) хранятся в начале списка.
 * Напишите функцию, которая суммирует два числа и возвращает результат в виде связного списка. */

package ssau.kuznetsov;

public class Main {

    public static void main(String[] args) {
    }

    public static Node addition(Node l1, Node l2, int carry) {
        if (l1 == null && l2 == null && carry == 0) {
            return null;
        }

        int value = carry;
        if (l1 != null) {
            value += l1.data;
        }
        if (l2 != null) {
            value += l2.data;
        }

        Node additionResult = new Node(value % 10);

        if (l1 != null || l2 != null) {
            additionResult.next = addition(
                    l1 == null ? null : l1.next,
                    l2 == null ? null : l2.next,
                    value >= 10 ? 1 : 0);
        }

        return additionResult;
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


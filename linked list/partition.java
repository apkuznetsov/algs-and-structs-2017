/* 2.4. Напишите код для разбиения связного списка вокруг значения x,
 * так чтобы все узлы, меньшие x, предшествовали удлам, большим или равным x.
 * Если x содержится в списке, то значения x должны следовать строго после элементов, меньших x.
 * Элемент разбивки x может находиться где угодно в правой части,
 * он не обязан располагаться между левой и правой частью. */

package ssau.kuznetsov;

public class Main {

    public static void main(String[] args) {
    }

    public static Node partition(Node head, int x) {
        Node start = head;
        Node end = head;
        Node curr = head;

        while (curr.next != null) {
            if (curr.data < x) {
                Node temp = start;
                start = curr;
                start.next = temp;
            } else {
                end.next = curr;
                end = curr;
            }

            curr = curr.next;
        }

        return start;
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


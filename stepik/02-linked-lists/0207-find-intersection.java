/* 2.7. Проверьте, пересекаются ли два заданных (одно-)связанных списка.
 *  Верните узел пересечения. Учтите, что пересечение определяется ссылкой,
 * а не значением. Иначе говоря,
 * если k-ый узел первого связного списка точно совпадает (по ссылке) с j-ым узлом второго связного списка,
 * то списки считаются перескающимися. */

package ssau.kuznetsov;

public class Main {

    public static void main(String[] args) {
    }

    public static Node findIntersection(Node a, Node b) {

        Node currA = a;
        int lenA = 1;
        while (currA.next != null) {
            currA = currA.next;
            lenA++;
        }

        Node currB = b;
        int lenB = 1;
        while (currB.next != null) {
            currB = currB.next;
            lenB++;
        }

        if (currA != currB) return null;

        Node shorter = lenA > lenB ? b : a;
        Node longer = lenA < lenB ? b : a;

        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            longer = longer.next;
        }

        while (longer != shorter) {
            longer = longer.next;
            shorter = shorter.next;
        }

        return longer;
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

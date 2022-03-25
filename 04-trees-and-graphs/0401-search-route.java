/* 4.1. Для заданного направленного графа разработайте алгоритм,
 * проверяющий существования маршрута между двумя узлами. */

package ssau.kuznetsov;

import java.util.LinkedList;

enum State {Unvisited, Visited, Visiting}

class Node {
    public String name;
    public Node[] nodesAdjacent;
    public State state = State.Unvisited;
}

class Graph {
    public Node[] nodes;
}

public class Main {

    public static void main(String[] args) {
    }

    boolean search(Graph g, Node start, Node end) {
        if (start == end)
            return true;

        LinkedList<Node> q = new LinkedList<>();

        for (Node n : g.nodes)
            n.state = State.Unvisited;

        start.state = State.Visiting;
        q.add(start);

        Node curr;
        while (!q.isEmpty()) {
            curr = q.removeFirst();
            if (curr == null)
                continue;

            for (Node adj : curr.nodesAdjacent) {
                if (adj.state == State.Unvisited) {
                    if (adj == end) {
                        return true;
                    } else {
                        adj.state = State.Visiting;
                        q.add(adj);
                    }
                }
            }

            curr.state = State.Visited;
        }

        return false;
    }
}

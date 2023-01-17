package kuznetsov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
//    List<List<Integer>> rooms = new ArrayList<>();
//    rooms.add(List.of(1));
//    rooms.add(List.of(2));
//    rooms.add(List.of(3));
//    rooms.add(List.of());

//    List<List<Integer>> rooms = new ArrayList<>();
//    rooms.add(List.of(1, 3));
//    rooms.add(List.of(3, 0, 1));
//    rooms.add(List.of(2));
//    rooms.add(List.of(0));

    List<List<Integer>> rooms = new ArrayList<>();
    rooms.add(List.of(1));
    rooms.add(List.of(1));

    System.out.println(
        canVisitAllRooms(rooms)
    );
  }

  public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<List<Integer>> visited = Collections.newSetFromMap(new IdentityHashMap<>());

    List<Integer> rootRoom = rooms.get(0);
    visited.add(rootRoom);

    Stack<List<Integer>> stack = new Stack<>();
    stack.add(rootRoom);

    while (!stack.isEmpty()) {
      List<Integer> currRoom = stack.pop();

      for (Integer key : currRoom) {
        List<Integer> next = rooms.get(key);
        if (!visited.contains(next)) {
          visited.add(next);
          stack.push(next);
        }
      }
    }

    return visited.size() == rooms.size();
  }

}

package kuznetsov;


import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class Main {

  public static void main(String[] args) {
//    char[][] grid = new char[][] {
//        {'1', '1', '0', '0', '0'},
//        {'1', '1', '0', '0', '0'},
//        {'0', '0', '1', '0', '0'},
//        {'0', '0', '0', '1', '1'}
//    };
    char[][] grid = new char[][] {
        {'1', '1', '1', '1', '0'},
        {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'},
        {'0', '0', '0', '0', '0'}
    };

    System.out.println(
        numIslands(grid)
    );
  }

  public static int numIslands(char[][] grid) {
    Set<Point> pointsVisited = new HashSet<>();
    int counterIslands = 0;

    for (int iRow = 0; iRow < grid.length; iRow++) {
      for (int iCol = 0; iCol < grid[iRow].length; iCol++) {
        if (grid[iRow][iCol] == '1') {
          Point curr = new Point(iRow, iCol);
          if (!pointsVisited.contains(curr)) {
            counterIslands += numIslandsHelper(grid, pointsVisited, curr);
          }
        }
      }
    }

    return counterIslands;
  }

  private static int numIslandsHelper(char[][] grid, Set<Point> pointsVisited, Point root) {
    Queue<Point> pointsProcessing = new ArrayDeque<>();
    pointsProcessing.add(root);
    pointsVisited.add(root);

    final int maxY = grid.length - 1;
    final int maxX = grid[0].length - 1;

    while (!pointsProcessing.isEmpty()) {
      int queueSize = pointsProcessing.size();
      for (int i = 0; i < queueSize; ++i) {
        Point curr = pointsProcessing.poll();
        int currY = curr.getY();
        int currX = curr.getX();
        Point[] neighbors = new Point[] {
            new Point(currY - 1, currX),
            new Point(currY + 1, currX),
            new Point(currY, currX - 1),
            new Point(currY, currX + 1)
        };

        for (Point neigh : neighbors) {
          int neighY = neigh.getY();
          int neighX = neigh.getX();
          if (neighY < 0 || neighY > maxY || neighX < 0 || neighX > maxX) {
            continue;
          }
          if (grid[neighY][neighX] == '0') {
            continue;
          }
          if (!pointsVisited.contains(neigh)) {
            pointsProcessing.add(neigh);
            pointsVisited.add(neigh);
          }
        }
      }
    }

    return 1;
  }

  static public class Point {

    private final int x;
    private final int y;

    public Point(int y, int x) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }

      Point point = (Point) o;
      if (x != point.x) {
        return false;
      }
      return y == point.y;
    }

  }

}

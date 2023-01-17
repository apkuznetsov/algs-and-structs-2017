package kuznetsov;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

public class Main {

  public static void main(String[] args) {
    int[][] image = new int[][] {
        {1, 1, 1},
        {1, 1, 0},
        {1, 0, 1}
    };
    int sr = 1, sc = 1, color = 2;

    System.out.println(
        Arrays.deepToString(floodFill(image, sr, sc, color))
    );
  }

  public static int[][] floodFill(int[][] image, int sy, int sx, int newColor) {
    final int startColor = image[sy][sx];

    Queue<Point> pointsProcessing = new ArrayDeque<>();
    pointsProcessing.add(new Point(sy, sx));

    final int maxY = image.length - 1;
    final int maxX = image[0].length - 1;

    while (!pointsProcessing.isEmpty()) {
      int queueSize = pointsProcessing.size();
      for (int i = 0; i < queueSize; ++i) {
        Point p = pointsProcessing.poll();
        if (image[p.y][p.x] == newColor) {
          continue;
        }
        image[p.y][p.x] = newColor;

        int pY = p.getY();
        int pX = p.getX();
        Point[] neighbors = new Point[] {
            new Point(pY - 1, pX),
            new Point(pY + 1, pX),
            new Point(pY, pX - 1),
            new Point(pY, pX + 1)
        };

        for (Point neigh : neighbors) {
          int neighY = neigh.getY();
          int neighX = neigh.getX();
          if (neighY < 0 || neighY > maxY || neighX < 0 || neighX > maxX) {
            continue;
          }
          if (image[neighY][neighX] != startColor) {
            continue;
          }
          pointsProcessing.add(neigh);
        }
      }
    }

    return image;
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

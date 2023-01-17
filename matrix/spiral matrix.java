package kuznetsov;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    System.out.println(
        spiralOrder(
            new int[][] {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
            }
        )
    );
  }

  public static List<Integer> spiralOrder(int[][] m) {
    int rowsNum = m.length;
    int colsNum = m[0].length;
    int len = rowsNum * colsNum;
    List<Integer> res = new ArrayList<>(len);

    final int WEST_TO_EAST = 0;
    final int NORTH_TO_SOUTH = 1;
    final int EAST_TO_WEST = 2;
    final int SOUTH_TO_NORTH = 3;

    int edgeRowNorth = 0;
    int edgeRowSouth = rowsNum - 1;
    int edgeColWest = 0;
    int edgeColEast = colsNum - 1;

    int currDirection = WEST_TO_EAST;
    int r = 0;
    int c = 0;

    for (int i = 0; i < len; i++) {
      int val = m[r][c];

      switch (currDirection) {
        case WEST_TO_EAST:
          c++;
          if (c > edgeColEast) {
            c = edgeColEast;
            r++;
            edgeRowNorth++;
            currDirection = NORTH_TO_SOUTH;
          }
          break;
        case NORTH_TO_SOUTH:
          r++;
          if (r > edgeRowSouth) {
            c--;
            r = edgeRowSouth;
            edgeColEast--;
            currDirection = EAST_TO_WEST;
          }
          break;
        case EAST_TO_WEST:
          c--;
          if (c < edgeColWest) {
            c = edgeColWest;
            r--;
            edgeRowSouth--;
            currDirection = SOUTH_TO_NORTH;
          }
          break;
        case SOUTH_TO_NORTH:
          r--;
          if (r < edgeRowNorth) {
            c++;
            r = edgeRowNorth;
            edgeColWest++;
            currDirection = WEST_TO_EAST;
          }
          break;
      }

      res.add(val);
    }

    return res;
  }
  
}
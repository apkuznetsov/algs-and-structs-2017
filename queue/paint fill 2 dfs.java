package kuznetsov;


import java.util.Arrays;

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

  public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
    int color = image[sr][sc];
    if (color != newColor) {
      dfs(image, sr, sc, color, newColor);
    }
    return image;
  }

  public static void dfs(int[][] image, int r, int c, int startColor, int newColor) {
    if (image[r][c] == startColor) {
      image[r][c] = newColor;
      if (r >= 1) {
        dfs(image, r - 1, c, startColor, newColor);
      }
      if (c >= 1) {
        dfs(image, r, c - 1, startColor, newColor);
      }
      if (r + 1 < image.length) {
        dfs(image, r + 1, c, startColor, newColor);
      }
      if (c + 1 < image[0].length) {
        dfs(image, r, c + 1, startColor, newColor);
      }
    }
  }

}

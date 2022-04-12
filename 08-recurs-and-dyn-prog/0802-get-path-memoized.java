/* 8.2. Робот стоит в левом верхнем углу сетки,
 * состоящей из r строк и c столбцов.
 * Робот может перемещаться в двух направлениях:
 * вправо и вниз, но некоторые ячейки сетки заблокированы,
 * т.е. робот через них проходить не может.
 * Разработайте алгоритм построения маршрута от левого верхнего
 * до правого нижнего угла.*/

package ssau.kuznetsov;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
    }

    boolean getPath(boolean[][] maze, int row, int col,
                    ArrayList<Point> path, HashMap<Point, Boolean> cache) {
        if (col < 0 || row < 0 || !maze[row][col])
            return false;

        Point p = new Point(row, col);
        if (cache.containsKey(p)) {
            return cache.get(p);
        }

        boolean isAtOrigin = (row == 0) && (col == 0);
        boolean success = false;

        if (isAtOrigin
                || getPath(maze, row, col - 1, path, cache)
                || getPath(maze, row - 1, col, path, cache)) {
            path.add(p);
            success = true;
        }

        cache.put(p, success);
        return success;
    }

    ArrayList<Point> getPath(boolean[][] maze) {
        if (maze == null || maze.length == 0)
            return null;

        ArrayList<Point> path = new ArrayList<>();
        HashMap<Point, Boolean> cache = new HashMap<>();
        int lastRow = maze.length - 1;
        int lastCol = maze[0].length - 1;

        if (getPath(maze, lastRow, lastCol, path, cache))
            return path;

        return null;
    }
}

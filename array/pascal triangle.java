package kuznetsov;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static List<List<Integer>> generate(int numRows) {
    List<List<Integer>> container = new ArrayList<>(numRows);

    List<Integer> l1 = new ArrayList<>();
    l1.add(1);
    container.add(l1);
    if (numRows == 1) {
      return container;
    }

    ArrayList<Integer> l2 = new ArrayList<>();
    l2.add(1);
    l2.add(1);
    container.add(l2);
    if (numRows == 2) {
      return container;
    }

    ArrayList<Integer> lastRow = l2;
    int lastRowSize = 2;
    int lastRowLeftIdx;
    int lastRowRightIdx;
    int lastRowLeftVal;
    int lastRowRightVal;

    ArrayList<Integer> currRow;
    int currRowSize;
    int currRowIdx;
    int currRowLastIdx;

    for (int i = 3; i <= numRows; i++) {
      lastRowLeftIdx = 0;
      lastRowRightIdx = lastRowLeftIdx + 1;

      currRowSize = lastRowSize + 1;
      currRow = new ArrayList<>(currRowSize);
      currRowIdx = 0;
      currRowLastIdx = currRowSize - 1;

      currRow.add(currRowIdx, 1);
      currRowIdx++;
      for (; currRowIdx < currRowLastIdx; currRowIdx++) {
        lastRowLeftVal = lastRow.get(lastRowLeftIdx);
        lastRowRightVal = lastRow.get(lastRowRightIdx);

        currRow.add(currRowIdx, lastRowLeftVal + lastRowRightVal);

        lastRowLeftIdx++;
        lastRowRightIdx++;
      }
      currRow.add(currRowLastIdx, 1);

      container.add(currRow);
      lastRow = currRow;
      lastRowSize = currRowSize;
    }

    return container;
  }

 public static List<Integer> getRow(int rowMaxIndex) {
    ArrayList<Integer> container = new ArrayList<>(rowMaxIndex + 1);
    container.add(1);
    if (rowMaxIndex == 0) {
      return container;
    }
    container.add(1);
    if (rowMaxIndex == 1) {
      return container;
    }

    for (int rowIdx = 2; rowIdx <= rowMaxIndex; rowIdx++) {
      int l = container.get(0);
      int r;
      for (int i = 1; i < rowIdx; i++) {
        r = container.get(i);
        container.set(i, l + r);
        l = r;
      }
      container.add(rowIdx, 1);
    }

    return container;
  }

}

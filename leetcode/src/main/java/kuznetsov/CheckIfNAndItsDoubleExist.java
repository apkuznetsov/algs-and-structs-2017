package kuznetsov;

import java.util.HashMap;
import java.util.Map;

// Given an array arr of integers, check if there exists two integers N and M
// such that N is the double of M ( i.e. N = 2 * M).
public class CheckIfNAndItsDoubleExist {

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Boolean> m = new HashMap<>();

        for (int currEl : arr) {
            if (m.containsKey(2 * currEl)) {
                return true;
            } else if ((currEl % 2 == 0)
                    && m.containsKey(currEl / 2)) {
                return true;
            } else {
                m.put(currEl, true);
            }
        }

        return false;
    }
}

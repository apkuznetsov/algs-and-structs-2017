package kuznetsov;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrequentlyOccurringSymbol {
    public char frequentlyOccurringSymbol(String str) {

        Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        char maxSymb = ' ';
        int maxCounter = 0;

        for (char symb : str.toCharArray()) {
            if (map.containsKey(symb)) {
                map.put(symb, map.get(symb) + 1);
            } else {
                map.put(symb, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCounter) {
                maxCounter = entry.getValue();
                maxSymb = entry.getKey();
            }
        }

        return maxSymb;
    }
}
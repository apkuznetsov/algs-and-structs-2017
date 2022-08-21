package kuznetsov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Сгрупипировать слова по общим буквам
//  in: ["eat", "tea", "tan", "ate", "nat", "bat"]
// out: [["ate", "eat", tea"], ["nat", "tan"], ["bat"]]
public class GroupWords {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(
                groupWords(strs)
        );
    }

    public static HashMap<String, ArrayList<String>> groupWords(String[] strs) {
        HashMap<String, ArrayList<String>> m = new LinkedHashMap<>();

        for (String str : strs) {
            String sortedStr = sort(str);
            if (m.containsKey(sortedStr)) {
                ArrayList<String> currList = m.get(sortedStr);
                currList.add(str);
            } else {
                ArrayList<String> newList = new ArrayList<String>();
                newList.add(str);
                m.put(sortedStr, newList);
            }
        }

        return m;
    }

    private static String sort(String str) {
        return Stream.of(str.split(""))
                .sorted()
                .collect(Collectors.joining());
    }
}

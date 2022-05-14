import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Solution {
    public int firstUniqChar(String s) {
        // key - char
        // value - number of occurrences
        Map<Integer, Long> charset = s.chars()
                .boxed()
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        for (int i = 0; i < s.length(); i++) {
            long count = charset.get((int) s.charAt(i));
            if (count == 1) {
                return i;
            }
        }
        return -1;
    }
}
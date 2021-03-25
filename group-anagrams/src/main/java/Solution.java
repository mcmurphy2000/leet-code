import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class AnagramKey {
    private final Map<Character, Long> charCount;

    AnagramKey(String s) {
        charCount = s.chars()
                .mapToObj(c -> (char)c)
                .collect(groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AnagramKey that = (AnagramKey) o;

        return charCount.equals(that.charCount);
    }

    @Override
    public int hashCode() {
        return charCount.hashCode();
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<AnagramKey, List<String>> result = Arrays.stream(strs)
                .collect(groupingBy(AnagramKey::new));
        return new ArrayList<>(result.values());
    }
}
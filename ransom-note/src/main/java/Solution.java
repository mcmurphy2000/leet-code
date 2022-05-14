import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Integer, Long> magSet = magazine.chars()
                .boxed()
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> noteSet = ransomNote.chars()
                .boxed()
                .collect(groupingBy(Function.identity(), Collectors.counting()));
        for (Map.Entry<Integer, Long> entry : noteSet.entrySet()) {
            Long magCount = magSet.get(entry.getKey());
            if (Objects.isNull(magCount) || magCount < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
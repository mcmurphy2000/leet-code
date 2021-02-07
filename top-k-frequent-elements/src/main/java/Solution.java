import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int i : nums) {
            freq.merge(i, 1, Integer::sum);
        }
        return freq.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();

    }
}

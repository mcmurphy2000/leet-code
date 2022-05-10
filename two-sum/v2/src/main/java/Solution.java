import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // key - element
        // value - indicies
        Map<Integer, List<Integer>> elToInd = IntStream.range(0, nums.length)
                .boxed()
                .collect(groupingBy(i -> nums[i], Collectors.toList()));

        for (int i = 0; i < nums.length; i++) {
            int targetEl = target - nums[i];
            Optional<Integer> ind2 = get2ndIndex(i, elToInd.get(targetEl));
            if (ind2.isPresent()) {
                res[0] = i;
                res[1] = ind2.get();
                return res;
            }
        }
        return res;
    }

    private Optional<Integer> get2ndIndex(int disallowedIndex, List<Integer> indList) {
        if (Objects.isNull(indList)) return Optional.empty();
        return indList.stream()
                .filter(i -> i != disallowedIndex)
                .findFirst();
    }
}
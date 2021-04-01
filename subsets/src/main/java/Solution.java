import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }

    private List<List<Integer>> subsets(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == nums.length) {
            result.add(Collections.emptyList());
            return result;
        }
        List<List<Integer>> prev = subsets(nums, index + 1);
        result.addAll(prev);
        prev.forEach(list -> {
            List<Integer> tmp = new ArrayList<>(list);
            tmp.add(nums[index]);
            result.add(tmp);
        });
        return result;
    }
}
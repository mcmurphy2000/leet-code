import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        return permute(nums, 0);
    }

    private List<List<Integer>> permute(int[] nums, int startIndex) {
        List<List<Integer>> result = new ArrayList<>();
        if (startIndex >= nums.length) return result;
        final Integer el = nums[startIndex];
        if (startIndex == nums.length - 1) {
            List<Integer> tmp2 = new LinkedList<>();
            tmp2.add(el);
            result.add(tmp2);
            return result;
        } else {
            List<List<Integer>> list = permute(nums, startIndex + 1);
            for (List<Integer> tmp : list) {
                for (int i = 0; i <= tmp.size(); i++) {
                    LinkedList<Integer> tmp2 = new LinkedList<>(tmp);
                    tmp2.add(i, el);
                    result.add(tmp2);
                }
            }
            return result;
        }
    }
}
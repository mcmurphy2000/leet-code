class Solution {

    // trend from left to right
    private enum Trend {
        ASC, DESC
    }

    public int findPeakElement(int[] nums) {
        return binarySearchPeak(nums, 0, nums.length);
    }

    // ascending trend - search right part for DESC
    // descending trend - search left part
    // from - inclusive
    // to - exclusive
    private int binarySearchPeak(int[] nums, int from, int to) {
        if (to - from == 1) return from;
        int mid = (from + to) / 2;
        switch (getTrend(nums, mid - 1)) {
            case ASC: return binarySearchPeak(nums, mid, to);
            case DESC: return binarySearchPeak(nums, from, mid);
            default: throw new RuntimeException("Illegal state");
        }
    }

    // returns trend (left to right) of index element in comparison to the next element
    // index is always a valid index (always in range)
    // next element always exists (always in range)
    // according to task description nums[i] != nums[i + 1]
    private Trend getTrend(int[] nums, int index) {
        return nums[index] < nums[index + 1] ? Trend.ASC : Trend.DESC;
    }
}
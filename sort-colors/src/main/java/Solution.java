class Solution {
    public void sortColors(int[] nums) {
        int index = quickSort(nums, 0, 1);
        quickSort(nums, index + 1, 2);
    }

    private int quickSort(int[] nums, int fromIndex, int pivot) {
        int i = fromIndex - 1;
        int j = fromIndex;
        while (j < nums.length) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
            j++;
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) return;
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
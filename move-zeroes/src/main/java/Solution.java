class Solution {

    public void moveZeroes(int[] nums) {
        int i = -1;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] != 0) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }

        i++;
        while (i < nums.length)
            nums[i++] = 0;

        /*
        int i = nums.length;
        int j = nums.length - 1;
        while (j >= 0) {
            if (nums[j] == 0) {
                i--;
                bubbleSwap(nums, j, i);
            }
            j--;
        }
         */
    }

    /*
    private void bubbleSwap(int[] nums, int j, int i) {
        while (j < i) {
            swap(nums, j, j+1);
            j++;
        }
    }

    private void swap(int[] nums, int j, int i) {
        if (i != j) {
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
    }
     */
}
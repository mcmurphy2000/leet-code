class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int length = m + n;
        int[] res = new int[length];
        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while (p < length) {
            if (p2 >= n || (nums1[p1] <= nums2[p2] && p1 < m)) {
                res[p++] = nums1[p1++];
            } else {
                res[p++] = nums2[p2++];
            }
        }
        System.arraycopy(res, 0, nums1, 0, length);
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        Comparator<int[]> byStart = Comparator.comparingInt(arr -> arr[0]);
        Comparator<int[]> byLength = Comparator.comparingInt(arr -> arr[1] - arr[0]);
        Comparator<int[]> comparator = byStart.thenComparing(byLength);

        Arrays.sort(intervals, comparator);
        List<int[]> list = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] > end) {
                list.add(new int[] {start, end});
                start = interval[0];
                end = interval[1];
            } else if (interval[1] > end) {
                end = interval[1];
            }
        }
        list.add(new int[] {start, end});
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++)
            result[i] = list.get(i);
        return result;
    }
}
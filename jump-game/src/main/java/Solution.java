import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Deque<Integer> stack = new LinkedList<>();
        stack.push(0);
        visited[0] = true;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (index == nums.length - 1) return true;
            int element = nums[index];

            for (int i = index + 1; i <= index + element; i++)
                if (i < nums.length && !visited[i]) {
                    stack.push(i);
                    visited[i] = true;
                }
        }
        return false;
    }
}
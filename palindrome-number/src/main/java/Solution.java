import java.util.Deque;
import java.util.LinkedList;

public class Solution {

    public boolean isPalindrome(int x) {
        if (x < 0) return false;

        Deque<Integer> digits = new LinkedList<>();
        while (x > 0) {
            int reminder = x % 10;
            digits.add(reminder);
            x /= 10;
        }

        while (!digits.isEmpty()) {
            int last = digits.pollLast();
            Integer first = digits.pollFirst();
            if (first != null && first != last) {
                return false;
            }
        }
        return true;
    }
}

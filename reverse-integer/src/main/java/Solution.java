class Solution {

    public int reverse(int x) {
        int result = 0;
        while (Math.abs(x) > 0) {
            int reminder = x % 10;
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && reminder > 7)) return 0;
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && reminder < -8)) return 0;
            result = result * 10 + reminder;
            x /= 10;
        }
        return result;
    }
}
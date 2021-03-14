class Solution {

    public int numDecodings(String s) {
        char[] chars = s.toCharArray();
        int[] waysCount = new int[chars.length];
        for (int i = chars.length - 1; i >=0; i--) {
            int oneDigit = 0;
            int twoDigits = 0;
            if (isDecodable(chars, i, 1))
                oneDigit = i == chars.length - 1 ? 1 : getWaysCount(waysCount, i + 1);
            if (isDecodable(chars, i, 2))
                twoDigits = i == chars.length - 2 ? 1 : getWaysCount(waysCount, i + 2);
            waysCount[i] = oneDigit + twoDigits;
        }
        return waysCount[0];
    }

    private boolean isDecodable(char[] chars, int index, int digitCount) {
        if (chars[index] == '0') return false;
        int res = Character.getNumericValue(chars[index]);
        if (digitCount == 2) {
            if (index == chars.length - 1) return false;
            res = res * 10 + Character.getNumericValue(chars[index + 1]);
        }
        return res <= 26;
    }

    private int getWaysCount(int[] waysCount, int index) {
        return index >= waysCount.length ? 0 : waysCount[index];
    }
}
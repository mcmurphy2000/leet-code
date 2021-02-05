public class Solution {

    public String longestPalindrome(String s) {
        for (int strLen = s.length(); strLen > 1; strLen--) {
            for (int startIndex = 0; startIndex <= s.length() - strLen; startIndex++) {
                int endIndex = startIndex + strLen;
                if (isPalindrome(s, startIndex, endIndex)) {
                    return s.substring(startIndex, endIndex);
                }
            }

        }
        return s.substring(0, 1);
    }

    // endIndex exclusive
    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        endIndex--;
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }
}

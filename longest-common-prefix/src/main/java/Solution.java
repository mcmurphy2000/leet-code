class Solution {

    public String longestCommonPrefix(String[] strs) {
        var sb = new StringBuilder();
        int pos = 0;
        while (true) {
            if (pos >= strs[0].length()) break;
            char ch = strs[0].charAt(pos);
            boolean identical = true;
            for (String s : strs) {
                if (pos >= s.length() || s.charAt(pos) != ch) {
                    identical = false;
                    break;
                }
            }
            if (identical) {
                sb.append(ch);
                pos++;
            } else
                break;
        }
        return sb.toString();
    }
}
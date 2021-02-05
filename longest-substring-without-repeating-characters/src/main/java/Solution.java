import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndex = new HashMap<>();

        // char with index = i + 1 is the 1st char of non-repeating string
        int i = -1;
        int maxStr = 0;
        for (int j = 0; j < s.length(); j++) {
            Integer lastSeen = lastIndex.get(s.charAt(j));
            if (lastSeen != null && lastSeen > i) {
                i = lastSeen;
            }
            maxStr = Math.max(maxStr, j - i);
            lastIndex.put(s.charAt(j), j);
        }
        return maxStr;
    }
}

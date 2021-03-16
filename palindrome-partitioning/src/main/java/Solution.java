import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> partition(String s) {
        Map<Integer, List<List<String>>> cache = new HashMap<>();
        return partition(s, 0, cache);
    }

    private List<List<String>> partition(String s, int startIndex, Map<Integer, List<List<String>>> cache) {
        List<List<String>> cached = cache.get(startIndex);
        if (cached != null) return cached;
        List<List<String>> resList = new LinkedList<>();
        int index = startIndex + 1;
        while (index <= s.length()) {
            String substr = s.substring(startIndex, index);
            if (isPalindrome(substr)) {
                List<List<String>> list = partition(s, index, cache);
                if (list.size() == 0) {
                    List<String> tmp = new LinkedList<>();
                    tmp.add(substr);
                    resList.add(tmp);
                } else {
                    list.forEach(subList -> {
                        LinkedList<String> ll = new LinkedList<>(subList);
                        ll.addFirst(substr);
                        resList.add(ll);
                    });
                }
            }
            index++;
        }
        cache.put(startIndex, resList);
        return resList;
    }

    private boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}
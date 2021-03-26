import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

class Solution {
    public List<String> letterCombinations(String digits) {
        final Map<Integer, List<Character>> digitsMapping = new HashMap<>(8);
        digitsMapping.put(2, Arrays.asList('a', 'b', 'c'));
        digitsMapping.put(3, Arrays.asList('d', 'e', 'f'));
        digitsMapping.put(4, Arrays.asList('g', 'h', 'i'));
        digitsMapping.put(5, Arrays.asList('j', 'k', 'l'));
        digitsMapping.put(6, Arrays.asList('m', 'n', 'o'));
        digitsMapping.put(7, Arrays.asList('p', 'q', 'r', 's'));
        digitsMapping.put(8, Arrays.asList('t', 'u', 'v'));
        digitsMapping.put(9, Arrays.asList('w', 'x', 'y', 'z'));
        return letterCombinations(digits, 0, digitsMapping).stream()
                .map(list -> list.stream().map(String::valueOf).collect(Collectors.joining()))
                .collect(toList());
    }

    List<List<Character>> letterCombinations(String digits, int startIndex, Map<Integer, List<Character>> digitsMapping) {
        final List<List<Character>> result = new ArrayList<>();
        if (startIndex >= digits.length()) return result;

        List<Character> chrs = digitsMapping.get(Character.getNumericValue(digits.charAt(startIndex)));

        List<List<Character>> strings = letterCombinations(digits, startIndex + 1, digitsMapping);
        if (strings.size() == 0) {
            chrs.forEach(c -> {
                List<Character> tmp = new ArrayList<>();
                tmp.add(c);
                result.add(tmp);
            });
        } else {
            for (Character c : chrs)
                for (List<Character> string : strings) {
                    List<Character> tmp = new ArrayList<>(string.size() + 1);
                    tmp.add(c);
                    tmp.addAll(string);
                    result.add(tmp);
                }
        }
        return result;
    }
}
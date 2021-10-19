import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {

    private final List<Character> openingList = List.of('(', '{', '[');
    private final List<Character> closingList = List.of(')', '}', ']');
    private final Set<Character> openingSet = new HashSet<>(openingList);

    public boolean isValid(String s) {
        final var stack = new LinkedList<Character>();
        for (var c : s.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isClosingFor(c, stack.peek()))
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpening(char c) {
        return openingSet.contains(c);
    }

    private boolean isClosingFor(Character c, Character openingChar) {
        if (isOpening(c))
            return false;
        return closingList.indexOf(c) == openingList.indexOf(openingChar);
    }
}
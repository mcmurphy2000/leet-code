import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (char ch : s.toCharArray()) {
            if (isOpening(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty() || !isMatch(stack.pop(), ch)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean isOpening(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private boolean isMatch(char opening, char closing) {
        switch (closing) {
            case ')':
                return opening == '(';
            case '}':
                return opening == '{';
            case ']':
                return opening == '[';
        }
        return false;
    }
}
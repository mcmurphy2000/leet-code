import java.util.Objects;

// from - inclusive
// to - exclusive
class Pair {
    final int from;
    final int to;

    public Pair(int from, int to) {
        this.from = from;
        this.to = to;
    }

    int length() {
        return to - from;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return from == pair.from &&
                to == pair.to;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}

class Solution {
    public int minimumLength(String s) {
        Pair newPair = new Pair(0, s.length());
        Pair pair;
        do {
            pair = newPair;
            newPair = trimEqualSuffixAndPrefix(s, pair);
        } while (!newPair.equals(pair));
        return newPair.length();
    }

    private Pair trimEqualSuffixAndPrefix(String s, Pair pair) {
        int i = pair.from;
        int j = pair.to;
        if (i >= s.length() || i >= j || pair.length() == 1 || s.charAt(i) != s.charAt(j - 1)) return pair;
        char c = s.charAt(i);
        while (i < j && s.charAt(i) == c)
            i++;
        while (j > i && s.charAt(j - 1) == c)
            j--;
        return new Pair(i, j);
    }
}
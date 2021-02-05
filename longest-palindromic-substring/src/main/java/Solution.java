class PalLength implements Comparable<PalLength> {
    final int startIndex;
    final int length;

    public PalLength(int startIndex, int length) {
        this.startIndex = startIndex;
        this.length = length;
    }

    @Override
    public int compareTo(PalLength other) {
        return this.length - other.length;
    }
}

public class Solution {

    public String longestPalindrome(String s) {
        PalLength longest = new PalLength(0, 1);
        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            PalLength lengthOdd = palindromeLength(s, startIndex, startIndex + 1);
            PalLength lengthEven = palindromeLength(s, startIndex, startIndex + 2);
            if (lengthOdd != null && lengthOdd.compareTo(longest) > 0) {
                longest = lengthOdd;
            }
            if (lengthEven != null && lengthEven.compareTo(longest) > 0) {
                longest = lengthEven;
            }
        }
        return s.substring(longest.startIndex, longest.startIndex + longest.length);
    }

    // endIndex exclusive
    private PalLength palindromeLength(String s, int startIndex, int endIndex) {
        if (startIndex < 0 || endIndex > s.length()) return null;
        if (s.charAt(startIndex) != s.charAt(endIndex - 1)) return null;
        PalLength thisLength = new PalLength(startIndex, endIndex - startIndex);
        PalLength biggerLength = palindromeLength(s, startIndex - 1, endIndex + 1);
        if (biggerLength == null || thisLength.compareTo(biggerLength) >= 0) {
            return thisLength;
        } else {
            return biggerLength;
        }
    }
}

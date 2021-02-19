import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

class Solution {

    public String largestNumber(int[] nums) {
        boolean onlyZeros = !Arrays.stream(nums)
                .filter(i -> i != 0)
                .findAny()
                .isPresent();
        if (onlyZeros) return "0";
        Comparator<Integer> comparator = (val1, val2) -> {
            int i1 = val1;
            int i2 = val2;
            int digits1 = numberOfDigits(i1);
            int digits2 = numberOfDigits(i2);
            int int1;
            int int2;
            if (digits1 < digits2) {
                int1 = upfill(i1, i2, digits1, digits2);
                int2 = i2;
            } else if (digits1 > digits2) {
                int1 = i1;
                int2 = upfill(i2, i1, digits2, digits1);
            } else {
                int1 = i1;
                int2 = i2;
            }
            int result = Integer.compare(int2, int1);
            if (result != 0)
                return result;
            else {
                long l1 = i1 * (long)Math.pow(10, digits2) + i2;
                long l2 = i2 * (long)Math.pow(10, digits1) + i1;
                return Long.compare(l2, l1);
            }
        };

        return Arrays.stream(nums)
                .boxed()
                .sorted(comparator)
                .map(Object::toString)
                .collect(Collectors.joining());
    }

    private int numberOfDigits(int number) {
        int length = 1;
        if (number >= 100000000) {
            length += 8;
            number /= 100000000;
        }
        if (number >= 10000) {
            length += 4;
            number /= 10000;
        }
        if (number >= 100) {
            length += 2;
            number /= 100;
        }
        if (number >= 10) {
            length += 1;
        }
        return length;
    }

    // i always has smaller number of digits than withInt
    private int upfill(int i, int withInt, int digits1, int digits2) {
        int diff = digits2 - digits1;
        int firstNDigits = withInt / (int)Math.pow(10, digits1);
        return i * (int)Math.pow(10, diff) + firstNDigits;
    }
}
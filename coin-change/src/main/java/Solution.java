import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.OptionalInt;

class Solution {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Map<Integer, Integer> cache = new HashMap<>();
        int minWays = minWays(amount, coins, cache);
        return minWays == 0 ? -1 : minWays;
    }

    private int minWays(int amount, int[] coins, Map<Integer, Integer> cache) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        Integer minWays = cache.get(amount);
        if (minWays != null) return minWays;
        OptionalInt min = Arrays.stream(coins)
                .map(coin -> minWays(amount - coin, coins, cache))
                .filter(ways -> ways >= 0)
                .min();
        if (min.isPresent()) {
            cache.put(amount, min.getAsInt() + 1);
            return min.getAsInt() + 1;
        } else
            return -1;
    }
}
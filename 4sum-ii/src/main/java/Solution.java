import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        /*
        // key - number
        // value - number of indicies
        Map<Integer, Long> aMap = Arrays.stream(A)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> bMap = Arrays.stream(B)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> cMap = Arrays.stream(C)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Integer, Long> dMap = Arrays.stream(D)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int count = 0;
        for (Map.Entry<Integer, Long> a : aMap.entrySet()) {
            for (Map.Entry<Integer, Long> b : bMap.entrySet()) {
                for (Map.Entry<Integer, Long> c : cMap.entrySet()) {
                    int target = - (a.getKey() + b.getKey() + c.getKey());
                    Long dCount = dMap.get(target);
                    if (dCount != null) {
                        count += a.getValue() * b.getValue() * c.getValue() * dCount.intValue();
                    }
                }
            }
        }
        return count;
         */

        Map<Integer, Integer> ab = sumsMap(A, B);
        Map<Integer, Integer> cd = sumsMap(C, D);
        int count = 0;
        for (Map.Entry<Integer, Integer> abEntry : ab.entrySet()) {
            int targetSum = - abEntry.getKey();
            Integer cdCount = cd.get(targetSum);
            if (cdCount != null) {
                count += cdCount * abEntry.getValue();
            }
        }
        return count;
    }

    // key - sum
    // value - number of times encountered
    Map<Integer, Integer> sumsMap(int[] xArr, int[] yArr) {
        Map<Integer, Integer> result = new HashMap<>();
        for (int x : xArr) {
            for (int y : yArr) {
                result.merge(x + y, 1, Integer::sum);
            }
        }
        return result;
    }
}

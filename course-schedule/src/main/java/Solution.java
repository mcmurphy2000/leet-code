import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class CyclicGraphException extends Exception {}

/**
 * DFS Pseudocode
 * dfs(node)
 *      node.inRecursion = true
 *      for child : node.children
 *          if child.inRecursion trow Cyclic
 *          if !child.visited
 *              dfs(g, child)
 *      node.inRecursion = false
 *      node.visited = true
 *
 * call dfs for all unvisited nodes
 */

class Graph {
    // key - 0-based nodeId
    private final Map<Integer, Set<Integer>> idToChildren;
    private final boolean[] visited;
    private final boolean[] inRecusrion;

    public Graph(int numCourses, int[][] prerequisites) {
        visited = new boolean[numCourses];
        inRecusrion = new boolean[numCourses];
        idToChildren = Arrays.stream(prerequisites)
                .parallel()
                .collect(
                        HashMap::new,
                        (map, pair) -> map.computeIfAbsent(pair[1], k -> new HashSet<>()).add(pair[0]),
                        (map1, map2) -> map2.forEach((key, set) ->
                                map1.merge(key, set, (set1, set2) -> {
                                    set1.addAll(set2);
                                    return set1;
                                })
                        )

                );
//                .collect(toMap(
//                        pair -> pair[1],
//                        pair -> {
//                            Set<Integer> set = new HashSet<>();
//                            set.add(pair[0]);
//                            return set;
//                        },
//                        (set1, set2) -> { set1.addAll(set2); return set1; }
//                ));
    }

    private void dfs(int nodeId) throws CyclicGraphException {
        inRecusrion[nodeId] = true;
        Set<Integer> childIds = idToChildren.get(nodeId);
        if (childIds != null)
            for (int childId : idToChildren.get(nodeId)) {
                if (inRecusrion[childId]) throw new CyclicGraphException();
                if (!visited[childId])
                    dfs(childId);
            }
        inRecusrion[nodeId] = false;
        visited[nodeId] = true;
    }

    public boolean canFinish() {
        try {
            for (int nodeId = 0; nodeId < visited.length; nodeId++)
                if (!visited[nodeId])
                    dfs(nodeId);
        } catch (CyclicGraphException e) {
            return false;
        }
        return true;
    }
}

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph(numCourses, prerequisites);
        return graph.canFinish();
    }
}
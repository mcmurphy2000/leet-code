import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

enum NodeState {
    UNVISITED, IN_RECURSION, VISITED
}

class CyclicGraphException extends RuntimeException {}

class Node {
    private final int value;
    private final List<Node> children = new ArrayList<>();
    private final List<List<Integer>> paths = new ArrayList<>();
    private NodeState state = NodeState.UNVISITED;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public List<Node> getChildren() {
        return children;
    }

    public List<List<Integer>> getPaths() {
        return paths;
    }

    public NodeState getState() {
        return state;
    }

    public void setState(NodeState state) {
        this.state = state;
    }

    void addChild(Node child) {
        children.add(Objects.requireNonNull(child));
    }

    public void addPath(List<Integer> path) {
        paths.add(Objects.requireNonNull(path));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        return value == node.value;
    }

    @Override
    public int hashCode() {
        return value;
    }
}

class Graph {
    // key == nodeValue == id
    private final Map<Integer, Node> nodes;

    Graph(int[][] graph) {
        nodes = IntStream.range(0, graph.length)
                .boxed()
                .collect(toMap(Function.identity(), Node::new));
        for (int i = 0; i < graph.length; i++) {
            Node parent = nodes.get(i);
            int[] childArr = graph[i];
            Arrays.stream(childArr).forEach(child -> parent.addChild(nodes.get(child)));
        }
    }

    List<List<Integer>> getsPaths() throws CyclicGraphException {
        return dfs(nodes.get(0), nodes.get(nodes.size() - 1));
    }

    private List<List<Integer>> dfs(Node node, Node target) throws CyclicGraphException {
        if (node.getState() == NodeState.IN_RECURSION) throw new CyclicGraphException();
        if (node.getState() == NodeState.VISITED)
            return node.getPaths();
        if (node.equals(target)) {
            node.addPath(Collections.singletonList(node.getValue()));
        } else {
            node.setState(NodeState.IN_RECURSION);
            for (Node child : node.getChildren()) {
                List<List<Integer>> pathsFromChild = dfs(child, target);
                pathsFromChild.forEach(list -> {
                    List<Integer> tmp = new ArrayList<>(list.size() + 1);
                    tmp.add(node.getValue());
                    tmp.addAll(list);
                    node.addPath(tmp);
                });
            }
        }
        node.setState(NodeState.VISITED);
        return node.getPaths();
    }
}

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        Graph graph1 = new Graph(graph);
        return graph1.getsPaths();
    }
}
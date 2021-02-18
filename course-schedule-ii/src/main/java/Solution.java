import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.stream.IntStream;

class CyclicGraph extends RuntimeException {}

/**
 * DFS Pseudocode
 * let stack be final order
 * dfs(node)
 * 	    node.inRecursion = true;
 * 	    for all children of node
 * 		    if child.inRecursiveStack throw CyclicGraph
 * 		    if !child.visited dfs(child)
 * 		node.inRecursion = false;
 * 	    node.visited = true
 * 	    stack.add(node)
 *
 * call dfs for all unvisited nodes
 */

class Node {
    private final int id;
    private final Set<Node> adjacents = new HashSet<>();
    boolean visited = false;
    boolean inRecursion = false;

    public Node(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    void addAdjacent(Node child) {
        adjacents.add(child);
    }

    Set<Node> getAdjacents() {
        return Collections.unmodifiableSet(adjacents);
    }
}

class Graph {
    // key - node id
    private final Map<Integer, Node> nodes = new HashMap<>();

    void addNode(int id) {
        nodes.put(id, new Node(id));
    }

    Node getNode(int id) {
        return nodes.get(id);
    }

    Collection<Node> getNodes() {
        return Collections.unmodifiableCollection(nodes.values());
    }
}

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Graph graph = new Graph();
        IntStream.range(0, numCourses).forEach(graph::addNode);
        Arrays.stream(prerequisites).forEach(pair -> {
            Node parent = graph.getNode(pair[1]);
            parent.addAdjacent(graph.getNode(pair[0]));
        });

        Deque<Node> stack = new LinkedList<>();
        try {
            graph.getNodes().stream()
                    .filter(node -> !node.visited)
                    .forEach(node -> dfs(node, stack));
        } catch (CyclicGraph e) {
            return new int[0];
        }
        return stack.stream()
                .mapToInt(Node::getId)
                .toArray();
    }

    void dfs(Node node, Deque<Node> outputStack) {
        node.inRecursion = true;
        for (Node child : node.getAdjacents()) {
            if (child.inRecursion) throw new CyclicGraph();
            if (!child.visited) dfs(child, outputStack);
        }
        node.inRecursion = false;
        node.visited = true;
        outputStack.push(node);
    }
}
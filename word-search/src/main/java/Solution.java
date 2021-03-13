import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;

import static java.util.stream.Collectors.toList;

class Node {
    final int id;
    final char value;
    final List<Node> children = new ArrayList<>();

    public Node(int id, char value) {
        this.id = id;
        this.value = value;
    }
}

class Graph {
    private final Map<Integer, Node> map = new HashMap<>();

    void addNode(int id, char value) {
        map.put(id, new Node(id, value));
    }

    void addChild(int parentId, int childId) {
        Node node = map.get(parentId);
        node.children.add(map.get(childId));
    }

    List<Node> getNodes(char value) {
        return map.values().stream()
                .filter(node -> node.value == value)
                .collect(toList());
    }
}

class FlatMatrix {
    final int rows, columns;
    FlatMatrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
    }

    int indexFrom(int row, int col) {
        return row * columns + col;
    }

    void executeIfValid(int row, int col, Consumer<Integer> consumer) {
        if (row >= 0 && col >= 0 && row < rows && col < columns) {
            int childId = indexFrom(row, col);
            consumer.accept(childId);
        }
    }
}

class Solution {

    boolean dfsRecursive(Node node, Set<Node> visited, int depth, char[] word) {
        visited.add(node);
        if (node.value != word[depth]) return false;
        if (depth == word.length - 1) return true;
        for (Node child : node.children)
            if (!visited.contains(child))
                if (dfsRecursive(child, new HashSet<>(visited), depth + 1, word))
                    return true;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return false;
        Graph graph = new Graph();
        FlatMatrix mtx = new FlatMatrix(board.length, board[0].length);
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++) {
                graph.addNode(mtx.indexFrom(row, col), board[row][col]);
            }
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++) {
                int parentId = mtx.indexFrom(row, col);
                mtx.executeIfValid(row - 1, col, childId -> graph.addChild(parentId, childId));
                mtx.executeIfValid(row + 1, col, childId -> graph.addChild(parentId, childId));
                mtx.executeIfValid(row, col - 1, childId -> graph.addChild(parentId, childId));
                mtx.executeIfValid(row, col + 1, childId -> graph.addChild(parentId, childId));
            }

        char[] targetWord = word.toCharArray();
        List<Node> nodes = graph.getNodes(targetWord[0]);
        for (Node node : nodes) {
            if (dfsRecursive(node, new HashSet<>(), 0, targetWord))
                return true;
        }
        return false;
    }
}
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

// id is a 0-based index
class Graph {

    private final char[][] board;
    private final int rows;
    private final int cols;
    private final boolean[] visited;


    public Graph(char[][] board) {
        rows = board.length;
        cols = rows == 0 ? 0 : board[0].length;
        visited = new boolean[rows * cols];
        this.board = board;
    }

    // returns ids of nodes which have value O in the board
    public List<Integer> getONodeIds() {
        int maxId = rows * cols;
        return IntStream.range(0, maxId)
                .filter(this::isAnO)
                .boxed()
                .collect(toList());
    }

    private List<Integer> getChildrenIds(int id) {
        List<Integer> children = new ArrayList<>(4);
        int row = rowFromId(id);
        int col = colFromId(id);
        addIfValidChild(children, row - 1, col);
        addIfValidChild(children, row + 1, col);
        addIfValidChild(children, row, col - 1);
        addIfValidChild(children, row, col + 1);
        return children;
    }

    private void addIfValidChild(List<Integer> children, int row, int col) {
        int id = toId(row, col);
        if (id != -1 && isAnO(id))
            children.add(id);
    }

    private boolean isOnBorder(int id) {
        int row = rowFromId(id);
        int col = colFromId(id);
        return row == 0 || row == rows - 1 || col == 0 || col == cols - 1;
    }

    public boolean isUnvisited(int id) {
        return !visited[id];
    }

    private void setVisited(int id) {
        visited[id] = true;
    }

    private void setX(List<Integer> ids) {
        ids.forEach(id -> board[rowFromId(id)][colFromId(id)] = 'X');
    }

    // 0 - based id
    // 0 - based row
    private int rowFromId(int id) {
        return id / cols;
    }

    // 0 - based id
    // 0 - based col
    private int colFromId(int id) {
        return id % cols;
    }

    // returns 0 - based id
    // returns -1 if row or col is invalid
    private int toId(int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols ?
            -1 : row * cols + col;
    }

    // returns true if the value of this item in the board is O
    // id is 0-based
    public boolean isAnO(int id) {
        return board[rowFromId(id)][colFromId(id)] == 'O';
    }

    // performs BFS starting from startNodeId and flips all O nodes to X if the discovered region does not touch border
    public void bfsFlip(int startNodeId) {
        final Queue<Integer> queue = new LinkedList<>();
        final List<Integer> region = new ArrayList<>();
        boolean shouldFlip = true;
        setVisited(startNodeId);
        queue.add(startNodeId);
        region.add(startNodeId);
        while (!queue.isEmpty()) {
            Integer id = queue.poll();
            if (isOnBorder(id))
                shouldFlip = false;
            for (int childId : getChildrenIds(id)) {
                if (isUnvisited(childId)) {
                    setVisited(childId);
                    queue.add(childId);
                    region.add(childId);
                }
            }
        }
        if (shouldFlip)
            setX(region);
    }
}

class Solution {
    public void solve(char[][] board) {
        Graph graph = new Graph(board);
        graph.getONodeIds().stream()
                .mapToInt(Integer::intValue)
                .filter(graph::isAnO)
                .filter(graph::isUnvisited)
                .forEach(graph::bfsFlip);
    }
}
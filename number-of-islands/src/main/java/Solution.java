import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Node {
    private final boolean land;
    private final List<Node> children = new ArrayList<>();
    private boolean visited = false;

    public Node(boolean land) {
        this.land = land;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public List<Node> getChildren() {
        return children;
    }

    public boolean isLand() {
        return land;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}

class Graph {
    private final int rows;
    private final int cols;
    private final Map<Integer, Node> nodeMap = new HashMap<>();

    public Graph(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    void addNode(int id, boolean land) {
        nodeMap.put(id, new Node(land));
    }

    private void addChild(int parentId, int childId) {
        Node parent = nodeMap.get(parentId);
        Node child = nodeMap.get(childId);
        parent.addChild(child);
    }

    Collection<Node> getNodes() {
        return nodeMap.values();
    }

    int getIndex(int row, int col) {
        return row < 0 || row >= rows || col < 0 || col >= cols ? -1 : row * cols + col;
    }

    void addChildIfLand(int parentId, int row, int col) {
        int childId = getIndex(row, col);
        Node child = nodeMap.get(childId);
        if (child != null && child.isLand())
            addChild(parentId, childId);
    }

    void bfs(Node startNode) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        startNode.setVisited(true);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            node.getChildren().stream()
                    .filter(child -> !child.isVisited())
                    .forEach(child -> {
                        queue.add(child);
                        child.setVisited(true);
                    });
        }
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0) return 0;
        if (grid[0].length == 0) return 0;
        Graph graph = createFromGrid(grid);
        int islandCount = 0;
        for (Node node : graph.getNodes()) {
            if (node.isLand() && !node.isVisited()) {
                graph.bfs(node);
                islandCount++;
            }
        }
        return islandCount;
    }

    private Graph createFromGrid(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Graph graph = new Graph(rows, cols);
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++)
                graph.addNode(graph.getIndex(row, col), grid[row][col] == '1');
        for (int row = 0; row < rows; row++)
            for (int col = 0; col < cols; col++) {
                int parentId = graph.getIndex(row, col);
                graph.addChildIfLand(parentId, row - 1, col);
                graph.addChildIfLand(parentId, row + 1, col);
                graph.addChildIfLand(parentId, row, col - 1);
                graph.addChildIfLand(parentId, row, col + 1);
            }
        return graph;
    }

}
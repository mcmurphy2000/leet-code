class Visit {
    int k;
    int current;
    int value;

    public Visit(int k, int current) {
        this.k = k;
        this.current = current;
    }
}

public class Solution {

    public int kthSmallest(TreeNode root, int k) {
        Visit visit = new Visit(k, 0);
        traverseInOrder(root, visit);
        return visit.value;
    }

    private void traverseInOrder(TreeNode node, Visit visit) {
        if (node == null || visit.current == visit.k) return;
        traverseInOrder(node.left, visit);
        if (visit.current < visit.k) {
            visit.value = node.val;
            visit.current++;
            traverseInOrder(node.right, visit);
        }
    }
}

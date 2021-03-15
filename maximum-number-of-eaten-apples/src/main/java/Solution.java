import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Node {
    private int appleCount;
    private final int expiryDay;

    public Node(int appleCount, int expiryDay) {
        this.appleCount = appleCount;
        this.expiryDay = expiryDay;
    }

    public boolean hasApples() {
        return appleCount > 0;
    }

    public void eatOneApple() {
        if (hasApples()) {
            appleCount--;
        } else {
            throw new RuntimeException("Out of apples");
        }
    }

    public boolean isExpired(int currentDay) {
        return currentDay >= expiryDay;
    }

    public int getExpiryDay() {
        return expiryDay;
    }
}


class Solution {
    public int eatenApples(int[] apples, int[] days) {
        Comparator<Node> comparator = Comparator.comparingInt(Node::getExpiryDay);
        Queue<Node> queue = new PriorityQueue<>(comparator);

        int dayNo = 0;
        int applesEaten = 0;

        do {
            if (dayNo < apples.length) {
                queue.add(new Node(apples[dayNo], dayNo + days[dayNo]));
            }
            removeEmptyOrExpiredNodes(queue, dayNo);
            if (!queue.isEmpty()) {
                queue.peek().eatOneApple();
                applesEaten++;
            }
            dayNo++;
        } while (!queue.isEmpty() || dayNo < apples.length);
        return applesEaten;
    }

    // keep removing top of the queue until there is unexpired Node with appleCount >0
    private void removeEmptyOrExpiredNodes(Queue<Node> queue, int dayNo) {
        while (!queue.isEmpty() && (queue.peek().isExpired(dayNo) || !queue.peek().hasApples()))
            queue.poll();
    }
}
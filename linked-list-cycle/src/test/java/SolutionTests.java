import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        int pos = 1;
        ListNode head = getHead(pos, 3,2,0,-4);
        boolean expected = true;

        assertEquals(expected, tested.hasCycle(head));
    }

    @Test
    public void shouldWork2() {
        int pos = 0;
        ListNode head = getHead(pos, 1,2);
        boolean expected = true;

        assertEquals(expected, tested.hasCycle(head));
    }

    @Test
    public void shouldWork3() {
        int pos = -1;
        ListNode head = getHead(pos, 1);
        boolean expected = false;

        assertEquals(expected, tested.hasCycle(head));
    }

    private ListNode getHead(int pos, int... arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        ListNode cur;
        ListNode cycled = null;
        if (pos == 0) cycled = head;
        for (int i = 1; i < arr.length; i++) {
            cur = new ListNode(arr[i]);
            if (i == pos) cycled = cur;
            prev.next = cur;
            prev = cur;
        }
        if (cycled != null) {
            prev.next = cycled;
        }
        return head;
    }
}

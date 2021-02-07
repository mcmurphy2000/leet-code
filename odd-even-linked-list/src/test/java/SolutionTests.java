import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class SolutionTests {

    private final Solution tested = new Solution();

    @Test
    public void shouldWork() {
        ListNode head = getHead(1, 2, 3, 4, 5);
        head = tested.oddEvenList(head);

        assertEquals(Arrays.asList(1, 3, 5, 2, 4), tested.toList(head));
    }

    @Test
    public void shouldWork2() {
        ListNode head = getHead(2, 1, 3, 5, 6, 4, 7);
        head = tested.oddEvenList(head);

        assertEquals(Arrays.asList(2, 3, 6, 7, 1, 5, 4), tested.toList(head));
    }

    @Test
    public void shouldWork3() {
        ListNode head = getHead();
        head = tested.oddEvenList(head);

        assertEquals(null, head);
    }

    @Test
    public void shouldWork4() {
        ListNode head = getHead(1);
        head = tested.oddEvenList(head);


        assertEquals(Arrays.asList(1), tested.toList(head));
    }

    private ListNode getHead(int... arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;
        ListNode cur;
        for (int i = 1; i < arr.length; i++) {
            cur = new ListNode(arr[i]);
            prev.next = cur;
            prev = cur;
        }
        return head;
    }
}

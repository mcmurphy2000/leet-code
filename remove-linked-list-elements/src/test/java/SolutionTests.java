import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTests {

    private Solution tested = new Solution();

    @Test
    public void shouldWork1() {
        ListNode head = buildLinkedList(new int[] {1,2,6,3,4,5,6});
        int val = 6;
        ListNode expected = buildLinkedList(new int[] {1,2,3,4,5});

        ListNode result = tested.removeElements(head, val);

        assertTrue(equals(expected, result));
    }

    @Test
    public void shouldWork2() {
        ListNode head = buildLinkedList(new int[] {});
        int val = 1;
        ListNode expected = buildLinkedList(new int[] {});

        ListNode result = tested.removeElements(head, val);

        assertTrue(equals(expected, result));
    }

    @Test
    public void shouldWork3() {
        ListNode head = buildLinkedList(new int[] {7,7,7,7});
        int val = 7;
        ListNode expected = buildLinkedList(new int[] {});

        ListNode result = tested.removeElements(head, val);

        assertTrue(equals(expected, result));
    }

    private ListNode buildLinkedList(int[] arr) {
        ListNode next = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            next = new ListNode(arr[i], next);
        }
        return next;
    }

    private boolean equals(ListNode list1, ListNode list2) {
        if (list1 == list2) return true;
        while (list1 != null && list1.hasNext() && list2 != null && list2.hasNext() && list1.val == list2.val) {
            list1 = list1.next;
            list2 = list2.next;
        }
        if (list1 == null || list2 == null || list1.val != list2.val || list1.hasNext() || list2.hasNext())
            return false;
        return true;
    }
}

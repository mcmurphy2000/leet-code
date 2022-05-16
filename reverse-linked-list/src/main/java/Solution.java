public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode head) {
        if (head == null) return prev;
        ListNode next = head.next;
        head.next = prev;
        return reverse(head, next);
    }
}

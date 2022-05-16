public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head.val == val) {
            head = head.next;
            if (head == null) return null;
        }
        head.next = removeElements(head.next, val);
        return head;
    }
}

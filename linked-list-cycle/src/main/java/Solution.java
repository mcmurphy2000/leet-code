public class Solution {

    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null) {
            if (p2 != null)
                p2 = p2.next;
            if (p2 == p1) return true;
            if (p2 != null)
                p2 = p2.next;
            if (p2 == p1) return true;

            p1 = p1.next;
        }
        return false;
    }
}

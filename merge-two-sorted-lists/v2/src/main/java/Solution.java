import java.util.Objects;

/**
 * Definition for singly-linked list.
 */
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    boolean hasNext() { return Objects.nonNull(next); }
 }

public class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val < list2.val) {
            ListNode node = new ListNode(list1.val);
            node.next = mergeTwoLists(list1.next, list2);
            return node;
        } else {
            ListNode node = new ListNode(list2.val);
            node.next = mergeTwoLists(list1, list2.next);
            return node;
        }
    }
}
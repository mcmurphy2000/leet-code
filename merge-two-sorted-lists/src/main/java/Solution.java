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
        ListNode head = null;
        ListNode cur = null;
        while (list1 != null || list2 != null) {
            if (list1 != null) {
                if (list2 != null) {
                    //advance smallest
                    ListNode smallest;
                    if (list1.val < list2.val) {
                        smallest = list1;
                        list1 = list1.next;
                    } else {
                        smallest = list2;
                        list2 = list2.next;
                    }
                    if (head == null) {
                        head = smallest;
                        cur = smallest;
                        continue;
                    }
                    cur.next = smallest;
                    cur = smallest;
                    //list1 = list1.next;
                } else {
                    //advance list1
                    if (head == null) {
                        head = list1;
                        cur = list1;
                        list1 = list1.next;
                        continue;
                    }
                    cur.next = list1;
                    cur = list1;
                    list1 = list1.next;
                }
            } else {
                //advance list2
                if (head == null) {
                    head = list2;
                    cur = list2;
                    list2 = list2.next;
                    continue;
                }
                cur.next = list2;
                cur = list2;
                list2 = list2.next;
            }
        }
        return head;
    }
}
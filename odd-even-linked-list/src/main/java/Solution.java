import java.util.LinkedList;
import java.util.List;

public class Solution {

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = evenHead;
        ListNode nextOdd = odd;
        ListNode nextEven = even;
        while (nextOdd != null || nextEven != null) {
            nextOdd = nextNext(odd);
            nextEven = nextNext(even);
            odd.next = nextOdd;
            if (even != null) {
                even.next = nextEven;
            }
            if (nextOdd != null) {
                odd = nextOdd;
            }
            if (nextEven != null) {
                even = nextEven;
            }
        }
        odd.next = evenHead;
        return head;
    }

    /**
     * Makes each node point to next.next node
     *
     * @param node to start from
     * @return the last node of the list
     */
    private ListNode makeSparseList(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            cur = nextNext(node);
            node.next = cur;
            if (cur != null) {
                node = cur;
            }
        }
        return node;
    }

    private ListNode nextNext(ListNode node) {
        if (node != null && node.next != null && node.next.next != null) {
            return node.next.next;
        } else {
            return null;
        }
    }

    public List<Integer> toList(ListNode head) {
        List<Integer> list = new LinkedList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return list;
    }
}

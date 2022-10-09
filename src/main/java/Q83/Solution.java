package Q83;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode point = head;
        while (point.next != null) {
            ListNode next = point.next;
            if (point.val == next.val) {
                point.next = next.next;
            } else {
                point = point.next;
            }
        }
        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
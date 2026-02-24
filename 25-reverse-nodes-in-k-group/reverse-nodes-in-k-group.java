class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k < 2)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode tail = dummy;
        ListNode temp;
        int count;

        while (true) {
            count = k;

            // Move tail k steps forward
            while (count > 0 && tail != null) {
                tail = tail.next;
                count--;
            }

            // Not enough nodes left
            if (tail == null)
                break;

            head = prev.next; // start of group

            // Reverse nodes in current k-group
            while (prev.next != tail) {
                temp = prev.next;
                prev.next = temp.next;

                temp.next = tail.next;
                tail.next = temp;
            }

            // Move prev and tail forward
            prev = head;
            tail = head;
        }

        return dummy.next;
    }
}
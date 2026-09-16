package blind75;

public class RemoveNthFromEnd {

    static class ListNode {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode sentinel = new ListNode(0);   // sits before head
        sentinel.next = head;

        ListNode fast = sentinel;
        ListNode slow = sentinel;

        // Move fast n steps ahead, so there's a gap of n between fast and slow.
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both together until fast is the last node.
        // slow then lands on the node just BEFORE the target.
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;   // unlink the target (mutate the field!)
        return sentinel.next;         // real head, even if the old head was removed
    }

    // ---- helpers ----

    static ListNode build(int... vals) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        for (int v : vals) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    static String toString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" ");
            head = head.next;
        }
        return sb.toString();
    }

    static void check(String label, String actual, String expected) {
        String status = actual.equals(expected) ? "PASS" : "FAIL";
        System.out.printf("[%s] %-18s got: \"%s\"  expected: \"%s\"%n",
                status, label, actual, expected);
    }

    public static void main(String[] args) {
        RemoveNthFromEnd solver = new RemoveNthFromEnd();

        // n = 5 -> remove the head (5th from end of a 5-node list)
        check("head removal",
                toString(solver.removeNthFromEnd(build(1, 2, 3, 4, 5), 5)),
                "2 3 4 5");

        // n = 1 -> remove the tail
        check("tail removal",
                toString(solver.removeNthFromEnd(build(1, 2, 3, 4, 5), 1)),
                "1 2 3 4");

        // n = 2 -> remove a middle node
        check("middle removal",
                toString(solver.removeNthFromEnd(build(1, 2, 3, 4, 5), 2)),
                "1 2 3 5");

        // single node, n = 1 -> empty list
        check("single node",
                toString(solver.removeNthFromEnd(build(1), 1)),
                "");
    }
}

package blind75;

public class MergeTwoSortedLists {

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        // Attach whichever list still has remaining nodes.
        tail.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    public static void main(String[] args) {

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode list1 = mergeTwoSortedLists.new ListNode(1);
        list1.next = mergeTwoSortedLists.new ListNode(2);
        list1.next.next = mergeTwoSortedLists.new ListNode(4);

        ListNode list2 = mergeTwoSortedLists.new ListNode(1);
        list2.next = mergeTwoSortedLists.new ListNode(3);
        list2.next.next = mergeTwoSortedLists.new ListNode(4);

        ListNode mergedList = mergeTwoSortedLists.mergeTwoLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }



}

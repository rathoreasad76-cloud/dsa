package linkedlist;

public class AddTwoNumbers {

    public static class ListNode {
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode sum = new ListNode();
        ListNode tail = sum;
        int lead = 0;

        while (l1 != null || l2 != null) {
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + lead;

            if (sumVal % 10 == sumVal) {
                tail.next = new ListNode(sumVal);
                lead = 0;
            } else {
                tail.next = new ListNode(sumVal % 10);
                lead = 1;
            }
            tail = tail.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        if (lead == 1) {
            tail.next = new ListNode(1);
        }
        return sum.next;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();

        //List 1 : [9,9,9,9,9,9,9]
        //List 2 : [9,9,9,9]

        ListNode l1 = new ListNode(9,
                new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(52))));

        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);


        while (result != null) {
            //System.out.print(result.val + " ");
            result = result.next;
        }

        System.out.println();

        // test removeAndReturnRest
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int indexToRemove = 2; // Remove the node at index 2 (value 3)
        ListNode modifiedList = addTwoNumbers.removeAndReturnRest(head, indexToRemove);
        while (modifiedList != null) {
            //System.out.print(modifiedList.val + " ");
            modifiedList = modifiedList.next;
        }


        // removeFromEnd test
        ListNode head2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int n = 5; // Remove the 2nd node from the end (value 4)
        ListNode modifiedList2 = addTwoNumbers.removeNthFromEnd(head2, n);
        while (modifiedList2 != null) {
            //System.out.print(modifiedList2.val + " ");
            modifiedList2 = modifiedList2.next;
        }

        // swapPairs test
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode swappedList = addTwoNumbers.swapPairs2(head3);
        while (swappedList != null) {
            // System.out.print(swappedList.val + " ");
            swappedList = swappedList.next;
        }

        // rotateRight test
        ListNode head4 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        int k = 2; // Rotate the list to the right by 2 positions
        ListNode rotatedList = addTwoNumbers.rotateRight(head4, k);
        while (rotatedList != null) {
            //System.out.print(rotatedList.val + " ");
            rotatedList = rotatedList.next;
        }

        // rotateNew test
        ListNode head5 = new ListNode(0, new ListNode(1, new ListNode(2, null)));
        int k2 = 3; // Rotate the list to the right by 2 positions
        ListNode rotatedList2 = addTwoNumbers.rotateNew(head5, k2);
        while (rotatedList2 != null) {
            //System.out.print(rotatedList2.val + " ");
            rotatedList2 = rotatedList2.next;
        }



        // test reverseBetween
        ListNode head7 = new ListNode(1, new ListNode(2, new    ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode reversedBetweenList = addTwoNumbers.reverseBetween(head7, 2, 4);
        while (reversedBetweenList != null) {
            System.out.print(reversedBetweenList.val + " ");
            reversedBetweenList = reversedBetweenList.next;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode p = dummy;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }

        if (head != null) {
            while (head.next != null) {
                head = head.next;
                p = p.next;
            }
        }
        p.next = p.next != null ? p.next.next : null;
        return dummy.next;
    }


    public ListNode removeAndReturnRest(ListNode head, int index) {
        ListNode p = head;
        ListNode h = head;
        int count = 0;
        while (h != null) {
            p = h;
            h = h.next;
            if (count == index - 1) {
                p.next = p.next.next;
            }
            count++;
        }
        return head;
    }

    public ListNode swapPairs(ListNode head) {
        ListNode f = head;
        ListNode p = head;
        while (f != null && p != null) {
            f = f.next;
            p.next = f.next;
            f.next = p;
            p = p.next != null ? p.next.next : null;
        }
        return head;
    }

    public ListNode swapPairs2(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            current.next = second;

            // Move to the next pair
            current = first;
        }

        return dummy.next;
    }

    ListNode rotateRight(ListNode head, int k) {

        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        tail.next = head;

        int newTailIndex = (length - (k % (length))) - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailIndex; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;

    }

    public ListNode rotateRight2(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // First, let's determine the length of the list and get the tail node.
        ListNode oldTail = head;
        int length = 1;
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        // Connect the tail to the head to make it circular.
        oldTail.next = head;

        // Find the new tail: (length - k % length - 1)th node
        // and the new head: (length - k % length)th node
        int newTailIndex = length - k % length - 1;
        ListNode newTail = head;
        for (int i = 0; i < newTailIndex; i++) {
            newTail = newTail.next;
        }
        ListNode newHead = newTail.next;

        // Break the circle
        newTail.next = null;

        return newHead;
    }


    public ListNode rotateNew(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        ListNode pf = dummy;
        ListNode t = dummy;
        int length = 0;

        while (t.next != null) {
            t = t.next;
            length++;
        }

        for (int i = 0; i < (k%length); i++) {
            pf = pf.next;
        }

        while (pf != null && pf.next != null) {
            pf = pf.next;
            p = p.next;
        }

        if (p == pf) {
            return head;
        }

        ListNode newHead = p.next;
        p.next = null;
        ListNode untouched = dummy.next;
        ListNode tempHead = new ListNode(0,newHead);
        while (newHead != null && newHead.next != null) {
            newHead = newHead.next;
        }
        if (newHead != null) {
            newHead.next = untouched;
        }
        dummy.next = tempHead.next;

        return dummy.next;
    }


    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        return prev;
    }


    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0,head);
        ListNode d = dummy;
        ListNode dp = null;
        ListNode rHead = null;
        int pos = 0;
        while (d.next !=null) {
            if (pos == left) {
                rHead = d;
                break;
            }
            dp = d;
            d = d.next;
            pos++;
        }
        if (rHead == null) {
            return head;
        }
        ListNode c = rHead;
        ListNode prev = null;
        while (c != null && pos != right) {
            ListNode temp = c.next;
            c.next = prev;
            prev = c;
            c = temp;
            pos ++;
        }

        if (c!= null) {
            ListNode last = c.next;
            c.next = prev;
            rHead.next = last;
        }

        if (dp != null) {
            dp.next = c;
        }
        return dummy.next;

    }





}

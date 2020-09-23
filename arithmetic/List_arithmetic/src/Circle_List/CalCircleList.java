package Circle_List;

import Cal_List_Binary_To_int.ListNode;

public class CalCircleList {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        boolean result = hasCycle(n1);
        System.out.println(result);

    }

    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode fast = head;
        ListNode low = head;
        while (fast != null&& fast.next != null ) {
            low = low.next;
            fast = fast.next.next;
            if (fast == low) {
                return true;
            }
        }

        return false;
    }
}


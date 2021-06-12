package GetIntersectionNode_52;


import java.util.List;

public class GetIntersectionNode {


    public static void main(String[] args) {
        ListNode n1 = new ListNode(4);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(8);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(0);
        ListNode n8 = new ListNode(1);
        n6.next = n7;
        n7.next = n8;
//        n8.next = n3;

        ListNode res = new GetIntersectionNode().getIntersectionNode(n1, n6);
        System.out.println(res);

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode tempA = headA;
        ListNode tempB = headB;

        while (tempA != tempB) {
            tempA = tempA != null ? tempA = tempA.next : headB;
            tempB = tempB != null ? tempB = tempB.next : headA;
        }

        return tempA;

    }
}

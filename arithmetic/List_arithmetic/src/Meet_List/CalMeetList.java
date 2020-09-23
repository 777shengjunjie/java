package Meet_List;

import Cal_List_Binary_To_int.ListNode;

public class CalMeetList {



    public static void main(String[] args) {

        //这里在new的时候n2与n3的地址不一样
        ListNode n1=new ListNode(4);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(8);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        ListNode p1=new ListNode(5);
        ListNode p2=new ListNode(0);
        ListNode p3=new ListNode(1);
//        ListNode p4=new ListNode(8);
//        ListNode p5=new ListNode(4);
//        ListNode p6=new ListNode(5);
        p1.next=p2;
        p2.next=p3;
        p3.next=n3;
//        p4.next=p5;
//        p5.next=p6;

        ListNode result =getIntersectionNode(n1,p1);
        System.out.println(result.val);

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){return null;}
        ListNode p=headA;
        ListNode n=headB;
        while(p!=n) {
            if (p == null) {
                p= headB;
            } else {
                p = p.next;
            }
            if (n == null) {
                n = headA;
            } else {
                n = n.next;
            }
        }
        return p;
    }
}

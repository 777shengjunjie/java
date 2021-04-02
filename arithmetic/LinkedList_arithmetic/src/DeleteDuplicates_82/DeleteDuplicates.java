package DeleteDuplicates_82;

import java.util.concurrent.ConcurrentHashMap;

public class DeleteDuplicates {


    public static void main(String[] args) {

        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(4);
        ListNode n6=new ListNode(4);
        ListNode n7=new ListNode(5);

        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        n5.next=n6;
        n6.next=n7;

        ListNode result=new DeleteDuplicates().deleteDuplicates(n1);


    }
    public ListNode deleteDuplicates(ListNode head) {
        ListNode n1=new ListNode(-1,head);
        ListNode n2=n1;
        while(n2.next!=null&&n2.next.next!=null){
            if (n2.next.val==n2.next.next.val){
                ListNode temp=n2.next;
                while (temp!=null&&temp.next!=null&&temp.val==temp.next.val){
                    temp=temp.next;
                }
                n2.next=temp.next;
            }else {
                n2=n2.next;
            }

        }
        return n1.next;
    }
}

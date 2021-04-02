package ReverseBetween_92;

import java.util.List;

public class ReverseBetween {

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;

        ListNode result=new ReverseBetween().reverseBetween(n1,2,4);
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode=new ListNode(-1,head);
        ListNode pre=dummyNode;

        for(int i=0;i<left-1;i++){
            pre=pre.next;
        }

        ListNode rightNode=pre;
        for(int i=0;i<right-left+1;i++){
            rightNode=rightNode.next;
        }

        ListNode leftNode=pre.next;
        ListNode curr=rightNode.next;

        pre.next=null;
        rightNode.next=null;

        reverseLinkedList(leftNode);

        pre.next = rightNode;
        leftNode.next = curr;
        return dummyNode.next;
    }

    private void reverseLinkedList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}

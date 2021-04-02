package RotateRight_61;

import java.util.List;

public class RotateRight {



    public ListNode rotateRight2(ListNode head, int k) {


        if (head == null) return null;
        if (head.next == null) return head;

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for(n = 1; old_tail.next != null; n++)
            old_tail = old_tail.next;
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++)
            new_tail = new_tail.next;
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;



    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null){
            return head;
        }
        if(k==0){
            return head;
        }
        int size=0;
        ListNode dummpNode=new ListNode(-1,head);
        ListNode last=new ListNode(-1);
        while(head!=null){
            size++;
            if(head.next==null){
                last=head;
            }
            head=head.next;
        }
        int move=size-k%size;
        if(move==size){
            return dummpNode.next;
        }
        ListNode fastNode=dummpNode;
        while(move!=0){
            fastNode=fastNode.next;
            move--;
        }
        ListNode pre=fastNode.next;
        fastNode.next=null;
        last.next=dummpNode.next;

        return pre;

    }
}

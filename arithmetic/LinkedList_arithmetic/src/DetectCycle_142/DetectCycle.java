package DetectCycle_142;

import java.util.HashSet;
import java.util.Set;

public class DetectCycle {


    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n2;
        ListNode result=new DetectCycle().detectCycle3(n1);
    }

//    public ListNode detectCycle(ListNode head) {

//        if (head==null||head.next==null){
//            return null;
//        }
//
//        ListNode fast=new ListNode(0);
//        ListNode low=new ListNode(0);
//
//
//        fast.next=head.next;
//        low.next=head;
//
//        while (fast!=low){
//            low=low.next;
//            if (fast!=null){
//                fast=fast.next.next;
//            }else {
//                return null;
//            }
//        }
//
//        while (head!=low){
//
//            head=head.next;
//            low=low.next;
//        }
//
//        return head;
//    }

    public ListNode detectCycle2(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }

    public ListNode detectCycle3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }


}

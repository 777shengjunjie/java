package Middle_List;

import Cal_List_Binary_To_int.ListNode;
import javafx.scene.control.skin.SliderSkin;


public class CalMiddleList {

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

        ListNode result =middleNode(n1);
        System.out.println(result.val);
    }

    public static ListNode middleNode(ListNode head){
        if (head==null||head.next==null)
            return head;

        ListNode fast=head;
        ListNode low =head;

        while (fast!=null&&fast.next!=null){
//            fast=fast.next;
//            low=low.next;
//            if (fast.next==null)
//                break;
//            fast=fast.next;
            //内存消耗小
            fast=fast.next.next;
            low=low.next;

        }
        return low;
    }
}

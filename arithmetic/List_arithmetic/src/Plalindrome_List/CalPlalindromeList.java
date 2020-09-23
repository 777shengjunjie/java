package Plalindrome_List;

import Cal_List_Binary_To_int.ListNode;

import java.util.ListIterator;

public class CalPlalindromeList {

    public static void main(String[] args) {

        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(1);
        ListNode n5=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        //n4.next=n5;



        boolean result=isPalindrome(n1);
        System.out.println(result);

    }


    public static boolean isPalindrome(ListNode head){

        if(head==null) return true;

        ListNode middleNode=getMiddleList(head);
        ListNode p=reversalList(middleNode.next);


        boolean result = true;

        while (result && p != null) {
            if (head.val != p.val) result = false;
            head = head.next;
            p = p.next;
        }

//        while (middleNode.next!=null&&head.val==p.val){
//
//            p=p.next;
//            head=head.next;
//        }

        return result ; }

    public static ListNode getMiddleList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode fast = head;
        ListNode low = head;

        //链表求得的中间节点是靠前的
        while (fast.next!= null && fast.next.next != null) {

            fast = fast.next.next;
            low = low.next;

        }
        return low;
    }

    public static ListNode reversalList(ListNode head){

        if (head==null) return null;

        ListNode pre=null;
        ListNode temp=null;

        while (head!=null){

            temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;

        }
        return  pre;

    }


}



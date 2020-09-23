package Reversal_List;

import Cal_List_Binary_To_int.ListNode;

public class Cal_List {

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
        //ListNode result=reverseList(n1);
        //ListNode result=reverseList2(n1);
        ListNode result=reverseList3(n1);
        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }


    }

    public static ListNode reverseList(ListNode head) {
        ListNode temp=new ListNode(0);
        ListNode newHead=null;
        while(head!=null){
            //删除头节点
            temp=head;
            head=head.next;
            //插入头节点
            temp.next=newHead;
            newHead=temp;

        }
        return newHead;
    }




    public static ListNode reverseList2(ListNode head) {
        ListNode pre=null;
        ListNode temp=null;
        while(head!=null){
            temp=head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }



    /* 我们来看是怎样的一个递归过程：1->2->3->4
     程序到达Node newHead = reverse(head.next);时进入递归
     我们假设此时递归到了3结点，此时head=3结点，temp=3结点.next(实际上是4结点)
     执行Node newHead = reverse(head.next);传入的head.next是4结点，返回的newHead是4结点。
     接下来就是弹栈过程了
     程序继续执行 temp.next = head就相当于4->3
     head.next = null 即把3结点指向4结点的指针断掉。
     返回新链表的头结点newHead
     注意：当return后，系统会恢复2结点压栈时的现场，此时的head=2结点；temp=2结点.next(3结点)，再进行上述的操作。最后完成整个链表的翻转。*/

    public static ListNode reverseList3(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode temp=head.next;
        ListNode newHead=reverseList3(head.next);
        temp.next=head;
        head.next=null;
        return newHead;
    }
}

package DeleteNode;

import Cal_List_Binary_To_int.ListNode;

public class CalDeleteNode {

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(1);
        ListNode n3=new ListNode(1);
        ListNode n4=new ListNode(3);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        deleteNode(n4);

        while (n1!=null){
            System.out.println(n1.val);
            n1=n1.next;
        }
    }


//    请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
    public static void deleteNode(ListNode node){
            node.val=node.next.val;
            node.next=node.next.next;
    }
}

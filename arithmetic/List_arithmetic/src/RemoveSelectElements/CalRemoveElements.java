package RemoveSelectElements;

import Cal_List_Binary_To_int.ListNode;

public class CalRemoveElements {

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
        ListNode result=removeElements(n1,1);

        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }

    public static ListNode removeElements(ListNode head,int val) {
        /*方法一
        if (head == null) return null;

        while (head.val==val){
            head=head.next;
            if (head==null) return null;
        }
        ListNode cur = head;
        while (cur != null&&cur.next!=null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
         */

        //方法二：设置哨兵节点
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val) prev.next = curr.next;
            else prev = curr;
            curr = curr.next;
        }
        return sentinel.next;

    }
}

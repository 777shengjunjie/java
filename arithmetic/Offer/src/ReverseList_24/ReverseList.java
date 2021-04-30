package ReverseList_24;

public class ReverseList {

    public static void main(String[] args) {
       ListNode node=new ListNode(1);
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(2);
        node.next=node1;
        node1.next=node2;

        ListNode res=new ReverseList().reverseList(node);
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=pre;
            pre=cur;
            cur=next;
        }

        return pre;
    }
}

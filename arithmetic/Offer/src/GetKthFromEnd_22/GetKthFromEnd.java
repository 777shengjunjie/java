package GetKthFromEnd_22;

public class GetKthFromEnd {

    public ListNode getKthFromEnd(ListNode head, int k) {
        int length=0;
        ListNode node=new ListNode(0);
        node.next=head;
        while (node.next!=null){
            length++;
            node.next=node.next.next;
        }
        int start=length-k;
        int count=0;
        while (head !=null){
            if (count==start){
                return head;
            }
            count++;
            head=head.next;
        }

        return node.next;

    }

    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode slow=head,fast=head;
        int t = 0;
        while(fast!=null){
            if(t>=k) slow=slow.next;
            fast = fast.next;
            t++;
        }
        return slow;
    }
}

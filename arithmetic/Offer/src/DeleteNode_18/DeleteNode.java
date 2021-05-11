package DeleteNode_18;


public class DeleteNode {

    public ListNode deleteNode(ListNode head, int val) {

        ListNode dumpy=new ListNode(-1);
        dumpy.next=head;
        ListNode before=dumpy;
        while (head!=null){
            if (head.val==val){
                before.next=head.next;
                return dumpy.next;
            }
            before=head;
            head=head.next;
        }

        return dumpy.next;
    }



}

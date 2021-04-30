package MergeTwoLists_25;

public class MergeTwoLists {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node=new ListNode(-1);
        ListNode head=node;
        while (l1!=null&&l2!=null){
            if (l1.val< l2.val){
                head.next=new ListNode(l1.val);
                head=head.next;
                l1=l1.next;
            }else {
                head.next=new ListNode(l2.val);
                head=head.next;
                l2=l2.next;
            }

        }

        if (l1!=null){
            head.next=l1;
        }
       if (l2!=null){
            head.next=l2;
        }

        return node.next;

    }

}

package InsertionSortList_147;

public class InsertionSortList {

    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(3);
        ListNode n3=new ListNode(2);
        ListNode n4=new ListNode(4);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        ListNode result=new InsertionSortList().insertionSortList(n1);
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode lastSorted = head, curr = head.next;
        while (curr != null) {
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = dummyHead;
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }
        return dummyHead.next;

    }

    public ListNode insertionSortList2(ListNode head) {


        if(head==null){
            return head;
        }

        ListNode dummyHead=new ListNode(0);
        dummyHead.next=head;
        ListNode lastHead=head,curr=head.next;

        while(curr!=null){
            if(lastHead.val<curr.val){
                lastHead=lastHead.next;
            }else{
                ListNode prev=dummyHead;
                while(prev.next.val<=curr.val){
                    prev=prev.next;
                }
                lastHead.next=curr.next;
                curr.next=prev.next;
                prev.next=curr;
            }
            curr=lastHead.next;
        }

        return dummyHead.next;

    }
}

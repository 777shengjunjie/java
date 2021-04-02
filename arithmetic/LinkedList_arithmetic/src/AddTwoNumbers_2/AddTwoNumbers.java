package AddTwoNumbers_2;


public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode l1=new ListNode(2);
        ListNode l2=new ListNode(4);
        ListNode l3=new ListNode(3);
        l1.next=l2;
        l2.next=l3;
        ListNode l4=new ListNode(5);
        ListNode l5=new ListNode(6);
        ListNode l6=new ListNode(4);
        l4.next=l5;
        l5.next=l6;
        ListNode node=new AddTwoNumbers().addTwoNumbers2(l1,l4);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ans=new ListNode(0);


        ans=add(ans,l1,l2);

        return ans;
    }

    public ListNode add(ListNode ans,ListNode l1,ListNode l2){
        if(l1==null&&l2==null){
            return null;
        }
        ListNode node=new ListNode();
        ans.next=node;
        ans.val+=l1.val+l2.val;
        if(ans.val>=10){
            ans.val-=10;
            ans.next.val=1;
        }
        if(l1.next==null&&l2.next!=null){
            ListNode node1=new ListNode(0);
            ans.next=add(ans.next,node1,l2.next);
            return ans;
        }
        if(l2.next==null&&l1.next!=null){
            ListNode node2=new ListNode(0);
            ans.next= add(ans.next,l1,node2);
            return  ans;
        }
        ans.next= add(ans.next,l1.next,l2.next);
        return ans;
    }
}

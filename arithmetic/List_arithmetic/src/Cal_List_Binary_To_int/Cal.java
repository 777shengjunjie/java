package Cal_List_Binary_To_int;

public class Cal {
    public static void main(String[] args) {
        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(0);
        ListNode n3=new ListNode(1);
        n1.next=n2;
        n2.next=n3;
        //n1.next=null;
        int i=getDecimalValue(n1);
        System.out.println(i);

    }

    //二进制链表转整数
    public static int getDecimalValue(ListNode head){
        int result=0;
        while(head!=null){
            result=result*2+head.val;
            head=head.next;
        }
        return  result;
    }



}

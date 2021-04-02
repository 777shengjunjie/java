package RemoveNthFromEnd_19;


import java.util.ArrayList;
import java.util.List;

public class RemoveNthFromEnd {

    public static void main(String[] args) {


//        int n=9;
//       A: for (int i = 0; i < n; i++) {
//            for (int i1 = 0; i1 < n; i1++) {
//                break A;
//            }
//        }
//
//        Integer a = new Integer(3);
//        Integer b = 3;                  // 将3自动装箱成Integer类型
//      //  int c = 3;
//        System.out.println(a == b);     // false 两个引用没有引用同一对象

        ListNode n1=new ListNode(1);
        ListNode n2=new ListNode(2);
        ListNode n3=new ListNode(3);
        ListNode n4=new ListNode(4);
        ListNode n5=new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;
        ListNode result=new RemoveNthFromEnd().removeNthFromEnd(n1,2);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ans=head;
        int size=0;
        while(head!=null){
            head=head.next;
            size++;
        }
        int index=size-n;
        head=ans;
        while(head!=null){
            if(index==1){

                head.next=head.next.next;
                break;
            }
            head=head.next;
            index--;
        }
        return ans;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;

    }
}

package DeleteDuplicatesElementList;

import Cal_List_Binary_To_int.ListNode;


public class CalDeleteElement {

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
        ListNode result=deleteDuplicates(n1);

        while (result!=null){
            System.out.println(result.val);
            result=result.next;
        }
    }


    public static ListNode deleteDuplicates(ListNode head){

        if(head==null) return null ;
        ListNode p=head;
        ListNode temp=null;//删除多余的野节点
        while(p!=null&&p.next!=null){
            if (p.val==p.next.val){
                temp=p.next;
                p.next=temp.next;
                temp.next=null;
            }else {
            p=p.next;
            }
        }
        return head;



    }
}

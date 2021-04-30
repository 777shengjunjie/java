package ReversePrint_06;

import com.sun.xml.internal.ws.client.ClientSchemaValidationTube;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReversePrint {

    List<Integer> list=new ArrayList<>();

    public static void main(String[] args) {
        ListNode node=new ListNode(1);
        ListNode node1=new ListNode(3);
        ListNode node2=new ListNode(2);
        node.next=node1;
        node1.next=node2;
        int[] result=new ReversePrint().reversePrint(node);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] reversePrint(ListNode head) {
        int value= head.val;
        reverse(head);
        list.add(value);
        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }

    public ListNode reverse(ListNode node){
        if (node.next==null){
            return node;
        }

        ListNode nextNode= reverse(node.next);
        list.add(nextNode.val);

        return node;
    }



    public int[] reversePrint2(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

    public void reverseLinkedList(ListNode node){
        ListNode pre=null;
        ListNode cur=node;
        while (cur!=null){
            ListNode next=cur.next;
            next.next=pre;
            pre=cur;
            cur=next;
        }

    }

}

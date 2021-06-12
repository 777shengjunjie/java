package CopyRandomList_35;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {


    public static void main(String[] args) {
        Node n1=new Node(1);
        Node n2=new Node(2);
        n1.next=n2;
        n1.random=n2;
        n2.random=n2;
        Node result=new CopyRandomList().copyRandomList(n1);
        System.out.println(result);
    }

    public Node copyRandomList(Node head) {

        if (head==null) return null;
        Node cur=head;
        Map<Node,Node> map=new HashMap<>();
        while (cur!=null){
            map.put(cur,new Node(cur.val));
            cur=cur.next;
        }
        cur=head;
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }

        return map.get(head);
    }
}

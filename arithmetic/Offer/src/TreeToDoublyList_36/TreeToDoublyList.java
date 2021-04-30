package TreeToDoublyList_36;

import java.util.ArrayList;
import java.util.List;

public class TreeToDoublyList {

    List<Node> lists=new ArrayList<>();

    public static void main(String[] args) {
        Node root=new Node(4);
        Node root1=new Node(2);
        Node root2=new Node(1);
        Node root3=new Node(3);
        Node root4=new Node(5);
        root.left=root1;
        root.right=root4;
        root1.left=root2;
        root1.right=root3;
        Node node=new TreeToDoublyList().treeToDoublyList(root);
    }


    public Node treeToDoublyList(Node root) {
        dfs(root);
        Node head=new Node();
        head.right=lists.get(0);
        for (int i = 0; i < lists.size(); i++) {
            if (i-1<0){
                lists.get(i).left=lists.get(lists.size()-1);
            }else {
                lists.get(i).left=lists.get(i-1);
            }
            if (i+1>=lists.size()){
                lists.get(i).right=lists.get(0);
            }else {
                lists.get(i).right=lists.get(i+1);
            }
        }

        return head.right;
    }


    public void dfs(Node node) {
        if (node== null) {
            return;
        }


        if (node.left != null) dfs(node.left);
        lists.add(node);
        if (node.right!=null) dfs(node.right);

    }


    Node pre, head;
    public Node treeToDoublyList2(Node root) {
        if(root == null) return null;
        dfs2(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs2(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

}

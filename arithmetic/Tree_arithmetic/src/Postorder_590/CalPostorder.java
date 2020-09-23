package Postorder_590;


import NTreeMaxDepth.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
给定一个 N 叉树，返回其节点值的后序遍历。
*/
public class CalPostorder {

    public static void main(String[] args) {

        List<Node>  t1=new ArrayList<>();
        List<Node>  t2=new ArrayList<>();

       // Node test=null;

        Node n1=new Node(1);
        Node n2=new Node(3);
        Node n3=new Node(2);
        Node n4=new Node(4);
        Node n5=new Node(5);
        Node n6=new Node(6);

        t1.add(n2);
        t1.add(n3);
        t1.add(n4);
        n1.children=t1;

        t2.add(n5);
        t2.add(n6);

        n2.children=t2;

        List<Integer> result=postorder2(n1);

        for (Integer integer : result) {
            System.out.println(integer);
        }


    }

    public static List<Integer> postorder(Node root){

        List<Integer> list=new LinkedList<>();
        getValue(root,list);
        return  list;

    }

    private static void getValue(Node root,List<Integer> list)  {

        if (root==null) return;
        if (root.children!=null){
            for (Node child : root.children) {
                getValue(child,list);
            }

        }
        list.add(root.val);


    }


    public static List<Integer> postorder2(Node root){

        LinkedList<Integer> ans=new LinkedList<>();
        Stack<Node> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node node=stack.pop();
            ans.addFirst(node.val);
            ans.add(node.val);
            if (node.children!=null) {


                for (Node child : node.children) {
                    if (child != null) {
                        stack.push(child);
                    }
                }

            }
        }
        return ans;

    }

}

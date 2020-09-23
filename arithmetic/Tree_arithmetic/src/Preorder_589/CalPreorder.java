package Preorder_589;

import NTreeMaxDepth.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//前序遍历N叉树
public class CalPreorder {

    public static void main(String[] args) {

        List<Node>  t1=new ArrayList<>();
        List<Node>  t2=new ArrayList<>();


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

        List<Integer> result=preorder2(n1);

        for (Integer integer : result) {
            System.out.println(integer);
        }

    }

    //递归
    public static List<Integer> preorder(Node root){

        List<Integer> list=new LinkedList<>();
        getValue(root,list);
        return list;


    }

    public static void getValue(Node root,List<Integer> list){
        if (root==null) return ;

        list.add(root.val);
        if (root.children!=null) {
            for (Node child : root.children) {
                getValue(child,list);
            }

        }
    }

    //迭代
    public static List<Integer> preorder2(Node root){

        List<Integer> list=new LinkedList<>();
        LinkedList<Node> stack=new LinkedList<>();
        if (root==null) return list;
        stack.offer(root);
        while (!stack.isEmpty()){
            Node node=stack.pollLast();
            list.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.offer(child);
            }
        }

         return list;

    }

}

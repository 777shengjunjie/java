package NTreeMaxDepth;


import javafx.util.Pair;

import java.util.*;

/*
给定一个 N 叉树，找到其最大深度。

最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
*/
public class CalNTreeMaxDepth {


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

        int result=maxDepth3(n1);
        System.out.println(result);



    }


    //递归
    public static int maxDepth(Node root){

        if (root==null) return 0;
        if (root.children==null)  return 1;
        else {
            int ans=0;
            int childVal=0;
            for (Node child : root.children) {
                childVal=maxDepth(child);
                ans=ans>childVal?ans:childVal;
            }
            return  ans+1;
        }



    }

    //递归
    public static int maxDepth2(Node root){

        if (root == null) {
            return 0;
        } else if (root.children.isEmpty()) {
            return 1;
        } else {
            List<Integer> heights = new LinkedList<>();
            for (Node item : root.children) {
                heights.add(maxDepth(item));
            }
            return Collections.max(heights) + 1;
        }

    }
    //迭代
    public static int maxDepth3(Node root){

     /*   Queue<Pair<Node,Integer>> stack=new LinkedList<>();
        if (root!=null){
            stack.offer(new Pair<>(root,1));
        }

        int depth=0;
        while (!stack.isEmpty()){
            Pair<Node, Integer> current = stack.poll();
            Node node = current.getKey();
            Integer current_depth = current.getValue();
            if (node!=null){
                depth=Math.max(depth,current_depth);
                for (Node child : node.children) {
                    stack.offer(new Pair<>(child,current_depth+1));
                }
            }

        }
        return depth;*/




        Queue<Pair<Node, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<Node, Integer> current = stack.poll();
            root = current.getKey();
            int current_depth = current.getValue();
            if (root != null) {
                depth = Math.max(depth, current_depth);
                for (Node c : root.children) {
                    stack.add(new Pair(c, current_depth + 1));
                }
            }
        }
        return depth;


    }


}

package LevelOrderBottom;

import MaxDepth.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class CalLevelOrderBottom {

    public static void main(String[] args) {

        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(9);
        TreeNode n3=new TreeNode(20);
        TreeNode n4=new TreeNode(15);
        TreeNode n5=new TreeNode(7);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;

        List<List<Integer>> result=levelOrderBottom(n1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }



    }


//    给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历
    public static  List<List<Integer>> levelOrderBottom(TreeNode root){

        if(root==null) return new LinkedList<>();

        List<List<Integer>> ans=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();


        queue.offer(root);
        while (!queue.isEmpty()){

            int size=queue.size();
            List<Integer> list=new LinkedList<>();

            while (size>0){
                TreeNode n=queue.poll();
                list.add(n.val);

                if (n.left!=null)  queue.offer(n.left);
                if (n.right!=null) queue.offer(n.right);

                size--;

            }
            ans.add(0,list);

        }


                return  ans;




    }


}

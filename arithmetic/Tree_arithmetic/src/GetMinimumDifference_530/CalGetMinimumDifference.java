package GetMinimumDifference_530;


/*
给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
*/

import MaxDepth.TreeNode;

import java.util.ArrayList;

import java.util.List;

public class CalGetMinimumDifference {

    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(2);

        n1.right=n2;
        n2.left=n3;

        int result=getMinimumDifference(n1);
        System.out.println(result);

    }

    public static int getMinimumDifference(TreeNode root){

        List<Integer> lists =new ArrayList<>();
        getValue(root,lists);
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < lists.size()-1; i++) {

            min=Math.min(min,lists.get(i+1)-lists.get(i));
        }

        return min;

    }

    public static void getValue(TreeNode root,List<Integer> list){

        if (root==null) return ;
        getValue(root.left,list);
        list.add(root.val);
        getValue(root.right,list);


    }


}

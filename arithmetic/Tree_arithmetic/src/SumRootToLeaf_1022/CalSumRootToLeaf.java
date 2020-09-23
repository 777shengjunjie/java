package SumRootToLeaf_1022;


import MaxDepth.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;




/*

给出一棵二叉树，其上每个结点的值都是0或1。每一条从根到叶的路径都代表一个从最高有效位开始的二进制数。
        例如，如果路径为0 -> 1 -> 1 -> 0 -> 1，那么它表示二进制数01101，也就是13。

        对树上的每一片叶子，我们都要找出从根到该叶子的路径所表示的数字。

        以10^9 + 7为模，返回这些数字之和。


*/


public class CalSumRootToLeaf {

    static int ans;

    public static void main(String[] args) {
        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(0);
        TreeNode n3=new TreeNode(1);
        TreeNode n4=new TreeNode(0);
        TreeNode n5=new TreeNode(1);
        TreeNode n6=new TreeNode(0);
        TreeNode n7=new TreeNode(1);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.left=n6;
        n3.right=n7;
        int result=sumRootToLeaf(n1);
        System.out.println(result);


    }


    public static int sumRootToLeaf(TreeNode root){


        if (root==null) return 0;
        int mod=1000000000+7;
        getDfs(root,0);
        return ans % mod;


    }

    private static void getDfs(TreeNode root,int sum) {
        if (root!=null){
           sum=sum*2+root.val;
           if (root.left==null&&root.right==null){
               ans+=sum;
           }
               getDfs(root.left, sum);
               getDfs(root.right, sum);

        }

    }


}

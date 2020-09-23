package SumOfLeftLeaves;

import MaxDepth.TreeNode;

public class CalSumOfLeftLeaves {


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

        int result=sumOfLeftLeaves(n1);
        System.out.println(result);

    }

    public static int sumOfLeftLeaves(TreeNode root){

        if(root==null) return 0;

        return sum(root,false);
    }

    private static int sum(TreeNode root,boolean flag) {

        if (root==null) return 0;

        if (flag&&root.left==null&&root.right==null) return root.val;

        int left=sum(root.left,true);
        int right=sum(root.right,false);

        return left+right;
    }
}

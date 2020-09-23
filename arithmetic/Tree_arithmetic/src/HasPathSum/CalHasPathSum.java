package HasPathSum;

import MaxDepth.TreeNode;

import java.util.LinkedList;
import java.util.Queue;


/*

给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

        说明: 叶子节点是指没有子节点的节点。
*/

public class CalHasPathSum {


    public static void main(String[] args) {

        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(4);
        TreeNode n3=new TreeNode(8);
        TreeNode n6=new TreeNode(11);
        TreeNode n7=new TreeNode(7);
        TreeNode n8=new TreeNode(2);
        TreeNode n4=new TreeNode(13);
        TreeNode n5=new TreeNode(4);
        TreeNode n9=new TreeNode(1);


        n1.left=n2;
        n1.right=n3;
        n2.left=n6;
        n6.left=n7;
        n6.right=n8;
        n3.left=n4;
        n3.right=n5;
        n5.right=n9;

        boolean resultPath=hasPathSum(n1,22);
        System.out.println(resultPath);
    }

    //递归
    private static boolean hasPathSum(TreeNode root, int sum) {

        if (root==null) return  false;

        if (root.left==null&&root.right==null){
            return sum==root.val;
        }


        return hasPathSum(root.left,sum- root.val)||hasPathSum(root.right,sum- root.val);

    }

//广度搜索
  /*  public static boolean hasPathSum(TreeNode root,int sum){

        if(root==null) return false;

        Queue<TreeNode> now=new LinkedList<>();
        Queue<Integer> val=new LinkedList<>();
        now.offer(root);
        val.offer(root.val);

        while(!now.isEmpty()){

            TreeNode node=now.poll();
            int total= val.poll();

            if(node.left==null&&node.right==null){
                if ( total==sum) return true;
                continue;
            }

            if (node.left!=null) {
                now.offer(node.left);
                val.offer(node.left.val+total);
            }

            if (node.right!=null) {
                now.offer(node.right);
                val.offer(node.right.val+total);
            }

        }

        return false;


    }*/


}

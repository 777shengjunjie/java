package TrimBST_669;

import MaxDepth.TreeNode;

import java.util.LinkedList;
import java.util.Queue;



/*

给定一个二叉搜索树，同时给定最小边界L和最大边界R。通过修剪二叉搜索树，使得所有节点的值在[L, R]中 (R>=L) 。
        你可能需要改变树的根节点，所以结果应当返回修剪好的二叉搜索树的新的根节点。
*/

public class CalTrimBST {

    //static TreeNode ans=null;
    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(0);
        TreeNode n3=new TreeNode(2);
        n1.left=n2;
        n1.right=n3;

        TreeNode result=trimBST(n1,1,2);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(result);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.println(node.val);
            if (node.left!=null) queue.offer(node.left);
            if (node.right!=null) queue.offer(node.right);
        }

    }

    public static TreeNode trimBST(TreeNode root,int low,int high){



        if (root==null)  return null;

        if (root.val<low){
            return trimBST(root.right,low,high);

        }else if (root.val>high){
           return trimBST(root.left,low,high);
        }else {
           root.left= trimBST(root.left,low,high);
           root.right=trimBST(root.right,low,high);
        }

        return root;

    }
}

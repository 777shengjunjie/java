package ConvertBST;

import MaxDepth.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CalConvertBST {

    static int sum=0;
    public static void main(String[] args) {

        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(9);
        TreeNode n3=new TreeNode(20);
        TreeNode n4=new TreeNode(15);
        TreeNode n5=new TreeNode(18);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;

        TreeNode resultPath=convertBST(n1);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(resultPath);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.println(node.val);
            if (node.right!=null) queue.offer(node.right);
            if (node.left!=null) queue.offer(node.left);
        }



    }

/*

    给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
    使得每个节点的值是原来的节点值加上所有大于它的节点值之和。

*/
    public static TreeNode convertBST(TreeNode root){

        if (root==null) return null;

            convertBST(root.right);
            sum+= root.val;
            root.val=sum;
            convertBST(root.left);


        return root;


    }

    public static TreeNode convertBST2(TreeNode root){

         TreeNode node=root;
         //栈先进后出
         Stack<TreeNode> stack=new Stack<>();

        while (!stack.isEmpty()||node!=null){

            while (node!=null){
                stack.add(node);
                node=node.right;
            }

            node=stack.pop();
            sum+= node.val;
            node.val=sum;

            node=node.left;

        }

        return root;
    }





}

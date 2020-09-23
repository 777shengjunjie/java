package InvertTree;


import MaxDepth.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;


//翻转一棵二叉树。
public class CalInvertTree {


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

        TreeNode result=invertTree(n1);

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(result);
        while (!queue.isEmpty()) {
            TreeNode n=queue.poll();
            System.out.println(n.val);
            if (n.left!=null) queue.offer(n.left);
            if (n.right!=null) queue.offer(n.right);

        }

    }

    //广度搜索
  /*  public static TreeNode invertTree(TreeNode root){

        if(root==null) return null;

        TreeNode temp=root.left;

        root.left=root.right;
        root.right=temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }*/

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            TreeNode temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
        return root;
    }



}

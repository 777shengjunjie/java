package MaxDepth;


/*
给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。
*/

import java.util.LinkedList;
import java.util.Queue;

public class CalMaxDepth {

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

        int resultPath=maxDepth(n1);
        System.out.println(resultPath);


    }

        //方法一：递归
        /*public static int maxDepth(TreeNode root){


           if(root==null) return 0;
           else {
               int leftMaxDepth=maxDepth(root.left);
               int rightMaxDepth=maxDepth(root.right);
               return Math.max(leftMaxDepth,rightMaxDepth)+1;
           }


        }*/


    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);

        int ans = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            ans++;
        }
        return ans;
    }


}

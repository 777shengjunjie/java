package MergeTrees;

import MaxDepth.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CalMergeTrees {

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


        TreeNode t1=new TreeNode(1);
        TreeNode t2=new TreeNode(2);
        TreeNode t3=new TreeNode(3);
        TreeNode t4=new TreeNode(4);
        TreeNode t5=new TreeNode(5);

        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;

        TreeNode result=mergeTrees(n1,t1);

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(result);
        while (!queue.isEmpty()) {
            TreeNode n=queue.poll();
            System.out.println(n.val);
            if (n.left!=null) queue.offer(n.left);
            if (n.right!=null) queue.offer(n.right);

        }
    }



/*
    给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。

    你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，
    否则不为 NULL 的节点将直接作为新二叉树的节点。
*/
    public static TreeNode mergeTrees(TreeNode t1,TreeNode t2){



            if (t1==null) return t2;

            if (t2==null) return t1;

            t1.val+=t2.val;

            t1.left=mergeTrees(t1.left,t2.left);
            t1.right=mergeTrees(t1.right,t2.right);

            return t1;

    }


}

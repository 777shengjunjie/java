package IsSameTree;

import MaxDepth.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/*
给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
*/

public class CalIsSameTree {

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

        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(9);
        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(8);


        t1.left=t2;
        t1.right=t3;
        t3.left=t4;
        t3.right=t5;

        boolean result=isSameTree(n1,t1);
        System.out.println(result);

    }


    public  static boolean isSameTree(TreeNode p,TreeNode q){

        //return check(p,q);

        /*
        方法二：广度优先搜索
         */
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        Queue<TreeNode> queue1 = new LinkedList<TreeNode>();
        Queue<TreeNode> queue2 = new LinkedList<TreeNode>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node1 = queue1.poll();
            TreeNode node2 = queue2.poll();
            if (node1.val != node2.val) {
                return false;
            }
            TreeNode left1 = node1.left, right1 = node1.right, left2 = node2.left, right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }
            if (left1 != null) {
                queue1.offer(left1);
            }
            if (right1 != null) {
                queue1.offer(right1);
            }
            if (left2 != null) {
                queue2.offer(left2);
            }
            if (right2 != null) {
                queue2.offer(right2);
            }
        }
        return queue1.isEmpty() && queue2.isEmpty();




    }

    private static boolean check(TreeNode p, TreeNode q) {

        if(p==null&&q==null) return true;
        if (p==null||q==null||p.val!=q.val) return false;
        return check(p.left,q.left)&&check(p.right,q.right);

    }
}

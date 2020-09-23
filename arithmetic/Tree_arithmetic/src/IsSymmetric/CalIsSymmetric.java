package IsSymmetric;

import MaxDepth.TreeNode;
import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CalIsSymmetric {


    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(2);
        TreeNode n6=new TreeNode(4);
        TreeNode n7=new TreeNode(3);
        TreeNode n4=new TreeNode(3);
        TreeNode n5=new TreeNode(4);

        n1.left=n2;
        n1.right=n3;
        n2.left=n6;
        n2.right=n7;
        n3.left=n4;
        n3.right=n5;

        boolean result=isSymmetric(n1);
        System.out.println(result);

    }

    public  static  boolean isSymmetric(TreeNode root){

        return check(root,root);


    }


    //方法一：递归
/*    public static boolean check(TreeNode p, TreeNode q) {

        if ( p==null  && q==null) return true;
        if (p==null||q==null||p.val!=q.val) return false;

        return check(q.left,p.right)&&check(q.right,p.left);
    }*/



   /* 「方法一」中我们用递归的方法实现了对称性的判断，那么如何用迭代的方法实现呢？首先我们引入一个队列，
    这是把递归程序改写成迭代程序的常用方法。初始化时我们把根节点入队两次。每次提取两个结点并比较它们的值
    （队列中每两个连续的结点应该是相等的，而且它们的子树互为镜像），然后将两个结点的左右子结点按相反的顺序插入队列中。
    当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。*/
    public static  boolean check(TreeNode p, TreeNode q){

        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(p);
        queue.offer(q);

        while (!queue.isEmpty()){
            p=queue.poll();
            q=queue.poll();

           if (p==null&&q==null)
               continue;

           if (p==null||q==null||p.val!=q.val)
               return false;

           queue.offer(p.left);
           queue.offer(q.right);

           queue.offer(p.right);
           queue.offer(q.left);

        }

        return true;

    }

}

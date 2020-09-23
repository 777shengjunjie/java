package LowestCommonAncestor;

import MaxDepth.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CalLowestCommonAncestor {



    public static void main(String[] args) {

        TreeNode p=new TreeNode(2);
        TreeNode q=new TreeNode(4);

        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(8);
        TreeNode n4=new TreeNode(7);
        TreeNode n5=new TreeNode(9);
        TreeNode n6=new TreeNode(0);
        TreeNode n7=new TreeNode(4);
        TreeNode n8=new TreeNode(3);
        TreeNode n9=new TreeNode(5);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;
        n2.left=n6;
        n2.right=n7;
        n7.left=n8;
        n7.right=n9;


        TreeNode result=lowestCommonAncestor2(n1,p,q);
        System.out.println(result.val);


    }


/*
    给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

    百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
    最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

*/

/*

    算法

    从根节点开始遍历树
    如果节点 pp 和节点 qq 都在右子树上，那么以右孩子为根节点继续 1 的操作
    如果节点 pp 和节点 qq 都在左子树上，那么以左孩子为根节点继续 1 的操作
    如果条件 2 和条件 3 都不成立，这就意味着我们已经找到节 pp 和节点 qq 的 LCA 了

*/


    public static TreeNode lowestCommonAncestor(TreeNode root,TreeNode p,TreeNode q){

        int AncestorVal= root.val;
        int pVal=p.val;
        int qVal= q.val;

        if (pVal>AncestorVal&&qVal>AncestorVal){
         return  lowestCommonAncestor(root.right,p,q);
        }
        if(pVal<AncestorVal&&qVal<AncestorVal){
            return lowestCommonAncestor(root.left,p,q);
        }

        return root;

    }

    //运算时间过长
    public static TreeNode lowestCommonAncestor2(TreeNode root,TreeNode p,TreeNode q){

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode node=root;
        while (!queue.isEmpty()){
            node=queue.poll();
            if (p.val<node.val&&q.val< node.val) queue.offer(root.left);
            if (p.val> node.val&&q.val> node.val) queue.offer(root.right);

        }

        return node;

    }


    public static TreeNode lowestCommonAncestor3(TreeNode root,TreeNode p,TreeNode q){


        int pVal = p.val;


        int qVal = q.val;


        TreeNode node = root;


        while (node != null) {


            int parentVal = node.val;

            if (pVal > parentVal && qVal > parentVal) {

                node = node.right;
            } else if (pVal < parentVal && qVal < parentVal) {

                node = node.left;
            } else {

                return node;
            }
        }
        return null;


    }

}

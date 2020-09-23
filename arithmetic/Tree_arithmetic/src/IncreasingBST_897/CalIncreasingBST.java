package IncreasingBST_897;


import MaxDepth.TreeNode;
import jdk.nashorn.api.tree.Tree;

import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;




/*
给你一个树，请你 按中序遍历 重新排列树，使树中最左边的结点现在是树的根，并且每个结点没有左子结点，只有一个右子结点。
*/

public class CalIncreasingBST {

    TreeNode cur;
    public static void main(String[] args) {

        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(6);
        TreeNode n4=new TreeNode(2);
        TreeNode n5=new TreeNode(4);
        TreeNode n6=new TreeNode(1);
        TreeNode n7=new TreeNode(8);
        TreeNode n8=new TreeNode(7);
        TreeNode n9=new TreeNode(9);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n4.left=n6;
        n3.right=n7;
        n7.left=n8;
        n7.right=n9;

        TreeNode result=increasingBST(n1);
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(result);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.println(node.val);
            if (node.left!=null) queue.offer(node.left);
            if (node.right!=null) queue.offer(node.right);
        }

    }


    //方法一
    public static TreeNode increasingBST(TreeNode root){

        List<Integer> lists=new ArrayList<>();
        helper(root,lists);


        return helperToNewTree(lists);

    }

    public static  void helper(TreeNode root,List<Integer> lists){

        if (root==null) return;
        helper(root.left,lists);
        lists.add(root.val);
        helper(root.right,lists);

    }

    public static TreeNode helperToNewTree(List<Integer> listsNew){

        if (listsNew.isEmpty()) return null;
        TreeNode node=new TreeNode(listsNew.remove(0));
        node.left=null;
        node.right=helperToNewTree(listsNew);
        return node;
    }

    //方法二
    public static TreeNode increasingBST2(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public static void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }

    //方法三
    public TreeNode increasingBST3(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }



}

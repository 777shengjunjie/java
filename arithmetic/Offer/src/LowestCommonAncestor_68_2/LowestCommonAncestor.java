package LowestCommonAncestor_68_2;

import java.util.LinkedList;
import java.util.Queue;

public class LowestCommonAncestor {

    public static void main(String[] args) {

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null && right == null) return null; // 1.
        if(left == null) return right; // 3.
        if(right == null) return left; // 4.
        return root; // 2. if(left != null and right != null)

    }


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        if (root==null||root==p||root==q) return root;
        TreeNode left=lowestCommonAncestor2(root.left,p,q);
        TreeNode right=lowestCommonAncestor2(root.right,p,q);
        if (left==null&&right==null) return null;
        if (left==null) return right;
        if (right==null) return left;
        return root;

    }



}

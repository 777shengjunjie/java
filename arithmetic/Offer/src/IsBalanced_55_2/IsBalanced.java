package IsBalanced_55_2;

import sun.reflect.generics.tree.Tree;

public class IsBalanced {

    boolean res=true;

    public static void main(String[] args) {

    }

    public boolean isBalanced(TreeNode root) {

        helper(root);
        return res;
    }

    public int helper(TreeNode root){
        if (root==null) return 0;
        int leftSize=helper(root.left);
        int rightSize=helper(root.right);
        if (Math.abs(leftSize-rightSize)>1) res=false;
        return Math.max(leftSize,rightSize)+1;
    }

    public boolean isBalanced2(TreeNode root) {
        return recur(root) != -1;
    }

    private int recur(TreeNode root) {
        if (root == null) return 0;
        int left = recur(root.left);
        if(left == -1) return -1;
        int right = recur(root.right);
        if(right == -1) return -1;
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }


}

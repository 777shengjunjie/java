package IsBalanced_55_2;


import MaxDepth.TreeNode;

import static java.lang.Math.max;

public class CalIsBalanced {


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

        boolean resultPath=isBalanced(n1);
        System.out.println(resultPath);


    }
//自底而上
    public static boolean isBalanced(TreeNode root){

        return calHeight(root)>=0;


    }

    private static int calHeight(TreeNode root) {

        if (root==null) return 0;
        int leftHeight = calHeight(root.left);
        int rightHeight = calHeight(root.right);


        if (leftHeight==-1||rightHeight==-1||Math.abs(leftHeight-rightHeight)>1)
            return -1;
        return Math.max(calHeight(root.left), calHeight(root.right))+1;

    }

/*
        自顶而下遍历
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

   */
}

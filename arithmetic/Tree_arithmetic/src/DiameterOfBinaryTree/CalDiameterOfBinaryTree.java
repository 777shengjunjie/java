package DiameterOfBinaryTree;

import MaxDepth.TreeNode;


/*
        给定一棵二叉树，你需要计算它的直径长度。
        一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
        这条路径可能穿过也可能不穿过根结点。

        注意：两结点之间的路径长度是以它们之间边的数目表示。

*/
public class CalDiameterOfBinaryTree {

    static int ans=0;

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

        int resultPath=diameterOfBinaryTree(n1);
        System.out.println(resultPath);

    }


    public static int diameterOfBinaryTree(TreeNode root){

        if (root==null) return 0;
        ans=1;

        depth(root);

        return ans-1;


    }

    private  static int depth(TreeNode root) {
        if (root==null) return 0;
        int L_depth=depth(root.left);
        int R_depth=depth(root.right);
        ans=Math.max(L_depth+R_depth+1,ans);
        return Math.max(L_depth,R_depth)+1;
    }


}

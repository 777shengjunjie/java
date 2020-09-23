package LongestUnivaluePath_687;


import MaxDepth.TreeNode;


/*一个二叉树，找到最长的路径，这个路径中的每个节点具有相同值。 这条路径可以经过也可以不经过根节点。

        注意：两个节点之间的路径长度由它们之间的边数表示。
*/


public class CalLongestUnivaluePath {

    static int maxCount;

    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(4);
        TreeNode n3=new TreeNode(5);
        TreeNode n4=new TreeNode(4);
        TreeNode n5=new TreeNode(4);
        TreeNode n6=new TreeNode(5);

        n1.left= n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.right=n6;


        int result=longestUnivaluePath(n1);
        System.out.println(result);
    }

    public static int longestUnivaluePath(TreeNode root){

        helper(root);
        return maxCount;
    }

    private static int  helper(TreeNode root) {

        if (root==null) return 0;

        int left= helper(root.left);
        int right= helper(root.right);
        int allowLeft=0,allowRight=0;
        if (root.left!=null&&root.val == root.left.val) {
            allowLeft=left+1;

        }

        if (root.right!=null&&root.val==root.right.val){
            allowRight=right+1;

        }
        maxCount=Math.max(maxCount,allowLeft+allowRight);
        return Math.max(allowLeft,allowRight);











    }
}

package IsUnivalTree_965;


import MaxDepth.TreeNode;

import java.util.ArrayList;
import java.util.List;


/*

如果二叉树每个节点都具有相同的值，那么该二叉树就是单值二叉树。

        只有给定的树是单值二叉树时，才返回 true；否则返回 false。

*/
public class CalIsUnivalTree {

    static boolean ans=true;
    static ArrayList<Integer> vals;
    public static void main(String[] args) {

        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(2);
        TreeNode n4=new TreeNode(5);
        TreeNode n5=new TreeNode(2);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;

        boolean result=isUnivalTree3(n1);
        System.out.println(result);

    }

    //方法一
    public static boolean isUnivalTree(TreeNode root){

        if (root==null) return ans ;
        check(root, root.val);
        return ans;
    }

    private static void check(TreeNode root,int val) {

        if(root!=null){
            if (root.val==val) {
                if (ans==false) return;
                ans=true;
              check(root.left,val) ;
              check(root.right,val);


            }else {
                ans=false;
                return;
            }

        }


    }

    public static boolean isUnivalTree2(TreeNode root) {
        boolean left_correct = (root.left == null ||
                (root.val == root.left.val && isUnivalTree2(root.left)));
        boolean right_correct = (root.right == null ||
                (root.val == root.right.val && isUnivalTree2(root.right)));
        return left_correct && right_correct;
    }



    public static boolean isUnivalTree3(TreeNode root) {



        vals = new ArrayList();
        dfs(root);
        for (int v: vals)
            if (v != vals.get(0))
                return false;
        return true;
    }

    public static void dfs(TreeNode node) {
        if (node != null) {
            vals.add(node.val);
            dfs(node.left);
            dfs(node.right);
        }
    }



}

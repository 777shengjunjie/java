package LeafSimilar_872;

import MaxDepth.TreeNode;

import java.util.ArrayList;
import java.util.List;




/*
请考虑一颗二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。
*/

public class CalLeafSimilar {



    public static void main(String[] args) {

        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(5);
        TreeNode n3=new TreeNode(1);
        TreeNode n4=new TreeNode(6);
        TreeNode n5=new TreeNode(2);
        TreeNode n6=new TreeNode(7);
        TreeNode n7=new TreeNode(4);
        TreeNode n8=new TreeNode(9);
        TreeNode n9=new TreeNode(8);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n5.left=n6;
        n5.right=n7;
        n3.left=n8;
        n3.right=n9;

        boolean ans=leafSimilar(n1,n2);
        System.out.println(ans);


    }

    public static boolean leafSimilar(TreeNode root1,TreeNode root2){

        boolean ans=true;
        List<Integer> lists1=new ArrayList<>();
        List<Integer> lists2=new ArrayList<>();
        helper(root1,lists1);
        helper(root2,lists2);

      /*  if (lists1.size()!=lists2.size()) return false;
        else {
            for (int i = 0; i < lists1.size(); i++) {
                if (lists1.get(i)!=lists2.get(i)) ans=false;
                else continue;
            }
        }

        return ans;*/
       return   lists1.equals(lists2);
    }

    public static void helper(TreeNode root,List<Integer> lists){

        if (root==null) return;

        if (root.left==null&&root.right==null) lists.add(root.val);
        helper(root.left,lists);
        helper(root.right,lists);

    }


}

package PostorderTraversal_145;


import MaxDepth.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*给定一个二叉树，返回它的 后序 遍历。*/
public class PostorderTraversal {

    List<Integer> list=new ArrayList<>();
    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);

        n1.right=n2;
        n2.left=n3;
        List<Integer> result=new PostorderTraversal().postorderTraversal(n1);
        System.out.println(result);

    }

    public List<Integer> postorderTraversal(TreeNode root){

        helper(root);

        return list;
    }

    private void helper(TreeNode root) {

        if (root==null) return;
        helper(root.left);
        helper(root.right);
        list.add(root.val);


    }


}

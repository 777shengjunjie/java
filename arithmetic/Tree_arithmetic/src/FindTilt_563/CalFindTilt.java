package FindTilt_563;


import MaxDepth.TreeNode;

import java.util.ArrayList;
import java.util.List;


/*
给定一个二叉树，计算整个树的坡度。

        一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。

        整个树的坡度就是其所有节点的坡度之和。
*/

public class CalFindTilt {
    int tilt=0;

    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);

        n1.left=n2;
        n1.right=n3;

        int result=findTilt(n1);

        System.out.println(result);
    }

    public static int findTilt(TreeNode root){

        int sum=0;
        List<Integer> lists=new ArrayList<>();
        helper(root,lists);

        for (Integer list : lists) {
            sum+=list;
        }

        return sum;

    }

    private static int helper(TreeNode root, List<Integer> lists) {

        if (root==null) return 0;
        int leftTilt=helper(root.left,lists);
        int rightTilt=helper(root.right,lists);

        lists.add(Math.abs(leftTilt-rightTilt));


        return root.val+leftTilt+rightTilt;

    }



    public int findTilt2(TreeNode root) {
        traverse(root);
        return tilt;
    }
    public int traverse(TreeNode root)
    {
        if(root==null )
            return 0;
        int left=traverse(root.left);
        int right=traverse(root.right);
        tilt+=Math.abs(left-right);
        return left+right+root.val;
    }


}

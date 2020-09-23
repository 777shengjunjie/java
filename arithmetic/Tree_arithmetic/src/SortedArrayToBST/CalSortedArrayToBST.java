package SortedArrayToBST;

import MaxDepth.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CalSortedArrayToBST {

    public static void main(String[] args) {


       int[] nums={-10,-3,0,5,9};

        TreeNode result=sortedArrayToBST(nums);

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(result);
        while (!queue.isEmpty()) {
            TreeNode n=queue.poll();
            System.out.println(n.val);
            if (n.left!=null) queue.offer(n.left);
            if (n.right!=null) queue.offer(n.right);

        }

    }

    public static TreeNode sortedArrayToBST(int[] nums){

        return helper(nums,0,nums.length-1);
    }


    //选择中间位置左边的数字作为根节点(left+right)/2;选择中间位置右边的数字作为根节点(left+right+1)/2;
    private static TreeNode helper(int[] nums, int left, int right) {

        if(left>right) return null;


        int mid=(left+right)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);

        return root;



    }
}

package FindMode_501;


import MaxDepth.TreeNode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

        假定 BST 有如下定义：

        结点左子树中所含结点的值小于等于当前结点的值
        结点右子树中所含结点的值大于等于当前结点的值
        左子树和右子树都是二叉搜索树
*/


public class CalFindMode {


    static int maxCount = 1;
    static int curCount = 1;
    static TreeNode pre = null;

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(2);

        node1.right = node2;
        node2.left = node3;

        int[] result = findMode(node1);
        for (int i : result) {
            System.out.println(i);
        }


    }

    public static int[] findMode(TreeNode root) {


        List<Integer> nums = new ArrayList<>();

        helper(root, nums);
        int[] ans = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            ans[i] = nums.get(i);
        }

        return ans;


    }

    private static void helper(TreeNode root, List<Integer> nums) {

        if (root == null) return;
        helper(root.left, nums);
        if (pre != null) {
            if (pre.val == root.val) curCount++;
            else curCount = 1;
        }

        if (curCount > maxCount) {
            maxCount = curCount;
            nums.clear();
            nums.add(root.val);
        } else if (curCount == maxCount) {
            nums.add(root.val);

        }

        pre = root;

        helper(root.right, nums);
    }


}

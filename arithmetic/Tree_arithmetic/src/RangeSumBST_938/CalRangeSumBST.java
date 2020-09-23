package RangeSumBST_938;

import MaxDepth.TreeNode;

import java.util.Stack;

/*
给定二叉搜索树的根结点 root，返回 L 和 R（含）之间的所有结点的值的和。【L，R】之间所有节点的和

        二叉搜索树保证具有唯一的值。
*/

public class CalRangeSumBST {

    static int sum=0;

    public static void main(String[] args) {

            TreeNode n1=new TreeNode(10);
            TreeNode n2=new TreeNode(5);
            TreeNode n3=new TreeNode(15);
            TreeNode n4=new TreeNode(3);
            TreeNode n5=new TreeNode(7);
            TreeNode n6=new TreeNode(18);

            n1.left=n2;
            n1.right=n3;

            n2.left=n4;
            n2.right=n5;

            n3.right=n6;

            int result=rangeSumBST2(n1,7,15);
            System.out.println(result);


    }

    public static int rangeSumBST(TreeNode root,int L,int R){

        if (root ==null) return 0;

        if (R< root.val){
            rangeSumBST(root.left,L,R);
        }else if (L> root.val){
            rangeSumBST(root.right,L,R);
        }else {
            sum+= root.val;
            rangeSumBST(root.left,L,R);
            rangeSumBST(root.right,L,R);
        }

        return sum;

    }

    //方法二是方法一的优化
    public void dfs(TreeNode node, int L, int R) {
        if (node != null) {
            if (L <= node.val && node.val <= R)
                sum += node.val;
            if (L < node.val)
                dfs(node.left, L, R);
            if (node.val < R)
                dfs(node.right, L, R);
        }
    }
    //迭代实现深度优先搜索
    public static int rangeSumBST2(TreeNode root,int L,int R){

        int ans=0;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node=stack.pop();
            if (node!=null){
                if (L<= node.val&&node.val<=R) ans+= node.val;
                if (L<node.val) stack.push(node.left);
                if (R>node.val) stack.push(node.right);
            }
        }

        return ans;

    }
}


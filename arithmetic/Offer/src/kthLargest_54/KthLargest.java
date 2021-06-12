package kthLargest_54;

import java.util.ArrayList;
import java.util.List;

public class KthLargest {
    public static void main(String[] args) {
        TreeNode t1=new TreeNode(3);
        TreeNode t2=new TreeNode(4);
        TreeNode t3=new TreeNode(1);
        TreeNode t4=new TreeNode(2);
        t1.right=t2;
        t1.left=t3;
        t3.right=t4;
        int result=new KthLargest().kthLargest(t1,1);
        System.out.println(result);

    }

    int res=0,k=0;
    public int kthLargest(TreeNode root, int k) {
       if (root==null) return 0;
       this.k=k;
       help(root);
       return res;

    }

    public void help(TreeNode root){
        if (root==null) return;
        help(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        help(root.left);
    }

}

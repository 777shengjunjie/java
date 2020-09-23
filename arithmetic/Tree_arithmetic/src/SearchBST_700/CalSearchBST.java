package SearchBST_700;




/*

给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。
        返回以该节点为根的子树。 如果节点不存在，则返回 NULL。

*/

import MaxDepth.TreeNode;
import jdk.nashorn.api.tree.Tree;

import javax.swing.table.TableRowSorter;
import java.util.LinkedList;
import java.util.Queue;

public class CalSearchBST {

    public static void main(String[] args) {

        TreeNode n1=new TreeNode(4);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(7);
        TreeNode n4=new TreeNode(1);
        TreeNode n5=new TreeNode(3);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;


        TreeNode result=searchBST(n1,2);

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(result);
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            System.out.println(node.val);
            if (node.left!=null) queue.offer(node.left);
            if (node.right!=null) queue.offer(node.right);
        }

    }

    public static TreeNode searchBST(TreeNode root ,int val){

        TreeNode ans=root;
        if (root==null) return null;

        if (root.val==val) return ans;
        else   if (root.val>val) ans=searchBST(root.left,val);
        else    ans=searchBST(root.right,val);

        return ans;


    }

    //迭代
    public TreeNode searchBST2(TreeNode root, int val) {
        while (root != null && val != root.val)
            root = val < root.val ? root.left : root.right;
        return root;
    }




}

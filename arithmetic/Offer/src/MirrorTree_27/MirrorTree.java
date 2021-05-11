package MirrorTree_27;

import java.util.*;

public class MirrorTree {



    public static void main(String[] args) {


        TreeNode node=new TreeNode(4);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(7);
        TreeNode node3=new TreeNode(1);
        TreeNode node4=new TreeNode(3);
        TreeNode node5=new TreeNode(6);
        TreeNode node6=new TreeNode(9);
        node.left=node1;
        node.right=node2;
        node1.left=node3;
        node1.right=node4;
        node2.left=node5;
        node2.right=node6;

        TreeNode result=new MirrorTree().mirrorTree(node);

    }

    public TreeNode mirrorTree(TreeNode root) {

        if (root==null) return null;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
//            System.out.println(node.val);
            if (node.right!=null){
                queue.add(node.right);
            }
            if (node.left!=null){
                queue.add(node.left);
            }
            TreeNode temp=node.left;
            node.left=node.right;
            node.right=temp;
        }

        return root;
    }

}

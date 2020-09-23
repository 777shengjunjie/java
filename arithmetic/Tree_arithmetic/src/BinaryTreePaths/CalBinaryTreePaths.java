package BinaryTreePaths;

import MaxDepth.TreeNode;


import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class CalBinaryTreePaths {

    public static void main(String[] args) {

        TreeNode n1=new TreeNode(1);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(3);
        TreeNode n4=new TreeNode(5);


        n1.left=n2;
        n1.right=n3;
        n2.right=n4;

        List<String> result=binaryTreePaths2(n1);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }




    }

    //方法一：递归 给定一个二叉树，返回所有从根节点到叶子节点的路径。
    public static List<String> binaryTreePaths(TreeNode root){

        LinkedList<String> ans=new LinkedList<>();
        String path="";
        construct_path(root,path,ans);

        return ans;
    }

    public static void construct_path(TreeNode root,String path,LinkedList<String> paths){


        if (root==null) return;
        path+=String.valueOf(root.val);
        if (root.left==null&&root.right==null) paths.add(path);
        else  {
            path+="->";
            construct_path(root.left,path,paths);
            construct_path(root.right,path,paths);
        }

    }
   //迭代 给定一个二叉树，返回所有从根节点到叶子节点的路径。
    public static List<String> binaryTreePaths2(TreeNode root){

        LinkedList<String> paths = new LinkedList();
        if (root == null)
            return paths;

        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while (!node_stack.isEmpty()) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }












}

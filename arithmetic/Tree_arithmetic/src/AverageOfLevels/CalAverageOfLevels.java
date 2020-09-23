package AverageOfLevels;

import MaxDepth.TreeNode;

import java.util.*;

/*

给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。

*/

public class CalAverageOfLevels {

    public static void main(String[] args) {


        TreeNode n1=new TreeNode(3);
        TreeNode n2=new TreeNode(9);
        TreeNode n3=new TreeNode(20);
        TreeNode n4=new TreeNode(15);
        TreeNode n5=new TreeNode(7);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;

        List<Double> result=averageOfLevels2(n1);
        for (Double ans : result) {
            System.out.println(ans);
        }

    }


    //广度优先搜索
    public static List<Double> averageOfLevels(TreeNode root){

        List<Double> ans=new ArrayList<>();

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        TreeNode node=null;
        while (!queue.isEmpty()){
            int size=queue.size();
            int num=size;
            double sum=0;

            while (size>0){
                node= queue.poll();
                if (node.left!=null)   queue.offer(node.left);
                if (node.right!=null)   queue.offer(node.right);
                sum+= node.val;
                size--;
            }

            ans.add(sum/num);
        }
        return ans;

    }

    public static List<Double> averageOfLevels2(TreeNode root){
        List < Integer > count = new ArrayList < > ();
        List < Double > res = new ArrayList < > ();
        average(root, 0, res, count);
        for (int i = 0; i < res.size(); i++)
            res.set(i, res.get(i) / count.get(i));
        return res;
    }
    public static void average(TreeNode t, int i, List < Double > sum, List < Integer > count) {
        if (t == null)
            return;
        if (i < sum.size()) {
            sum.set(i, sum.get(i) + t.val);
            count.set(i, count.get(i) + 1);
        } else {
            sum.add(1.0 * t.val);
            count.add(1);
        }
        average(t.left, i + 1, sum, count);
        average(t.right, i + 1, sum, count);
    }



}

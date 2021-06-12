package IsSubStructure_26;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsSubStructure {


    public static void main(String[] args) {
        TreeNode A=new TreeNode(1);
        TreeNode A1=new TreeNode(0);
        TreeNode A2=new TreeNode(1);
        TreeNode A3=new TreeNode(-4);
        TreeNode A4=new TreeNode(-3);
//        TreeNode A5=new TreeNode(6);
//        TreeNode A6=new TreeNode(7);
//        TreeNode A7=new TreeNode(8);
//        TreeNode A8=new TreeNode(9);
        A.left=A1;
        A.right=A2;
        A1.left=A3;
        A1.right=A4;
//        A2.left=A5;
//        A2.right=A6;
//        A3.left=A7;
//        A3.right=A8;
        TreeNode B=new TreeNode(1);
        TreeNode B1=new TreeNode(-4);
//        TreeNode B2=new TreeNode(9);
        B.left=B1;
//        B.right=B2;
        boolean result=new IsSubStructure().isSubStructure(A,B);
        System.out.println(result);
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (B==null) return false;

        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(A);
        while (!queue.isEmpty()){
            TreeNode temp=queue.poll();
            if (temp.val==B.val){
                Queue<TreeNode> queueA=new LinkedList<>();
                queueA.add(temp);
                Queue<TreeNode> queueB=new LinkedList<>();
                queueB.add(B);
                boolean flag=true;
                while (!queueA.isEmpty()||!queueB.isEmpty()){
                    TreeNode tempA=queueA.poll();
                    TreeNode tempB=queueB.poll();
                    if (tempA.val!=tempB.val){
                        flag=false;
                        break;
                    }
                    if (tempB.left!=null&&tempA.left==null){
                        flag=false;
                        break;
                    }
                    if (tempB.right!=null&&tempA.right==null){
                        flag=false;
                        break;
                    }

                    if (tempB.left!=null&&tempA.left!=null){
                        queueB.add(tempB.left);
                        queueA.add(tempA.left);
                    }

                    if (tempB.right!=null&&tempA.right!=null){
                        queueB.add(tempB.right);
                        queueA.add(tempA.right);
                    }
                }
                if (flag) return true;
            }
            if (temp.left!=null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
        }

        return false;
    }


    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        return (A!=null&&B!=null)&&(recur(A,B)||isSubStructure2(A.left,B)||isSubStructure2(A.right,B));
    }

    boolean recur(TreeNode A,TreeNode B){
        if (B==null) return true;
        if (A==null||A.val!=B.val) return false;
        return recur(A.left,B.left)&&recur(A.right,B.right);
    }
}

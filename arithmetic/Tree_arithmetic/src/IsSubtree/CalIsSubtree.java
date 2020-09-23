package IsSubtree;

import MaxDepth.TreeNode;




public class CalIsSubtree {


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


        TreeNode t3=new TreeNode(20);
        TreeNode t4=new TreeNode(15);
        TreeNode t5=new TreeNode(7);

        t3.left=t4;
        t3.right=t5;

        boolean resultPath=isSubtree(n1,t3);
        System.out.println(resultPath);
    }

/*
    给定两个非空二叉树 s 和 t，检验s 中是否包含和 t 具有相同结构和节点值的子树。
    s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
*/


    public static boolean isSubtree(TreeNode s,TreeNode t){

        if (s==null&&t==null) return true;
        if (s==null||t==null) return false;

        return isSubtree(s.left,t)||isSubtree(s.right,t)||isSame(s,t);

        }

    private static boolean isSame(TreeNode s, TreeNode t) {
        if (s==null&&t==null) return true;
        if (s==null||t==null) return false;

        if (s.val!=t.val) return false;

        return isSame(s.left,t.left)&&isSame(s.right,t.right);


    }



}

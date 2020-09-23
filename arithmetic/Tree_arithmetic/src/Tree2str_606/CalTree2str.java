package Tree2str_606;


import MaxDepth.TreeNode;


/*
你需要采用前序遍历的方式，将一个二叉树转换成一个由括号和整数组成的字符串。

空节点则用一对空括号 "()" 表示。而且你需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
*/

public class CalTree2str {


    public static void main(String[] args) {
            TreeNode n1=new TreeNode(1);
            TreeNode n2=new TreeNode(2);
            TreeNode n3=new TreeNode(3);
            TreeNode n4=new TreeNode(4);
            n1.left=n2;
            n1.right=n3;
            n2.left=n4;
            String result=tree2str(n1);
            System.out.println(result);

    }

    public static String tree2str(TreeNode t){

        if (t==null) return "";
        if (t.right==null&&t.left==null) return t.val+"";
        if (t.right==null) return t.val+"("+tree2str(t.left)+")";
        return  t.val+"("+tree2str(t.left)+")("+tree2str(t.right)+")";


    }

}

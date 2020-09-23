package FindSecondMinimumValue_671;




/*

给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为2或0。
如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。

*/


import MaxDepth.TreeNode;

public class CalFindSecondMinimumValue {


    public static void main(String[] args) {

        TreeNode n1=new TreeNode(2);
        TreeNode n2=new TreeNode(2);
        TreeNode n3=new TreeNode(5);
        TreeNode n4=new TreeNode(5);
        TreeNode n5=new TreeNode(7);

        n1.left=n2;
        n1.right=n3;
        n3.left=n4;
        n3.right=n5;

        int result=findSecondMinimumValue(n1);

        System.out.println(result);

    }

    public  static int findSecondMinimumValue(TreeNode root){

       /* int ans= root.val;

        if (root!=null){
            if (root.left.val==root.right.val) {

                findSecondMinimumValue(root.left);
                findSecondMinimumValue(root.right);
                return -1;
            }
            ans= root.left.val> root.right.val ? root.left.val : root.right.val ;



            return ans;
        }

    return ans;*/

        if (root == null) return -1;
        return help(root, root.val);
    }

    private static int help(TreeNode root, int min) {
        if (root == null) return -1;
        if (root.val > min) return root.val;
        int left = help(root.left, min);
        int right = help(root.right, min);
        if (left == -1) return right;
        if (right == -1) return left;
        return Math.min(left, right);
    }


}

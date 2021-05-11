package MaxDepth_55_1;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    public int maxDepth(TreeNode root) {
        if (root==null) return 0;

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

    public int maxDepth2(TreeNode root) {
        if (root==null) return 0;
        int res=0;
        Queue<TreeNode> nodes=new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            Queue<TreeNode> temp=new LinkedList<>();
            for (TreeNode node : nodes) {
                if (node.left!=null) temp.add(node.left);
                if (node.right!=null) temp.add(node.right);
            }
            nodes=temp;
            res++;
        }
        return res;

    }
}

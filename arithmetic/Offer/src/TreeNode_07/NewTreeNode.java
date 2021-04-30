package TreeNode_07;


import java.util.HashMap;
import java.util.Map;

public class NewTreeNode {

    int[] preorder;
    Map<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);
        }

        return recur(0,0,inorder.length-1);
    }

    public TreeNode recur(int root,int left,int right){
        if (left>right) return null;
        TreeNode node=new TreeNode(preorder[root]);
        int i=map.get(preorder[root]);
        node.left=recur(root+1,left,i-1);
        node.right=recur(root+i-left+1,i+1,right);

        return node;
    }

}

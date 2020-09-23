package IsCousins_993;

import MaxDepth.TreeNode;

import java.util.HashMap;
import java.util.Map;


/*
        在二叉树中，根节点位于深度 0 处，每个深度为 k 的节点的子节点位于深度 k+1 处。

        如果二叉树的两个节点深度相同，但父节点不同，则它们是一对堂兄弟节点。

        我们给出了具有唯一值的二叉树的根节点 root，以及树中两个不同节点的值 x 和 y。

        只有与值 x 和 y 对应的节点是堂兄弟节点时，才返回 true。否则，返回 false。
*/

public class CalIsCousins {
    static Map<Integer,TreeNode> par;
    static Map<Integer,Integer> depth;

    public static void main(String[] args) {

        TreeNode node=new TreeNode(1);
        TreeNode node1=new TreeNode(2);
        TreeNode node2=new TreeNode(3);
        TreeNode node3=new TreeNode(4);

        node.left=node1;
        node.right=node2;
        node1.left=node3;

        boolean result =isCousins(node,4,3);
        System.out.println(result);


    }
/*
    我们用深度优先搜索标记每一个节点，对于每一个节点 node，它的父亲为 par，深度为 d，
    我们将其记录到 Hashmap 中：parent[node.val] = par 且 depth[node.val] = d。

 */
    public static boolean isCousins(TreeNode root,int x,int y){

        par=new HashMap<>();
        depth=new HashMap<>();
        dfs(root,null);


        return  par.get(x)!=par.get(y)&&depth.get(x)==depth.get(y);

    }

    private static void dfs(TreeNode root,TreeNode p) {

        if (root!=null){
            depth.put(root.val, p!=null ? depth.get(p.val)+1:0);
            par.put(root.val,p);
            dfs(root.left,root);
            dfs(root.right,root);
        }


    }
}

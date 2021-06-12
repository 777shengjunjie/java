package LevelOrder_32_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {



    public static void main(String[] args) {


    }

    public int[] levelOrder(TreeNode root) {

        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        if (root!=null) queue.add(root);
        while (!queue.isEmpty()){
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node= queue.poll();
                list.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
            }
        }

        int[] res=new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;
    }
}

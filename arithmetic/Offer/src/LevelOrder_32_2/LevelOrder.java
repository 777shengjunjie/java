package LevelOrder_32_2;

import org.omg.CORBA.INTERNAL;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args) {

    }

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res=new ArrayList<>();
        if (root==null) return res;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp=queue.poll();
                list.add(temp.val);
                if (temp.left!=null) queue.add(temp.left);
                if (temp.right!=null) queue.add(temp.right);
            }
            res.add(list);


        }

        return res;
    }


}

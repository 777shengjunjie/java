package LevelOrder_32_3;

import java.util.*;

public class LevelOrder {

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n3.right = n5;
        List<List<Integer>> result = new LevelOrder().levelOrder(n1);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }

    }

    public List<List<Integer>> levelOrder(TreeNode root) {


        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        boolean flag = true;
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);

            }

            if (!flag)   Collections.reverse(list);
            res.add(list);
            flag = (!flag);

        }
        return res;

    }

}

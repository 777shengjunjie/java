package FindTarget_653;


import MaxDepth.TreeNode;


import java.util.*;

/*
给定一个二叉搜索树和一个目标结果，如果 BST 中存在两个元素且它们的和等于给定的目标结果，则返回 true。

  */
public class CalFindTarget {

    public static void main(String[] args) {

        TreeNode n1=new TreeNode(5);
        TreeNode n2=new TreeNode(3);
        TreeNode n3=new TreeNode(6);
        TreeNode n4=new TreeNode(2);
        TreeNode n5=new TreeNode(4);
        TreeNode n6=new TreeNode(7);

        n1.left=n2;
        n1.right=n3;
        n2.left=n4;
        n2.right=n5;
        n3.right=n6;

        boolean result=findTarget2(n1,28);
        System.out.println(result);



    }


    public static  boolean findTarget(TreeNode root ,int k){

        Set<Integer> set=new HashSet<>();
        return find(root,k,set);

    }

    private static boolean find(TreeNode root, int k, Set<Integer> set) {

        if (root==null) return false;
        if (set.contains(k - root.val)) return true;

        set.add(root.val);

        return find(root.left,k,set)||find(root.right,k,set);

    }

    private static boolean findTarget2(TreeNode root, int k) {

        Set<Integer> set2 =new HashSet<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                    TreeNode node = queue.remove();
                    if (set2.contains(k - node.val))
                        return true;
                    set2.add(node.val);
                    queue.add(node.right);
                    queue.add(node.left);
                } else
                    queue.remove();
            }

            return false;

    }

    public static boolean findTarget3(TreeNode root, int k) {
        List< Integer > list = new ArrayList();
        inorder(root, list);
        int l = 0, r = list.size() - 1;
        while (l < r) {
            int sum = list.get(l) + list.get(r);
            if (sum == k)
                return true;
            if (sum < k)
                l++;
            else
                r--;
        }
        return false;
    }
    public static void inorder(TreeNode root, List < Integer > list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }


}

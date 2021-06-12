package PathSum_34;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

    public static void main(String[] args) {

    }


    public List<List<Integer>> res=new ArrayList<>();
    public List<Integer> list=new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {

        recur(root,target);
        return res;

    }

    public void recur(TreeNode root,int target){
        if (root==null) return;
        target-=root.val;
        list.add(root.val);
        if (target==0) {
            if (root.left==null&&root.right==null){
                res.add(new ArrayList<>(list));
            }
            list.remove(list.size()-1);
            return;
        }

        recur(root.left, target);
        recur(root.right, target);
        list.remove(list.size()-1);
    }


}

package IsSymmetric_28;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class IsSymmetric {

    public static void main(String[] args) throws FileNotFoundException {



    }

    public boolean isSymmetric(TreeNode root) {
        if (root==null) return true;
        return recur(root.left,root.right);
    }

    public boolean recur(TreeNode left,TreeNode right){
        if (left==null&&right==null) return true;
        if (left==null||right==null||left.val!=right.val) return false;
        return recur(left.left,right.right)&&recur(left.right,right.left);
    }





}

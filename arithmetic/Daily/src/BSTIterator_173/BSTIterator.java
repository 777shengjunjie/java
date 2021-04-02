package BSTIterator_173;

public class BSTIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        TreeNode root1 = new TreeNode(3);
        TreeNode root2 = new TreeNode(15);
        TreeNode root3 = new TreeNode(9);
        TreeNode root4 = new TreeNode(20);
        root.left = root1;
        root.right = root2;
        root2.left = root3;
        root2.right = root4;
        BSTIterator obj = new BSTIterator(root);
        int param_1 = obj.next();
        boolean param_2 = obj.hasNext();
    }

    public TreeNode dummy = new TreeNode(Integer.MIN_VALUE);
    public int nextNum = 0;
    public boolean given = false;
    public int nextCount = 0;
    public int moveCount = -1;
    public int allCount = 0;
    public int count = 0;

    public BSTIterator(TreeNode root) {

        this.dummy.right = root;
        move(dummy.right);
        allCount = count;
        moveCount++;
    }

    public int next() {
        moveCount++;
        nextCount=0;
        allCount--;
        move(dummy.right);
        return nextNum;
    }

    public void move(TreeNode root) {
        if (root == null) {
            given = true;
            return;
        }
        move(root.left);
        count++;
        if (given) {
            nextCount++;
            if (nextCount == moveCount) {
                nextNum = root.val;
                return;
            }

        }
        move(root.right);
    }

    public boolean hasNext() {
        allCount--;
        if (allCount < 0) {
            return false;
        }
        return true;
    }
}

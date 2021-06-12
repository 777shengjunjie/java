package VerifyPostorder_33;


public class VerifyPostorder implements Cloneable{



    public static void main(String[] args)  {


    }

    public boolean verifyPostorder(int[] postorder) {

        return recur(postorder,0,postorder.length-1);
    }

    private boolean recur(int[] postorder, int i, int j) {

        if (i>=j) return true;
        int p=i;
        while (postorder[p]<postorder[j]) p++;
        int m=p;
        while (postorder[m]>postorder[j]) m++;
        return j==m&&recur(postorder,i,m-1)&&recur(postorder,m,j-1);
    }

}



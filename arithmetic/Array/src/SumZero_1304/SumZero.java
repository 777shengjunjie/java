package SumZero_1304;


/**
 * 给你一个整数n，请你返回任意一个由n个各不相同的整数组成的数组，并且这n个数相加和为0。
 */
public class SumZero {

    public static void main(String[] args) {
       int n=4;
       int[] result=new SumZero().sumZero(n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sumZero(int n) {

        int[] ans=new int[n];
        if (n%2==0){
            for (int i = 1; i <= ans.length/2; i++) {
                ans[2*i-2]=i;
                ans[2*i-1]=-i;
            }
        }else {
            ans[0]=0;
            for (int i = 1; i <= (ans.length-1)/2; i++) {
                ans[2*i-1]=i;
                ans[2*i]=-i;
            }
        }
        return ans;
    }
}

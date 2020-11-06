package Tribonacci_1137;


/**
 * 泰波那契序列Tn定义如下：
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * 给你整数n，请返回第 n 个泰波那契数Tn 的值。
 */
public class Tribonacci {

    public static void main(String[] args) {

        int n=25;
        int result =new Tribonacci().tribonacci(n);
        System.out.println(result);

    }


    public int tribonacci(int n) {

        int T0=0,T1=1,T2=1;
        if (n==0) return T0;
        else if (n==1) return T1;
        else if (n==2) return T2;
        int Tn=helper(T0,T1,T2,n);
        return Tn;
    }

    private int helper(int t0, int t1, int t2, int n) {
        if (--n<2) return t2;
        int t=t0+t1+t2;
        int Tn=helper(t1,t2,t,n);
        return Tn;

    }

    public int tribonacci2(int n) {
        if (n < 3) return n == 0 ? 0 : 1;

        int tmp, x = 0, y = 1, z = 1;
        for (int i = 3; i <= n; ++i) {
            tmp = x + y + z;
            x = y;
            y = z;
            z = tmp;
        }
        return z;
    }

    private int n = 38;
    public int[] nums = new int[n];

      Tribonacci() {
        nums[1] = 1;
        nums[2] = 1;
        for (int i = 3; i < n; ++i)
            nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
    }



    public static Tribonacci t = new Tribonacci();
    public int tribonacci3(int n) {
        return t.nums[n];
    }




}

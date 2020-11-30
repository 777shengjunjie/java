package Fib_509;


/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 */
public class Fib {

    public static void main(String[] args) {
        int N=4;
        int result=new Fib().fib(N);
        System.out.println(result);
    }

    public int fib(int N){
        int F0=0,F1=1;
        if (N==0) return 0;
        if (N==1) return F1;
        while (N-1>0){
            int temp=F1;
            F1=F1+F0;
            F0=temp;
            N--;
        }

        return F1;
    }

    public int fib2(int N) {
        if (N <= 1) {
            return N;
        }
        return fib(N-1) + fib(N-2);
    }

    private Integer[] cache = new Integer[31];

    public int fib3(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(N);
    }

    public int memoize(int N) {
        if (cache[N] != null) {
            return cache[N];
        }
        cache[N] = memoize(N-1) + memoize(N-2);
        return memoize(N);
    }



}

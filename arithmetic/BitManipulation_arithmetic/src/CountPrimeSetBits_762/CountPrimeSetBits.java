package CountPrimeSetBits_762;


/**
 * 给定两个整数L和R，找到闭区间[L, R]范围内，计算置位位数为质数的整数个数。
 * （注意，计算置位代表二进制表示中1的个数。例如21的二进制表示10101有 3 个计算置位。还有，1 不是质数。
 */
public class CountPrimeSetBits {

    public static void main(String[] args) {

        int L=6,R=10;
        int result =new CountPrimeSetBits().countPrimeSetBits(L,R);
        System.out.println(result);
    }


    public int countPrimeSetBits(int L,int R){

        int count=0,bitCount=0;
        for (int i = L; i <= R; i++) {

            bitCount=Integer.bitCount(i);
            if (bitCount==1) continue;
            int j;
            for (j = 2; j < bitCount ; j++) {

                if (bitCount%j==0) break;


            }
            if (j==bitCount) count++;

        }

        return count;
    }



    public int countPrimeSetBits2(int L, int R) {
        int ans = 0;
        for (int x = L; x <= R; ++x)
            if (isSmallPrime(Integer.bitCount(x)))
                ans++;
        return ans;
    }


    public boolean isSmallPrime(int x) {
        return (x == 2 || x == 3 || x == 5 || x == 7 ||
                x == 11 || x == 13 || x == 17 || x == 19);
    }



}

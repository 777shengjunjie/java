package CountPrimes_204;

import java.util.Arrays;

/**
 * 统计所有小于非负整数 n 的质数的数量。
 */
public class CountPrimes {

    public int countPrimes(int n) {
            int[] isPrime = new int[n];
            Arrays.fill(isPrime, 1);
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                if (isPrime[i] == 1) {
                    ans += 1;
                    if ((long) i * i < n) {
                        for (int j = i * i; j < n; j += i) {
                            isPrime[j] = 0;
                        }
                    }
                }
            }
            return ans;

    }

    /**
     * 超时，算法不好
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int count=0;
        for(int i=2;i<n;i++){
            count += isPrimes(i) ? 1 : 0;
        }
        return count;
    }

    public boolean isPrimes(int n){

        for(int i=2;i<=n-1;i++){
            if(n%i==0){
                return false;
            }
        }

        return true;
    }
}

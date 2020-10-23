package HasAlternatingBits_693;


/**
 * 给定一个正整数，检查他是否为交替位二进制数：换句话说，就是他的二进制数相邻的两个位数永不相等。
 */
public class HasAlternatingBits {

    public static void main(String[] args) {

        int n=10;
        boolean result=new HasAlternatingBits().hasAlternatingBits(n);
        System.out.println(result);

    }

    public boolean hasAlternatingBits(int n){

        int count=0;
        StringBuilder sb=new StringBuilder();
        while(n!=0){
            sb.append(n&1);
            n>>>=1;
            count++;
        }

        if (count==1) return true;

        for (int i = 0; i < count-1; i++) {

            if (sb.charAt(i+1)!=sb.charAt(i)) continue;
            else return false;
        }

        return true;
    }

    public boolean hasAlternatingBits2(int n) {
        // 初始化，为 n 的最后一位
        int prev = n & 1;


        while (n != 0) {
            n >>= 1;
            int cur = n & 1;

            // 当前和上一个相等，返回 false
            if (cur == prev) return false;

            // 不相等，把 prev 设置当前，用于下一个比较
            prev = cur;
        }

        // 遍历完，都不相等，返回 true
        return true;
    }

    /**
     * # 若n是交替位二进制数,则n与右移1位的数字异或后，有效二进制位一定全是1
     * # 若n不是交替位二进制数则n与右移1位的数字异或后，有效二进制位一定包含0
     * # 而一个数字m的有效位是否全是1，等价于m&(m+1)是否为0
     * @param n
     * @return
     */
    public boolean hasAlternatingBits3(int n) {
        int tmp = n ^ (n >> 1);
        return (tmp & (tmp + 1)) == 0;
    }



}

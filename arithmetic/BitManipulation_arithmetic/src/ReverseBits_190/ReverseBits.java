package ReverseBits_190;


/**
 * 颠倒给定的 32 位无符号整数的二进制位。-1使用的时候为1111 1111
 */
public class ReverseBits {

    public static void main(String[] args) {



        int n = 0b11_111_111_111_111_111_111_111_111_111_101;


        int result = new ReverseBits().reverseBits(n);

        System.out.println(result);

    }


    public int reverseBits(int n) {

        //ans最终返回的值，ret反转的索引
        int ans = 0;
        for (int ret=31;ret>=0;ret--)
        {
            ans += (n & 1) << ret;
            n >>= 1;

        }

        return ans;
    }

    public int reverseBits2(int n) {

        n = (n >>> 16) | (n << 16);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);

        return n;
    }


}

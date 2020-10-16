package HammingWeight_191;





/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 */
public class HammingWeight {


    public static void main(String[] args) {


        int n=00000000000000000000000000001011;

        int result=new HammingWeight().hammingWeight(n);
        System.out.println(result);

    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {

        int count=0;
        while(n!=0){

            n=n&(n-1);
            count++;
        }

        return count;
    }

    public int hammingWeight2(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }


}

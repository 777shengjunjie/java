package GetSum_371;

/**
 * 不使用运算符 + 和 - ，计算两整数 a 、b 之和。
 */
public class GetSum {

    public static void main(String[] args) {

        int a=-2,b=3;
        int result=new GetSum().getSum(a,b);
        System.out.println(result);
    }

    /**
     * 第一步：相加各位的值，不算进位，得到010，二进制每位相加就相当于各位做异或操作，101^111。
     * 第二步：计算进位值，得到1010，相当于各位进行与操作得到101，再向左移一位得到1010，(101&111)<<1。
     * 第三步重复上述两步，各位相加 010^1010=1000，进位值为100=(010 & 1010)<<1。
     * 继续重复上述两步：1000^100 = 1100，进位值为0，跳出循环，1100为最终结果。
     * 结束条件：进位为0，即a为最终的求和结果。
     * @param a
     * @param b
     * @return
     */
    public int getSum(int a,int b){

        int temp=0;
        while (b!=0){
            temp=a^b;
            b=(a&b)<<1;
            a=temp;
        }

        return a+b;
    }
}

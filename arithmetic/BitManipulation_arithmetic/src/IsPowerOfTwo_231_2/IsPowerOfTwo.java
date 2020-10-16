package IsPowerOfTwo_231_2;


/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 *      如何获取二进制中最右边的 1：x & (-x)。
 *     如何将二进制中最右边的 1 设置为 0：x & (x - 1)。
 */
public class IsPowerOfTwo {


    public static void main(String[] args) {


        int n=-2147483648;
        boolean result=new IsPowerOfTwo().isPowerOfTwo3(n);
        System.out.println(result);
    }


    public boolean isPowerOfTwo(int n){

        while (n!=1&&n>0){
            if (n%2==0) {
                n/=2;
                continue;
            }else {
                break;
            }

        }
        if (n==1) return true;
        return false;
    }

    public boolean isPowerOfTwo2(int n) {
        if (n == 0) return false;
        long x = (long) n;
        return (x & (-x)) == x;
    }

    //int -2,147,483,648——2,147,483,647
    public boolean isPowerOfTwo3(int n) {
        if (n== 0) return false;
        long x = (long) n;

        return (x & (x - 1)) == 0;
    }



}

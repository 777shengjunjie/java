package IsPowerOfFour_324_4;


/**
 * 给定一个整数 (32 位有符号整数)，请编写一个函数来判断它是否是 4 的幂次方。
 */
public class IsPowerOfFour {


    public static void main(String[] args) {
        int num=16;
        boolean result=new IsPowerOfFour().isPowerOfFour2(num);
        System.out.println(result);

    }


    public boolean isPowerOfFour(int num){

        if (num==0) return false;
        while (num!=1){
            if (num%4==0){
            num/=4;
            }else  {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查 num 是否为 2 的幂：x > 0 and x & (x - 1) == 0
     *(101010...10)用十六进制表示为 ：(aaaaaaaa)
     * 在第一种情况下（4 的幂），1 处于偶数位置：第 0 位、第 2 位、第 4 位等 num & 0xaaaaaaaa
     * @param num
     * @return
     */
    public boolean isPowerOfFour2(int num){

        return (num>0)&&((num&(num-1))==0)&&((num&0xaaaaaaaa)==0);


    }


}

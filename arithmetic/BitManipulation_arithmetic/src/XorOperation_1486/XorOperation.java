package XorOperation_1486;


/**
 * 给你两个整数，n 和 start 。
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 */
public class XorOperation {

    public static void main(String[] args) {

        int n=1,start=7;
        int result=new XorOperation().xorOperation(n,start);
        System.out.println(result);

    }


    public int xorOperation(int n,int start){

        int ans=0;
        for (int i = 0; i < n; i++) {
            ans^=start+2*i;
        }
        return ans;
    }
}

package GetMaximumGenerated_1646;


import java.util.Arrays;

/**
 * 给你一个整数 n 。按下述规则生成一个长度为 n + 1 的数组 nums ：
 *
 * nums[0] = 0
 * nums[1] = 1
 * 当 2 <= 2 * i <= n 时，nums[2 * i] = nums[i]
 * 当 2 <= 2 * i + 1 <= n 时，nums[2 * i + 1] = nums[i] + nums[i + 1]
 * 返回生成数组 nums 中的 最大 值
 */
public class GetMaximumGenerated {

    public static void main(String[] args) {

        int n=7;
        int result=new GetMaximumGenerated().getMaximumGenerated(n);
        System.out.println(result);
    }

    public int getMaximumGenerated(int n) {
        if (n==0) return 0;
        else if (n==1) return 1;

        int[] array=new int[n+1];
        array[0]=0;
        array[1]=1;
        for (int i = 2; i < n + 1; i++) {
            if (i%2==0){
                array[i] = array[i/2];
            }else {
                array[i]=array[i/2+1]+array[i/2];
            }
        }

        Arrays.sort(array);

        return array[n];
    }
}

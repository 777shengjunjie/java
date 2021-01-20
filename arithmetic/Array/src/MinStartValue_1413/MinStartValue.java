package MinStartValue_1413;


import java.util.List;

/**
 * 给你一个整数数组 nums。你可以选定任意的正数 startValue 作为初始值。
 *
 * 你需要从左到右遍历 nums数组，并将 startValue 依次累加上nums数组中的值。
 *
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的正数作为 startValue 。
 */
public class MinStartValue {

    public static void main(String[] args) {
        int[] nums={-3,2,-3,4,2};
        int result=new MinStartValue().minStartValue(nums);
        System.out.println(result);
    }


    public int minStartValue(int[] nums) {

        int sum=0;
        int minSum=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if (minSum>sum){
                minSum=sum;
            }
        }
        // return 1-minSum;
        return minSum<=0?Math.abs(minSum)+1:1;

    }

    public int minStartValue2(int[] nums) {
        int min = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum<min)
                min = sum;
        }
        return 1-min;
    }

}

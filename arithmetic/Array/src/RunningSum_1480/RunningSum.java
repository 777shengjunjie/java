package RunningSum_1480;


import java.util.List;

/**
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * 请返回 nums 的动态和。
 */
public class RunningSum {


    public static void main(String[] args) {

        int[] nums={3,1,2,10,1};
        int[] result=new RunningSum().runningSum(nums);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] runningSum(int[] nums){

        int[] ans=new int[nums.length];
        ans[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans[i]=ans[i-1]+nums[i];
        }
        return ans;
    }

    public int[] runningSum2(int[] nums) {
        for( int i = 1 ; i < nums.length ; i++ ){
            nums[i] += nums[i-1];
        }
        return nums;
    }

}

package MaxProduct_1464;


import java.util.Arrays;

/**
 * 给你一个整数数组 nums，请你选择数组的两个不同下标 i 和 j，
 * 使 (nums[i]-1)*(nums[j]-1) 取得最大值。
 * 请你计算并返回该式的最大值。
 */
public class MaxProduct {

    public static void main(String[] args) {
        int[] nums={3,4,5,2};
        int result=new MaxProduct().maxProduct(nums);
        System.out.println(result);
    }

    public int maxProduct(int[] nums) {

        Arrays.sort(nums);
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }

    public int maxProduct2(int[] nums) {
        if(nums.length==2) return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
        int one = nums[0];
        int two = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]>one){
                two = one;
                one = nums[i];
            }else if(nums[i] <= one){
                if(nums[i] >= two){
                    two = nums[i];
                }
            }
        }
        return (one-1)*(two-1);
    }

}

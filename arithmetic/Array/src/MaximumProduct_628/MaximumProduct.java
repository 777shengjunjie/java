package MaximumProduct_628;


import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class MaximumProduct {


    public static void main(String[] args) {
        int[] nums = {-1, -2, -4, -3};
        int result = new MaximumProduct().maximumProduct(nums);
        System.out.println(result);
    }

    public int maximumProduct(int[] nums) {
        int length = nums.length - 1;
        Arrays.sort(nums);

        return Math.max(nums[length] * nums[length - 1] * nums[length - 2],nums[0]*nums[1]*nums[length]);


    }
}

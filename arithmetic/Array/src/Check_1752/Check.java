package Check_1752;

import java.util.Arrays;

/**
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，
 * 但按非递减顺序排列。
 *
 * 如果nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；
 * 否则，返回 false 。
 *
 * 源数组中可能存在 重复项 。
 *
 * 注意：我们称数组 A 在轮转 x 个位置后得到长度相同的数组 B ，
 * 当它们满足 A[i] == B[(i+x) % A.length] ，其中 % 为取余运算。
 */
public class Check {


    public static void main(String[] args) {
    int[] nums={6,7,7,5};
    boolean result=new Check().check(nums);
        System.out.println(result);
    }

    public boolean check(int[] nums) {


        int i=0;
        for (i = 1; i < nums.length; i++) {
            if (nums[i-1]>nums[i]){
                break;
            }
        }
        if (i== nums.length) return true;

        for (; i <nums.length-1; i++) {
            if (nums[i]>nums[i+1]){
                break;
            }
        }

        if (i==nums.length-1&&nums[nums.length-1]<=nums[0])
            return true;

        return false;
    }
}

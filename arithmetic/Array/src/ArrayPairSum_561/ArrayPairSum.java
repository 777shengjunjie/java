package ArrayPairSum_561;


import java.util.Arrays;

/**
 * 给定长度为2n的整数数组 nums ，你的任务是将这些数分成n 对,
 * 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从 1 到n 的 min(ai, bi) 总和最大。
 * 返回该 最大总和 。
 */
public class ArrayPairSum {

    public static void main(String[] args) {
        int[] nums = {6,2,6,5,1,2};
        int result = new ArrayPairSum().arrayPairSum(nums);
        System.out.println(result);
    }

    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            sum += nums[i * 2];
        }
        return sum;

    }
    public int arrayPairSum2(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums)
            arr[num + lim]++;
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }



}

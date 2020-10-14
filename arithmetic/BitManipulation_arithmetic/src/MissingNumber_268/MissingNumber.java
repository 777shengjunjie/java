package MissingNumber_268;





/*
给定一个包含 [0, n]中n个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

        进阶：

        你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
*/

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {


    public static void main(String[] args) {

        int[] nums;
        nums = new int[]{0};
        int result =new MissingNumber().missingNumber3(nums);
        System.out.println(result);

    }


    public int missingNumber(int[] nums) {

        int length=nums.length;
        int ans=0;
        int[] bucket=new int[length+1];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }

        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i]==0) {
                ans=i;
                break;
            }
        }

        return ans;

    }

    public int missingNumber2(int[] nums) {
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }


    /**
     * 我们知道数组中有 nn 个数，并且缺失的数在 [0..n][0..n] 中。因此我们可以先得到 [0..n][0..n] 的异或值，
     * 再将结果对数组中的每一个数进行一次异或运算。未缺失的数在 [0..n][0..n] 和数组中各出现一次，因此异或后得到 0。
     * 而缺失的数字只在 [0..n][0..n] 中出现了一次，在数组中没有出现，因此最终的异或结果即为这个缺失的数字。
     * @param nums
     * @return
     */
    public int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public int missingNumber4(int[] nums) {
        int expectedSum = nums.length*(nums.length + 1)/2;
        int actualSum = 0;
        for (int num : nums) actualSum += num;
        return expectedSum - actualSum;
    }


}

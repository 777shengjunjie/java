package SingleNumber_136;


import java.util.Arrays;

/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
        说明：
        你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
*/
public class SingleNumber {

    public static void main(String[] args) {

        int[] nums={4,1,2,1,2};
        int result=new SingleNumber().singleNumber(nums);
        System.out.println(result);

    }

    public int singleNumber(int[] nums) {

        int single=0;
        for (int num : nums) {
            single ^= num;
        }

        return single;

    }



    public int singleNumber2(int[] nums) {

        if (nums.length == 1) return nums[0];
        Arrays.sort(nums);
        if (nums[0] != nums[1]) return nums[0];
        if (nums[nums.length - 1] != nums[nums.length - 2]) return nums[nums.length - 1];
        for (int i = 1; i < nums.length - 1; i++) {

            if (nums[i - 1] == nums[i] || nums[i] == nums[i + 1]) {
                continue;
            } else {
                return nums[i];
            }

        }

        return 0;

    }
}

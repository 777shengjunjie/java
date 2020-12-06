package CheckPossibility_665;


/**
 * 给你一个长度为n的整数数组，请你判断在 最多 改变1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的：对于数组中所有的i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 */
public class CheckPossibility {

    public static void main(String[] args) {

        //3423
        int[] nums = {-1,4,2,3};
        boolean result=new CheckPossibility().checkPossibility(nums);
        System.out.println(result);
    }

    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        if (nums.length <= 2) return true;
        int lo = 0, hi = nums.length - 1;
        while (lo < hi && nums[hi - 1] <= nums[hi])
            hi--;
        while (lo < hi && nums[lo] <= nums[lo + 1])
            lo++;
        if (hi - lo > 1) return false;
        // hi - lo <= 1 时：
        if (lo == 0 || hi == nums.length - 1        // 除了边界，其他都递增
                || nums[lo - 1] <= nums[lo + 1]     // 除了nums[lo]其他都递增
                || nums[hi - 1] <= nums[hi + 1])    // 除了nums[hi]其他都递增
            return true;
        return false;


    }

}

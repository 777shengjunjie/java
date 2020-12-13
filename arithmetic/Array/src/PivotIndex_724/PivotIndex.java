package PivotIndex_724;

/**
 * 给定一个整数类型的数组nums，请编写一个能够返回数组 “中心索引” 的方法。
 * <p>
 * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 */
public class PivotIndex {

    public static void main(String[] args) {
        int[] nums = {-1,-1,-1,-1,-1,0};
        int result=new PivotIndex().pivotIndex(nums);
        System.out.println(result);


    }


    public int pivotIndex(int[] nums) {
       int sum=0,lSum=0;
        for (int num : nums) {
            sum+=num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (lSum==sum-lSum-nums[i]) return i;
            lSum+=nums[i];
        }
        return -1;
    }


}

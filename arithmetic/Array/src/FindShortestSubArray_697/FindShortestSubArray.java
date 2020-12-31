package FindShortestSubArray_697;


import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个非空且只包含非负数的整数数组nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 */
public class FindShortestSubArray {

    public static void main(String[] args) {
        int[] nums={1, 2, 2, 3, 1};
        int result=new FindShortestSubArray().findShortestSubArray(nums);
        System.out.println(result);
    }

    public int findShortestSubArray(int[] nums) {

        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x=nums[i];
            if (left.get(x)==null) left.put(x,i);
            right.put(x,i);
            count.put(x,count.getOrDefault(x,0)+1);
        }

        int ans=nums.length;
        int degree= Collections.max(count.values());
        for (Integer x : count.keySet()) {
            if (count.get(x)==degree)
            ans=Math.min(ans,right.get(x)-left.get(x)+1);
        }

        return ans;

    }

}

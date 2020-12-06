package NumIdenticalPairs_1512;


import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 。
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * 返回好数对的数目。
 */
public class NumIdenticalPairs {

    public static void main(String[] args) {
        int[] nums={1,2,3};
        int result=new NumIdenticalPairs().numIdenticalPairs(nums);
        System.out.println(result);
    }

    public int numIdenticalPairs(int[] nums) {
        int ans=0;
        int[] bucket=new int[101];
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i]]++;
        }
        for (int i = 1; i < bucket.length; i++) {
            if (bucket[i]>1){
                ans+=bucket[i]*(bucket[i]-1)/2;
            }
        }
        return ans;
    }

    public int numIdenticalPairs2(int[] nums) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int v = entry.getValue();
            ans += v * (v - 1) / 2;
        }

        return ans;
    }


}

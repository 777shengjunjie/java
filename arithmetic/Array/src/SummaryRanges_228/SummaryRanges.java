package SummaryRanges_228;

import java.util.ArrayList;
import java.util.List;


/**
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，
 * 并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class SummaryRanges {



    public static void main(String[] args) {
        int[] nums={0,1,2,4,5,7};
        List<String> result=new SummaryRanges().summaryRanges(nums);
        System.out.println(result);
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();

        for (int i = 0,j=0; i < nums.length; j++) {
            if (j+1<nums.length&&nums[j+1]==nums[j]+1){
                continue;
            }
            if (i==j){
                ans.add(nums[i]+"");
            }else {
                ans.add(nums[i]+"->"+nums[j]);
            }

            i=j+1;
        }

        return ans;
    }
}

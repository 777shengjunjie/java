package FrequencySort_1636;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，请你将数组按照每个值的频率 升序 排序。
 * 如果有多个值的频率相同，请你按照数值本身将它们 降序 排序。
 *
 * 请你返回排序后的数组。
 */
public class FrequencySort {


    public static void main(String[] args) {
        int[] nums={1,1,2,2,2,3};
        int[] result=new FrequencySort().frequencySort(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] frequencySort(int[] nums) {

        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }

        int[] ans= Arrays.stream(nums).boxed().sorted((o1,o2)->{
            int count1=map.get(o1);
            int count2=map.get(o2);
            return count1==count2?o2-o1:count1-count2;
        }).mapToInt(Integer::intValue).toArray();

        return ans;
    }
}

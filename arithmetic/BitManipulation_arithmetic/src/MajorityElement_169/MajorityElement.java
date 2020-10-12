package MajorityElement_169;



/*
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于⌊ n/2 ⌋的元素。

        你可以假设数组是非空的，并且给定的数组总是存在多数元素。
*/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static void main(String[] args) {

        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int result = new MajorityElement().majorityElement(nums);
        System.out.println(result);

    }

    public int majorityElement(int[] nums) {

        int length = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int count = map.getOrDefault(num, 0) + 1;
            if (count > length / 2)
                return num;
            map.put(num, count);
        }

        return 0;

    }

    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement3(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;

        }

        return candidate;

    }


}

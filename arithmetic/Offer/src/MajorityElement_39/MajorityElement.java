package MajorityElement_39;

import java.util.Arrays;

public class MajorityElement {

    public static void main(String[] args) {

    }

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int repeatCounts=nums.length/2;
        return nums[repeatCounts+1];
    }

    public int majorityElement2(int[] nums) {

        int x = 0, votes = 0, count = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        // 验证 x 是否为众数
        for(int num : nums)
            if(num == x) count++;
        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0


    }
}

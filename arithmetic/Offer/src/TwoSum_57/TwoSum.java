package TwoSum_57;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {

    }


    public int[] twoSum(int[] nums, int target) {

        int i=0,j=nums.length-1;
        while (i<j){
            int tempSum=nums[i]+nums[j];
            if (tempSum>target){
                j--;
            }else if (tempSum<target){
                i++;
            }else {
                return new int[] {nums[i],nums[j]};
            }
        }

        return new int[0];

    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res=new int[2];
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int remainder=target-nums[i];
            if (remainder<=0) return res;
            if (list.contains(remainder)){
                res[1]=nums[i];
                res[0]=remainder;
                return res;
            }else {
                list.add(nums[i]);
            }
        }

        return res;

    }
}

package TwoSum_1;


import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个目标值 target，
 * 请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 */
public class TwoSum {

    public static void main(String[] args) {

        /*int[] a=new int[0];
        int b= a.length;
        for (int i = 0; i < a.length; i++) {
            a[i]=i;
            System.out.println(a[i]);
        }*/

        int[] nums={-10,-1,-18,-19};
        int target=-19;
        int[] result=new TwoSum().twoSum(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] twoSum(int[] nums,int target){

        int pre=0,aft=nums.length-1;
        while (nums[pre]+nums[aft]!=target){

            for (int i = pre; i < aft  ; i++) {
                if (nums[i]+nums[aft]==target) {
                    pre=i;
                    break;
                }
            }
            if (nums[pre]+nums[aft]==target){
                break;
            }
            aft--;
        }
        return new int[]{pre,aft};
    }

    public int[] twoSum2(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    public int[] twoSum3(int[] nums, int target) {

        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }



}

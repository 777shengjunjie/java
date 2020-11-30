package ContainsDuplicate_217;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任意一值在数组中出现至少两次，函数返回 true 。
 * 如果数组中每个元素都不相同，则返回 false 。
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums={1,1,1,3,3,4,3,2,4,2};
        boolean result=new ContainsDuplicate().containsDuplicate(nums);
        System.out.println(result);
    }

    public boolean containsDuplicate(int[] nums){
        if (nums.length==0) return false;
        Arrays.sort(nums);
        int pre=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]==pre){
                return true;
            }
            pre=nums[i];
        }

        return false;

    }

    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) return true;
            set.add(x);
        }
        return false;
    }

}

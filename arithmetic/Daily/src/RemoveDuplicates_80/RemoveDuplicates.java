package RemoveDuplicates_80;


import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {



        int[] nums={1,1,1,2,2,2,3,3};
        int result=new RemoveDuplicates().removeDuplicates(nums);
        System.out.println(result);
    }

    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

}

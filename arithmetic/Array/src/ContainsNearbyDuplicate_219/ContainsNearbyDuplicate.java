package ContainsNearbyDuplicate_219;


import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，
 * 使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 */
public class ContainsNearbyDuplicate {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 1, 2, 3};
        int k = 2;
        boolean result = new ContainsNearbyDuplicate().containsNearbyDuplicate(nums, k);
        System.out.println(result);

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && j - i <= k) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}


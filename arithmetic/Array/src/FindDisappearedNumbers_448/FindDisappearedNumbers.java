package FindDisappearedNumbers_448;

import java.util.*;


/**
 * 给定一个范围在 1 ≤ a[i] ≤ n (n = 数组大小 ) 的整型数组，
 * 数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗?
 * 你可以假定返回的数组不算在额外空间内。
 */
public class FindDisappearedNumbers {

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = new FindDisappearedNumbers().findDisappearedNumbers2(nums);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!set.contains(i)){
                ans.add(i);
            }

        }
        return ans;

    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {

        // Hash table for keeping track of the numbers in the array
        // Note that we can also use a set here since we are not
        // really concerned with the frequency of numbers.
        HashMap<Integer, Boolean> hashTable = new HashMap<Integer, Boolean>();

        // Add each of the numbers to the hash table
        for (int i = 0; i < nums.length; i++) {
            hashTable.put(nums[i], true);
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that don't appear in the hash table.
        for (int i = 1; i <= nums.length; i++) {
            if (!hashTable.containsKey(i)) {
                result.add(i);
            }
        }

        return result;
    }

    public List<Integer> findDisappearedNumbers3(int[] nums) {

        // Iterate over each of the elements in the original array
        for (int i = 0; i < nums.length; i++) {

            // Treat the value as the new index
            int newIndex = Math.abs(nums[i]) - 1;

            // Check the magnitude of value at this new index
            // If the magnitude is positive, make it negative
            // thus indicating that the number nums[i] has
            // appeared or has been visited.
            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        // Response array that would contain the missing numbers
        List<Integer> result = new LinkedList<Integer>();

        // Iterate over the numbers from 1 to N and add all those
        // that have positive magnitude in the array
        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }


}




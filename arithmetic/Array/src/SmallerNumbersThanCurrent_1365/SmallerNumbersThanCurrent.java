package SmallerNumbersThanCurrent_1365;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个数组nums，对于其中每个元素nums[i]，请你统计数组中比它小的所有数字的数目。
 *
 * 换而言之，对于每个nums[i]你必须计算出有效的j的数量，其中 j 满足j != i 且 nums[j] < nums[i]。
 *
 * 以数组形式返回答案。
 */
public class SmallerNumbersThanCurrent {

    public static void main(String[] args) {


        int[] nums={8,1,2,2,3};
        int[] result=new SmallerNumbersThanCurrent().smallerNumbersThanCurrent2(nums);
        for (int i : result) {
            System.out.println(i);
        }

    }

    public int[] smallerNumbersThanCurrent(int[] nums){

        int[] length=new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]<nums[i]){
                    length[i]++;
                }
            }

        }

        return length;


    }

    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int n = nums.length;
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i][0] = nums[i];
            data[i][1] = i;
        }
        Arrays.sort(data, new Comparator<int[]>() {
            public int compare(int[] data1, int[] data2) {
                return data1[0] - data2[0];
            }
        });

        int[] ret = new int[n];
        int prev = -1;
        for (int i = 0; i < n; i++) {
            if (prev == -1 || data[i][0] != data[i - 1][0]) {
                prev = i;
            }
            ret[data[i][1]] = prev;
        }
        return ret;
    }
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] cnt = new int[101];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            cnt[nums[i]]++;
        }
        for (int i = 1; i <= 100; i++) {
            cnt[i] += cnt[i - 1];
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nums[i] == 0 ? 0 : cnt[nums[i] - 1];
        }
        return ret;
    }



}

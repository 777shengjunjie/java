package SumOfUnique_1748;

/**
 * 给你一个整数数组 nums 。数组中唯一元素是那些只出现 恰好一次 的元素。
 * 请你返回 nums 中唯一元素的 和 。
 */
public class SumOfUnique {

    public static void main(String[] args) {
        int[]  nums={1,2,3,2};
        int result=new SumOfUnique().sumOfUnique(nums);
        System.out.println(result);
    }

    public int sumOfUnique(int[] nums) {
        int[] list=new int[101];
        for (int i = 0; i < nums.length; i++) {
            list[nums[i]]++;
        }

        int sum=0;
        for (int i = 0; i < list.length; i++) {
            if (list[i]==1){
                sum+=i;
            }
        }

        return sum;
    }
}

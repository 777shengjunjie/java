package SpecialArray_1608;


/**
 * 给你一个非负整数数组 nums 。如果存在一个数 x ，
 * 使得 nums 中恰好有 x 个元素 大于或者等于 x ，
 * 那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。
 * 注意： x 不必 是 nums 的中的元素。
 * 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。
 * 否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，
 * 那么其特征值 x 是 唯一的
 */
public class SpecialArray {

    public static void main(String[] args) {
        int[] nums={3,5};
        int result=new SpecialArray().specialArray(nums);
        System.out.println(result);

    }

    public int specialArray(int[] nums) {

        int size=nums.length+1;
        int count=0;
        for (int i = 0; i < size; i++) {
            for (int num : nums) {
                if (i<=num){
                    count++;
                }

            }

            if (i==count){
                return i;
            }

            count=0;
        }

        return -1;

    }
}

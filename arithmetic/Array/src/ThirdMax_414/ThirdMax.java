package ThirdMax_414;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 */
public class ThirdMax {

    public static void main(String[] args) {

        int[] nums={1,2,2,5,3,5};
        int result=new ThirdMax().thirdMax(nums);
        System.out.println(result);
    }

    public int thirdMax(int[] nums){

        int length=nums.length;
        if (length<3) return nums[length-1];
        Arrays.sort(nums);
        int pre=nums[0];
        int flag=1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i]!=pre){
                flag++;

            }
            pre=nums[i];
        }
        if (flag<3){
            return nums[length-1];
        }

        int index=1;


        while(index<3&&length-2>=0){
            if (nums[length-1]!=nums[length-2]){
                index++;
            }
            length--;
        }
        return nums[length-1];

    }

    public int thirdMax2(int[] nums) {
        long first = Long.MIN_VALUE;
        long second = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for (int num : nums) {
            if(num>first){
                third = second;
                second = first;
                first = num;
            }else if(num>second&&num<first){
                third = second;
                second = num;
            }else if(num<second&&num>third){
                third = num;
            }
        }
        return third!=Long.MIN_VALUE ? Long.valueOf(third).intValue() : Long.valueOf(first).intValue();

    }


}

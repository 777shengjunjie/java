package Exchange_21;

import java.util.ArrayList;
import java.util.List;

public class Exchange {


    public static void main(String[] args) {
        int i=5;
        System.out.println(i&1);
    }

    public int[] exchange(int[] nums) {
        List<Integer> list=new ArrayList<>();
        List<Integer> odds=new ArrayList<>();
        for (int num : nums) {
            if (num%2==1){
                list.add(num);
            }else {
                odds.add(num);
            }
        }

        for (Integer odd : odds) {
            list.add(odd);
        }


        return list.stream().mapToInt(Integer::valueOf).toArray();
    }


    public int[] exchange2(int[] nums) {

        int low=0,fast=0;
        while (fast<nums.length){
            if ((nums[fast]&1)==1){
                int temp=nums[low];
                nums[low]=nums[fast];
                nums[fast]=temp;
                low++;
            }
            fast++;
        }

        return nums;

    }
}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.Lock;

public class test {

    public static void main(String[] args) {


        int[] nums={2,5,3,5};
        int target=6;
        int result=new test().purchasePlans(nums,target);
        System.out.println(result);
    }

    public int purchasePlans(int[] nums, int target) {


        Arrays.sort(nums);

        int ans=0;
        int i=0,j=nums.length-1;
//        while (i<j){
//            if (nums[i]+nums[j]<=target){
//                ans+=j-i;
//                i++;
//            }else {
//                j--;
//            }
//        }

        while (i<=j){
            while (j>=0){
                if (nums[i]+nums[j]>target){
                    j-=1;
                }else {
                    break;
                }
            }

            if (j>i){
                ans+=j-i;
            }else {
                break;
            }

            i+=1;
        }
        return ans%(1000000007);
    }
}

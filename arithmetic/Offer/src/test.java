import java.util.Arrays;

public class test {

    static int a=4;

    public static void main(String[] args) {

        test t=new test();
        System.out.println(t.a);
        test.a=20;
        t.a=10;
        System.out.println(t.a);

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

package MaxSubArray_42;

public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums={-2,1,-3,4,-1,2,1,-5,4};
        int result=new MaxSubArray().maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int max=nums[0];
        int fx=nums[0];
        if (nums.length<2){
            return max;
        }
        for (int i = 1; i < nums.length; i++) {

            fx=Math.max(fx+nums[i],nums[i]);
            max=Math.max(fx,max);
        }

        return max;
    }

}

package FindMaxConsecutiveOnes_485;


/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 */
public class FindMaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] nums={1,1,0,1,1,1};
        int result=new FindMaxConsecutiveOnes().findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    public int findMaxConsecutiveOnes(int[] nums) {

        int ans=0,index=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==1){
                index++;
                if (ans<index){
                    ans=index;
                }
            }else {
                index=0;
            }
        }
        return ans;
    }

    public int findMaxConsecutiveOnes2(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                // Increment the count of 1's by one.
                count += 1;
            } else {
                // Find the maximum till now.
                maxCount = Math.max(maxCount, count);
                // Reset count of 1.
                count = 0;
            }
        }
        return Math.max(maxCount, count);
    }


}

package MissingNumber_53_2;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int length=nums.length;
        for(int i=0;i<length;i++){
            if(nums[i]!=i){
                return i;
            }
        }
        return length;
    }

    public int missingNumber2(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = (i + j) / 2;
            if(nums[m] == m) i = m + 1;
            else j = m - 1;
        }
        return i;
    }


}

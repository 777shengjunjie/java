package SumOddLengthSubarrays_1588;


/**
 * 给你一个正整数数组arr，请你计算所有可能的奇数长度子数组的和。
 *
 * 子数组 定义为原数组中的一个连续子序列。
 *
 * 请你返回 arr中 所有奇数长度子数组的和 。
 */
public class SumOddLengthSubarrays {

    public static void main(String[] args) {
        int[] arr={1,4,2,5,3};
        int result=new SumOddLengthSubarrays().sumOddLengthSubarrays(arr);
        System.out.println(result);

    }

    public int sumOddLengthSubarrays(int[] arr) {
        int sum=0;
        int length=arr.length;
        for (int i = 0; i < length; i++) {
            int left=i+1;
            int right=length-left+1;

            int leftOdd=left/2;
            int leftEven=(left+1)/2;

            int rightOdd=right/2;
            int rightEven=(right+1)/2;

            sum+=arr[i]*(leftOdd*rightOdd+leftEven*rightEven);
        }

        return sum;
    }
}

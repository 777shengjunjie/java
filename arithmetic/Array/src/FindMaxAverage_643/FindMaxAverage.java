package FindMaxAverage_643;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 */
public class FindMaxAverage {

    public static void main(String[] args) {
       // int[] nums={1,12,-5,-6,50,3};
        int[] nums={-1};
        int k=1;
        double result=new FindMaxAverage().findMaxAverage(nums,k);
        System.out.println(result);
    }


    public double findMaxAverage(int[] nums, int k) {

        double sum=0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        double max=sum;
        for (int i = k; i < nums.length; i++) {
            sum+=nums[i]-nums[i-k];
            max= Math.max(max,sum);
        }

        return max/k;
    }


}

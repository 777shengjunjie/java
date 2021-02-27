package TrimMean_1619;

import java.util.Arrays;

/**
 * 给你一个整数数组 arr ，请你删除最小 5% 的数字和最大 5% 的数字后，
 * 剩余数字的平均值。
 *
 * 与 标准答案 误差在 10-5 的结果都被视为正确结果
 */
public class TrimMean {

    public static void main(String[] args) {
        int[] arr={1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        double result=new TrimMean().trimMean(arr);
        System.out.println(result);

    }

    public double trimMean(int[] arr) {
        int length= (int) (arr.length*(0.05));
        Arrays.sort(arr);
        double sum=0;
        for (int i = length; i < arr.length-length; i++) {
            sum+=arr[i];
        }

        return sum/(arr.length-length*2);
    }
}

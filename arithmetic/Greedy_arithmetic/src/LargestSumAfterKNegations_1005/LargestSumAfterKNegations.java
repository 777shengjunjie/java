package LargestSumAfterKNegations_1005;




/*
给定一个整数数组 A，我们只能用以下方法修改该数组：我们选择某个索引 i并将 A[i] 替换为 -A[i]，
        然后总共重复这个过程 K 次。（我们可以多次选择同一个索引 i。）

        以这种方式修改数组后，返回数组可能的最大和。
*/


import java.util.Arrays;

public class LargestSumAfterKNegations {

    public static void main(String[] args) {

        int [] A={2,-3,-1,5,-4};
        int k=2;
        int result =new LargestSumAfterKNegations().largestSumAfterKNegations(A,k);
        System.out.println(result);

    }

    public int largestSumAfterKNegations(int[] A,int K){

        int sum=0;
        Arrays.sort(A);

        while (A[0]<0&&K>0){
            A[0]=-A[0];
            Arrays.sort(A);
            K--;
        }
        if (K%2==0){
            for (int i : A) {
                sum+=i;
            }
            return sum;
        }

        A[0]=-A[0];
        for (int i : A) {
            sum+=i;
        }
        return sum;

    }
    public int largestSumAfterKNegations2(int[] A,int K){

        int sum=0;
        Arrays.sort(A);

        while (K>0){
            A[0]=-A[0];
            Arrays.sort(A);
            K--;
        }

        for (int i : A) {
            sum+=i;
        }
        return sum;

    }
    public int largestSumAfterKNegations3(int[] arr, int k) {
        Arrays.sort(arr); // asc: 负数...0..0..正数
        int sum = 0, len = arr.length, minIndex = 0; // 初始第一个最小
        while (k > 0) {
            arr[minIndex] = -arr[minIndex]; // 最小者取反
            k--;
            // 维护最小值索引
            // 若后面还有数，则看当前的与下一个谁更小
            if (minIndex + 1 < len && arr[minIndex] > arr[minIndex + 1]) minIndex++;
        }
        for (int i : arr) sum += i;
        return sum;
    }



}

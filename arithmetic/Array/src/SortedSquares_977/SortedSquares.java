package SortedSquares_977;


import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 */
public class SortedSquares {

    public static void main(String[] args) {
        int[] A={-7,-3,2,3,11};
        int[] result=new SortedSquares().sortedSquares(A);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sortedSquares(int[] A) {

        for (int i = 0; i < A.length; i++) {
            A[i]=A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }

    public int[] sortedSquares2(int[] A) {
        int n = A.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = A[j] * A[j];
                ++j;
            } else if (j == n) {
                ans[index] = A[i] * A[i];
                --i;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    public int[] sortedSquares3(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;
    }


}

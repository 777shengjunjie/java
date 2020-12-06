package SortArrayByParity_905;

import java.util.Arrays;

/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 */
public class SortArrayByParity {

    public static void main(String[] args) {
        int A[] = {3, 1, 2, 4};
        int[] result = new SortArrayByParity().sortArrayByParity2(A);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] sortArrayByParity(int[] A) {
        int low = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[low];
                A[low] = A[i];
                A[i] = temp;
                low++;
            }
        }
        return A;
    }

    public int[] sortArrayByParity2(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t)
            B[t] = A[t];

        Arrays.sort(B, (a, b) -> Integer.compare(a % 2, b % 2));

        for (int t = 0; t < A.length; ++t)
            A[t] = B[t];
        return A;

        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }
    public int[] sortArrayByParity3(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 0)
                ans[t++] = A[i];

        for (int i = 0; i < A.length; ++i)
            if (A[i] % 2 == 1)
                ans[t++] = A[i];

        return ans;
    }

    /**
     * 维护两个指针 i 和 j，循环保证每刻小于 i 的变量都是偶数（也就是 A[k] % 2 == 0 当 k < i），所有大于 j 的都是奇数。
     *
     * 所以， 4 种情况针对 (A[i] % 2, A[j] % 2)：
     *
     * 如果是 (0, 1)，那么万事大吉 i++ 并且 j--。
     * 如果是 (1, 0)，那么交换两个元素，然后继续。
     * 如果是 (0, 0)，那么说明 i 位置是正确的，只能 i++。
     * 如果是 (1, 1)，那么说明 j 位置是正确的，只能 j--。
     * 通过这 4 种情况，循环不变量得以维护，并且 j-i 不断变小。最终就可以得到奇偶有序的数组。
     * @param A
     * @return
     */
    public int[] sortArrayByParity4(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }

            if (A[i] % 2 == 0) i++;
            if (A[j] % 2 == 1) j--;
        }

        return A;
    }


}

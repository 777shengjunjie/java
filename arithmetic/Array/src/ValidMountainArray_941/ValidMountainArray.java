package ValidMountainArray_941;

/**
 * 给定一个整数数组A，如果它是有效的山脉数组就返回true，否则返回 false。
 * 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组：
 * A.length >= 3
 * 在0 < i< A.length - 1条件下，存在i使得：
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 */
public class ValidMountainArray {

    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
        boolean result = new ValidMountainArray().validMountainArray(arr);
        System.out.println(result);
    }

    public boolean validMountainArray(int[] arr) {
        int length = arr.length;
        if (length < 3) return false;
        int pre = arr[0];
        if (pre>arr[1]) return false;
        int index = 0;
        for (int i = 1; i < arr.length; i++) {
            if (pre == arr[i]) return false;
            if (pre > arr[i]) {
                index = i-1;
                break;
            }
            pre = arr[i];

        }
        if (length - index < 1) return false;
        for (int i = index + 1; i < arr.length; i++) {
            if (pre == arr[i]) return false;
            if (pre < arr[i]) return false;
            pre = arr[i];
        }
        return true;
    }
    public boolean validMountainArray2(int[] A) {
        int N = A.length;
        int i = 0;

        // 递增扫描
        while (i + 1 < N && A[i] < A[i + 1]) {
            i++;
        }

        // 最高点不能是数组的第一个位置或最后一个位置
        if (i == 0 || i == N - 1) {
            return false;
        }

        // 递减扫描
        while (i + 1 < N && A[i] > A[i + 1]) {
            i++;
        }

        return i == N - 1;
    }


}

package FindTheDistanceValue_1385;

import java.util.Arrays;

/**
 * 给你两个整数数组arr1，arr2和一个整数d，请你返回两个数组之间的距离值。
 * 「距离值」定义为符合此距离要求的元素数目：对于元素arr1[i]，
 * 不存在任何元素arr2[j]满足 |arr1[i]-arr2[j]| <= d 。
 */
public class FindTheDistanceValue {

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 8}, arr2 = {10, 9, 1, 8};
        int d = 2;
        int result = new FindTheDistanceValue().findTheDistanceValue(arr1, arr2, d);
        System.out.println(result);
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {

        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                    break;
                }
                if (j == arr2.length - 1 && Math.abs(arr1[i] - arr2[j])>d){
                    count++;
                }
            }

        }

        return count;
    }

    public int findTheDistanceValue2(int[] arr1, int[] arr2, int d) {
        int cnt = 0;
        for (int x : arr1) {
            boolean ok = true;
            for (int y : arr2) {
                ok &= Math.abs(x - y) > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    public int findTheDistanceValue3(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int cnt = 0;
        for (int x : arr1) {
            int p = binarySearch(arr2, x);
            boolean ok = true;
            if (p < arr2.length) {
                ok &= arr2[p] - x > d;
            }
            if (p - 1 >= 0 && p - 1 <= arr2.length) {
                ok &= x - arr2[p - 1] > d;
            }
            cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    public int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        if (arr[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

}

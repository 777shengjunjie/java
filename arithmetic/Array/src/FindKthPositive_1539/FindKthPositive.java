package FindKthPositive_1539;


/**
 * 给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
 * <p>
 * 请你找到这个数组里第 k 个缺失的正整数。
 */
public class FindKthPositive {

    public static void main(String[] args) {
        int[] arr = {2};
        int k = 1;
        int result = new FindKthPositive().findKthPositive(arr, k);
        System.out.println(result);
    }

    public int findKthPositive(int[] arr, int k) {

        if (k+1<=arr[0]){
            return k;
        }
        k -= (arr[0] - 1);
        int before = arr[0];
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] - 1 == arr[i - 1]) {
                before=arr[i];
                continue;
            }
            int temp = arr[i] - before-1;

            if (k > temp) {
                k -= temp;
            } else {
                return before + k ;
            }
            before = arr[i];

        }

        return before+k;
    }

    public int findKthPositive2(int[] arr, int k) {
        int missCount = 0, lastMiss = -1, current = 1, ptr = 0;
        for (missCount = 0; missCount < k; ++current) {
            if (current == arr[ptr]) {
                ptr = (ptr + 1 < arr.length) ? ptr + 1 : ptr;
            } else {
                ++missCount;
                lastMiss = current;
            }
        }
        return lastMiss;
    }


}

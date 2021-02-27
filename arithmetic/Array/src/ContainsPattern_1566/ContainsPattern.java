package ContainsPattern_1566;


/**
 * 给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。
 * <p>
 * 模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。
 * 模式由其长度和重复次数定义。
 * <p>
 * 如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回 false
 */
public class ContainsPattern {

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 1, 3};
        int m = 2, k = 3;
        boolean result = new ContainsPattern().containsPattern(arr, m, k);
        System.out.println(result);
    }


    public boolean containsPattern(int[] arr, int m, int k) {

        int n = arr.length;
        for (int l = 0; l <= n - m * k; ++l) {
            int offset;
            for (offset = 0; offset < m * k; ++offset) {
                if (arr[l + offset] != arr[l + offset % m]) {
                    break;
                }
            }
            if (offset == m * k) {
                return true;
            }
        }
        return false;


    }
}

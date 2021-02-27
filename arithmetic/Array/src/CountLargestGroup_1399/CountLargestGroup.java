package CountLargestGroup_1399;


import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数 n 。请你先求出从 1 到 n 的每个整数 10 进制表示下的数位和
 * （每一位上的数字相加），然后把数位和相等的数字放到同一个组中。
 * 请你统计每个组中的数字数目，并返回数字数目并列最多的组有多少个。
 */
public class CountLargestGroup {

    public static void main(String[] args) {
        int n = 13;
        int result = new CountLargestGroup().countLargestGroup(n);
        System.out.println(result);
    }

    public int countLargestGroup(int n) {

        Map<Integer, Integer> map = new HashMap<>();
        int MaxCount = 0;
        for (int i = 1; i <= n; i++) {
            int key=i;
            int keySum = 0;
            while (key != 0) {
                keySum += key % 10;
                key/= 10;
            }
            map.put(keySum, map.getOrDefault(keySum, 0) + 1);
            MaxCount = Math.max(MaxCount, map.get(keySum));
        }

        int count = 0;
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == MaxCount) {
                count++;
            }
        }
        return count;
    }


}

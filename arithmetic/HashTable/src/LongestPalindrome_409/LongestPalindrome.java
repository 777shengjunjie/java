package LongestPalindrome_409;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。
 * <p>
 * 在构造过程中，请注意区分大小写。比如"Aa"不能当做一个回文字符串。
 * <p>
 * 注意:
 * 假设字符串的长度不会超过 1010
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "ccc";
        int result = new LongestPalindrome().longestPalindrome(s);
        System.out.println(result);
    }

    public int longestPalindrome(String s) {
        int sum = 0;
        boolean flag = true;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            sum += (value / 2 * 2);
            if (value % 2 == 1 && flag) {
                sum++;
                flag = false;
            }
        }

        return sum;
    }

    public int longestPalindrome2(String s) {
        int[] count = new int[128];
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            char c = s.charAt(i);
            count[c]++;
        }

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (v % 2 == 1 && ans % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }


}

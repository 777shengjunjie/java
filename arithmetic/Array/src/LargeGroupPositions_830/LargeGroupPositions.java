package LargeGroupPositions_830;

import sun.applet.resources.MsgAppletViewer;

import java.util.*;


/**
 * 在一个由小写字母构成的字符串 s 中，包含由一些连续的相同字符所构成的分组。
 * <p>
 * 例如，在字符串 s = "abbxxxxzyy"中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * <p>
 * 分组可以用区间 [start, end] 表示，其中 start 和 end 分别表示该分组的起始和终止位置的下标。
 * <p>
 * 上例中的 "xxxx" 分组用区间表示为 [3,6] 。
 * <p>
 * 我们称所有包含大于或等于三个连续字符的分组为 较大分组 。
 * <p>
 * 找到每一个 较大分组 的区间，按起始位置下标递增顺序排序后，返回结果。
 */
public class LargeGroupPositions {

    public static void main(String[] args) {
        String s = "aaa";
        List<List<Integer>> result = new LargeGroupPositions().largeGroupPositions(s);
        for (List<Integer> list : result) {
            for (Integer ans : list) {
                System.out.println(ans);
            }
        }
    }

    public List<List<Integer>> largeGroupPositions(String s) {

        List<List<Integer>> ans = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if (i == s.toCharArray().length - 1 && map.get(s.charAt(i)) >= 3) {
                List<Integer> count = new ArrayList<>();
                ans.add(count);
                count.add(i - map.get(s.charAt(i))+1);
                count.add(i);
            }
            if (i == s.toCharArray().length - 1) break;
            if (map.get(s.charAt(i)) < 3 && s.charAt(i + 1) != s.charAt(i)) {
                map.put(s.charAt(i),0);
            }
            if (map.get(s.charAt(i)) >= 3 && s.charAt(i) != s.charAt(i + 1)) {
                List<Integer> count = new ArrayList<>();
                ans.add(count);
                count.add(i - map.get(s.charAt(i))+1);
                count.add(i);
                map.put(s.charAt(i),0);
            }

        }

        return ans;


    }

    public List<List<Integer>> largeGroupPositions2(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;
    }


}

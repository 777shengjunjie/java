package UniqueOccurrences_1207;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class UniqueOccurrences {

    public static void main(String[] args) {
        int[] arr={1,2,2,1,1,3};
        boolean result=new UniqueOccurrences().uniqueOccurrences(arr);
        System.out.println(result);
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        Set<Integer> times=new HashSet<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            times.add(entry.getValue());
        }

        return times.size()==map.size();
    }
}

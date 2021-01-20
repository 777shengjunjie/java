package FindLucky_1394;


import java.lang.reflect.Array;
import java.util.*;

/**
 * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
 * <p>
 * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
 * <p>
 * 如果数组中存在多个幸运数，只需返回 最大 的那个。
 * 如果数组中不含幸运数，则返回 -1 。
 */
public class FindLucky {


    public static void main(String[] args) {
        int[] arr={2,2,3,4};
        int result=new FindLucky().findLucky(arr);
        System.out.println(result);

    }

    public int findLucky(int[] arr) {

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey().equals(entry.getValue())){
                list.add(entry.getValue());
            }
        }
        int max;
        if (list.isEmpty()){
            max=-1;
        }else{

           max=list.get(0);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i)>max){
                max=list.get(i);
            }
        }
        return max;


    }
    public int findLucky2(int[] arr) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        for (int x : arr) {
            m.put(x, m.getOrDefault(x, 0) + 1);
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (key == value) {
                ans = Math.max(ans, key);
            }
        }
        return ans;
    }



}



package MinimumAbsDifference_1200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 给你个整数数组 arr，其中每个元素都 不相同。
 * <p>
 * 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回
 */
public class MinimumAbsDifference {


    public static void main(String[] args) {
        int[] arr={1,3,6,10,15};
        List<List<Integer>> result=new MinimumAbsDifference().minimumAbsDifference(arr);
        for (List<Integer> list : result) {
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }


    }

    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        int min = arr[1] - arr[0];
        for (int i = 2; i < arr.length; i++) {
            int temp = arr[i] - arr[i - 1];
            if (temp < min) {
                min = temp;
            }
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i] - arr[i - 1];
            if (temp == min) {
                List<Integer> count=new ArrayList<>();
                ans.add(count);
                count.add(arr[i-1]);
                count.add(arr[i]);

            }
        }

        return ans;


    }

    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new LinkedList<>();
        int min = 99999999;
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i] - arr[i - 1];
            // 找到新的最小差，清空原有结果
            if (tmp < min) {
                min = tmp;
                res.clear();
            }
            // 如果是最小差，记录
            if (tmp == min) {
                List<Integer> item = new ArrayList<>(2);
                item.add(arr[i - 1]);
                item.add(arr[i]);
                res.add(item);
            }
        }
        return res;
    }


}

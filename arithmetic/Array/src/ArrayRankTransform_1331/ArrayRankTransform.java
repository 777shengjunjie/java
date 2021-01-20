package ArrayRankTransform_1331;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组arr ，请你将数组中的每个元素替换为它们排序后的序号。
 *
 * 序号代表了一个元素有多大。序号编号的规则如下：
 *
 * 序号从 1 开始编号。
 * 一个元素越大，那么序号越大。如果两个元素相等，那么它们的序号相同。
 * 每个数字的序号都应该尽可能地小
 */
public class ArrayRankTransform {

    public static void main(String[] args) {
        int[] arr={40,10,20,30};
        int[] result=new ArrayRankTransform().arrayRankTransform(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] arrayRankTransform(int[] arr) {

        int[] clone=arr.clone();
        Arrays.sort(clone);
        int count=1;
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < clone.length; i++) {
            if (i>0&&clone[i-1]!=clone[i]){
                map.put(clone[i],count);
                count++;
            }
            if (i==0){
                map.put(clone[i],count);
                count++;
            }


        }

        for (int i = 0; i < arr.length; i++) {
            arr[i]=map.get(arr[i]);
        }

        return arr;
    }
}

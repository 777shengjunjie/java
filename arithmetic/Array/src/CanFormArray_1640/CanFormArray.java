package CanFormArray_1640;


import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 arr ，数组中的每个整数 互不相同 。
 * 另有一个由整数数组构成的数组 pieces，其中的整数也 互不相同 。
 * 请你以 任意顺序 连接 pieces 中的数组以形成 arr 。
 * 但是，不允许 对每个数组 pieces[i] 中的整数重新排序。
 * 如果可以连接 pieces 中的数组形成 arr ，返回 true ；否则，返回 false 。
 */
public class CanFormArray {

    public static void main(String[] args) {
        int[] arr={49,18,16};
        int[][] pieces={{16,18,49}};
        boolean result=new CanFormArray().canFormArray(arr,pieces);
        System.out.println(result);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }
        int[] temp = new int[arr.length];
        for (int i = 0; i < pieces.length; i++) {
            for (int j = 0; j < pieces[i].length; j++) {
                if (!map.containsKey(pieces[i][j])) {
                    return false;
                } else {
                    temp[j] = map.get(pieces[i][j]);
                }
            }
            for (int j = 0; j < pieces[i].length - 1; j++) {
                if (temp[j] > temp[j + 1] || temp[j + 1] - temp[j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}

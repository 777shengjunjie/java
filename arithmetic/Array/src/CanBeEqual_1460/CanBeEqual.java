package CanBeEqual_1460;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个长度相同的整数数组target和arr。
 *
 * 每一步中，你可以选择arr的任意 非空子数组并将它翻转。你可以执行此过程任意次。
 *
 * 如果你能让 arr变得与 target相同，返回 True；否则，返回 False 。
 */
public class CanBeEqual {

    public static void main(String[] args) {
        int[] target={1,2,2,3};
        int[] arr={1,1,2,3};
        boolean result=new CanBeEqual().canBeEqual(target,arr);
        System.out.println(result);

    }

    public boolean canBeEqual(int[] target, int[] arr) {
         Map<Integer,Integer> map=new HashMap<>();
        for (int i : target) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (int i : arr) {
            if(!map.containsKey(i)||map.get(i)-1<0){
                return false;
            }else {
                map.put(i,map.get(i)-1);
            }
        }

        return true;
    }

    public boolean canBeEqual2(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }

        Arrays.sort(target);
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            if (target[i]!=arr[i]){
                return false;
            }
        }

        return true;
    }


}

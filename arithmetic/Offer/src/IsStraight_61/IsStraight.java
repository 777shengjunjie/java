package IsStraight_61;

import org.omg.CORBA.INTERNAL;

import java.util.*;

public class IsStraight {

    public static void main(String[] args) {

    }

    public boolean isStraight(int[] nums) {

        Arrays.sort(nums);
        Map<Integer, Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()!=1&&entry.getKey()!=0){
                return false;
            }
        }
        int zeroCount=0;
        if (map.containsKey(0)){
             zeroCount=map.get(0);
        }

        if ((nums[4]-nums[zeroCount])<=4){
            return true;
        }else {
            return false;
        }

    }

    public boolean isStraight2(int[] nums) {
        Set<Integer> repeat = new HashSet<>();
        int max = 0, min = 14;
        for(int num : nums) {
            if(num == 0) continue; // 跳过大小王
            max = Math.max(max, num); // 最大牌
            min = Math.min(min, num); // 最小牌
            if(repeat.contains(num)) return false; // 若有重复，提前返回 false
            repeat.add(num); // 添加此牌至 Set
        }
        return max - min < 5; // 最大牌 - 最小牌 < 5 则可构成顺子
    }


}

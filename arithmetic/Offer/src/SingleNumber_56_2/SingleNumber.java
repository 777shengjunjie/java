package SingleNumber_56_2;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {


    public static void main(String[] args) {


    }
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    public int singleNumber2(int[] nums) {

        Map<Integer,Integer> map=new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1)
                return entry.getKey();
        }
        return -1;
    }
}

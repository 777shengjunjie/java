package SingleNumbers_56_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumbers {

    public static void main(String[] args) {
        int[] nums={4,1,4,6};
        int[] result=new SingleNumbers().singleNumbers(nums);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] singleNumbers(int[] nums) {
        int ret=0;
        for (int num : nums) {
            ret^=num;
        }

        int target=1;
        while ((target&ret)==0){
            target=target<<1;
        }
        int a=0,b=0;
        for (int num : nums) {
            if ((num&target)==0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }


    public int[] singleNumbers2(int[] nums) {

        List<Integer> list=new ArrayList<>();
        Map<Integer,Integer> map=new HashMap();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        int[] res=new int[2];
        for (int i = 0; i < list.size(); i++) {
            res[i]=list.get(i);
        }
        return res;

    }
}

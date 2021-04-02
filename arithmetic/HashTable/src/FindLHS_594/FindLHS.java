package FindLHS_594;

import java.util.HashMap;
import java.util.Map;

public class FindLHS {


    public static void main(String[] args) {

    }


    public int findLHS(int[] nums) {
        int ans=0;
        Map<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(map.containsKey(entry.getKey()-1)){
                int tempSum=entry.getValue()+map.get(entry.getKey()-1);
                if(tempSum>ans){
                    ans=tempSum;
                }
            }
         /*   if(map.containsKey(entry.getKey()+1)){
                int tempSum=entry.getValue()+map.get(entry.getKey()+1);
                if(tempSum>ans){
                    ans=tempSum;
                }
            }*/
        }

        return ans;
    }
}

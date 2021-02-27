package FindErrorNums_645;


import java.util.HashMap;
import java.util.Map;

public class FindErrorNums {

    public static void main(String[] args) {

    }

    public int[] findErrorNums(int[] nums) {
        int [] ans=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(int i=1;i<=nums.length;i++) {
            if(map.containsKey(i)){
                if(map.get(i)==2){
                    ans[0]=map.get(i);
                }
            }else{
                ans[1]=i;
            }
        }


        return ans;
    }
}

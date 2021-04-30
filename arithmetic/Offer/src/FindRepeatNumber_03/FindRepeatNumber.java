package FindRepeatNumber_03;

import java.util.HashSet;
import java.util.Set;

public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        int ans=0;
        Set set=new HashSet();
        for (int num : nums) {
            if (!set.contains(num)){
                set.add(num);
            }else {
                ans=num;
                break;
            }
        }

        return ans;
    }
}

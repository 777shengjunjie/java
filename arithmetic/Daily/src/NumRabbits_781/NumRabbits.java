package NumRabbits_781;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NumRabbits {

    public int numRabbits(int[] answers) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap();
        for (int answer : answers) {
            map.put(answer, map.getOrDefault(answer, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey()==0){
                ans+=entry.getValue();
                continue;
            }
            if (entry.getKey()>entry.getValue()){
                ans+=entry.getKey()+1;
                continue;
            }
            if (entry.getKey()<=entry.getValue()){
                int length=(entry.getValue()/(entry.getKey()+1))*(entry.getKey()+1);
                ans+=length;
                if(entry.getValue()%(entry.getKey()+1)!=0){
                    ans+=entry.getKey()+1;
                }
                continue;
            }

        }

        return ans;
    }

    public int numRabbits2(int[] answers) {
        Map<Integer, Integer> count = new HashMap<Integer, Integer>();
        for (int y : answers) {
            count.put(y, count.getOrDefault(y, 0) + 1);
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int y = entry.getKey(), x = entry.getValue();
            ans += (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }


}

package UncommonFromSentences_884;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonFromSentences {

    public static void main(String[] args) {

        String A="this apple is sweet";
        String B="this apple is sour";
        String[] result=new UncommonFromSentences().uncommonFromSentences(A,B);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public String[] uncommonFromSentences(String A, String B) {
        List<String> list=new ArrayList<>();
        Map<String,Integer> mapA=new HashMap<>();
        Map<String,Integer> mapB=new HashMap<>();
        String[] aList=A.split("\\s");
        String[] bList=B.split("\\s");
        for(int i=0;i<aList.length;i++){
            mapA.put(aList[i],mapA.getOrDefault(aList[i],0)+1);
        }
        for(int i=0;i<bList.length;i++){
            mapB.put(bList[i],mapB.getOrDefault(bList[i],0)+1);
        }

        for(Map.Entry<String,Integer> entry:mapA.entrySet()){
            if (entry.getValue()==1&&!mapB.containsKey(entry.getKey())){


                list.add(entry.getKey());

            }
        }

        for(Map.Entry<String,Integer> entry:mapB.entrySet()){
            if (entry.getValue()==1&&!mapA.containsKey(entry.getKey())){
                list.add(entry.getKey());
            }
        }

        String[] ans=new String[list.size()];

        for (int i = 0; i < ans.length; i++) {
            ans[i]=list.get(i);
        }

        return ans;

    }
}
